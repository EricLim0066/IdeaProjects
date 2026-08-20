package MyJava.Class.ClassMe.ClassMe1000;

public class FlagFish extends Fish {                 //继承自Fish，实现calc方法
    //
    public FlagFish() {

    }
    //
    public FlagFish (int speed) {                   //初始化变量，继承自父类的普通属性，可以直接访问，因为是 public
        this.speed = speed;
    }
    //
    @Override                                       //子类重写声明calc和hours参数
    public int calc(int hours) {
        return speed *hours;                        //speed不是抽象属性，可以直接调用父类属性
    }
}