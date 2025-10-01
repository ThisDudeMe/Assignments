package se.uppgift2;

public class Clothing extends Product{

    public Clothing(String title, double price, int articleNumber, String description) {
        super(title, price, articleNumber, description);

    }

    @Override
    public String category() {
        return "Clothing";
    }
}




