package com.sptest.server.services;

import com.sptest.server.dao.PersonDao;
import com.sptest.server.dao.model.entities.Person;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PersonServiceImp implements PersonService {

   @Autowired
   private PersonDao userDao;

   @Transactional
   @Override
   public void add(Person person) {
      userDao.add(person);
   }

   @Transactional(readOnly = true)
   @Override
   public List<Person> listPersons() {
      return userDao.listPersons();
   }

}
