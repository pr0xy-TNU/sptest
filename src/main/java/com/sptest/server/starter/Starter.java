package com.sptest.server.starter;

import com.sptest.server.config.AppConfig;
import com.sptest.server.dao.model.entities.EmployeeEntity;
import com.sptest.server.dao.model.entities.RoleEntity;
import com.sptest.server.dao.model.entities.reports.MoneyReport;
import com.sptest.server.services.IMoneyReportService;
import com.sptest.server.services.IRoleService;
import com.sptest.server.services.MoneyReportService;
import java.io.FileNotFoundException;
import org.joda.time.LocalTime;
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

       /* IRoleService roleService = context.getBean(IRoleService.class);
        RoleEntity role1 = new RoleEntity("student", 1200, 410113);
        RoleEntity role2 = new RoleEntity("prepod", 8100, 4100115);

        EmployeeEntity employeeEntity1 = new EmployeeEntity("Lola", 22, "Lola address");
        EmployeeEntity employeeEntity2 = new EmployeeEntity("Masha", 23, "masha adress");
        EmployeeEntity employeeEntity3 = new EmployeeEntity("Vika", 20, "vika address");

        role1.getEmployees().add(employeeEntity1);
        role1.getEmployees().add(employeeEntity2);
        role1.getEmployees().add(employeeEntity3);

        role2.getEmployees().add(employeeEntity1);
        role2.getEmployees().add(employeeEntity2);
        role2.getEmployees().add(employeeEntity3);

        roleService.save(role1);
        roleService.save(role2);
*/
        IMoneyReportService reportService = context.getBean(IMoneyReportService.class);

        MoneyReport moneyReport1 = new MoneyReport(1232,"12", "100", "124.45f", "23123123");
        MoneyReport moneyReport2 = new MoneyReport(1221,"13", "200", "145325.45f",
            String.valueOf(System.currentTimeMillis()));
        MoneyReport moneyReport3 = new MoneyReport(1255,"14", "300", "19999.45f",
            String.valueOf(System.currentTimeMillis()));
        MoneyReport moneyReport4 = new MoneyReport(1299, "45","400", "145234.45f",
            String.valueOf(System.currentTimeMillis()));
        reportService.create(moneyReport1);
        reportService.create(moneyReport2);
        reportService.create(moneyReport3);
        reportService.create(moneyReport4);
        reportService.findAll().forEach(System.out::println);

    }

}
