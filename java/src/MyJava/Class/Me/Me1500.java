package MyJava.Class.Me;

import MyJava.Class.ClassMe.ClassMe1500.WeekDay;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class Me1500 {
    public static void test(WeekDay Day) {                 //定义test类，接收weekday类型的值
        //实用类
        ///枚举类型是由一组固定常量组成的类型，当某种类型只能取固定范围的值时，可将其定义为枚举类型
        ///即把只能选几个固定值的情况，单独做成一种类型
        ///方程式: 访问修饰符 enum 枚举名称 {
        ///值1，值2，值3.....
        /// }
        //移步ClassMe1500/WeekDay.java
        switch (Day) {                                     //Day对象定义判断结构，是哪个常量就输出哪个
            case Monday:
                System.out.println("one");
                break;

            case Tuesday:
                System.out.println("two");
                break;

            case Wednesday:
                System.out.println("three");
                break;

            case Thursday:
                System.out.println("four");
                break;

            case Friday:
                System.out.println("five");
                break;

            case Saturday:
                System.out.println("six");
                break;

            case Sunday:
                System.out.println("seven");
                break;

            default:
                System.out.println(":(");
                break;
        }

    }
    public static void main(String[] args) {
        int num1 = 1;
        double num2 = 1.1;
        WeekDay Day = WeekDay.Monday;                      //定义Day对象，父类引用枚举常量值
        test(Day);                                         //Day对象作为参数方法把当前枚举值传入test类
        ///定义枚举，用户只能取用限定的值
    }
}
class Me1501 {
    public static void main(String[] args) {
        //包装类
        ///把基本类型包装成对象，并提供系列方法
        //装箱: 基本类型 -> 包装类型
        Integer integer = Integer.valueOf(20);            //手动装箱(静态方法)
        Double doub = Double.valueOf(5.1);
        Character character = 'a';                          //自动装箱
        Boolean flag = true;
        ///包装类型本质就是"对象版"基本类型，每个包装类存对应的基本值对象，Integer存数字对象，Boolean存布尔值对象，Character存字符对象
        ///注，常规new Integer(20);已于java 9版本移除，已替换成Integer.valueOf(20);静态方法或 20;自动装箱
        //拆箱: 包装类型 -> 基本类型
        int num = integer.intValue();                       //手动拆箱(静态方法)
        double d = doub.doubleValue();
        char c = character;                                 //自动拆箱
        boolean b = flag;
        ///Java 5版本后，装箱拆箱由编译器自动完成
        //泛型集合+包装类，不允许存放基本类型数据，可以使用包装类
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);

    }
}
class Me1502 {
    public static void main(String[] args) {
        //Math应用
        ///java.lang.Math提供常用的数学运算方法
        ///注:这些方法都是静态
        int num1 = Math.abs(-400);           ///Math.abs()绝对值函数
        System.out.println(num1);
        int num2 = Math.max(100, 106);       ///Math.max(int a, int b)取中间最大值
        System.out.println(num2);
        double num3 = Math.pow(2, 3);        ///Math.pow(int a, int b)取a的几次方b函数,返回double类型
        System.out.println(num3);
        int num4 = Math.min(100, 106);       ///Math.min(int a, int b)取中间最小值
        System.out.println(num4);
        double num5 = Math.sqrt(9);         ///Math.sqrt(int a)取a的开平方函数,返回double类型
        System.out.println(num5);
    }
}
class Me1503 {
    public static void main(String[] args) {
        //String和StringBuffer
        //常规String赋值方法
        //方法1
        String str1 = "Halo";                                     //常规的字面量字符串，存在字符串常量池
        //方法2
        String str2 = new String("halo");                 //显式创建新对象，存在堆内存
        System.out.println(str1 + " and " + str2);
    }
}
class Me1504 {
    public static void main(String[] args) {
        //String
        ///int类型 length(),获取字符串长度数字
        String str1 = "hello, welcome to our restaurant";
        int Str1 = str1.length();
        System.out.println(Str1);
        System.out.println("===============================");

        ///boolean类型 equals(Obejct object),比较字符串是否一致
        String str2 = "hello, welcome to our restaurant";             ///==和.equals()区别
        if(str1.equals(str2)) {                                       ///==比较地址，是不是同一对象
            System.out.println("yes");                                ///.equals()比较内容是否相同，不需要对象或地址是否相同
        } else {
            System.out.println("no");
        }
        System.out.println("===============================");

        //////boolean类型 equalsIgnoreCase(String str),比较忽略大小写,只要没有错字，不管大不大写，都算同一内容
        final String str3 = "HELLO", Str3 = "hello";
        if (str3.equalsIgnoreCase(Str3)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
        System.out.println("===============================");

        ///String类型 toLowerCase() 转小写
        String str4 = "Halo, Welcome";
        String Str4 = str4.toLowerCase();
        System.out.println(Str4);
        ///String类型 toUpperCase() 转大写
        String Str5 = str4.toUpperCase();
        System.out.println(Str5);
        System.out.println("===============================");

        ///String类型 concat(String str) 字符串链接,不空格
        String str6 = "Hello";                                         ///如果要空格，字符串添加\t
        String Str6 = str6.concat(str4);
        System.out.println(Str6);
        System.out.println("===============================");

        ///int类型 indexOf(String value)搜索某个字符在整个字符串中第一次出现的位置，如果没有，返回-1
        String str7 = "HelloWorld";
        int Str7 = str7.indexOf("l");
        System.out.println(Str7);
        ///int类型 lastLIndexOf(String value)搜索某个字符在整个字符串中最后一次出现的位置，如果没有，返回-1
        int Str8 = str7.lastIndexOf("l");
        System.out.println(Str8);
        System.out.println("===============================");

        ///String类型 substring(int index) 提取从索引位置开始的整个字符串部分到结束
        String str9 = "HelloWorld";
        String Str9 = str9.substring(7);
        System.out.println(Str9);
        ///String类型 substring(int beginIndex, int endIndex) 提取从索beginIndex和endIndex之间的字符串
        String Str10 = str9.substring(5,8);
        System.out.println(Str10);
        System.out.println("===============================");

        ///String类型 trim() 移除前后字符串,中间不移除
        String str11 = " Welcome Here ";
        String Str11 = str11.trim();
        System.out.println(Str11);
        System.out.println("===============================");

        ///String类型 replace(char oldChar, char newChar) 将oldChar旧字符替换成newChar新字符
        String str12 = "Hello";
        String Str12 = str12.replace('H','l');   //注意大小写 //所有出现相同字符的地方都被替换
        System.out.println(Str12);
        ///String类型 replace(charSequence target, charSequence replacement) 将target替换成replacement
        ///如果单独替换一个字符，其他字符也会被替换
        String str13 = "Hello";
        String Str13 = str13.replace("Hell","Buff");   //注意大小写和写对字符串
        System.out.println(Str13);
        System.out.println("===============================");

        ///String[]数组 split(String regex) 将字符串分割为子字符串符，将结果为字符串返回
        ///拆分后，每个段都是单独一个数组元素
        String str14 = "HelloWorld";
        String[] Str14 = str14.split("l");   //注意大小写和写对字符串
        for (String str: Str14) {
            System.out.println(str);                  //for增强删除
        }
        System.out.println("===============================");
    }
}
class Me1505{
    public static void main(String[] args) {
        //StringBuffer
        ///是可变字符串，如果字符串需要拼接，StringBuffer可以大大提高效率
        StringBuffer str = new StringBuffer();
        str.append("Hello ! ");                                   //append()添加字符串
        str.append("Im your teacher");
        str.insert(8,"Are you ok? ");                  //insert(offset，object)下标要插入的地方,和用什么链接
        String str2 = str.toString();
        System.out.println(str2);
    }
}
class Me1506 {
    public static void main(String[] args) {
        //Random随机数
        ///Random(seed) 如果种子值相同，生成的随机数序列是固定一样的(每一次调用顺序也相同)
        ///nextInt(bound)范围控制，随机的数控制在设定的bound值以下
        Random random = new Random(5);
        Random random2 = new Random(5);
        int num1 = random.nextInt(10);
        int num2 = random2.nextInt(10);
        System.out.println(num1);
        System.out.println(num2);
    }
}
class Me1507{
    public static void main(String[] args) {
        //生成1~100的随机数
        Random random = new Random();
        int num = random.nextInt(100)+1;            //100以下1以上
        System.out.println(num);
    }
}
class Me1508{
    public static void main(String[] args) {
        //java操作日期和时间
        ///导入java.util.Date获取日期
        ///注意:导入的是util包不是sql包
        Date date = new Date();
        ///格式化日期 (dd-MM-yyyy hh:mm:ss)新马时间格式
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String time = format.format(date);                         //格式化为字符串
        System.out.println(time);
    }
}