package interaction;

import java.util.Scanner;

public class CustomerInteractionController {
    private CustomerType customer;

    public void processCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Are you a Loyalty Member? (yes/no): ");
        String type = scanner.nextLine();

        if (type.equalsIgnoreCase("yes")) {
            System.out.print("Enter Loyalty ID: ");
            String loyaltyID = scanner.nextLine();
            customer = new LoyaltyMember(name, loyaltyID);
        } else {
            customer = new GuestUser(name);
        }

        displayGreeting();
        generateReceipt();
        collectFeedback();
    }

    private void displayGreeting() {
        System.out.println("Welcome to Grill'd!");
        customer.displayPromotions();
        customer.printSummary();
    }

    public void generateReceipt() {
        String[] items = {"Classic Burger", "Chips"};
        double total = 15.50;
        Receipt receipt = new Receipt(items, total);
        receipt.printReceipt();
    }

    public void collectFeedback() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please rate your experience (1-5): ");
        int rating = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline
        System.out.print("Leave a comment: ");
        String comment = scanner.nextLine();
        Feedback feedback = new Feedback(rating, comment);
        feedback.displayFeedback();
    }

    public static void main(String[] args) {
        CustomerInteractionController controller = new CustomerInteractionController();
        controller.processCustomer();
    }
}