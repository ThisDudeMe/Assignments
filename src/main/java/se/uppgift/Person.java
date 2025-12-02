package se.uppgift;

import java.sql.Date;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private Date dob;
    private double income;

    public Person(String firstName, String lastName, Date dob, double income) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.income = income;
    }

    public Person(int id, String firstName, String lastName, Date dob, double income) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.income = income;
    }

    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Date getDob() { return dob; }
    public double getIncome() { return income; }

    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + firstName + " " + lastName + "', dob=" + dob + ", income=" + income + "}";
    }
}
