package com.gamestore;

import java.util.ArrayList;
import java.util.List;

import com.gamestore.models.Game;

public class Store {
    private List<Game> catalog;
    private List<Game> inventory;
    private double totalRevenue;

    public Store() {
        catalog = new ArrayList<>();
        inventory = new ArrayList<>();
        totalRevenue = 0.0;
    }

    public List<Game> getCatalog() {
        return catalog;
    }

    public List<Game> getInventory() {
        return inventory;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void addGameToCatalog(Game game) {
        catalog.add(game);
    }

    public void displayCatalog() {
        System.out.println("Catalog:");
        for (Game game : catalog) {
            System.out.println("Title: " + game.getTitle());
            System.out.println("Genre: " + game.getGenre());
            System.out.println("Platform: " + game.getPlatform());
            System.out.println("Quantity: " + game.getQuantity());
            System.out.println("Price: $" + game.getPrice());
            System.out.println("----------------------");
        }
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (Game game : inventory) {
            System.out.println("Title: " + game.getTitle());
            System.out.println("Quantity: " + game.getQuantity());
            System.out.println("Price (Buy): $" + game.getPrice());
            System.out.println("Price (Sell): $" + (game.getPrice() * 1.2)); // Selling price with 20% markup
            System.out.println("Genre: " + game.getGenre());
            System.out.println("Platform: " + game.getPlatform());
            System.out.println("----------------------");
        }
    }

    public void buyGame(String title, int quantity) {
        for (Game game : catalog) {
            if (game.getTitle().equalsIgnoreCase(title)) {
                if (game.getQuantity() >= quantity) {
                    Game purchasedGame = new Game(game.getTitle(), game.getGenre(), game.getPlatform(), quantity, game.getPrice());
                    inventory.add(purchasedGame);
                    game.setQuantity(game.getQuantity() - quantity);
                    System.out.println("Successfully bought " + quantity + " copies of " + title);
                } else {
                    System.out.println("Insufficient quantity of " + title + " available.");
                }
                return;
            }
        }
        System.out.println("Game not found in the catalog.");
    }

    public void sellGame(String title, int quantity) {
        for (Game game : inventory) {
            if (game.getTitle().equalsIgnoreCase(title)) {
                if (game.getQuantity() >= quantity) {
                    inventory.remove(game);
                    totalRevenue += game.getPrice() * quantity;
                    game.setQuantity(game.getQuantity() - quantity);
                    System.out.println("Successfully sold " + quantity + " copies of " + title);
                } else {
                    System.out.println("Insufficient quantity of " + title + " in the inventory.");
                }
                return;
            }
        }
        System.out.println("Game not found in the inventory.");
    }

    public void generateReport() {
        System.out.println("Total Revenue: $" + totalRevenue);
    }
}
