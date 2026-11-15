package MyJava.Class.Me;

import java.util.Scanner;

public class Me100 {
    public static void main(String[] args) {
        //定义变量,后续可改变的量
        int n = 5;                                     //int只能保存整数 //=用于赋值
        System.out.println(n);                         //不放""输出变量值
        System.out.println("n");                       //放""输出里面内容
    }
}
class Me101 {
    public static void main(String[] args) {
        //标识符命名规则
        System.out.println("int int = 5 ");               //不可使用或同名系统关键词作为标识符，否则报错
        System.out.println("num");                        //标识符先定义其值再使用，否则报错
        System.out.println("int a = 5");                  //标识符只能包含"a~z","0~9","_"
        //开头只能"a~z","_"

        /* int name;
           int age;
           //开头a~z，可以运行

           int best_2024;
           int city1977;
           //虽然后面是数字但前面开头是字母，可以运行

           int _first;
           int _13theme;
           //只要开头是"_",后面可以跟数字或字母

           int 5th;
           int 81days;
           //开头数字,报错

           int price$;
           int _we@;
           //如果包含"_"以外的符号，不管开头是字母还是"_",报错

         */
        System.out.println("int a = 5; int a = 3");    //同一段域，标识符不可重复定义，否则报错
        System.out.println("int a = 5; int A = 3");    //但同段域，标识符可通过大小写区分定义，但可读性变差，不建议
        System.out.println("int apple = 5");           //尽量见名知义，增加可读性，详情Practice101
    }
}
class Me102 {
    public static void main(String[] args) {
        byte a  = 100;                                 //byte 只能存极少数，不常用
        short bc = 200;                                //short 比byte稍大，但还是比int小，不常用
        int cd = 300;                                  //int 只能储存整数，最常用
        long de = 400;                                 //long 能存比int大的极大数，但编程很少使用过大范围，不常用

        double b = 10.4;                               //double 双精度，精度更高，储存小数
        float bb = 3.1f;                               //float 单精度, 也是储存小数点，但精度低，后面要加f，不常用

        char c = 'b';                                  //char 只能储存单个字符，要用单括号

        String e = "helo";                             //String 储存多个字符，要用双括号，注意S要大写
        String f = "13114";                            //same as "char"储存字符,储存数字将视为字符而不是数字

        System.out.println(a + b + 'e' + "helo");
    }
}
class Me103 {
    public static void main(String[] args) {
        //定义常量，后续不可改变的量
        //常量一旦定义，任何后续无法更改其值，尝试更改会报错
        int a = 2;
        a = 2 * a;                                     //变量可通过后续更改其初始值
        System.out.println(a);
        //
        final int A = 2;                               //final double; final char; final String
        // A = 2 * A                                   //final 为基本常量，标识符通常全大写，后续数值无法更改
        System.out.println(A);
    }
}
class Me104 {
    public static void main(String[] args) {
        //赋值运算符
        // =赋值符，不是等于符， +加符， -减符， *乘符， /除符， %取余符
        int a = 300;                                             //表示300赋值给a
        int b = 800;                                             //表示800赋值给b
        int c = a * b;                                           //表示a乘以b的值赋值给c
        System.out.println(c + a + b);
        //
        int num1 = 5;
        int num2 = 2;
        int d = (num1 % num2);
        int e = (num1 / num2);
        System.out.println(num1 + " % " + num2 + " = " + d);     //5%2余1，取1
        System.out.println(num1 + " / " + num2 + " = " + e);     //5/2本为2.5，在int去小数点取2
    }
}
class Me105 {
    public static void main(String[] args) {
        //自增自减运算符
        int a = 1;
        a++;                                                     //++自增，每次加1
        System.out.println(a);
        a--;                                                     //--自减，每次减1
        System.out.println(a);
        //
        int b = 2;
        System.out.println(b++);                     //b++ 字符在前，先运算再+1 （先用后加）
        int c = 2;
        System.out.println(++c);                     //++c ++在前，先+1再运算 （先加后用）
        int d = 2;
        System.out.println(d--);                     //d-- 字符在前，先运算再-1 （先用后减）
        int e = 2;
        System.out.println(--e);                     //--e --在前，先-1再运算 （先减后用）
    }
}
class Me106 {
    public static void main(String[] args) {
        //类型自动转换
        double num1 = 1.2;
        int num2 = 1;
        double a = num1 + num2;                      //类型必须相同，数字换数字，123 to 123
        System.out.println(a);                       //原类型 < 目标类型，double可以cover掉整数和小数，int只可以cover整数
        //类型强制转换
        double num3 = 3.14;
        int b = (int)num3;                           //前提也是内容必须相同
        System.out.println(b);                       //目标类型 < 原类型，int无法cover double，需要从double强制转换成int
    }
}
class Me107 {
    public static void main(String[] args) {
        //等于创建一个扫描对象仪
        Scanner input = new Scanner(System.in);      //Scanner 接受用户输入内容
        int num = input.nextInt();                   //可接收操作台，接收数字
        System.out.println("Your enter contact is " + num);
        //char num = scanner.next().charAt(0);接收单字符，//String num = scanner.next().;接收字符串
    }
}