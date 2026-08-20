package PlayFun;

import java.util.Scanner;

public class help {
    public String missing;

    public static void missing() {
        System.out.println("go call the 911");
    }

    public help() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to help service center\nwhat situation?");
        String command = input.next();
        if (!command.isEmpty()) {
            missing();
        } else {
            System.out.println("fuck off and bye!");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("any help ?");
        System.out.println("1 === YES \n2 === NO");
        String a = input.nextLine();
        if (a.equals("1")) {
            new help();
        } else if (a.equals("2")) {
            System.out.println("fuck off and bye !");
        }
    }
}

class help2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter a square number to judge imaginary unit:");
        int n = input.nextInt() % 4;
        if (n < 0) {
            n += 4;
        }
        if (n == 0) {
            System.out.println("1");
        } else if (n == 1) {
            System.out.println("i");
        } else if (n == 2) {
            System.out.println("-1");
        } else {
            System.out.println("-i");
        }
    }
}