package services;

import entities.Person;
import java.util.List;


public interface PersonService {
    void add(Person person);
    List<Person> listPersons();
}
