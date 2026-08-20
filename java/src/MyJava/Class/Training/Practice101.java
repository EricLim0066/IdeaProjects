package MyJava.Class.Training;

import java.util.Scanner;

class Practice101 {
    public static void main(String[] args) {
        //假设电影票每张15块 price
        //假设20人来看电影  number
        int price = 15;
        int number = 20;
        int money = price * number;  //总金额 money
        System.out.println("Total of money is " + money + " Dollar.");
        //同行同时输出内容或变量值，添加+
    }
}
class Practice102 {
    public static void main(String[] args) {
        //登记电脑信息
        //需要品牌，尺寸，容量和价格
        String brand = "HuaweiMacbook14s";
        double size = 14.2;
        int ram = 16;
        int price = 6899;
        System.out.println("Brand of computer is " + brand + ", size is " + size + ", ram is " + ram + ", price is " + price + " dollar.");
    }
}
class Practice103 {
    public static void main(String[] args) {
        //计算圆周长和面积，半径为1.5
        //周长= circumference =2PIr ;面积 = area = PIr^2
        final double PI = 3.14;
        final double R = 1.5;
        double circumference = 2 * PI * R;
        double area = PI * R * R;
        System.out.println("Circumference of circle is " + circumference );
        System.out.println("Area of circle is " + area );
    }
}
class Practice104 {
    public static void main(String[] args) {
        //Minh准备实现数字加密器，加密规则是【(num * 8 + 3) / 2 + 2.6】
        //加密结果需要整数
        int num = 5;
        int a = (int)((num * 8 + 3) / 2 + 2.6);
        System.out.println("the number is " + a);
        //(num * 8 + 3) / 2本为21.5，但类型被事先强制转换为int，去0.5，取21
        // 21 + 2.6 本为23.6，也被强制转换成int，去0.5，取23
    }
}
class Practice105 {
    public static void main(String[] args) {
        //已知男同学20位平均分87，女同学15位平均分85，计算全班同学平均分
        int total = 20 * 87 + 15 * 85;                         //综合分数
        int num = 20 + 15;                                     //总人数
        double average = total /(double) num;                  //总平均分
        //对小数进行控制或保留，但因String，返回结果为字符串类型
        String result = String.format("%.2f",average);         //format格式化，%格式说明符，2f浮点数for float，保留后小数点2位，用于分离数位
        System.out.println("the total average marks is " + result);
    }
}
class Practice106 {
    public static void main(String[] args) {
        //Claire买来30片饼干，每天都会吃掉剩余的一半后又吃一片，第三天还剩多少饼干
        int biscuits = 30;
        biscuits = biscuits / 2 - 1;                          //第一天吃剩的
        biscuits = biscuits / 2 - 1;                          //第二天吃剩的
        biscuits = biscuits / 2 - 1;                          //第三天吃剩的
        System.out.println("Still have " + biscuits + " biscuits");
        //or
        int Biscuits = 30;
        int Days = 3;
        for (int i = 0; i < Days; i++) {
            Biscuits = Biscuits / 2 - 1;
        }
        System.out.println("Still have " + Biscuits + " biscuits");
    }
}
class Practice107 {
    public static void main(String[] args) {
        //将3位数123分离
        int num = 123;
        int one = num%10;                                     //个位数
        int ten = num/10%10;                                  //十位数
        int hundred = num/100;                                //百位数
        System.out.println("Single digits: " + one);
        System.out.println("Tens digits: " + ten);
        System.out.println("Hundreds digits: " + hundred);


    }
}
class Practice108 {
    public static void main(String[] args) {
        //输出并交换两个整数变量，a与b，设a为5，b为3
        int a = 5;
        int b = 3;
        System.out.println("Before Change " + "a = " + a + "; b = " + b );
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After Change " + "a = " + a + "; b = " + b );
    }
}
class Practice109 {
    public static void main(String[] args) {
        //一个三位数，百位的数比十位大1，个位数是百位数的2倍，如果十位数上的值为3，求这三位数的值
        char one = 'x';                                       //个位数
        int ten = 3;                                          //十位数
        char hundred ='y';                                    //百位数
        hundred = (char)(ten + 1);
        one = (char)(hundred * 2);
        //
        int num = (hundred * 100 + ten * 10 + one);
        System.out.println("This 3 digits number is " + num);
    }
}
class Practice110 {
    public static void main(String[] args) {
        //输入一个小写字母，输出其大写字母，比如输入q，输出Q
        Scanner input = new Scanner(System.in);
        //先接收字符串，然后用charAt()进行转换
        char Ch = input.next().charAt(0);               //charAt下标0代表目标字符位置为第一个，hello，拿h
        char BigCh = (char)(Ch - 32);                   //由于字符运算会先将char提升为int，结果类型为int，(Ch - 32)，所以需要二次强制转换(char)将数值重新转回字符类型
        System.out.println(BigCh);
    }
}
