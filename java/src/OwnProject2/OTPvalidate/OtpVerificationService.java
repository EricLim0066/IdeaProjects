package OwnProject2.OTPvalidate;

import java.security.SecureRandom;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import static OwnProject2.OTPvalidate.OtpConfig.VALID_FOR;

public class OtpVerificationService {
    private final Map<String, OtpPending> pending = new HashMap<>();
    private final SecureRandom random;
    private final Clock clock;
    private final CodeSender sender;

    public OtpVerificationService(SecureRandom random, Clock clock, CodeSender sender) {
        this.random = random;
        this.clock = clock;
        this.sender = sender;
    }

    private String generateCode() {
        String template = "%0" + OtpConfig.CODE_LENGTH + "d";
        int bound = (int)(Math.pow(10,OtpConfig.CODE_LENGTH));
        return String.format(template,random.nextInt(bound));
    }

    public void issue (String key) {
        String code = generateCode();

        Instant expiryFor = clock.instant().plus(VALID_FOR);

        // send the code and time to file
        sender.send(key, code, VALID_FOR);

        // record the last code sent and expiry time
        pending.put(key, new OtpPending(code, expiryFor));

    }

    public VerifyResult verify(String key, String input) {
        OtpPending request = pending.get(key);

        if (request == null) {
            return VerifyResult.NOTFOUND;
        }

        if (!clock.instant().isBefore(request.expireAt)) {
            cancel(key);
            return VerifyResult.TIME_EXPIRED;
        }

        if (!request.code.equals(input)) {
            request.attempts++;
            if (request.attempts >= OtpConfig.MAX_ATTEMPTS) {
                cancel(key);
                return VerifyResult.ATTEMPT_LIMITED;
            }

            return VerifyResult.WRONG_CODE;
        }

        cancel(key);
        return VerifyResult.SUCCESS;
    }

    public void cancel(String key) {
        pending.remove(key);
    }

    public Duration uiRemaining(String key) {
        OtpPending request = pending.get(key);
        if (request == null) {
            return Duration.ZERO;
        }

        Duration left = Duration.between(clock.instant(), request.expireAt);
        if (left.isNegative()) {
            return Duration.ZERO;
        }

        return left;
    }

    private static final class OtpPending {
        private final String code;
        private final Instant expireAt;
        private int attempts;

        private OtpPending(String code, Instant expireAt) {
            this.code = code;
            this.expireAt = expireAt;
        }
    }

    public int attemptsLeft(String key) {
        OtpPending request = pending.get(key);

        // return 0, that mean locked or haven't requested yet
        if (request == null) {
            return 0;
        }

        return OtpConfig.MAX_ATTEMPTS - request.attempts;
    }
}

