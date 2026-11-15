package PlayFun;

import java.util.InputMismatchException;
import java.util.Scanner;

public class triangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = 0;
        while (true) {
            try {
                num = input.nextInt();
            } catch (InputMismatchException e){
                System.out.println("sorry only can scanner integer");
                input.nextLine();
                continue;
            } catch (Exception e) {
                e.printStackTrace();
                input.nextLine();
                continue;
            }
            if (num > 10) {
                System.out.println("sorry only can 10 below");
                continue;
            }
            for (int i = 1; i <= num; i++) {
                for ( int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println("");
            }
            break;
        }
    }
}
