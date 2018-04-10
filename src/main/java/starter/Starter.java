package starter;

import config.AppConfig;
import entities.AlbumsEntity;
import entities.ArtistsEntity;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.IArtistService;

public class Starter {

    public static Logger logger = LoggerFactory.getLogger(Starter.class.getName());
    public static String FILE_PATH = "G:/file1.xlsx";
    public static String FILE_PATH_OUT = "G:/TestElsle/file1.txt";

    public static void main(String[] args) throws FileNotFoundException {
        logger.info("hello from sl4j");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            AppConfig.class);

        IArtistService artistService = context.getBean(IArtistService.class);
        ArtistsEntity artist = new ArtistsEntity(78, "Devid Guetta");
        List<AlbumsEntity> list = new ArrayList<>();
        list.add(new AlbumsEntity(93, "God rap", 2003, artist));
        list.add(new AlbumsEntity(39, "Heaven", 2012, artist));
        list.add(new AlbumsEntity(48, "Delchevita", 2013, artist));
        artist.setAlbums(list);
        artistService.save(artist);
    }

}
