package repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.ShopEntity;
import entities.StudentEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import utils.Utils;

public class LocalShopRepository implements ILocalShopRepository {

    private List<ShopEntity> list;

    public LocalShopRepository() {
        this.list = new ArrayList<>();
    }

    @Override
    public void add(ShopEntity shopEntity) {
        list.add(shopEntity);
    }

    @Override
    public ShopEntity get(int index) {
        return list.get(index);
    }

    @Override
    public ShopEntity create() {
        return null;
    }

    @Override
    public List<ShopEntity> getAll() {
        return null;
    }

    @Override
    public void loadJson() {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        ObjectMapper mapper = new ObjectMapper();
        List<ShopEntity> jsonData;
        try {
            jsonData = mapper.readValue(loader.getResource(Utils.JSON_PATH),
                new TypeReference<List<ShopEntity>>() {
                });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeJson() {
        ObjectMapper mapper = new ObjectMapper();

    }
}
