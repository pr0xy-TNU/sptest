package dao;

import entities.ShopEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;
import utils.Utils.ShopTable;


@Repository
public class ShopDao implements IShopDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void add(ShopEntity shopEntity) {
        manager.persist(shopEntity);
    }

    @Override
    public List<ShopEntity> getAllShops() {
        Session session;
        Criteria criteria;
        session = manager.unwrap(Session.class);
        criteria = session.createCriteria(ShopEntity.class);
        Projection projections = Projections.projectionList()
            .add(Projections.property(ShopTable.NAME))
            .add(Projections.property(ShopTable.ADDRESS))
            .add(Projections.property(ShopTable.OWNER))
            .add(Projections.property(ShopTable.CUSTOMERS_DENSITY));
        criteria.setProjection(projections);
        @SuppressWarnings("unchecked")
        List<Object[]> list = criteria.list();
        List<ShopEntity> result = new ArrayList<>();
        if (result != null && !result.isEmpty()) {
            return list.stream().map(object ->
                new ShopEntity((String) object[0], (String) object[1], (String) object[2],
                    (int) object[3])).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public ShopEntity getShopById(int id) {
        Session session;
        Criteria criteria;
        session = manager.unwrap(Session.class);
        criteria = session.createCriteria(ShopEntity.class);
        List<Object[]> tempList = criteria.list();
        if (tempList != null && !tempList.isEmpty()) {
            ShopEntity result = new ShopEntity();
            result.setShopName((String) tempList.get(0)[0]);
            result.setShopAddress((String) tempList.get(0)[1]);
            result.setShopOwner((String) tempList.get(0)[2]);
            result.setShopCustomerCount((int) tempList.get(0)[3]);
            return result;
        } else {
            return null;
        }
    }

    @Override
    public void add(List<ShopEntity> list) {
        list.forEach(item -> manager.persist(item));
    }
}
