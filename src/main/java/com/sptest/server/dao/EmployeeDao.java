package com.sptest.server.dao;

import com.sptest.server.dao.model.entities.EmployeeEntity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao implements IEmployeeDao {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public void save(EmployeeEntity employeeEntity) {
    if (employeeEntity != null) {
      manager.merge(employeeEntity);
    }
  }
}
