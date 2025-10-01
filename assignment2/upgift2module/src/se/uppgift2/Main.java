package se.uppgift2;

public class Main {


    public static void main(String[] args) {


        UI ui = new ConsoleUI();


        ProductFileHandler fileHandler = new ProductFileHandler("assignment2/upgift2module/src/se/uppgift2/products.txt");


        Application app = new Application(ui, fileHandler);

        app.run();
    }
}