package OwnProject2.MessageToPlayer;

import java.nio.file.Path;

public class RegisterInputMessage {
    private RegisterInputMessage() {}

    public static final String MESSAGE_ASK_NAME =
            "Please create your name: ";

    public static final String MESSAGE_ASK_PASSWORD =
            "Please create your password: ";

    public static final String MESSAGE_ASK_CODE =
            "Please enter the otp code: ";

    public static final String MESSAGE_SUCCESS =
            "Registration successful !";

    public static String codeSentTo(Path inbox) {
        return "Code was sent to " + inbox + ". Please check the verification code as soon as possible.";
    }

    public static String countdown(long minutes, long seconds) {
        return String.format("%02d: %02d", minutes, seconds);
    }
}
