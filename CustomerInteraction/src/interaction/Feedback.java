package interaction;

public class Feedback {
    private int rating;
    private String comment;

    public Feedback(int rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public void displayFeedback() {
        System.out.println("Customer Feedback:");
        System.out.println("Rating: " + rating + "/5");
        System.out.println("Comment: " + comment);
    }
}