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
        ILocalShopRepository shopRepository = context.getBean(ILocalShopRepository.class);
        IShopService shopService = context.getBean(IShopService.class);
       /* List<ShopEntity> list = shopRepository.getDataFromJson();
        if (list != null) {
            if (!list.isEmpty()) {
                list.forEach(System.out::println);
                shopService.add(list);
            } else {
                logger.info("list is empty");
            }
            logger.info("list is null");
        }*/
        ShopEntity testCriteriaUpdate = new ShopEntity("Cocobura", "some where where is good",
            "Alex", 234.12);
        ShopEntity test = shopService.update(7, testCriteriaUpdate);
        logger.info(test.toString());

        context.close();
    }

}
