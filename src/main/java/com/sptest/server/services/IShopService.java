package com.sptest.server.services;

import com.sptest.server.dao.model.entities.ShopEntity;
import java.util.List;

public interface IShopService {

    void add(ShopEntity shopEntity);

    List<ShopEntity> getAllShops();

    ShopEntity getShopById(int id);

    void add(List<ShopEntity> list);

    ShopEntity getShopByIdBeta(int id);

}
