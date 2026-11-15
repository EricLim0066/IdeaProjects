package OwnProject2.MessageToPlayer;

import OwnProject2.OTPvalidate.VerifyResult;

public class OtpVerifyMessage {
    private OtpVerifyMessage() {}

    public static String wrongCode(int attempts) {
        String unit = (attempts == 1) ? " attempt" : " attempts";
        return "Invalid verification code. " + attempts + unit + " left. Please try again.";
    }

    public static final String MESSAGE_OTP_EXPIRED =
            "The verification code has expired. Please request a new one.";

    public static final String MESSAGE_ATTEMPT_LIMITED =
            "Too many incorrect attempts! Please try again later.";

    public static final String MESSAGE_NOT_FOUND =
            "No active verification request found. Please request a new code.";

    public static final String MESSAGE_OTP_SUCCESS =
            "Verification successful. ";

    public static final String MESSAGE_OTP_BLANK =
            "The code cannot be empty. Please try again";

    public static String textOf(VerifyResult result) {
        return switch (result) {
            case SUCCESS ->
                    MESSAGE_OTP_SUCCESS;

            case NOTFOUND ->
                    MESSAGE_NOT_FOUND;

            case WRONG_CODE ->
                    throw new IllegalArgumentException("WRONG_CODE needs attempts left, use wrongCode(int)");

            case TIME_EXPIRED ->
                    MESSAGE_OTP_EXPIRED;

            case ATTEMPT_LIMITED ->
                    MESSAGE_ATTEMPT_LIMITED;
        };
    }

}
