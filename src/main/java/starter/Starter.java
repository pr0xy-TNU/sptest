package starter;

import config.AppConfig;
import entities.Person;
import entities.PhoneEntity;
import entities.ShopEntity;
import entities.StudentEntity;
import entities.UserEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.ILocalShopRepository;
import services.IShopService;
import services.IStudentService;
import services.IUserService;
import services.PersonService;

public class Starter {

    public static Logger logger = LoggerFactory.getLogger(Starter.class.getName());


    public static void main(String[] args) {
        logger.info("hello from sl4j");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            AppConfig.class);
        PersonService personService = context.getBean(PersonService.class);
        // Add Persons
        /*personService.add(new Person("Sunil", "Bora", "suni.bora@example.com"));
        personService.add(new Person("David", "Miller", "david.miller@example.com"));
        personService.add(new Person("Sameer", "Singh", "sameer.singh@example.com"));
        personService.add(new Person("Paul", "Smith", "paul.smith@example.com"));

        List<Person> persons = personService.listPersons();
        for (Person person : persons) {
            System.out.println("Id = " + person.getId());
            System.out.println("First Name = " + person.getFirstName());
            System.out.println("Last Name = " + person.getLastName());
            System.out.println("Email = " + person.getEmail());
            System.out.println();
        }*/

       /* IUserService userService = context.getBean(IUserService.class);

        UserEntity userEntity = new UserEntity();
        userEntity.setAdress("rand");
        userEntity.setUserName("dhon");
        userEntity.setUserAge("12");
        List<PhoneEntity> listInsert = Arrays.asList(
            new PhoneEntity("motorolla", "12-26-76", userEntity),
            new PhoneEntity("meizu", "54-47-29", userEntity),
            new PhoneEntity("xxxz", "56-45-34", userEntity)
        );

        userEntity.setPhonesByUserId(listInsert);

        userService.add(userEntity);


        /*List<UserEntity> listSelect = userService.getAll();
        listSelect.forEach(System.out::println);
        IStudentService studentService = context.getBean(IStudentService.class);
        //List list = studentService.getAll();
        List<StudentEntity> criteriaResult = studentService.getStudentsById(2);
        criteriaResult.forEach(item -> {
            System.out.println(item.getStudentName() + " " + item.getStudentId());
        })*/
        ;
        ILocalShopRepository shopRepository = context.getBean(ILocalShopRepository.class);
        IShopService shopService = context.getBean(IShopService.class);
        List<ShopEntity> list = shopRepository.getDataFromJson();
        /*if (list != null) {
            if (!list.isEmpty()) {
                list.forEach(System.out::println);
            } else {
                logger.info("list is empty");
            }
            logger.info("list is null");
        }*/
        //insert data from json
        ShopEntity test = shopService.getShopByIdBeta(7);
        logger.info(test.toString());

        context.close();
    }

}
