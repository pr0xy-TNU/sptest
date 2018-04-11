package com.sptest.server.dao;

import com.sptest.server.dao.model.entities.ShopEntity;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.sptest.server.utils.Utils.ShopTable;


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
        if (list != null && !list.isEmpty()) {
            return list.stream().map(object ->
                new ShopEntity((String) object[0], (String) object[1], (String) object[2],
                    (double) object[3])).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public ShopEntity getShopById(int id) {
        Session session;
        Criteria criteria;
        session = manager.unwrap(Session.class);
        Projection projections = Projections.projectionList()
            .add(Projections.property(ShopTable.ID))
            .add(Projections.property(ShopTable.ADDRESS))
            .add(Projections.property(ShopTable.CUSTOMERS_DENSITY))
            .add(Projections.property(ShopTable.NAME))
            .add(Projections.property(ShopTable.OWNER));
        criteria = session.createCriteria(ShopEntity.class);
        criteria.add(Restrictions.eq(ShopTable.ID, id));
        criteria.setProjection(projections);
        @SuppressWarnings("unchecked")
        List<Object[]> list = criteria.list();
        if (list != null && !list.isEmpty()) {
            Object[] objects = list.get(0);
            int _id = (int) objects[0];
            String address = (String) objects[1];
            double customerDensity = (double) objects[2];
            String shopName = (String) objects[3];
            String owner = (String) objects[4];
            return new ShopEntity(_id, shopName, address, owner, customerDensity);
        }
        return null;
    }

    @Override
    public void add(List<ShopEntity> list) {
        list.forEach(item -> manager.merge(item));
    }

    @Override
    public ShopEntity getShopByIdBeta(int id) {
        /*CriteriaQuery<ShopEntity> query = manager.getCriteriaBuilder()
            .createQuery(ShopEntity.class);
        Root<ShopEntity> root = query.from(ShopEntity.class);*/
        return manager.find(ShopEntity.class, id);
    }
}
