package com.sptest.server.dao;

import com.sptest.server.dao.model.entities.RoleEntity;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDao implements IRoleDao {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public void save(RoleEntity roleEntity) {
    if (roleEntity != null) {
      manager.merge(roleEntity);
    }
  }
}
