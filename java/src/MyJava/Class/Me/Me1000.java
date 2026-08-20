package MyJava.Class.Me;

import MyJava.Class.ClassMe.ClassMe1000.*;

public class Me1000 {
    public static void main(String[] args) {
        //类的继承extends
        ////在父类定义共同属性或方法后，子类可以继承或重用父类已有的属性和方法
        ////优点: 代码复用，减少代码复用率，让类之间形成层级关系
        ////查看继承关系，对要查看的类点击右键，然后点击diagram，再show diagram
        //创建dog对象，Dog已继承父类Pet，所以可以使用Pet中定义的属性和方法
        //移步(父类ClassMe1000/Pet.java 和 子类ClassMe1000/Dog.java)
        Dog dog = new Dog();
        dog.name = "Chop";
        dog.run(dog.name);
    }
}
class Me1001{
    public static void main(String[] args) {
        ////Java单继承
        ////一个类只能继承一个直接父类(单继承)，可以多个子类可以多个孙类，但父类只有一个
        ////但是可以多层继承，形成线性继承链(爷类 → 父类 → 子类 → 孙类 )
        ///符合is-a关系的场景可以使用父子类，比如Dog是Pet,猫也是Pet,Bird也是Pet，Child是Human等有联关系
        //====================================================================================
        ////子类不能继承父类的修饰符: private修饰符，父子类不同包的默认修饰符和构造方法
        //private修饰符
        //移步(父类ClassMe1000/Pet.java 和 子类ClassMe1000/Dog.java)
        Dog dog = new Dog();
        //dog.age=1;                         //age无法访问,因为父类设age为private私有,子类Dog无法继承
        //
        //默认修饰符
        //移步(父类ClassMe700/Dog.java 和 子类ClassMe1000/DogChild.java)
        DogChild dogchild = new DogChild();
        //dogchild.ages = 1;                 //ages无法访问，因为默认修饰符只能同包访问，无法跨包访问

    }
}
class Me1002 {
    public static void main(String[] args) {
        ////断点Debug和追踪初始化进程
        ////目的让程序暂停，一步一步观察和理解java程序真实执行过程
        ////调试方法步骤: 1.在下面代码打红色断点 2.使用爬虫图案debug运行程序 3.用step into逐步观察执行流程
        //===========================================================================
        ///三件事: 1.开辟对象空间 2.调用构造方法进行初始化 3.创建并返回对象引用
        ///结合上行2的初始化顺序: 2.1.父类属性初始化 2.2.父类构造执行 2.3.子类属性初始化 2.4.子类构造执行
        //
        //移步(子类ClassMe1000/Vehicle.java 和 子类ClassMe1000/Truck.java)
        Truck truck = new Truck();
    }
}
class Me1003 {
    public static void main(String[] args) {
        ////子类重写或改写父类方法(override)，不是属性，让行为更具体
        ////重写规则: 父子类的方法名，参数列表要相同，返回值类型宽泛或相同或者其下子类，子类访问权限不能严于父类
        //
        //创建子类对象，移步(父类ClassMe1000/Cat.java和 ClassMe1000/CatChild.java)
        CatChild catchild = new CatChild();             ////public修饰符不严于父类，void相同或他的子类(范围尽可能比父类小）
        catchild.cat();                                 ////cat名称相同，()参数类型相同
    }
}
class Me1004 {
    public static void main(String[] args) {
        ////方法重写(override)与重载(overload)
        /// Override(重写):子类和父类方法有继承关系，方法名和参数必须相同，返回值相同或兼容，访问修饰符不能更严格
        /// Overload(重载):同一个类中多个方法名相同，但参数类型/数量/顺序不同，返回值和修饰符可以不同
    }
}
class Me1005 {
    public static void main(String[] args) {
        //super使用
        ////java中，和this不同，this是当前类的对象，super是父类对象，super可访问父类成员/父类属性
        ///super无法访问父类私有成员(private String, private int)
        ////super调用父类构造方法时只能放在子类构造里的第一句
        ////super成员属性可以放在其他行因为不属于父子构造关系
        //移步(父类ClassMe1000/Turtle.java 和子类 ClassMe1000/TurtleChild.java)
        TurtleChild turtleChild = new TurtleChild();
    }
}
class Me1006 {
    public static void main(String[] args) {
        //object类
        ///object是所有类的父类，任何类默认继承object类，即没有extends的类默认extends object，存在java.lang包里
        ///object常用方法可被子类重写
        //=====================================================================
        ///toString()：返回当前对象的字符串表示，默认打印内容为类名和哈希码(16进制)
        ////如果子类重写了toString()，打印对象时会调用子类实现
        ////此方法主要用于调试，日志
        //移步(ClassME1000/Car.java)
        Car car = new Car("BYD","FY400", 400000);
        System.out.println(car.toString());                   ///对象的自我介绍，println会调用对象的toString()方法，把对象内容转成字符串
        //=====================================================================
        ////equals(Object obj)：判断对象是否相等，不仅仅比较对象的内存地址是否相同
        ////equals和==同等作用，都是用于比较对象的地址是否相同
        ///==对于简单数据类型，直接比较值 1 == 1，如果为引用类型，比较地址 MATH.equals(math)
        //移步(ClassME1000/Car.java)
        Car car2 = new Car("BYD","FY400", 400000);
        System.out.println(car.equals(car2));               //equals比较两个car的内容是否相同
        ///所以对于判定两个字符串的值是否同等，使用equals()
    }
}
class Me1007 {
    public static void main(String[] args) {
        //抽象类和抽象方法
        ////抽象类和方法中使用abstract修饰
        ///抽象方法必须在抽象类里，而且没有方法体(后面没有{})
        ///必须在子类实现，除非子类也是抽象类
        //移步(父类(ClassMe1000/Animal.java 和 子类ClassMe1000/Shark.java)
        Shark shark = new Shark();
        shark.show();
        shark.name = "halo";                                 ///抽象父类虽然无法直接创造对象，但可以以子类的名义调度父类的普通属性和方法
        ///抽象类可以有非抽象方法(普通属性，普通方法，构造方法)，但无法创建对象，只能被子类调度
        ///抽象类和方法本质就是普通类+声明行为，在父类声明后，传给子类使用
    }
}
class Me1008 {
    public static void main(String[] args) {
        //final的使用
        ////final类型不能有子类
        ////就算可以extends，父类方法为final时不能被重写
        ///使用final修饰的属性或方法等
        ///final修饰变量变为常量，赋值后后续无法更改
        //移步(父类ClassMe1000/Bear.java 和 ClassMe1000/LittleBear.java)
        Bear bear = new Bear("Bear");
        System.out.println(bear.name);
        bear.show();
    }
}