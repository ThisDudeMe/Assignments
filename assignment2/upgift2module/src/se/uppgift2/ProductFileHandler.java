package se.uppgift2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ProductFileHandler {
    
    private final String filename;
    
    public ProductFileHandler(String filename) {
        this.filename = filename;
    }

    public void saveProducts(List<Product> products) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Product product : products) {

                writer.write(product.getClass().getSimpleName());
                writer.write("|");

                writer.write(product.getTitle());
                writer.write("|");
                writer.write(String.valueOf(product.getPrice()));
                writer.write("|");
                writer.write(String.valueOf(product.getArticleNumber()));
                writer.write("|");
                writer.write(product.getDescription());
                writer.newLine();
            }
        }
    }

    public List<Product> loadProducts() throws IOException {
        List<Product> products = new ArrayList<>();
        File file = new File(filename);

        if (!file.exists()) {
            return products;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    Product product = parseProduct(line);
                    if (product != null) {
                        products.add(product);
                    }
                } catch (Exception e) {
                    System.err.println("Error parsing line: " + line);
                }
            }
        }
        
        return products;
    }

    private Product parseProduct(String line) {
        String[] parts = line.split("\\|");
        
        if (parts.length != 5) {
            return null;
        }
        
        String type = parts[0];
        String title = parts[1];
        double price = Double.parseDouble(parts[2]);
        int articleNumber = Integer.parseInt(parts[3]);
        String description = parts[4];

        switch (type) {
            case "Book":
                return new Book(title, price, articleNumber, description);
            case "Electronics":
                return new Electronics(title, price, articleNumber, description);
            case "Clothing":
                return new Clothing(title, price, articleNumber, description);
            default:
                return null;
        }
    }
}
