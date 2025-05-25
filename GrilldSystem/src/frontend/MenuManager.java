package frontend;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class MenuManager {
    private ArrayList<MenuItem> menu;

    public MenuManager() {
        menu = new ArrayList<>();
        menu.add(new MenuItem("Beef Burger", "Burger", 10.0));
        menu.add(new MenuItem("Veggie Burger", "Burger", 8.5));
        menu.add(new MenuItem("Fries", "Sides", 3.0));
        menu.add(new MenuItem("Soft Drink", "Drinks", 2.5));
    }

    public void displayAllItems() {
        System.out.println("\n--- Menu by Category ---");
        Map<String, List<MenuItem>> categoryMap = new HashMap<>();

        for (MenuItem item : menu) {
            categoryMap.computeIfAbsent(item.getCategory(), k -> new ArrayList<>()).add(item);
        }

        for (String category : categoryMap.keySet()) {
            System.out.println("--- " + category + " ---");
            for (MenuItem item : categoryMap.get(category)) {
                System.out.println(item);
            }
        }
    }

    public void addMenuItem(String name, String category, double price) {
        menu.add(new MenuItem(name, category, price));
        System.out.println(name + " added to the menu under " + category + ".");
    }

    public void removeMenuItem(String name) {
        MenuItem item = getItemByName(name);
        menu.remove(item);
        System.out.println(name + " removed from the menu.");
    }

    public void updateMenuItem(String name, String newName, Double newPrice) {
        for (MenuItem item : menu) {
            if (item.getName().equalsIgnoreCase(name)) {
                if (newName != null && !newName.trim().isEmpty()) item.setName(newName);
                if (newPrice != null && newPrice >= 0) item.setPrice(newPrice);
                System.out.println("Item updated.");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    public void toggleItemAvailability(String name) {
        MenuItem item = getItemByName(name);
        item.toggleAvailability();
        System.out.println(name + " availability toggled.");
    }

    public void displayItemNamesOnly() {
        System.out.println("Item Names Only:");
        for (MenuItem item : menu) {
            System.out.println("- " + item.getName());
        }
    }

    public void showAllCategories() {
        System.out.println("Categories:");
        for (MenuItem item : menu) {
            System.out.println("- " + item.getCategory());
        }
    }

    public void sortMenuByPrice(boolean ascending) {
        System.out.println("Menu Sorted by Price:");
        menu.stream()
            .sorted((a, b) -> ascending ?
                    Double.compare(a.getPrice(), b.getPrice()) :
                    Double.compare(b.getPrice(), a.getPrice()))
            .forEach(System.out::println);
    }

    public void countTotalItems() {
        System.out.println("Total items in menu: " + menu.size());
    }

    public void showAvailableItemsOnly() {
        System.out.println("Available Menu Items:");
        for (MenuItem item : menu) {
            if (item.isAvailable()) {
                System.out.println(item);
            }
        }
    }

    public MenuItem getItemByName(String name) {
        for (MenuItem item : menu) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public MenuItem getItemByIndex(int index) {
        if (index >= 0 && index < menu.size()) {
            return menu.get(index);
        }
        return null;
    }

    public void displayItemsByCategory(String category) {
        boolean found = false;
        for (MenuItem item : menu) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                System.out.println(item);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No items found in category: " + category);
        }
    }
}
