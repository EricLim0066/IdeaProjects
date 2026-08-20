package MyJava.Class.Training;

import java.util.Scanner;

public class Practice301 {
    public static void main(String[] args) {
        //计算100以内的奇数的和以及偶数的和
        //需要定义两个变量用于保存奇数和以及偶数和
        int even = 0;
        int odd = 0;
        for(int i = 1; i <= 100; i++) {
            if (i%2 == 0) {
                even += i;                                 // +=叠加，-=叠减，把每一次算过的值叠加在even上
            } else {
                odd += i;
            }
        }
        System.out.println("Total even is " + even + ", and total odd is " + odd);
    }
}
class Practice302 {
    public static void main(String[] args) {
        //求1*2+2*3+3*4+4*5+...+100*101的值
        int num1 = 0;                                      //观察(1*2)中的1,循环100次直到（100*101）中的100
        for (int i = 1; i <= 100; i++){                    //观察(1*2)中的2,直到101中每次的数都比前面大1
            num1 += ( i * ( i + 1 ) );                     //故得( i * ( i + 1 ) )
        }
        System.out.println(num1);
    }
}
class Practice303 {
    public static void main(String[] args) {
        //水仙花是三位数，等于各数位上的数字总立方和，1³+5³+3³=153（即每个数位上的数字按照总数位^，加起来还是该数字本身）
        for (int i = 100; i < 1000; i++) {
            int hun = (i / 100) % 10;                      //位数分离，找百位数
            int ten = (i / 10) % 10;                       //位数分离，找十位数
            int one = (i / 1) % 10;                        //位数分离，找个位数

            if ( ( hun * hun * hun ) + ( ten * ten * ten ) + ( one *one * one ) == i) {
                System.out.println(i);
            }
        }
    }
}
class Practice304 {
    public static void main(String[] args) {
        //使用while求6+12+18+24....+180的总和
        int a = 6;                                         //定义初始值
        int b = 180;                                       //定义最高值
        int c = 0;                                         //定义变量总和
        while ( a <= b ) {
            c += a;
            a += 6;
        }
        System.out.println("Total number is " + c);
    }
}
class Practice305 {
    public static void main(String[] args) {
        //输入整数m，求s=1+2+3+4....+n，加到第几个时，s值会超过m
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int s = 1;
        int n = 1;
        while ( s < m ) {
            n++;
            s += n;
        }
        System.out.println(n);
    }
}
class Practice306 {
    public static void main(String[] args) {
        //Albert,Brain,Charlie玩拍手游戏，Albert每1秒拍一次手，Brain每2秒一次，Charlie每4秒拍一次
        //三人拍第一次手，每人都拍10次，算一算观众可以听到多少掌声
        int a,b,c;                                         //int不赋值,先声明变量，再后续赋值
        a = b = c = 1;                                     //假设一开始都拍了一次手
        int time = 0;                                      //设第0秒时，每人拍一次手
        int clap = 1;                                      //观众听到掌声的次数
        boolean flag;                                      //同一秒如果同时拍手，观众只能听到一个声音，定义boolean类型，确认有没有人在拍手
        //
        do {
            flag = false;                                  //假设都没有人拍手
            time++;                                        //时间流逝
            //
            if (a < 10) {
                a++;                                       //如果Albert拍手次数小于10次，继续拍
                flag = true;                               //flag为真，证明拍手了
            }
            //
            if (b < 10 && time%2==0) {                     //每2秒拍一次
                b++;                                       //如果Brain拍手次数小于10次，继续拍
                flag = true;                               //flag为真，证明拍手了
            }
            //
            if (c < 10 && time%4==0) {                     //每4秒拍一次
                c++;                                       //如果Charlie拍手次数小于10次，继续拍
                flag = true;                               //flag为真，证明拍手了
            }
            //
            if (flag == true) {                            //代码执行到这里，证明有人拍手
                clap++;                                    //每拍一次手，观众听到的次数增加一次
            }
        } while (a + b + c < 30);                          //题目限定每人10下，总共不会大于20下
        System.out.println(clap);                          //输出观众听到的拍手次数
    }
}
class Practice307 {
    public static void main(String[] args) {
        //Ali和Ben玩报数游戏，Ali 1~20报数，Ben1~30报数，如果两人同时开始并同样速度报数，两人同时报到1000时,同时报数相同的次数是多少
        //每次报到自身最大数时，重新循环，（Ali重新报1时，Ben还在报21）
        int a = 0,b = 0;                                   //一开始都没报，从零开始
        int num = 0;                                       //报数的个数
        int count = 0;                                     //报到相同数字的次数
        //
        do {
            a++;                                           //每次循环，Ali报数增加
            if (a > 20) {
                a = 1;                                     //Ali报数，报到20，重新开始
            }
            b++;                                           //每次循环，Ben报数增加
            if (b > 30) {
                b = 1;                                     //Ben报数，报到30，重新开始
            }
            if (a == b) {
                count++;                                   //如果报的数字相同，count增加
            }
            num++;                                         //循环完毕，报的数增加
        } while (num < 1000);                              //是否同时报到1000，没有就下一轮循环
        System.out.println(count);                         //输出报数相同的次数
    }
}
class Practice308 {
    public static void main(String[] args) {
        //如果同时有根长15米和18米的钢丝在不剩余的情况下同时截成长度一样的小段，每段最长有几米
        int m = 15,n = 18;                                 //辗转相除法（欧几里得算法），找到相同最大的公约数
        int r = m % n;                                     //即用上轮除数（18）除以上轮两数字相除的余数（15%18），
        while (r != 0) {                                   //如果余数不为0，继续相除，直到余数变成0，余数为0后，最后一次的除数就是最大公约数
            //国际标准写法，被除数 % 除数
            m = n;                                         //18赋给m，15（余）赋给r，（18%15）赋给r
            n = r;                                         //继续上轮的15赋给m，3(余）赋给r，（15%3）赋给r
            r = m % n;                                     //15%3没有余，根据上轮的余数，3就是最大公约数
        }
        System.out.println(n);
    }
}
class practice309 {
    public static void main(String[] args) {
        //班上学生有x名，给出每位学生的整数年龄，求班上所有学生的平均年龄，保留到小数点后两位
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the total of students:");
        int num = input.nextInt();                       //输入总人数
        //
        int sum = 0;                                     //输入变量
        System.out.println("Enter the age of students:");
        for ( int stu = 1; stu <= num; stu++) {           //已知总人数，让学生从自己的年龄开始收集到第num学生的年龄
            int age = input.nextInt();                   //接收输入进来的年龄
            sum += age;                                  //年龄累加
        }
        double average = sum*1.0/num;                    //平均年龄 = 总累加年龄/学生的总数
        String result = String.format("%.2f",average);
        System.out.println(result);
    }
}