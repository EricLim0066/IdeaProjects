package MyJava.Class.Training;

import java.util.Scanner;

public class Practice401 {
    public static void main(String[] args) {
        /*打印 0
              12
              345
              6789  */
        int n = 4;
        int k = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(k++);
            }
            System.out.println();
        }
    }
}
class Practice402 {
    public static void main(String[] args) {
        //打印9*9乘法表
        int n = 9;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + (i * j) + "\t" );
            }
            System.out.println();
        }
    }
}
class Practice403 {
    public static void main(String[] args) {
        //求1*1*1*1+2*2*2*2+3*3*3*3+....+n*n*n*n的和
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();                           //打印表达组合
        int sum = 0;                                       //综合变量
        //
        for (int i = 1; i <= n; i++) {                     //外层控制数据的组数
            int temp = 1;
            for (int j = 1; j <= 4; j++) {                 //内层控制每组乘的次数
                temp *= i;                                 //累乘
            }
            sum += temp;                                   //累乘后累加
        }
        System.out.println(sum);
    }
}
class Practice404 {
    public static void main(String[] args) {
        //有个三位数，个位数比百位数大，而百位数又比十位数大，并且各位数字的和等于各位数字的相乘总和，求三位数
        // 个 > 百 > 十, 个+百+十==个*百*十
        for (int i = 1; i <= 9; i++) {                      //个
            for (int j = 1; j <= i; j++) {                  //百
                for (int k = 1; k <= j; k++) {              //十
                    if ((i + j + k) == (i*j*k)) {
                        System.out.println(j*100+k*10+i);
                        break;
                    }
                }
            }
        }
    }
}
class Practice405 {
    public static void main(String[] args) {
        //计算阶乘的和，S = 1!+2!+3!+.....+n!
        //4!(1*2*3*4) , 6!(1*2*3*4*5*6)
        Scanner input = new Scanner (System.in);
        int n = input.nextInt();                           //输入n个数字，代表多少阶乘和
        int s = 0;
        //
        for (int i = 1; i <= n; i++) {                     //外层计算1！递增到n！
            int  temp = 1;                                 //设变量储存数字，放外层内确保每次结果初始化为1
            for (int j = 1 ; j <= i; j++) {                //内层计算i！（单个数字阶乘的结果）
                temp *= j;                                 //累乘
            }
            s += temp;                                     //累乘的结果累加
        }                                                  //累乘完temp回到外层内初始化
        System.out.println(s);
    }
}
class Practice406 {
    public static void main(String[] args) {
        //给一个十进制正整数（1<=n<=10000),写下从1到n的所有整数，然后数其中出现数字1的个数总数
        //比如输入n = 2，输出1，2，有1个1，n = 12,输出1，2，3，4，5，6，7，8，9，10，11，12，有5个1，
        Scanner input = new Scanner (System.in);
        int num = input.nextInt();
        int total = 0;                                      //设置变量
        //
        for (int i = 1; i <= num; i++) {
            int temp = i;                                   //设置替身变量，让temp代替i进行变化，i保持原值
            while (temp != 0 ) {                            //循环到temp变成0，即处理完所有数位
                int n = temp%10;                            //取出n的个位数
                if (n == 1) {                               //如果n是1，变量记录
                    total++;
                }
                temp /= 10;                                 //阶除
            }//每次分离最后一位，改变数字本身大小，减少一位数
        }
        System.out.println(total);
    }
}
class Practice407 {
    public static void main(String[] args) {
        //输入一个正数n，求第n小的质数
        //比如输入10，质数顺序，2，3，5，7，11，13，17，19，21，29，第10个质数便是29
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();                           //输入第几个质数
        int i = 0, num = 2;                                //i保存质数总数; num从最小质数（2）开始判断
        //
        while (true) {                                     //一直执行代码，直到遇到break终止
            //判断num是不是质数
            boolean flag = true;                           //做个开关，假设num是质数
            for (int j = 2; j < num; j++) {                //j从最小质数2开始
                if (num % j == 0) {
                    flag = false;                          //如果num取余j是0，证明不是质数
                    break;                                 //退出当前循环
                }
            }
            //
            if (flag) {
                i++;                                       //如果是质数，i++
                if (i == n) {
                    System.out.println(num);               //如果i等于你输入的n值，输出每次循环的num
                    break;                                 //结束整个循环
                }
            }
            num++;                                         //回到for那里，每次for循环条件增加
        }
    }
}