package PlayFun;

import java.util.Scanner;

public class note {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int b = 0;
        while (num != 0) {
            int a = num%10;
            b = num*10%a;
        }
        System.out.println(b);
    }
}
