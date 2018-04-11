package com.sptest.server.services;

import com.sptest.server.dao.model.entities.Person;
import java.util.List;


public interface PersonService {
    void add(Person person);
    List<Person> listPersons();
}
