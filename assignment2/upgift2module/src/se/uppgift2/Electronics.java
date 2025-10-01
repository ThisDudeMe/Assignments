package se.uppgift2;

public class Electronics extends Product{

    public Electronics(String title, double price, int articleNumber, String description) {
        super(title, price, articleNumber, description);

    }

    @Override
    public String category() {
        return "Electronics";
    }
}




