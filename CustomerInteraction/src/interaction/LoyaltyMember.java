package interaction;

public class LoyaltyMember implements CustomerType {
    private String name;
    private String loyaltyID;
    private int rewardPoints;

    public LoyaltyMember(String name, String loyaltyID) {
        this.name = name;
        this.loyaltyID = loyaltyID;
        this.rewardPoints = 100; // starting points
    }

    @Override
    public void displayPromotions() {
        System.out.println("Exclusive Loyalty Promotions: Buy 1 Get 1 Free!");
    }

    @Override
    public void printSummary() {
        System.out.println("Thank you " + name + " (Loyalty ID: " + loyaltyID + ")");
        System.out.println("Reward Points: " + rewardPoints);
    }

    public String getName() { return name; }
    public String getLoyaltyID() { return loyaltyID; }
}