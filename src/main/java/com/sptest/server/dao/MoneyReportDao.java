package com.sptest.server.dao;

import com.sptest.server.dao.model.entities.reports.MoneyReport;
import com.sptest.server.utils.DBConstants;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository("IMoneyReportDao")
public class MoneyReportDao implements IMoneyReportDao {

    @Autowired
    private MongoOperations mongoTemplate;

    @Override
    public void create(MoneyReport report) {
        mongoTemplate.insert(report);

    }

    @Override
    public void update(MoneyReport report) {
        mongoTemplate.save(report);
    }

    @Override
    public void delete(MoneyReport report) {
        mongoTemplate.remove(report);
    }

    @Override
    public MoneyReport find(MoneyReport report) {
        Query query = new Query(Criteria.where("_id").is(report.getId()));
        return mongoTemplate.findOne(query, MoneyReport.class, DBConstants.MONGO_COLLECTION_NAME);
    }

    @Override
    public List<MoneyReport> findAll() {
        return mongoTemplate.findAll(MoneyReport.class);
    }
}
