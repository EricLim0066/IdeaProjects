package OwnProject2.MessageToPlayer;

public class AccountMessage {
    private AccountMessage () {}

    public static final String MESSAGE_ACCOUNT_INVALID_INPUT =
            "Invalid input. Please check your username and password.";

    public static final String MESSAGE_ACCOUNT_WRONG_PASSWORD =
            "Incorrect password. Please try again.";

    public static final String MESSAGE_ACCOUNT_WRONG_NAME =
            "Username not found. Please try again.";

    public static final String MESSAGE_ACCOUNT_SAME_PASSWORD =
            "New password cannot be same as old password.";

    public static final String MESSAGE_ACCOUNT_SUCCESS =
            "Verification Successful!";

    //

    public static final String MESSAGE_CHANGE_PASSWORD_INVALID_INPUT =
            "Invalid password format. Please try again.";

    public static final String MESSAGE_CHANGE_PASSWORD_VERIFY_DIFFERENT =
            "Passwords do not match. Please reenter.";

    public static final String MESSAGE_CHANGE_PASSWORD_SAME =
            "New password cannot be same as your current password";

    public static final String MESSAGE_CHANGE_PASSWORD_SUCCESSFUL =
            "Password changed successfully!";

    //

    public static final String MESSAGE_CHANGE_NAME_INVALID_INPUT =
            "Invalid username. Please try again.";

    public static final String MESSAGE_CHANGE_NAME_SAME =
            "New username cannot be same as your current username";

    public static final String MESSAGE_CHANGE_NAME_SUCCESSFUL =
            "Username hanged successfully!";
}
