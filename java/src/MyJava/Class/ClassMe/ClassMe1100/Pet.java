package MyJava.Class.ClassMe.ClassMe1100;

public abstract class Pet {
    //定义宠物父类
    public String name;                        //定义宠物的名字
    public int energy;                         //定义宠物的初始能量值
    public abstract void eat(int num);         //不知道宠物吃什么，先声明，并且num吃了加能量值
}