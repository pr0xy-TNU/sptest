package com.sptest.server.services;

import com.sptest.server.dao.IRoleDao;
import com.sptest.server.dao.model.entities.RoleEntity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService implements IRoleService {

  @Autowired
  private IRoleDao roleDao;

  @Transactional
  @Override
  public void save(RoleEntity roleEntity) {
    roleDao.save(roleEntity);
  }
}
