package com.sptest.server.starter;

import com.sptest.server.config.AppConfig;
import com.sptest.server.dao.model.entities.AlbumsEntity;
import com.sptest.server.dao.model.entities.ArtistsEntity;
import com.sptest.server.dao.model.entities.EmployeeEntity;
import com.sptest.server.dao.model.entities.RoleEntity;
import com.sptest.server.services.IRoleService;
import com.sptest.server.services.RoleService;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.sptest.server.services.IArtistService;

public class Starter {

    public static Logger logger = LoggerFactory.getLogger(Starter.class.getName());
    public static String FILE_PATH = "G:/file1.xlsx";
    public static String FILE_PATH_OUT = "G:/TestElsle/file1.txt";

    public static void main(String[] args) throws FileNotFoundException {
        logger.info("hello from sl4j");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            AppConfig.class);

        IRoleService roleService = context.getBean(IRoleService.class);
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


    }

}
