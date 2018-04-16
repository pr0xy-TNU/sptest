package com.sptest.server.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sptest.server.dao.model.entities.ShopEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.sptest.server.utils.DBConstants;

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
        return new ShopEntity("shopName", "shopAddress", "shopOwner", 23.2);
    }

    @Override
    public List<ShopEntity> getAll() {
        return list;
    }

    @Override
    public void loadJson() {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        ObjectMapper mapper = new ObjectMapper();
        try {
            list = mapper.readValue(loader.getResource(DBConstants.JSON_PATH),
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

    @Override
    public List<ShopEntity> getDataFromJson(){
        loadJson();
        return list;
    }
}
