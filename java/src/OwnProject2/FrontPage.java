package OwnProject2;

import OwnProject2.ConsoleBox.ConsoleBox;
import OwnProject2.ConsoleBox.ConsoleInput;
import OwnProject2.ConsoleBox.ConsoleLogin;
import OwnProject2.ConsoleFlow.RegistrationFlow;
import OwnProject2.CreateUid.UidGenerator;
import OwnProject2.OTPvalidate.FileCodeSender;
import OwnProject2.OTPvalidate.OtpConfig;
import OwnProject2.OTPvalidate.OtpVerificationService;
import OwnProject2.PlayerAccountState.Account;
import OwnProject2.PlayerAccountState.AccountRegistry;
import OwnProject2.PlayerAccountState.PlayerState;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.time.Clock;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

class FrontPage {
    public static ConsoleBox console = new ConsoleBox();
    public static PlayerState player = new PlayerState(0);
    public static void main(String[] args) {
        String leftTitle = "Game";
        String rightTitle = "Player State";
        List<String> list = List.of(

        );
        List <String> play = List.of(
                "Player name :",
                "PLayer uid :",
                "Amount :" + player.getDollarAmount(),
                "Current Stake :" + player.getStake(),
                "Current Bet : " + player.getBet(),
                "Total of rounds :" + player.getRounds(),
                "Win :" + player.getWin(),
                "Lose :" + player.getLose(),
                "Win Rate :" +player.getWinRate()

        );
        console.show(leftTitle, rightTitle, list, play);
    }
}

class loginPage {
    public static ConsoleLogin login = new ConsoleLogin();

    public static void main(String[] args) {
        String title = "Login";
        Scanner input = new Scanner(System.in);
        List <String> hint = List.of(
                "Welcome to Betting Game",
                "",
                "1.Login",
                "2.Sign In",
                "",
                "3.Esc",
                "",
                ""
        );

        login.show(title, hint);
    }
}

class money {
    public static PlayerState state = new PlayerState(0);

    private static void message() {
        System.out.println("Bet : " + state.getBet());
        System.out.println("Stake :" + state.getStake());
        System.out.println("Amount :" + state.getCentAmount());
        System.out.println("Front amount :" + state.getDollarAmount());
    }

    public static void main(String[] args) {

        message();

        System.out.println("money -> amount (money)");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        state = new PlayerState(num);

        message();

        System.out.println("amount -> stake (money)");
        int num2 = input.nextInt();
        boolean s = state.verifyExchange(num2);

        message();

        System.out.println("stake -> bet (stake)");
        int num3 = input.nextInt();
        boolean t = state.verifyPlaceBet(num3);

        message();

        System.out.println("stake -> money (stake)");
        int num4 = input.nextInt();
        boolean u = state.verifyWithdraw(num4);

        message();
    }
}

class account {
    public static void main(String[] args) {
        AccountRegistry registry = new AccountRegistry(new UidGenerator("A000AA0", new SecureRandom()));
        OtpVerificationService otp = new OtpVerificationService(
                new SecureRandom(), Clock.systemUTC(), new FileCodeSender(OtpConfig.INBOX));
        ConsoleInput input = new ConsoleInput(
                new BufferedReader(new InputStreamReader(System.in)));

        RegistrationFlow flow = new RegistrationFlow(registry, otp, input);
        while (true) {
            Optional<Account> result = flow.run();

            System.out.println(result
                    .map(a -> "RESULT: OK  uid=" + a.getPlayerUid()
                            + "  no=" + a.getPlayerNumber())
                    .orElse("RESULT: CANCELLED"));

            String check = input.readString("Look up which name? (blank to skip): ");
            if (!check.isBlank()) {
                System.out.println("findByName -> "
                        + (registry.findByName(check) != null ? "FOUND" : "not found"));
            }

            if (!input.readString("Run again? (y/n): ").equalsIgnoreCase("y")) {
                break;
            }
        }
    }
}