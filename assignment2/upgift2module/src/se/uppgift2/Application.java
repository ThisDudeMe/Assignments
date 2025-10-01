package se.uppgift2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private final List<Product> products = new ArrayList<>();
    private final UI ui;
    private final ProductFileHandler fileHandler;

    public Application(UI ui, ProductFileHandler fileHandler) {
        this.ui = ui;
        this.fileHandler = fileHandler;
        loadProductsFromFile();
    }

    private void loadProductsFromFile() {
        try {
            List<Product> loadedProducts = fileHandler.loadProducts();
            products.addAll(loadedProducts);
            if (!loadedProducts.isEmpty()) {
                ui.info("Loaded " + loadedProducts.size() + " products from file.");
            }
        } catch (IOException e) {
            ui.info("Could not load products from file: " + e.getMessage());
        }
    }

    public void saveProductsToFile() {
        try {
            fileHandler.saveProducts(products);
            ui.info("Products saved successfully!");
        } catch (IOException e) {
            ui.info("Error saving products: " + e.getMessage());
        }
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("product must not be null");
        }

        int articleNumber = product.getArticleNumber();
        boolean duplicate = products.stream().anyMatch(p -> p.getArticleNumber() == articleNumber);
        if (duplicate) {
            throw new IllegalArgumentException("Duplicate article number: " + articleNumber);
        }
        else
            products.add(product);
    }

    public void listProducts() {
        if (products.isEmpty()) {
            ui.info("No products available.");
        } else {
            for (Product product : products) {
                ui.info(product.toString());
            }
        }
    }

    public void showProduct(int articleNumber) {
        boolean found = false;
        for (Product product : products) {
            if (product.getArticleNumber() == articleNumber) {
                ui.info(product.toString());
                found = true;
            }
        }
        if (!found) {
            ui.info("Product not found with article number: " + articleNumber);
        }
    }

    public void run() {
        boolean running = true;

        while (running) {
            String choice = ui.menu();

            switch (choice) {
                case "1":
                    addProductInteractive();
                    break;
                case "2":
                    listProducts();
                    break;
                case "3":
                    showProductInteractive();
                    break;
                case "4":
                    saveProductsToFile();
                    break;
                case "5":
                    saveProductsToFile(); // Save before exit
                    ui.info("Goodbye!");
                    running = false;
                    break;
                default:
                    ui.info("Invalid choice. Try again.");
            }
        }
    }

    private void addProductInteractive() {
        String type = ui.prompt("Product type (1=Book, 2=Electronics, 3=Clothing)");
        String title = ui.prompt("Title");
        String priceStr = ui.prompt("Price");
        String articleStr = ui.prompt("Article number");
        String description = ui.prompt("Description");

        try {
            double price = Double.parseDouble(priceStr);
            int articleNumber = Integer.parseInt(articleStr);

            Product product = null;
            switch (type) {
                case "1":
                    product = new Book(title, price, articleNumber, description);
                    break;
                case "2":
                    product = new Electronics(title, price, articleNumber, description);
                    break;
                case "3":
                    product = new Clothing(title, price, articleNumber, description);
                    break;
                default:
                    ui.info("Invalid product type");
                    return;
            }

            addProduct(product);
            ui.info("Product added successfully!");

        } catch (NumberFormatException e) {
            ui.info("Invalid number format");
        } catch (IllegalArgumentException e) {
            ui.info("Error: " + e.getMessage());
        }
    }

    private void showProductInteractive() {
        String articleStr = ui.prompt("Enter article number");
        try {
            int articleNumber = Integer.parseInt(articleStr);
            showProduct(articleNumber);
        } catch (NumberFormatException e) {
            ui.info("Invalid article number");
        }
    }
}
