package se.uppgift;

import java.sql.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAOImpl();

        // 1. Insert a new person
        Person newPerson = new Person("Anna", "Andersson", Date.valueOf("1990-01-01"), 35000);
        personDAO.insert(newPerson);

        // 2. Find and print all people
        List<Person> people = personDAO.findAll();
        System.out.println("--- All People ---");
        for (Person p : people) {
            System.out.println(p);
        }
    }
}