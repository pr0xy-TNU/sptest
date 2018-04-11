package com.sptest.server.services;

import com.sptest.server.dao.IShopDao;
import com.sptest.server.dao.model.entities.ShopEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ShopService implements IShopService {

    @Autowired
    private IShopDao shopDao;

    @Transactional
    @Override
    public void add(ShopEntity shopEntity) {
        shopDao.add(shopEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ShopEntity> getAllShops() {
        return shopDao.getAllShops();
    }

    @Transactional(readOnly = true)
    @Override
    public ShopEntity getShopById(int id) {
        return shopDao.getShopById(id);
    }

    @Transactional
    @Override
    public void add(List<ShopEntity> list) {
        shopDao.add(list);
    }

    @Transactional(readOnly = true)
    @Override
    public ShopEntity getShopByIdBeta(int id) {
        return shopDao.getShopByIdBeta(id);
    }
}
