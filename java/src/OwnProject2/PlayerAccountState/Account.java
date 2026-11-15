package OwnProject2.PlayerAccountState;

public class Account {
    private String playerName;
    private String playerPassword;
    private final String playerUid;
    private final int playerNumber;

    public enum PasswordChangeResult { SUCCESS, SAME_AS_CURRENT, VERIFY_DIFFERENT, INVALID_INPUT }
    public enum UsernameChangeResult { SUCCESS, SAME_AS_CURRENT, INVALID_INPUT }
    public enum IdentityCheckResult { SUCCESS, PASSWORD_ERROR, USERNAME_ERROR, INVALID_INPUT }
    
    public String getPlayerName() {
        return this.playerName;
    }

    public String getPlayerUid() {
        return this.playerUid;
    }

    public int getPlayerNumber() {
        return this.playerNumber;
    }

    public Account (String playerName, String playerPassword, String playerUid, int playerNumber) {
        this.playerName = playerName;
        this.playerPassword = playerPassword;
        this.playerUid = playerUid;
        this.playerNumber = playerNumber;
    }

    private void changePassword (String newPlayerPassword) {
        this.playerPassword = newPlayerPassword;
    }

    private void changeUsername (String newPlayerName) {
        this.playerName = newPlayerName;
    }

    private static boolean isValid(String text) {
        return text != null && !text.isBlank();
    }

    // does input equal the stored password
    public boolean passwordMatches(String input) {
        return this.playerPassword.equals(input);
    }

    private boolean usernameMatches(String input) {
        return this.playerName.equals(input);
    }

    // identity user before change username or login
    public IdentityCheckResult checkUserInfo (String inputPassword, String inputUsername) {
        if (!isValid(inputPassword) || !isValid(inputUsername)) {
            return IdentityCheckResult.INVALID_INPUT;
        }

        if (!passwordMatches(inputPassword)) {
            return IdentityCheckResult.PASSWORD_ERROR;
        }

        if (!usernameMatches(inputUsername)) {
            return IdentityCheckResult.USERNAME_ERROR;
        }

        return IdentityCheckResult.SUCCESS;
    }

    private PasswordChangeResult validateNewPassword(String newPassword, String againPassword) {
        if (!isValid(newPassword) || !isValid(againPassword)) {
            return PasswordChangeResult.INVALID_INPUT;
        }

        if (!newPassword.equals(againPassword)) {
            return PasswordChangeResult.VERIFY_DIFFERENT;
        }

        if (passwordMatches(newPassword)) {
            return PasswordChangeResult.SAME_AS_CURRENT;
        }

        return PasswordChangeResult.SUCCESS;

    }

    private UsernameChangeResult validateNewUsername (String newUsername) {
        if (!isValid(newUsername)) {
            return UsernameChangeResult.INVALID_INPUT;
        }

        if (usernameMatches(newUsername)) {
            return UsernameChangeResult.SAME_AS_CURRENT;
        }

        return UsernameChangeResult.SUCCESS;
    }

    public PasswordChangeResult doChangePassword (String newPassword, String againPassword) {
        PasswordChangeResult result = validateNewPassword(newPassword, againPassword);
        if (result == PasswordChangeResult.SUCCESS) {
            changePassword(newPassword);
        }
        return result;
    }

    // stop use, go registry
    public UsernameChangeResult doChangeUsername (String newUsername) {
        UsernameChangeResult result = validateNewUsername(newUsername);
        if (result == UsernameChangeResult.SUCCESS) {
            changeUsername(newUsername.toLowerCase());
        }
        return result;
    }
}
