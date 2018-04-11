package com.sptest.server.starter;

import com.sptest.server.config.AppConfig;
import com.sptest.server.dao.model.entities.AlbumsEntity;
import com.sptest.server.dao.model.entities.ArtistsEntity;
import com.sptest.server.dao.model.entities.EmployeeEntity;
import com.sptest.server.dao.model.entities.RoleEntity;
import com.sptest.server.services.IRoleService;
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

       /* IArtistService artistService = context.getBean(IArtistService.class);
        ArtistsEntity artist = new ArtistsEntity(78, "Devid Guetta");
        List<AlbumsEntity> list = new ArrayList<>();
        list.add(new AlbumsEntity(93, "God rap", 2003, artist));
        list.add(new AlbumsEntity(39, "Heaven", 2012, artist));
        list.add(new AlbumsEntity(48, "Delchevita", 2013, artist));
        artist.setAlbums(list);
        artistService.save(artist);*/

    IRoleService roleService = context.getBean(IRoleService.class);
    RoleEntity roleEntity1 = new RoleEntity(1032, "pomoshnik", 13000, 230013);
    RoleEntity roleEntity2 = new RoleEntity(9992, "nachalnik", 93000, 230015);

    EmployeeEntity employeeEntity1 = new EmployeeEntity(101, "David", 23, "temps");
    EmployeeEntity employeeEntity2 = new EmployeeEntity(102, "Stiven", 34, "temp adress");
    EmployeeEntity employeeEntity3 = new EmployeeEntity(103, "ROger", 54, "voll street");

    roleEntity1.getEmployees().add(employeeEntity1);
    roleEntity1.getEmployees().add(employeeEntity2);
    roleEntity1.getEmployees().add(employeeEntity3);

    roleEntity2.getEmployees().add(employeeEntity1);
    roleEntity2.getEmployees().add(employeeEntity2);
    roleEntity2.getEmployees().add(employeeEntity3);

    roleService.save(roleEntity1);
    roleService.save(roleEntity2);


  }

}
