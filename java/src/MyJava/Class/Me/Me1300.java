package MyJava.Class.Me;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Me1300 {
    public static void main(String[] args) {
        //异常Exception
        ////指运行过程中发生的不正常事情，会中断我们正在运行的程序
        ////可以在程序中预先设置异常处理方法，一旦发生就可以及时对其进行处理，让程序恢复正常运行
        ////java处理异常的5个关键字
        ////try执行可能产生的代码,catch捕获异常,finally代码执行无论发生异常,throws声明可能会抛出的异常,throw手动抛出异常
        ///除0异常，java中不能将数字除以0，否则报错，尝试将数字除以0，看看编译器会产生什么提示
        //=================================================================================================
        System.out.println("Enter the first number");
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();
        System.out.println("Enter a number use for division");
        int num2 = input.nextInt();
        //默认上方代码没有异常
        ///异常发生时，后续代码没有执行权，所以制作个异常捕获
        try {                                                       ////try执行代码，如果没有异常，直接执行finally，不执行catch
            int result = num1/num2;
            System.out.println("number is " + result);
            ///Exception异常类型 ex异常对象
        }catch (Exception ex) {                                     ////try有异常，执行catch，对异常处理，然后执行finally
            System.out.println("The divisor number can't be 0");
            //System.err.println执行时机不确定
            ex.printStackTrace();                                   ///void printStackTrace()打印异常的详细信息
            System.out.println(ex.getMessage());                    ///String getMessage()即打印异常的简短信息
            return;                                                 ///return不会立刻结束方法，会先执行finally，再真正返回
        } finally {                                                 ////finally一般释放资源，有或无异常都会继续执行
            System.out.println("Code Ended");
        }
        ///利用try catch finally,解决因为异常而产生程序中断的事情
        ///finally后，后续代码继续执行，不至于中断
        //以下为void printStackTrace() 异常详细信息
        //java.lang.ArithmeticException: / by zero                  //异常类型 原因
        //at MyJava.Class.Me.Me1300.main(Me1300.java:23)            //异常所在地址
    }
}
class Me1301 {
    public static void main(String[] args) {
        //多路异常捕获
        ///catch语句多个块组成，先子后父，子类的小范围如果抓不到异常，父类的大范围来抓
        ///发生异常时按顺序匹配
        ///只执行第一个与异常类型匹配的catch语句
        //================================================================================
        //捕获异常快捷键，左键长按包围，点击surround，点击try catch finally
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Enter the first number");
            int num1 = input.nextInt();
            System.out.println("Enter a number use for division");
            int num2 = input.nextInt();
            int result = num1/num2;
            System.out.println(result);
            //子类小范围捕捉异常
        } catch (InputMismatchException ex) {                       ///InputMismatchException输入不匹配异常，如果用户不是输入整数，发生输入不匹配异常
            System.out.println("The number must be integer");
        } catch (ArithmeticException ex) {                          ///ArithmeticException捕获算数异常，如果除数为0，发生算数异常
            System.out.println("The divisor number can't be 0");
            //父类大范围捕捉异常
        } catch (Exception ex) {                                    ///Exception其他类型异常，范围大，更笼统
            System.out.println("Unknown anomaly");
        } finally {
            System.out.println("Code ended");
        }
    }
}
class Me1302 {
    public static void calc() throws Exception{
        //throws声明异常，在方法中使用
        ///方法中有异常，如何通知调用者
        ///1.用try catch finally捕获异常 2.不处理，声明异常
        ///每个声明可以多个异常，必须用逗号分隔
        System.out.println(5/0);
    }
    public static void main(String[] args) {
        try {
            calc();
        } catch (Exception ex) {
            System.out.println("the number cannot divide by 0");
        } finally {

        }
    }
}
class Me1303{
    //throw手动抛出异常
    ///用在方法体内部
    ////throws是异常声明，一定要和throw区分开
    public static void divide(int a, int b){                        //定义除数方法
        if (b == 0) {
            throw new ArithmeticException("the number can't divide by 0"); //使用throw手动抛出异常
        } else {
            int result = a/b;                                      //如果没有异常，后续代码继续执行
        }
    }
    public static void main(String[] args) {
        try {
            divide(5,0);
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
        } finally {

        }

    }
}
class Me1304 {
    public static void main(String[] args) {
        ///两大异常，RunTimeException运行异常和IO/SQLException检查异常
        ///运行异常，运行时才知道有错，不强制处理
        System.out.println(5/0);
        ///检查异常，外部环境可能出错，必须强制处理
        File file = new File("c://test.txt");                  ///File,创建file对象，表示硬盘文件
        ///红线报错，文件不存在
        try {
            FileInputStream files = new FileInputStream(file);          ///FileInputStream,准备导入硬盘文件
        } catch(FileNotFoundException ex) {                             ///文件不存在，添加FileNotFoundException文件不存在异常
            System.out.println("Files Not Found");
        }
        ///检查异常子类，IOException IO异常，SQLException SQL异常
        ///运行异常子类，ClassCastException类型转换异常,ArithmeticException算数异常,ArrayIndexOutOfBoundsException数组下标越界异常,NullPointerException空指针异常
    }
}
class Me1305 {
    //自定义异常
    ///Exception检查异常，RunTimeException检查运行时异常
    static class AgeException extends Exception{                               ///搭建异常类年龄
        public AgeException(String msg) {                               ///异常方法
            super(msg);                                                 ////super访问父类
        }
    }
    //一个文件只有一个public修饰类
    public static void main(String[] args) {
        //检查年龄异常
        //登记用户姓名和年龄，如果年龄不合法，输出提示
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name");
        String name = input.next();
        System.out.println("Please enter your age");
        int age = input.nextInt();
        try {
            if (age < 0) {                                                 //判断年龄是否合法
                throw new AgeException("Age cannot less than 0");
            }
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        } catch (AgeException ex){
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Code ended");
        }
    }
}
class Me1306 {
    public static void main(String[] args) {
        //Log4j
        ///日志记录框架
        ///1.下载log4j-api-2.xx.jar和log4j-core-2.xx.jar
        ///2.在src外建lib文件夹,放入两个jar
        ///3.右键jar,然后点击Add as Library,然后点击Module Library
        ///4.总文件右键,然后Open Module Settings,然后Module,然后Dependencies，确认安装
        ///API提供接口,Core提供实现,两者都要加
        //==================================================================================
        ///在src外建立resources文件夹，里面创建Log4j.properties文件
        ///右键resources,Mark Director as,然后点击resources root
        //特例，并不是所有对象创建时都是使用new关键词 //(类名.class)
        Logger logger = LogManager.getLogger(Me1306.class);
        //log4j 2代需要导入logger和logManager两个包，同时LogManager.getLogger为新写法 (企业用)
        logger.error("Error message recorded");                       //输入异常信息到日志  //error错误级别
        ///日志级别 OFF最高级别，FATAL致命 ，ERROR错误 ，WARN警告 ，INFO信息 ，DEBUG调试 ，TRACE追踪 ，ALL最低级别
    }
}