package se.uppgift2;

public class Book extends Product{

    public Book(String title, double price, int articleNumber, String description) {
        super(title, price, articleNumber, description);

    }

    @Override
    public String category() {
        return "Books";
    }
}




