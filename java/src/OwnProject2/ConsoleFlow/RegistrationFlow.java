package OwnProject2.ConsoleFlow;

import OwnProject2.ConsoleBox.ConsoleInput;
import OwnProject2.MessageToPlayer.OtpVerifyMessage;
import OwnProject2.MessageToPlayer.RegisterResultMessage;
import OwnProject2.MessageToPlayer.RegisterInputMessage;
import OwnProject2.OTPvalidate.OtpConfig;
import OwnProject2.OTPvalidate.OtpVerificationService;
import OwnProject2.OTPvalidate.VerifyResult;
import OwnProject2.PlayerAccountState.Account;
import OwnProject2.PlayerAccountState.AccountRegistry;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.Optional;

public class RegistrationFlow {
    private final AccountRegistry registry;
    private final OtpVerificationService otp;
    private final ConsoleInput input;

    public RegistrationFlow(AccountRegistry registry, OtpVerificationService otp, ConsoleInput input) {
        this.registry = registry;
        this.otp = otp;
        this.input = input;
    }

    private boolean confirmByOtp(String key) {
        otp.issue(key);
        System.out.println(RegisterInputMessage.codeSentTo(OtpConfig.INBOX));
        while (true) {
            System.out.println(RegisterInputMessage.MESSAGE_ASK_CODE);
            Optional <String> line = input.readLineWithin(() -> otp.uiRemaining(key), this::showCountdown);
            if (line.isEmpty()) {
                System.out.println(OtpVerifyMessage.textOf(VerifyResult.TIME_EXPIRED));
                otp.cancel(key);
                return false;
            }

            String code = line.get().trim();
            if (code.isEmpty()) {
                System.out.println("\r" + OtpVerifyMessage.MESSAGE_OTP_BLANK);
                continue;
            }

            VerifyResult result = otp.verify(key, code);
            if (result == VerifyResult.WRONG_CODE) {
                int attempts = otp.attemptsLeft(key);
                System.out.println(OtpVerifyMessage.wrongCode(attempts));
                continue;
            }

            if (result == VerifyResult.SUCCESS) {
                otp.cancel(key);
                System.out.println(OtpVerifyMessage.MESSAGE_OTP_SUCCESS);
                return true;
            }

            System.out.println(OtpVerifyMessage.textOf(result));
            return false;
        }
    }

    private void showCountdown(Duration left) {
        int minutes = Math.toIntExact(left.toMinutes());
        int seconds = left.toSecondsPart();
        System.out.println(RegisterInputMessage.countdown(minutes, seconds));
    }

    private String askName() {
        while (true) {
            String name = input.readString(RegisterInputMessage.MESSAGE_ASK_NAME);
            if (!name.isBlank()) {
                return name;

            }
            System.out.println(RegisterResultMessage.MESSAGE_REGISTER_EMPTY_NAME);
        }

    }

    private String askPassword () {
        while (true) {
            String password = input.readString(RegisterInputMessage.MESSAGE_ASK_PASSWORD);
            if (!password.isBlank()) {
                return password;
            }
            System.out.println(RegisterResultMessage.MESSAGE_REGISTER_EMPTY_PASSWORD);
        }
    }

    public Optional<Account> run() {
        String name = askName();
        String password = askPassword();
        AccountRegistry.RegisterResult result = registry.check(name, password);

        if (result != AccountRegistry.RegisterResult.SUCCESS) {
            System.out.println(RegisterResultMessage.textOf(result));
            return Optional.empty();
        }
        String key = registry.normalizeName(name);

        if (!confirmByOtp(key)) {
            return Optional.empty();
        }

        AccountRegistry.RegisterOutcome outcome = registry.register(name, password);
        System.out.println(RegisterResultMessage.textOf(outcome.result()));
        if (outcome.result() != AccountRegistry.RegisterResult.SUCCESS) {
            return Optional.empty();
        }

        return Optional.of(outcome.account());

    }
}
