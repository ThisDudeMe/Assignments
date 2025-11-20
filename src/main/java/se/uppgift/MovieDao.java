package se.uppgift;

import org.bson.Document;
import java.util.List;

public interface MovieDao {

    void insert(String title, int year);

    List<Document> findAll();



}
