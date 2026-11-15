package OwnProject2.OTPvalidate;

import OwnProject2.MessageToPlayer.OtpVerifyMessage;

import java.time.Duration;

public class OtpSetText {
    private OtpSetText() {}

    public static String fileBody(String code, Duration validFor) {
        long minutes = validFor.toSeconds();
        return """
               Your verification code is :%s.
                
               This code is valid for %d minutes.
                
               Do not reply this message.
                
               """.formatted(code, minutes);
    }
}
