package com.sptest.server.dao;

import com.sptest.server.dao.model.entities.Person;
import java.util.List;


public interface PersonDao {
   void add(Person person);
   List<Person> listPersons();
}
