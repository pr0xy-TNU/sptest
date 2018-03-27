package dao;

import entities.Person;
import java.util.List;


public interface PersonDao {
   void add(Person person);
   List<Person> listPersons();
}
