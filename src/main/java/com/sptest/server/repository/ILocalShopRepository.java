package com.sptest.server.repository;

import com.sptest.server.dao.model.entities.ShopEntity;
import java.util.List;

public interface ILocalShopRepository {

    void add(ShopEntity entity);

    ShopEntity get(int index);

    ShopEntity create();

    List<ShopEntity> getAll();

    void loadJson();

    void writeJson();
    public List<ShopEntity> getDataFromJson();

}
