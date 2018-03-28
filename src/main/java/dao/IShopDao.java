package dao;

import entities.ShopEntity;
import java.util.List;

public interface IShopDao {

    void add(ShopEntity shopEntity);

    List<ShopEntity> getAllShops();

    ShopEntity getShopById(int id);

    void add(List<ShopEntity> list);

    ShopEntity getShopByIdBeta(int id);

}
