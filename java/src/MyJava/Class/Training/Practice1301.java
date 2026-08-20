package MyJava.Class.Training;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Practice1301 {
    public static void main(String[] args) {
        //输入1~7任何数字，输出对应的星期名，如果输入不是数字，给出提示，如果是1~7以外的数字，提示无对应数据
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number between 1~7 for the corresponding week name");
        //switch选择结构判定
        try {                                                      //try执行代码
            int num = input.nextInt();
            switch (num) {
                case 1:
                    System.out.println("Monday");
                    break;
                case 2:
                    System.out.println("Tuesday");
                    break;
                case 3:
                    System.out.println("Wednesday");
                    break;
                case 4:
                    System.out.println("Thursday");
                    break;
                case 5:
                    System.out.println("Friday");
                    break;
                case 6:
                    System.out.println("Saturday");
                    break;
                case 7:
                    System.out.println("Sunday");
                    break;
                default :                                          //输入1~7以外的数字，提示异常
                    System.out.println("Sorry mismatched numbers :(");
            }
        } catch (InputMismatchException ex) {                      //InputMismatchException 输入不匹配异常
            System.out.println("Sorry not a integer :(");
        } catch (Exception ex) {                                   //Exception 其他异常
            System.out.println("Unknown anomaly");
        } finally {
            System.out.println("Code ended");
        }
    }
}
class Practice1302 {
    public static void main(String[] args) {

    }
}