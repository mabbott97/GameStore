package com.gamestore;

import java.util.Scanner;

import com.gamestore.models.Game;

public class GameStoreSimulator {
    public void run() {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);

        // Agregar juegos al catálogo
        Game game1 = new Game("Super Mario Odyssey", "Platformer", "Nintendo Switch", 10, 49.99);
        Game game2 = new Game("The Last of Us Part II", "Action-Adventure", "PlayStation 4", 5, 59.99);
        Game game3 = new Game("Cyberpunk 2077", "RPG", "PC", 8, 39.99);

        store.addGameToCatalog(game1);
        store.addGameToCatalog(game2);
        store.addGameToCatalog(game3);

        System.out.println("Welcome to the Game Store!");

        while (true) {
            System.out.println("Select user type: ");
            System.out.println("1. Administrator");
            System.out.println("2. Customer");
            System.out.println("0. Exit");

            int userType = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (userType == 0) {
                System.out.println("Thank you for using the Game Store. Goodbye!");
                break;
            } else if (userType == 1) {
                System.out.println("Administrator Menu:");
                System.out.println("1. Display Catalog");
                System.out.println("2. Display Inventory");
                System.out.println("3. Buy Game");
                System.out.println("4. Sell Game");
                System.out.println("5. Generate Report");
                System.out.println("0. Back");

                int adminChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (adminChoice) {
                    case 0:
                        break;
                    case 1:
                        store.displayCatalog();
                        break;
                    case 2:
                        store.displayInventory();
                        break;
                    case 3:
                        System.out.println("Enter the game title:");
                        String buyTitle = scanner.nextLine();
                        System.out.println("Enter the quantity:");
                        int buyQuantity = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        store.buyGame(buyTitle, buyQuantity);
                        break;
                    case 4:
                        System.out.println("Enter the game title:");
                        String sellTitle = scanner.nextLine();
                        System.out.println("Enter the quantity:");
                        int sellQuantity = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        store.sellGame(sellTitle, sellQuantity);
                        break;
                    case 5:
                        store.generateReport();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else if (userType == 2) {
                System.out.println("Customer Menu:");
                System.out.println("1. Display Catalog");
                System.out.println("2. Buy Game");
                System.out.println("0. Back");

                int customerChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (customerChoice) {
                    case 0:
                        break;
                    case 1:
                        store.displayCatalog();
                        break;
                    case 2:
                        System.out.println("Enter the game title:");
                        String buyTitle = scanner.nextLine();
                        System.out.println("Enter the quantity:");
                        int buyQuantity = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        store.buyGame(buyTitle, buyQuantity);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("Invalid user type. Please try again.");
            }
        }
    }
}
