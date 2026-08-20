package MyJava.Class.ClassMe.ClassMe900;

//static测试
public class StaticTest {
    static int num = 100;
    static {                                   //static代码块只会执行一次
        num+=100;
        System.out.println(num);
    }
    static {
        num+=500;
        System.out.println(num);
    }
}
