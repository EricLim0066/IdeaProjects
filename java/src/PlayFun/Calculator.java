package PlayFun;

import java.util.Scanner;

public class Calculator {
    static Scanner input = new Scanner(System.in);
    static int num1;
    static int num2;
    static int result;

    public static void Add() {
        result = num1 + num2;
        System.out.println(result);
    }
    public static void Sub() {
        result = num1 - num2;
        System.out.println(result);
    }
    public static void Multi() {
        result = num1 * num2;
        System.out.println(result);
    }
    public static void Divis() {
        if (num2 != 0) {
            result = num1 / num2;
            System.out.println(result);
        } else {
            System.out.println("Cannot divide by 0");
        }
    }
    public static void main(String[] args) {
        //User Want calc
        System.out.println("Enter first number");
        num1 = input.nextInt();
        System.out.println("Enter Symbol");
        String calc = input.next();
        System.out.println("Enter Second number");
        num2 = input.nextInt();
        switch (calc) {
            case "+":
                Add();
                break;
            case "-":
                Sub();
                break;
            case "*":
                Multi();
                break;
            case "/":
                Divis();
                break;
            default :
                System.out.println("restart");
                break;
        }
    }
}
