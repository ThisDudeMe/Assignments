package se.javabackend;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private List<Product> products = new ArrayList<>();


    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("product must not be null");
        }
        int articleNumber = product.getArticleNumber();
        boolean duplicate = products.stream()
                .anyMatch(p -> p.getArticleNumber() == articleNumber);
        if (duplicate) {
            throw new IllegalArgumentException("Duplicate article number: " + articleNumber);
        }
        products.add(product);
    }

    public void listProducts() {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public void showProduct(int articleNumber) {
        for (Product product : products) {
            if (product.getArticleNumber() == articleNumber) {
                System.out.println(product.toString());
            }


        }
    }



}
