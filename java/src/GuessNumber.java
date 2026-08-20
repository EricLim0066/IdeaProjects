import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        //Guess number game
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int GuessNum = random.nextInt(100)+1;
        int BigNum = 100;
        int SmallNum = 1;
        boolean flag = true;
        int attempts = 0;
        System.out.println("guess a number between " + SmallNum + " and " + BigNum);
        //set number between 100 and 1
        while (flag) {
            try {
                int Guess = input.nextInt();
                if (Guess > BigNum || Guess < SmallNum) {
                    throw new IllegalArgumentException("Sorry out of range, It's between " + SmallNum + " and " + BigNum + " , please try again :(");
                }
                //
                if (Guess > GuessNum) {
                    BigNum = Guess;
                    System.out.println("Continue guess ! It's between " + SmallNum + " and " + BigNum);
                    attempts++;
                } else if (Guess < GuessNum) {
                    SmallNum = Guess;
                    System.out.println("Continue guess ! It's between " + SmallNum + " and " + BigNum);
                    attempts++;
                } else {
                    System.out.println("Boom ! it's " + GuessNum);
                    attempts++;
                    System.out.println("Total guess: " + attempts );
                    flag = false;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Input valid must only be integer, please try again :(");
                input.nextLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
