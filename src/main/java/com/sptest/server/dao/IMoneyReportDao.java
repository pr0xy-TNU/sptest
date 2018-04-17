package com.sptest.server.dao;

import com.sptest.server.dao.model.entities.reports.MoneyReport;
import java.util.List;

public interface IMoneyReportDao {

    void create(MoneyReport report);

    void update(MoneyReport report);

    void delete(MoneyReport report);

    MoneyReport find(MoneyReport report);

    List<MoneyReport> findAll();
}
