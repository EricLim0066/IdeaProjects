package MyJava.Class.Me;

import MyJava.Class.ClassMe.ClassMe1100.*;

import java.util.Random;

public class Me1100 {
    //多态应用场景
    //小动物们饿了须补充能量，但不同动物吃不同食物，狗狗吃肉，猫猫吃鱼，需要根据动物种类的不同，喂食相应的食物
    //移步(父类ClassMe1100/Pet.java,子类ClassMe1100/Dog.java,子类ClassMe1100/Cat.java,子类ClassMe1100/Master.java)
    public static void main(String[] args) {
        Dog dog = new Dog("Chop",100);                 //创建带参对象(宠物)并赋予名字和初始能量值
        Cat cat = new Cat("Cola",100);
        //
        Master master = new Master();                               //创建无参对象(主人)
        master.feed(dog, 30);                                 //喂食时，调度相应子类的eat方法，增加相应的数值
        master.feed(cat, 50);
    }
}
class Me1101{
    public static void main(String[] args) {
        //代码写完了，突然出现第三种宠物Monkey,又吃不同食物，如何应对
        //只能添加对应的类，定义eat()方法，并修改Master类并添加feed()方法
        ///可以考虑使用多态，只写一个feed方法，实现所有动物喂食方法
        //================================================================================
        ///同一种操作，但条件不同，结果也不同
        ///同个引用类型，使用不同的实例执行不同操作，即左边父类类型变量，右边子类实例化对象(多态写法)
        ///不同类型决定内存占用空间的不同，基本类型再栈上，引用类型在栈和堆都有
        Pet pet = new Dog();              ////向上转型 子类到父类 (自动类型转换)，放大范围
        ////“Dog是pet，但pet不一定是dog”
        Dog Dog = (Dog)pet;               ////向下转型 父类到子类 (强制类型转换)，缩小范围
        ////“pet可以是dog，也可能不是”
        ////对象是谁，看new，能用什么方法，看左边类型
        //================================================================================
        //instanceof判断运算符，布尔值类型，判断是否类型
        //移步(父类ClassMe1100/Pet.java,子类ClassMe1100/Dog.java,子类ClassMe1100/Cat.java,子类ClassMe1100/Owner.java)
        ///在main函数new子类时，new的各个子类调度其对应的方法
        Dog dog = new Dog("Chop",100);                 //创建带参对象(宠物)并赋予名字和初始能量值
        Cat cat = new Cat("Cola",100);
        //
        Owner owner = new Owner();                                  //创建无参对象(主人)
        owner.feed(dog, 30);                                  //喂食时，调度相应子类的eat方法，增加相应的数值
        owner.feed(cat, 50);
        //================================================================================
        //向下转型
        //移步(父类ClassMe1100/Pet.java,子类ClassMe1100/Dog.java,子类ClassMe1100/Cat.java,子类ClassMe1100/Owner.java)
        Dog dog2 = new Dog("Chop",100);                 //创建带参对象(宠物)并赋予名字和初始能量值
        Cat cat2 = new Cat("Cola",100);
        //
        Owner owner2 = new Owner();                                  //创建无参对象(主人)
        owner2.work(dog2);                                           //把dog2对象传入work方法，判断pet（dog2）是否为Dog类，是就执行LookDoor()
        owner2.work(cat2);
        ///多态的终极价值，实现统一调用，增强扩展性
    }
}
class Me1102 {
    public static void main(String[] args) {
        //父类作为返回值实现多态
        //吹糖人可以根据顾客的需求吹出对应的动物，比如顾客喜欢小狗小猪小猫，吹糖人就会吹出小狗小猪小猫，模拟老爷爷吹出不同动物的过程
        //移步(父类ClassMe1100/Pet.java,子类ClassMe1100/LittleDog.java,子类ClassMe1100/LittleCat.java,子类ClassMe1100/LittlePig.java,子类ClassMe1100/OldMan.java)
        OldMan oldman = new OldMan();                               //无法自行吹出动物，需要老人吹，所以定义oldman对象
        String[] types = {"dog","cat","pig"};
        ///for each迭代/增强
        for (String type: types){                                   ///每次取下一个值，不需要经过索引
            Animal animal= oldman.BlowSugar(type);                  //引用子类oldman的BlowSugar方法，根据顾客需求吹出对应类型，返回父类animal
            animal.getShape();                                      //父类animal引用子类的getShape方法
            ////父类装下了子类，但本质对应子类
        }
    }
}
class Me1103 {
    public static void main(String[] args) {
        Random rand = new Random();                               ////随机数，和Scanner scanner = new Scanner()同等道理
        int num = rand.nextInt(10);                        ////next(),放上参数，范围内随机
        System.out.println(num);                                  ////输出num
    }
}