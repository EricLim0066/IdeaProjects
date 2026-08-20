package MyJava.Class.ClassMe.ClassMe1100;

public class Dog extends Pet {                           //Dog子类继承Animal父类
    public Dog(){                                        ////*养成一个额外创建无参构造函数的习惯

    }
    public Dog(String name,int energy){                  //创建带参构造函数，用于创建狗狗时指定名字和默认的初始能量值
        this.name = name;                                //外界实例化，让对象输入进来的name赋值给父类name成员变量
        this.energy = energy;

    }
    @Override                                            //注解重写父类方法
    public void eat(int num) {                           //重写父类声明下宠物方法，吃了增加能量值
        this.energy += num;                              //吃了食物后，当前对象叠加能量值
        System.out.println("Dog " + this.name + ", energy value increase " + num + ",total energy is " + this.energy);
        //打印名字，当前增加能量，总能量
    }
    public void LookDoor() {                             //添加看门方法
        System.out.println("Looking Door");              //输出看门
    }
}
