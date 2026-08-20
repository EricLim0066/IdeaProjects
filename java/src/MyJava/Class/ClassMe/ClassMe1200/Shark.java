package MyJava.Class.ClassMe.ClassMe1200;

public class Shark extends Fish implements Eat,Swim,Power{
    //定义一个鲨鱼子类
    //既要继承fish，又要实现技能接口
    public Shark(){

    }
    public Shark(String type){                                   //调用父类成员变量
        this.type = type;
    }
    @Override
    public void eat() {
        System.out.println("Shark eating");                      //输出鲨鱼吃东西
    }

    @Override
    public void show() {
        System.out.println("type of fish is " + this.type);       //输出鱼的类型
    }

    @Override
    public void swim() {
        System.out.println("Shark swimming");                    //输出鲨鱼游泳
    }

    @Override
    public void power() {
        System.out.println("Shark inductance");                  //输出鲨鱼电感应
    }
}