
package com.gamestore.models;

public class Game {
    private String title;
    private String genre;
    private String platform;
    private int quantity;
    private double price;

    public Game(String title, String genre, String platform, int quantity, double price) {
        this.title = title;
        this.genre = genre;
        this.platform = platform;
        this.quantity = quantity;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlatform() {
        return platform;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }
}
