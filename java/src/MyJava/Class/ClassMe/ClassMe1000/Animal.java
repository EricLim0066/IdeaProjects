package MyJava.Class.ClassMe.ClassMe1000;

public abstract class Animal {
    //抽象类和方法
    ///被abstract修饰的类都是抽象类，不能直接创建对象
    public String name;                                 ///可以有普通属性
    public void game() {                               ///可以有普通和构造方法

    }
    ///有抽象方法，只有声明没有方法体(后面没有{})
    public abstract void show();                       ///必须在子类中实现
    ////抽象类和方法本质就是普通类+声明行为，在父类声明后，传给子类使用
}
