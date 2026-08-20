package MyJava.Class.ClassMe.ClassMe1100;

import org.w3c.dom.ls.LSOutput;

public class Cat extends Pet {                           //Dog子类继承Animal父类
    public Cat(){                                        ////*养成一个额外创建无参构造函数的习惯

    }
    public Cat(String name,int energy){                  //创建带参构造函数，用于创建猫猫时指定名字和默认的初始能量值
        this.name = name;                                //外界实例化，让对象输入进来的name赋值给父类name成员变量
        this.energy = energy;

    }
    @Override                                            //注解重写父类方法
    public void eat(int num) {                           //重写父类声明下宠物方法，吃了增加能量值
        this.energy += num;                              //吃了食物后，当前对象叠加能量值
        System.out.println("Cat " + this.name + ", energy value increase " + num + ",total energy is " + this.energy);
        //打印名字，当前增加能量，总能量
    }
    public void CatchMouse() {                          //添加抓老鼠方法
        System.out.println("Catching mouse");           //输出抓老鼠
    }


}