package OwnProject2.OTPvalidate;

import java.nio.file.Path;
import java.time.Duration;

public class OtpConfig {
    private OtpConfig() {}

    public static final int CODE_LENGTH = 6;
    public static final int MAX_ATTEMPTS = 3;
    public static final Duration VALID_FOR = Duration.ofMinutes(1);
    public static final Path INBOX = Path.of(System.getProperty("user.home"),"otp","otp.txt");
}
