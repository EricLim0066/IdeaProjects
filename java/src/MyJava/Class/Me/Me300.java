package MyJava.Class.Me;

import java.util.Scanner;

public class Me300 {
    public static void main(String[] args) {
        //循环结构
        //在判断条件满足下，重复执行同一段代码 （先判断，后执行）
        //三大循环结构，for循环，while循环，do while循环             //for 四大要素
        for (int i = 1; i < 5; i++) {                          //for(循环变量初始值（设一开始的的值）;循环条件（要值循环多少次）;循环变量增值（每次循环增加或减少）) {
            System.out.println("hi");                          //要执行的循环语句;
        }                                                      //}
    }
}
class Me301 {
    public static void main(String[] args) {
        //用for循环输出100编“ x time learning "                   //执行机制
        for (int i = 1; i <= 100; i++) {                        //1.先执行循环变量初始值，注只执行一次 (int i = 1)
            System.out.println( i + " time learning.");         /*2.判断循环条件，若为假（初始值大于循环条件），结束执行跳到5
                                                                 若为真（初始值仍小于循环条件），继续执行 ( i <= 100) → (sout("");)   */
        }                                                       //3.执行变量增值 (i++)
    }                                                           //4.转回2重复执行，再判断是否还是小于循环条件，小于就继续执行，反而之
}                                                               //5.循环结束，执行下一条
class Me302 {
    public static void main(String[] args) {
        //break跳出循环，可改变程序控制流向，即任意在某段强制结束并跳出整个循环到for }
        //输入一个数，判断是不是质数，（只能被1和本身整除）
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        boolean flag = true;                                    //假设每个数字都是质数，设立flag为true
        if ( num <= 1 ) {                                       //1不是质数，为了严谨，补上漏洞
            flag = false;
        }
        for (int i = 2; i < num; i++) {                         //设立计数器，让i从2（最小质数）开始，每次加1，直到i等于num时停止循环
            if (num%i == 0) {                                   //用输入数字取余i，查看是否没有余，如果num能被i整除，说明找到了因数
                flag = false;                                   //能整除，变动flag为false
                break;                                          //用break中断，避免不必要计算
            }
        }
        if ( flag == true ) {
            System.out.println("Yes，is prime number");
        } else {
            System.out.println("No, isn't prime number");
        }
    }
}
class Me303 {
    public static void main(String[] args) {
        //continue循环，和break类似作用，但break是跳出整个循环，continue是跳出本次循环继续下一次循环，不会结束整个循环
        //Franklin和朋友们玩名叫逢7必过的游戏，大家围坐一起开始报数，从1到20，每次到7的倍数或者尾数为7的不必报数
        for (int i = 1; i <= 20; i++) {
            if (i % 7 == 0 || i % 10 == 7) {                     //倍数分离，取余7为0时便是7的倍数 //尾数分离，取余10为7时便是7的尾数
                System.out.println("pass");
                continue;                                       //放continue，后续没有了执行机会，继续下一个循环
            }
            System.out.println(i);
        }
    }
}
class Me304 {
    public static void main(String[] args) {
        //while循环，先判断条件，只要条件为真就重复执行，适用于循环次数未知但有明确继续条件的场景（先判断，后执行）
        //不同于for，for对循环次数已知
        //用while输入1~100这几个数字
        int a = 1;
        int b = 100;
        while ( a <= b ) {                                  //for循环需要放三大要素，但while只需要循环条件
            System.out.println(a);
            a++;
        }
    }
}
class Me305 {
    public static void main(String[] args) {
        //do while循环，无论条件是否成立，都会先执行一次（先执行，后判断）
        //和for while不同，for while因为先判断，所以有可能一次都不执行
        int a = 1;
        int b = 0;
        do {
            a++;
        } while (a < b);                                  //不同于for while，do while的while后面是;而不是{
        System.out.println(a);
    }
}
