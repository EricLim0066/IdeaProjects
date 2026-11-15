package OwnProject2.MessageToPlayer;

public class InputMessage {
    private InputMessage() {}

    public static final String INVALID_MESSAGE =
            "Invalid number, please try again.";

    public static String outOfRangeMessage (int min, int max) {
        return "Sorry please choose a number between %d and %d. Please try again.".formatted(min, max);
    }
}
