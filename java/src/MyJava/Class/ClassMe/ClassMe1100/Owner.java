package MyJava.Class.ClassMe.ClassMe1100;

//改master类，简化优化类代码
public class Owner {
    public void feed(Pet pet,int num){          ///定义喂食方法,参数1统一为父类型，广义对应可以喂食任何宠物子类，参数2喂食增加能量
        pet.eat(num);                           //投喂对应宠物时，调度pet对应eat方法，表示增加了多少能量值

        ///父类引用调用eat方法时，运行时会根据实际对象类型调用对应的子类方法
        ///例如，Dog对象会执行Dog.eat()
    }
    //Master类改child
    //利用Child驱动动物干活
    public void work(Pet pet){                    ////定义work方法，广义接受任何宠物子类
        //对象区分动物类型 对象 instanceof 类型
        if (pet instanceof Dog) {                 //判断对象是否为Dog类，是就向下转型(强制转换)
            Dog dog = (Dog)pet;                   //pet父类强制转换给dog对象
            dog.LookDoor();                       //dog对象调度子类LookingDoor方法
        } else if (pet instanceof Cat) {
            Cat cat = (Cat)pet;
            cat.CatchMouse();
        }
    }
}
