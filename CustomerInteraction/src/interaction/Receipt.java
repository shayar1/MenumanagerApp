package interaction;

import java.time.LocalDateTime;

public class Receipt {
    private String[] items;
    private double total;
    private String timestamp;

    public Receipt(String[] items, double total) {
        this.items = items;
        this.total = total;
        this.timestamp = LocalDateTime.now().toString();
    }

    public void printReceipt() {
        System.out.println("----- Receipt -----");
        for (String item : items) {
            System.out.println(item);
        }
        System.out.println("Total: $" + total);
        System.out.println("Date: " + timestamp);
    }
}