package MyJava.Class.ClassMe.ClassMe1000;

public class TurtleChild extends Turtle{
    //super使用
    ///定义子类和super调用父类属性
    public void show() {
        super.age = 1;                               ///通过super访问父类，成功调用
    }
    public TurtleChild() {
        super(15);                              ///如果super想调度构造函数，位置必须是子类构造方法的第一行，不能是普通方法
        System.out.println("yes");
        ////super成员属性可以放在其他行因为不属于父子构造关系
    }
}
