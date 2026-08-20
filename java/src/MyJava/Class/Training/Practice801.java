package MyJava.Class.Training;

import MyJava.Class.ClassMe.ClassMe800.Account;

import java.util.Scanner;

public class Practice801 {
    public static void main(String[] args) {
        //实现银行存款功能
        Account account = new Account();
        Scanner input = new Scanner(System.in);
        while (true) {                                          //添加while用于如果不想结束循环
            System.out.println("Welcome to Maze Bank !");
            System.out.println("1.Deposit, 2.Withdraw, 3.Check Balance 0.Quit. Please select your service");
            int num = input.nextInt();                         //输入整数对应银行功能
            //
            if (num == 1) {
                System.out.println("Here's deposit service, please enter your deposit amount");
                double money = input.nextDouble();
                account.save(money);
            } else if (num == 2) {
                System.out.println("Here's withdraw service, please enter your withdraw amount");
                double money = input.nextDouble();
                account.get(money);
            } else if (num == 3) {
                account.check();
            } else if (num == 0) {
                System.out.println("Thanks for visit Maze Bank, see you soon !");
                break;
            } else {
                System.out.println("Service not found, please try again");
            }
            System.out.println("===================================================================");
        }
    }
}
class Practice802 {
    public static void main(String[] args) {
    }
}