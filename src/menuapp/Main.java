package menuapp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuManager manager = new MenuManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== Menu Management System =====");
            System.out.println("1. Add Item");
            System.out.println("2. View All Items");
            System.out.println("3. Search Item by Name");
            System.out.println("4. Update Availability");
            System.out.println("5. Delete Item");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Clear newline
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Please enter a number (1-6).");
                scanner.nextLine(); // Clear buffer
                continue; // Restart loop
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Category: ");
                        String category = scanner.nextLine();

                        System.out.print("Enter Price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Is Available (true/false): ");
                        boolean available = scanner.nextBoolean();
                        scanner.nextLine();

                        MenuItem item = new MenuItem(id, name, category, price, available);
                        manager.addItem(item);
                        System.out.println("✅ Item added successfully!");
                    } catch (InputMismatchException e) {
                        System.out.println("❌ Invalid input. Please try again.");
                        scanner.nextLine(); // Clear buffer
                    }
                    break;

                case 2:
                    manager.displayAllItems();
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    MenuItem foundItem = manager.searchItemByName(searchName);
                    if (foundItem != null) {
                        System.out.println("✅ Found: " + foundItem);
                    } else {
                        System.out.println("❌ Item not found.");
                    }
                    break;

                case 4:
                    try {
                        System.out.print("Enter item ID to update availability: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Set available? (true/false): ");
                        boolean newAvailability = scanner.nextBoolean();
                        scanner.nextLine();

                        boolean updated = manager.updateItemAvailability(updateId, newAvailability);
                        System.out.println(updated ? "✅ Updated successfully." : "❌ Item not found.");
                    } catch (InputMismatchException e) {
                        System.out.println("❌ Invalid input. Please enter valid values.");
                        scanner.nextLine(); // Clear buffer
                    }
                    break;

                case 5:
                    try {
                        System.out.print("Enter item ID to delete: ");
                        int deleteId = scanner.nextInt();
                        scanner.nextLine();
                        boolean deleted = manager.deleteItem(deleteId);
                        System.out.println(deleted ? "✅ Deleted successfully." : "❌ Item not found.");
                    } catch (InputMismatchException e) {
                        System.out.println("❌ Invalid input. Please enter a valid number.");
                        scanner.nextLine();
                    }
                    break;

                case 6:
                    running = false;
                    System.out.println("👋 Exiting... Thank you!");
                    break;

                default:
                    System.out.println("❌ Invalid option. Please choose 1 to 6.");
            }
        }

        scanner.close();
    }
}
