package menuapp;

import java.util.ArrayList;
import java.util.List;
import java.util.List;

public class MenuManager {
    private List<MenuItem> menu;

    public MenuManager() {
        menu = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        menu.add(item);
    }

    public void displayAllItems() {
        if (menu.isEmpty()) {
            System.out.println("Menu is empty.");
        } else {
            for (MenuItem item : menu) {
                System.out.println(item);
            }
        }
    }

    public MenuItem searchItemByName(String name) {
        for (MenuItem item : menu) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public boolean updateItemAvailability(int id, boolean availability) {
        for (MenuItem item : menu) {
            if (item.getId() == id) {
                item.setAvailable(availability);
                return true;
            }
        }
        return false;
    }

    public boolean deleteItem(int id) {
        return menu.removeIf(item -> item.getId() == id);
    }
}
