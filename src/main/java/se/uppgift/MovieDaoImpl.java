package se.uppgift;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MovieDaoImpl implements MovieDao {

    private final MongoCollection<Document> collection;

    public MovieDaoImpl(MongoDatabase database) {
        this.collection = database.getCollection("movies");
    }

    @Override
    public void insert(String title, int year) {
        Document movie = new Document("title", title)
                .append("year", year);
        collection.insertOne(movie);
        System.out.println("Film tillagd: " + title + " (" + year + ")");

    }

    @Override
    public List<Document> findAll() {

        List<Document> movies = new ArrayList<>();
        collection.find().into(movies);
        return movies;
    }



}
