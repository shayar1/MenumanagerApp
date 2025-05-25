package interaction;

public class GuestUser implements CustomerType {
    private String name;

    public GuestUser(String name) {
        this.name = name;
    }

    @Override
    public void displayPromotions() {
        System.out.println("Current Promotions: Free fries with any burger!");
    }

    @Override
    public void printSummary() {
        System.out.println("Thank you for visiting, " + name + "!");
    }

    public String getName() { return name; }
}