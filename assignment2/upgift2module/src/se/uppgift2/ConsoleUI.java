package se.uppgift2;

import java.util.Scanner;

public class ConsoleUI implements UI {

    private final Scanner scanner;

    public ConsoleUI() {

        this.scanner = new Scanner(System.in);

    }

    @Override
    public String prompt(String message) {

        System.out.println(message);
        return scanner.nextLine();

    }

    @Override
    public void info(String message) {

        System.out.println(message);

    }

    @Override
    public String menu() {

        System.out.println("\n=== MENU ===");
        System.out.println("1. Add product");
        System.out.println("2. List all products");
        System.out.println("3. Show specific product");
        System.out.println("4. Save products to file");
        System.out.println("5. Exit");
        System.out.print("Choose option: ");
        return scanner.nextLine();

    }




}
