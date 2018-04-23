package com.sptest.server.starter;

import com.sptest.server.config.AppConfig;
import com.sptest.server.dao.model.entities.EmployeeEntity;
import com.sptest.server.dao.model.entities.RoleEntity;
import com.sptest.server.dao.model.entities.reports.MoneyReport;
import com.sptest.server.services.IMoneyReportService;
import com.sptest.server.services.IRoleService;
import com.sptest.server.services.MoneyReportService;
import java.io.FileNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Starter {

  public static Logger logger = LoggerFactory.getLogger(Starter.class.getName());


  public static void main(String[] args) throws FileNotFoundException, BeansException {
    logger.info("hello from sl4j");
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        AppConfig.class);

    IMoneyReportService reportService = context.getBean(IMoneyReportService.class);

    MoneyReport moneyReport1 = new MoneyReport(3412, "998", "245", "550.00f",
        String.valueOf(System.currentTimeMillis()));
    MoneyReport moneyReport2 = new MoneyReport(3411, "997", "246", "460.00f",
        String.valueOf(System.currentTimeMillis()));
    MoneyReport moneyReport3 = new MoneyReport(3410, "996", "227", "770.00f",
        String.valueOf(System.currentTimeMillis()));
    MoneyReport moneyReport5 = new MoneyReport(3409, "995", "248", "980.00f",
        String.valueOf(System.currentTimeMillis()));
    MoneyReport moneyReport4 = new MoneyReport(3408, "994", "249", "190.00f",
        String.valueOf(System.currentTimeMillis()));
    /*reportService.create(moneyReport1);
    reportService.create(moneyReport2);
    reportService.create(moneyReport3);
    reportService.create(moneyReport4);
    reportService.create(moneyReport5);*/
    reportService.findAll().forEach(System.out::println);

  }

}
