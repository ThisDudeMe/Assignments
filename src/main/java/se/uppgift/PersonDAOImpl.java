package se.uppgift;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {

    @Override
    public void insert(Person person) {
        String sql = "INSERT INTO person (first_name, last_name, dob, income) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConnectionManager.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, person.getFirstName());
            pstmt.setString(2, person.getLastName());
            pstmt.setDate(3, person.getDob());
            pstmt.setDouble(4, person.getIncome());
            
            pstmt.executeUpdate();
            System.out.println("Person inserted successfully.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> findAll() {
        List<Person> people = new ArrayList<>();
        String sql = "SELECT * FROM person";
        
        try (Connection conn = ConnectionManager.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                people.add(new Person(
                    rs.getInt("person_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getDate("dob"),
                    rs.getDouble("income")
                ));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }
}
