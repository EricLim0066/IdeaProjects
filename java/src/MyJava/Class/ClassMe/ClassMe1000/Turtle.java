package MyJava.Class.ClassMe.ClassMe1000;

public class Turtle {
    ///super使用
    //定义父类属性
    public int age;                               ////如果父类修饰符为私有private，子类中super无法调用
    //
    //定义父类构造方法
    public Turtle(int age){
        this.age = age;                           //Turtle构造函数
    }
}
