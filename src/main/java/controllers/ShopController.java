package controllers;


import entities.Greeting;
import entities.ShopEntity;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repository.IShopJpaRepository;
import services.IShopService;
import services.ShopService;

@Controller
@RequestMapping("shop")
public class ShopController {

    @Autowired
    private IShopService shopService;
    @Autowired
    private IShopJpaRepository jpaRepository;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value = "goods")
    public ResponseEntity<List<ShopEntity>> getAllShopGoods() {
        List<ShopEntity> list = shopService.getAllShops();
        return new ResponseEntity<List<ShopEntity>>(list, HttpStatus.OK);
    }

    @GetMapping(value = "goods/{id}")
    public ResponseEntity<ShopEntity> getAllShopGoods(@PathVariable("id") int id) {
        ShopEntity shopEntity;
        if (id != 0) {
            shopEntity = shopService.getShopById(id);
            if (shopEntity != null) {
                return new ResponseEntity<>(shopEntity, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(new ShopEntity(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
            String.format(template, name));
    }
}
