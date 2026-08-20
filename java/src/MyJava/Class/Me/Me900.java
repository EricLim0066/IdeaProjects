package MyJava.Class.Me;

import MyJava.Class.ClassMe.ClassMe900.Bird;
import MyJava.Class.ClassMe.ClassMe900.Car;             ////确保你要用的文件地址正确
import MyJava.Class.ClassMe.ClassMe900.StaticTest;
import org.w3c.dom.ls.LSOutput;

public class Me900 {
    ///三步查看类的提炼过程
    ////1.发现类(Dog类) 2.发现类的属性(品种，毛发) 3.发现类的方法(跑，叫)
    ////从现实生活中归纳总结多种相同的物种和特性(属性+行为)，提炼到一个容器，这个容器就是类
    //
    ////可以使用类图描述类，进而分析和设计类，使描述更加形象直观
    ////真实开发中，需求文档中的求都是文字描述，从文字提取有效信息，然后将这些信息设计类图，再定义类
    //
    //-------------------------------------------------------------------------------
    ////以下为类图
    public static class Dog {                          ////Dog类名称
        ///创建属性
        String brand;                                  ////brand,name,age成员属性
        String name;
        int age;
        //
        ////创建方法，行为
        public void run() {                            ////run成员方法 void无返回值
            System.out.println("run");
        }
        ////构造方法主要完成创建对象
        public void bark() {                           ///访问修饰符 构造方法名()（构造方法没有返回值类型）
            System.out.println("bark");
        }
        public void show() {
            System.out.println("Hi,my name is " + name +", I'm " + age + " years old, my brand is " + brand);
        }
        ///构造方法，无参构造
        ///系统本提供默认无参构造方法，如果自己手写一个构造函数，系统便不会帮我们生成构造了，因为调用我们手写的了
        public Dog() {
            System.out.println("Test");
        }
    }
    public static void main(String[] args) {
        //ctrl + 左键，可以在IDEA转到定义
        ////构造方法可以创建对象
        ////手写一个构造函数，系统便不再提供构造
        Dog dog = new Dog();                           ////本质上调用无参构造方法(public Dog())
        dog.brand = "Gold";
        dog.name = "Frank";
        dog.age = 5;
        dog.show();
    }
    ////无参构造配无参对象，有参构造配有参对象，没写构造系统生成无参构造，有参对象必须自己写构造。
}
//
class Me901 {
    ////自定义构造方法，可以在创建对象前完成赋值
    ///构造方法须与类名相同
    public static class Dog {
        String brand;                                  ////brand,name,age成员属性
        String name;
        int age;
        //
        ////所有构造方法没有返回类型，加void本质上不是构造方法了，而是普通方法
        ////一旦自定义构造方法，系统便不会生成构造了，因为对象会调用我们的自定义构造方法
        public Dog(String brand, String name, int age) {            ///创建有参构造
            ///this用法
            ///如果方法参数名和成员变量同名又没有加this，用名会产生歧义
            ////系统默认左右都是参数，所以实际上什么都没赋给成员变量，成员是null
            //
            this.brand = brand;
            this.name = name;                          ////这时添加this，后面指定成员变量，这时右边的brand代表我们的参数
            this.age = age;
        }
        public void show() {
            System.out.println("Hi,my name is " + name +", I'm " + age + " years old, my brand is " + brand);
        }
    }
    public static void main(String[] args) {
        //调度了带三个参数的构造
        Dog dog = new Dog("black","Chop",5);
        dog.show();
    }  ////所以有参构造的最大作用就是在对象创建的时候一次性完成赋值
}
class Me902 {
    //方法重载(overload)
    ////有多个名称相同，但参数类型，个数和顺序不同的方法，实现的功能都相同
    ////普通方法和构造方法都可以实现重载
    public static class Cat {
        int Cat() {                                               //修饰符和返回值类型
            return 1;
        }
        public void Cat(int age, String name) {                   //名称相同，参数类型，个数，顺序不同
            System.out.println("yes");
        }
        public void Cat(String name, int age) {
            System.out.println("no");
        }
        public Cat(String brand, int age, String name) {          //构造方法也可以重载

        }
    }
    public static void main(String[] args) {
        Cat cat = new Cat("Black", 5,"Chop" );   //调用方法4（构造方法）
        cat.Cat();                                                //调用方法1
        cat.Cat(5,"Chop");                             //调用方法2
        cat.Cat("Chip",6);                             //调用方法3
    }
    ////方法要达成重载，条件为参数顺序，类型，个数等差异不同
    ///也不管返回值、访问修饰符，也不管方法体内容是否相同
}
class Me903 {
    //Static使用方法(静态属性)
    ////使用static修饰属性和方法便可使用类名直接访问类的属性和方法
    public static class Cat {                                    ////内部类，要加static
        static String name;
        static int num;
        //静态代码块
        ///JVM加载类时，加载代码块
        ///如果有多个静态块，按顺序加载，并且只会被执行一次
        static {
            num++;
            System.out.println(num);
        }
        //
        public void Cat(int age, String name) {
            System.out.println("yes");
        }
        public void Cat(String name, int age) {
            System.out.println("no");
        }
        static void show() {
            System.out.println("hi");
        }
    }
    public static void main(String[] args) {
        ////类名 方法名
        Cat.name = "Chop";                                      //static静态属性，不需要对象，类名可直接访问
        Cat.show();
        Cat.num = 5;
        ///static属于类共享数据，如果乱用会破坏对象独立性，所以不能图方便一股脑把属性和方法全设成static
        ////一旦成员被定义为 static，它就属于类本身，让所有对象共享同一份数据，不再属于某个对象
    }
    ///总结: static静态变量共享数据，非static实例变量独立数据
}
class Me904{
    public static void main(String[] args) {
        //移步(ClassMe900/StaticTest.java)
        StaticTest num1 = new StaticTest();                      //psvm也是static类，可直接调用static成员
        StaticTest num2 = new StaticTest();                      //static静态代码块只会加载一次，所以num2不会再执行
    }
}
class Me905 {
    public static void main(String[] args) {
        //static变量，移步(ClassMe900/Car.java)
        //实例化变量
        Car car = new Car();
        car.brand = "Audi";
        Car car2 = new Car();                                    //在内存中car2和car都是独立数据，没有任何关系
        car2.brand = "Mercedes";
        car.show();
        car2.show();
        //静态化变量
        car.name = "Ace";
        car2.name = "South";                                     //在内存中car2和car都是共享数据，一个改全部改
        car.look();
        car2.look();
        ///静态static方法只能直接访问静态static成员，实例非static方法可访问全部
        ///静态static方法共享数据，属于类，实例非static方法独立数据
    }
}
class Me906 {
    public static void main(String[] args) {
        //封装
        ///面向对象三大特性 1.封装 2.继承 3.多态
        ///封装把对象的属性和方法绑定在一起，并且对外隐藏内部实现细节，只提供有限的接口让外部访问，不允许外部直接访问
        ///优点: 1.隐藏类实现细节 2.只能通过规定方法访问数据
        ///封装过程：1.将属性/方法设为private，2.创建getter和setter公有方法，3.在getter和setter加入判断语句
        //移步(ClassMe900/Bird.java)
        //无判断语句
        Bird bird = new Bird();                                   //创建对象
        bird.setAge(100);
        int age = bird.getAge();
        System.out.println(age);
        //防止非法输入，添加判断语句
        bird.setName("Chop");
        String name = bird.getName();                              //如果Chop为正确，打印Chop
        System.out.println(name);
        ///封装两种体现，1.一个类可以出现成员变量和成员方法 2.将私有变量封装成公有的get和set方法
    }
}
class Me907{
    public static void main(String[] args) {
        //import导入包
        ///如果你要用的类分开在不同的包，可以在使用import导入类文件
        //查看第4行
        Car car = new Car();
        ////如果同时用到多个包，必须写完整类名区分(查看并对比Me700.java/Me800.java/Me900.java的顶层)
        ///如果可以，可以一次性用*代替多个类名，变成一行
        //import MyJava.Class.ClassMe.ClassMe900.*
        //
        ////如果出现同名类，必须写完完整类名区分
        MyJava.Class.ClassMe.ClassMe700.Car car2 = new MyJava.Class.ClassMe.ClassMe700.Car();
    }
}
class Me908 {
    //类的访问控制
    ////public修饰符 - 可访问任何地方(当前类，当前包，子类)
    ////protected修饰符 - 当前类，当前包，子类，不同包和跨包不能访问
    ////默认修饰符 - 当前类，当前包
    ////private修饰符 -只能当前类
    public static void main(String[] args) {
    }
}