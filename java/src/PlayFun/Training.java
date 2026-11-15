package PlayFun;


import java.util.Scanner;

public class Training {
    public static void main(String[] args) {
        int age = 10;
        String name = "Ahmeng";
        double tall = 170.54;
        System.out.println("Hi, my name is " + name + ". I'm " + age + " years old, my height is " + tall + "." );
        System.out.printf("Hi, my name is %s, I'm %d years old, my tall is %.2f %n", name,age,tall);
    }
}

class Training1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        if (num < 0) {
            System.out.println("Sorry invalid number");
        } else if (num >= 18) {
            System.out.println("Adult");
        } else {
            System.out.println("Child");
        }
    }
}
 class Training2 {
     public static void main(String[] args) {
         int num = 1;
         int num2 = 2;
         for (int i = 0; i < 10; i++) {
             if (num % 2 == 0) {
                 System.out.println(num);
             }
             num++;
         }
         while (num2 <= 10) {
             System.out.println(num2);
             num2 += 2;
         }
     }
 }

class Training3 {
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
    public static int sumRange(int start, int end) {
        int num = 0;
        for (int i = start; i <= end; i++) {
            num += i;
        }
        return num;
    }
    public static void main(String[] args) {
        int num = 0;
        int start = 1;

        Scanner input = new Scanner(System.in);
        num = input.nextInt();
        boolean even = isEven(num);
        int sum = sumRange(start, num);

        System.out.println(even);
        System.out.println(sum);
    }
}

class Training4 {
    private String owner = "Ahmeng";
    private double balance = 500;
    private double wallet = 0;

    public double getBalance() {
        return this.balance;
    }

    public double getWallet() {
        return this.wallet;
    }

    public void BankAccount(String owner) {
        this.owner = owner;
        this.balance = 500;
        this.wallet = 0;
    }

    private String saveMoney(double num) {
        if (num > this.wallet) {
            return "The amount cannot more than your wallet balance :(";

        } else if (num <= 0) {
            return "Sorry invalid amount :(";

        } else {
            this.balance += num;
            this.wallet -= num;
            return "Deposit Success";
        }
    }

    private String takeMoney(double num) {
        if (num > this.balance) {
            return "Sorry no have enough money to withdraw you poor guy XD";

        } else if (num <= 0) {
            return "invalid amount :(";

        } else {
            this.balance -= num;
            this.wallet += num;
            return "Withdraw Success";
        }
    }

    public String Action(String action, double num) {
        if (action.equals("take")) {
            return this.takeMoney(num);

        } else if (action.equals("save")) {
            return this.saveMoney(num);
        }

        return "Unknown action";
    }

    public String getOwner() {
        return owner;
    }
}
class Training5 {
    private static String withdraw(String action, Training4 data) {

        Scanner input = new Scanner(System.in);
        double num;
        double amount = data.getBalance();
        double wallet = data.getWallet();


        System.out.println("Welcome to withdraw system, how many you want to withdraw ?");
        System.out.printf("Current Bank balance: %.2f.%n", amount);
        System.out.printf("Current Wallet balance: %.2f.%n", wallet);

        try {
            num = input.nextDouble();
        } catch (Exception ignored) {
            System.out.println("Please enter invalid amount :(");
            return "Fail";
        }
        return data.Action(action, num);
    }

    private static String deposit(String action, Training4 data) {

        Scanner input = new Scanner(System.in);
        double num;
        double amount = data.getBalance();
        double wallet = data.getWallet();


        System.out.println("Welcome to deposit system, how many you want to deposit?");
        System.out.printf("Current Bank balance: %.2f.%n", amount);
        System.out.printf("Current Wallet balance: %.2f.%n", wallet);

        try {
            num = input.nextDouble();
        } catch (Exception ignored) {
            System.out.println("Please enter invalid amount :(");
            return "Fail";
        }
        return data.Action(action, num);
    }

    public static String chosen (Training4 data) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Welcome %s, which service you want ?%n",data.getOwner() );
        System.out.println("Press 1 to deposit");
        System.out.println("Press 2 to withdraw");

        String result = " ";
        String action;
        int num = scanner.nextInt();

        if (num == 1) {
            action = "save";
            result = deposit(action, data);

        } else if (num == 2) {
            action = "take";
            result = withdraw(action, data);
        }
        return result;
    }
    public static void main(String[] args) {
        Training4 data;
        data = new Training4();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to bank, Please enter ur name: " );

        int num = 3;

        while (num >= 0) {
            String name = scanner.nextLine();
            if (name.equals(data.getOwner())) {
                System.out.println(chosen(data));
                System.out.println("Bank: "  + data.getBalance());
                System.out.println("Wallet: " + data.getWallet());
                num = 3;
                break;
            } else if (num < 0){
                System.out.printf("Sorry wrong user, please enter again, you still have %d times :", num);
                num -= 1 ;
            } else {
                System.out.println("Sorry no have times to enter your name, see you next time");
            }
        }
    }
}
class Training6 {

    public static int findMax(int[] scores) {

        int max = scores[0];
        for (int temp : scores) {
            if (temp > max) {
                max = temp;
            }
        }
       return max;
    }

    public static double average(int[] scores) {

        double temp = 0;
        for (int ave : scores) {
            temp += ave;
        }
        temp = temp / scores.length;
        return temp;
    }

    public static void main(String[] args) {
        int[] scores = {23, 89, 12, 67, 45};

        System.out.println("Max number :" + findMax(scores));
        System.out.println("Average number :" + average(scores));
    }
}
