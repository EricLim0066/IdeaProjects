package MyJava.Class.Me;

import MyJava.Class.ClassMe.ClassMe700.*;

import java.util.Scanner;

public class Me700 {
    public static void main(String[] args) {
        ////类和对象，把具有相同属性的对象和方法归为一个类(class)
        ////类算对象的模板和蓝图，也是对象的抽象化，而对象是实体化
        ////类不代表具体事物，对象才是表示具体事物，比如房子蓝图和房子本身，蓝图无法实体也无法具象，但房子可实实在在具象化实体化
        ////类是对象模板，对象是类的实例
    }
}
//类的定义
//定义类名 (移步ClassMe700/Dog.java)
class Me701 {
    //类函数是程序入口的函数
    public static void main(String[] args) {
        //在java创建狗狗对象
        Dog dog = new Dog();                            //类名 对象名 = new 类名()
        dog.name ="Chop";                               //引用对象成员，使用"."
        dog.age = 8;                                    //引用类属性: 对象名.属性
        dog.sayHello();                                 //引用类方法: 对象名.方法名()
        //
        Dog dog2 = new Dog();
        dog.name ="Munk";
        dog.age = 4;
        dog.sayHello();
    }
}
class Me702 {
    public static void main(String[] args) {
        //定义一个Car类，有品牌Brand，有颜色Colour和价格Price三种属性，一个介绍自己名称的方法为show(),使用程序定义盖类并创建对象
        //移步(ClassMe700/Car.java)
        Car car = new Car();
        car.brand = "Ferrari";
        car.colour = "yellow";
        car.price = 300000;
        car.show();
        //
        Car car2 = new Car();
        car2.brand = "Lamborghini";
        car2.colour = "black";
        car2.price = 753000;
        car2.show();
    }
}
class Me703 {
    public static void main(String[] args) {
        /// /面向对象思想 (object oriented programming) (OOP)
        ////面向对象思想：把功能分散到不同对象中，每个对象负责自己的行为，main函数只负责创建对象并组合调用
        ////即类是配方（定义属性和方法），对象是按配方做出来的实例，main是制作的地方（即这里）
        //使用面向对象方式做个登陆系统
        //定义类名 (移步ClassMe700/UserInfo.java)
        //现实中，登陆系统不止一个用户
        ////先建类，才能引用类，才可以建立对象，类的对象可以应用为数组，下面的代码实现题目
        UserInfo[] users = new UserInfo[50];                 //系统自带和类自定义也算类型 //数组每一项保存的讯息都是一个用户对象
        //创建一个UserInfo对象
        ///相比int只能储存单个数值，自定义类可以封装多个数据和行为，因此表达能力更强
        UserInfo info = new UserInfo();
        info.username = "Eric";
        info.password = "114514";
        users[0] = info;                                     //保存用户对象
        //
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter your username");
        String YourName = input.next();                      //输入用户讯息
        System.out.println("Please Enter your password");
        String YourPassword = input.next();
        //判定是否登陆失败
        boolean login = false;                               //假设都登陆失败
        for (int i = 0; i < users.length; i++) {             //数组要下标为0
            ////java使用.equals判定或对比字符串是否相等，用对象里的用户讯息对比用户输入的讯息
            //users[i].username(指单个用户对象.对象里的变量属性）
            ////null用于判定对象是否为空
            if(users[i] != null && users[i].username.equals(YourName) && users[i].password.equals(YourPassword)) {
                //代码执行到这里证明登录成功
                login = true;
                break;
            }
        }
        //出了循环，判定结果
        if (login == true) {
            System.out.println("Login successful !");
        } else {
            System.out.println("Login failed, please try again !");
        }
    }
}
class Me704{                                                     //这段为类*
    public void show() {
        ////定义类方法5要素,访问修饰符，返回值类型，方法名，参数列表和方法体
        ////定义一个方法就是定义一个功能，即类有什么能力，可以做到什么事情
        ////public为访问修饰符，void为返回值类型，xxx()为方法名，()里面为类型和参数列表
        System.out.println("yes");
        System.out.println("no");                                //整段为方法体
    }
}
class Me705{
    public static void main(String[] args) {
        //类的无参数列表无返回值方法
        //没有参数，括号里面不写，没有返回值，写void
        //移步(ClassMe700/Dog.java)
        ////如果方法没有返回值，返回类型为void，代表没有返回值
        Dog dog = new Dog();
        dog.sayHello();                                          //如果类没有赋值，对象打印时会默认为空(null,0)
        dog.bark();
        ////如果有返回值，类方法必须带return返回该值
        ////方法返回类型和return类型必须一致或兼容，(public int return int, public String return String)
        //移步(ClassMe700/Cal.java)
        Cal cal = new Cal();
        int result = cal.getsum();
        System.out.println(result);
    }
}
class Me706 {
    public static void main(String[] args) {
        ////方法调用问题
        ////如果两个方法不在同一个类，需要先实体化对象，然后通过对象名.方法名()调度(查看上一段的main函数)
        ////如果两个方法在同一个类，那么我们可以直接通过方法名调用(查看ClassMe700/Calc.java)
    }
}
class Me707{
    public static void main(String[] args) {
        ////全局变量和局部变量，变量声明的位置决定其作用域
        ////全局变量，在类里，整个对象可访问，随对象存在，全局可用，不被类方法包含
        //移步(ClassMe700/Tool.java)
        Tool tool = new Tool();
        tool.f1();
        System.out.println(tool.num);
        ////局部变量，在方法里，随方法存在，只在方法里用，出了方法{}就会失效
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);                     //参考循环，{}里的i也算一种局部变量，只在当前方法有效
        }
        System.out.println("i");
    }
}