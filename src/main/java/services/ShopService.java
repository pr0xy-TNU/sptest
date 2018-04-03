package services;

import dao.IShopDao;
import entities.ShopEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.IShopJpaRepository;


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
        if (list != null && !list.isEmpty()) {
            for (ShopEntity item : list
                ) {
                add(item);
            }
        }
    }

    @Transactional(readOnly = true)
    @Override
    public ShopEntity getShopByIdBeta(int id) {
        return shopDao.getShopById(id);
    }


    @Transactional
    @Override
    public ShopEntity update(int id, ShopEntity shopEntity) {
        return shopDao.update(id, shopEntity);
    }

    @Transactional
    @Override
    public void create(ShopEntity shopEntity) {
        shopDao.create(shopEntity);
    }
}
