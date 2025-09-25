package se.javabackend;

import jdk.jfr.Category;

public abstract class Product {

    private String title;
    private double price;
    private int articleNumber;
    private String description;
    private int stock;


    public Product(String title, double price, int articleNumber, String description, int stock) {

        this.title = title;
        this.price = price;
        this.articleNumber = articleNumber;
        this.description = description;
        this.stock = stock;

    }

    public abstract String category();

    public void setTitle(String title) {

        if (title.length() < 3) throw new IllegalArgumentException("Title must be at least 3 characters long");

        else if (title.length() > 15) throw new IllegalArgumentException("Title can be max 15 characters long");

        else
            this.title = title;

    }

    public void setPrice(double price) {

        if (price <= 0) throw new IllegalArgumentException("Price can't be negative or 0");

        else
            this.price = price;

    }

    public void setArticleNumber(int articleNumber) {

        this.articleNumber = articleNumber;


    }

    public void setDescription(String description) {

        this.description = description;

    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getTitle() {

        return title;

    }

    public double getPrice() {

        return price;
    }

    public int getArticleNumber() {

        return articleNumber;
    }

    public String getDescription() {

        return description;
    }

    public int getStock() {
        return stock;
    }

}
