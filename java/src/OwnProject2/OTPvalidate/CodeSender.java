package OwnProject2.OTPvalidate;

import java.time.Duration;

public interface CodeSender {
    void send(String key, String code, Duration validFor);
}


