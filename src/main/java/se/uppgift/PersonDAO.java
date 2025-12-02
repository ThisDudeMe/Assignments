package se.uppgift;

import java.util.List;

public interface PersonDAO {
    void insert(Person person);
    List<Person> findAll();
}
