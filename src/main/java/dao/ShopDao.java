package dao;

import entities.ShopEntity;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import static starter.Starter.logger;
import static starter.Starter.main;

import sun.plugin2.message.Message;
import utils.Utils.ShopTable;


@Repository
public class ShopDao implements IShopDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void add(ShopEntity shopEntity) {
        manager.merge(shopEntity);
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
        return manager.find(ShopEntity.class, id);
    }

    @Override
    public ShopEntity update(int id, ShopEntity shopEntity) {
        ShopEntity tempEntity = getShopById(id);

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        if (tempEntity != null) {
            CriteriaUpdate<ShopEntity> criteriaUpdate = builder
                .createCriteriaUpdate(ShopEntity.class);
            Root<ShopEntity> root = criteriaUpdate.from(ShopEntity.class);
            criteriaUpdate.set(root.get(ShopTable.ADDRESS), tempEntity.getShopAddress());
            criteriaUpdate
                .set(root.get(ShopTable.CUSTOMERS_DENSITY), tempEntity.getShopCustomerDensity());
            criteriaUpdate.set(root.get(ShopTable.NAME), tempEntity.getShopName());
            criteriaUpdate.set(root.get(ShopTable.OWNER), tempEntity.getShopOwner());
            criteriaUpdate.where(builder.equal(root.get(ShopTable.ID), tempEntity.getShopId()));
            int result = manager.createQuery(criteriaUpdate).executeUpdate();
            logger
                .info(MessageFormat.format("Instance with id={0} was added in row{1}", id, result));
            return shopEntity;
        } else {
            create(shopEntity);
        }
        return shopEntity;
    }

    @Override
    public void create(ShopEntity shopEntity) {
        if (shopEntity != null) {
            manager.merge(shopEntity);
        }
    }
}
