package com.sptest.server.dao;

import com.sptest.server.dao.model.entities.UserEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao implements IUserDao {

    @PersistenceContext
    private EntityManager manager;


    @Override
    public void add(UserEntity userEntity) {
        manager.persist(userEntity);
    }

    @Override
    public List<UserEntity> getAll() {
        CriteriaQuery<UserEntity> query = manager.getCriteriaBuilder()
            .createQuery(UserEntity.class);
        Root<UserEntity> root = query.from(UserEntity.class);
        return manager.createQuery(query).getResultList();
    }
}
