package se.uppgift;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

public class Main {

    public static void main(String[] args) {

    // RÄTT connection string - ska börja med mongodb+srv://
    String url = "mongodb+srv://<username>:<password>@<cluster>.mongodb.net/?retryWrites=true&w=majority";
    
    // Ersätt <username>, <password> och <cluster> med dina uppgifter
    // Exempel: mongodb+srv://myuser:mypassword@cluster0.abc123.mongodb.net/?retryWrites=true&w=majority

    try (MongoClient mongoClient = MongoClients.create(url)){

        MongoDatabase database = mongoClient.getDatabase("moviesdb");

        MovieDao movieDao = new MovieDaoImpl(database);

        System.out.println("=== Lägger till nya filmer ===");
        // Insert nya filmer
        movieDao.insert("The Matrix", 1999);
        movieDao.insert("Inception", 2010);
        movieDao.insert("The Shawshank Redemption", 1994);

        System.out.println("\n=== Hämtar alla filmer ===");
        // Hämta alla filmer
        List<Document> allMovies = movieDao.findAll();

        if (allMovies.isEmpty()) {
            System.out.println("Inga filmer hittades i databasen.");
        } else {
            System.out.println("Antal filmer: " + allMovies.size());
            System.out.println("\nFilmlista:");
            for (Document movie : allMovies) {
                System.out.println(movie.toJson());
            }
        }

    } catch (Exception e) {
        System.err.println("Fel vid anslutning till MongoDB: " + e.getMessage());
        e.printStackTrace();
    }

}