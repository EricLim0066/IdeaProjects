package MyJava.Class.Training;

import java.util.Scanner;

class Practice201 {
    public static void main(String[] args) {
        //输入一个整数判断是不是偶数，如果是，输出"偶数"
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        //
        if (num%2 == 0) {
            System.out.println("even number");
        }
    }
}
class Practice202 {
    public static void main(String[] args) {
        //给一个整数，判断该数是奇数或偶数，如果是奇数输出odd，偶数输出even
        Scanner input = new Scanner(System.in);
        //用alt + enter将nextInt()接收到的数据快速生成一个变量，alt + enter然后三下enter
        int i = input.nextInt();
        //
        if (i % 2 != 0) {
            System.out.println("This number is odd number.");
        } else {
            System.out.println("This number is even number.");
        }
    }
}
class Practice203 {
    public static void main(String[] args) {
        //输入两个整数比较大小，若x大于y输出">"，若x等于y输出"=="，若x小于y输出"<"
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int num2 = input.nextInt();                     //添加多个接收台，输入多个讯息
        //
        if ( num < num2 ) {
            System.out.println("<");
        } else if ( num == num2 ) {
            System.out.println("==");
        } else {
            System.out.println(">");
        }
    }
}
class Practice204 {
    public static void main(String[] args) {
        //输入并读取一个整数，如果这个数大于1小于100，输出yes，否则输出no
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        //
        if ( num > 1 ) {
            if ( num < 100 ) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        } else {
            System.out.println("no");
        }
    }
}
class Practice205 {
    public static void main(String[] args) {
        //输入三个数，并输出其中最大数（打擂台）
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int num2 = input.nextInt();
        int num3 = input.nextInt();
        //
        int max = num;
        if ( max < num2 ) {
            max = num2;
        }
        if ( num3 > max) {
            max = num3;
        }
        System.out.println( "The biggest number is " + max );
    }
}
class Practice206 {
    public static void main(String[] args) {
        //判断某年是否闰年，如果公元x年是闰年，输出"yes",否则"no"
        System.out.println("Enter the Years");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        //
        if ( (num%4 == 0 && num%100 != 0) || num%400 == 0 ) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
