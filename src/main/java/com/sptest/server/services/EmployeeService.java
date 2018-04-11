package com.sptest.server.services;

import com.sptest.server.dao.model.entities.EmployeeEntity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService implements IEmployeeService {

  @Autowired
  private IEmployeeService employeeService;

  @Transactional
  @Override
  public void save(EmployeeEntity employeeEntity) {
    employeeService.save(employeeEntity);
  }
}
