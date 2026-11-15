package OwnProject2.MessageToPlayer;

import OwnProject2.PlayerAccountState.AccountRegistry;

public class RegisterResultMessage {
    private RegisterResultMessage() {}

    public static final String MESSAGE_REGISTER_EMPTY_NAME =
            "Username cannot be empty. Please enter username.";

    public static final String MESSAGE_REGISTER_EMPTY_PASSWORD =
            "Password cannot be empty. Please enter password";

    public static final String MESSAGE_REGISTER_NAME_OCCUPIED =
            "This username is already taken or registered. Please try another one";

    public static final String MESSAGE_REGISTER_LONG_INPUT =
            "Input too long! Username and password must not exceed " + AccountRegistry.EXCEED_LENGTH + " characters";

    public static final String MESSAGE_REGISTER_UID_ERROR =
            "An internal error occurred. Please try again.";

    public static final String MESSAGE_REGISTER_SUCCESS =
            "Registration successful!";

    public static String textOf(AccountRegistry.RegisterResult result) {
        return switch (result) {
            case EMPTY_NAME_INPUT ->
                    MESSAGE_REGISTER_EMPTY_NAME;

            case EMPTY_PASSWORD_INPUT ->
                    MESSAGE_REGISTER_EMPTY_PASSWORD;

            case NAME_OCCUPIED ->
                    MESSAGE_REGISTER_NAME_OCCUPIED;

            case UID_GENERATE_ERROR ->
                    MESSAGE_REGISTER_UID_ERROR;

            case LONG_INPUT ->
                    MESSAGE_REGISTER_LONG_INPUT;

            case SUCCESS ->
                    MESSAGE_REGISTER_SUCCESS;
        };
    }
}
