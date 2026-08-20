package MyJava.Class.ClassMe.ClassMe1200;

public class GoldFish extends Fish implements Eat,Swim{
    //定义一个金鱼子类
    //既要继承fish，又要实现技能接口
    public GoldFish(){

    }
    public GoldFish(String type){                                //调用父类成员变量
        this.type = type;
    }
    @Override
    public void eat() {
        System.out.println("Gold fish eating");                  //输出金鱼吃东西
    }

    @Override
    public void show() {
        System.out.println("type of fish is  " + this.type);       //输出鱼的类型
    }

    @Override
    public void swim() {
        System.out.println("Gold fish swimming");                //输出金鱼游泳
    }

}
