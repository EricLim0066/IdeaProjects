package MyJava.Class.ClassMe.ClassMe1000;

public abstract class Fish {
    //fish抽象类
    //希望写的方法提供一个返回计算结果的方法，就必须声明返回类型，所以放int，
    public int speed;                                 //速度成员变量

    public abstract int calc(int hours);             //抽象方法，声明计算时间，子类必须实现
}