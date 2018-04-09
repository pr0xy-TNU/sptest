package starter;

import config.AppConfig;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import utils.FileHelper;

public class Starter {

    public static Logger logger = LoggerFactory.getLogger(Starter.class.getName());
    public static String FILE_PATH = "G:/file1.xlsx";
    public static String FILE_PATH_OUT = "G:/file1.txt";

    public static void main(String[] args) throws FileNotFoundException {
        logger.info("hello from sl4j");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            AppConfig.class);
        /*PersonService personService = context.getBean(PersonService.class);
        ILocalShopRepository shopRepository = context.getBean(ILocalShopRepository.class);
        IShopService shopService = context.getBean(IShopService.class);
        List<ShopEntity> list = shopRepository.getDataFromJson();
        *//*if (list != null) {
            if (!list.isEmpty()) {
                list.forEach(System.out::println);
            } else {
                logger.info("list is empty");
            }
            logger.info("list is null");
        }*//*
        //insert data from json
        ShopEntity test = shopService.getShopByIdBeta(7);
        logger.info(test.toString());*/
        List<String> exelData = FileHelper.excelConverterText(FILE_PATH);
        assert exelData != null;
        exelData.forEach(System.out::println);
        {
            int size = exelData.size();
            PrintWriter printWriter = new PrintWriter(FILE_PATH_OUT);
            for (String line : exelData
            ) {
                printWriter.write(line);
                printWriter.write(System.getProperty("line.separator"));
            }
            printWriter.close();
        }
        context.close();
    }

}
