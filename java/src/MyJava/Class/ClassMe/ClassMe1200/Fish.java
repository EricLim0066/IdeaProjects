package MyJava.Class.ClassMe.ClassMe1200;

public abstract class Fish implements Eat,Swim {
    //定义一个父类，所有子类鱼类继承自他
    //定义这个父类为抽象类，用来保存鱼的类型
    ///抽象类也可以实现接口
    ///子类也必须重写父类方法，除非子类也是抽象类
    String type;                                    //定义鱼的类型
    public abstract void show();                    //声明鱼类的技能方法
}
