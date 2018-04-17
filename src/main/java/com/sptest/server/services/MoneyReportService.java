package com.sptest.server.services;


import com.sptest.server.dao.IMoneyReportDao;
import com.sptest.server.dao.model.entities.reports.MoneyReport;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("IMoneyReportService")
public class MoneyReportService implements IMoneyReportService {


    @Autowired
    private IMoneyReportDao reportDao;

    @Override
    public void create(MoneyReport report) {
        reportDao.create(report);
    }

    @Override
    public void update(MoneyReport report) {
        reportDao.update(report);
    }

    @Override
    public void delete(MoneyReport report) {
        reportDao.delete(report);
    }

    @Override
    public MoneyReport find(MoneyReport report) {
        return reportDao.find(report);
    }

    @Override
    public List<MoneyReport> findAll() {
        return reportDao.findAll();
    }
}
