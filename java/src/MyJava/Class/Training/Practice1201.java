package MyJava.Class.Training;

import MyJava.Class.ClassMe.ClassMe1200.*;

import java.util.Scanner;

public class Practice1201 {
    public static void main(String[] args) {
        //鱼类有游泳和吃东西的能力，定义金鱼实现游泳和吃东西两个接口与鲨鱼实现游泳，吃东西和电感应三个接口
        //移步(接口ClassMe1200/Eat.java,接口ClassMe1200/Swim.java,接口ClassMe1200/Power.java,类ClassMe1200/GoldFish.java,类ClassMe1200/Shark.java)
        //第一种做法
        //创建父类数组
        Fish[] fish = new Fish[]{new GoldFish("Gold fish"), new Shark("Shark")};
        for (Fish fishs : fish) {                            //变量fishs接收fish的数组
            fishs.eat();
            fishs.swim();
            if (fishs instanceof Shark) {                    //instaceof单独判断鲨鱼
                Shark shark = (Shark) fishs;                 //如果fishs是鲨鱼就强制转换成鲨鱼变量
                shark.power();                               //调度鲨鱼电感应能力
            }
            fishs.show();
        }
        //第二种做法
        //创建金鱼对象
        System.out.println("=====================================================");
        GoldFish goldfish = new GoldFish("GoldFish");
        goldfish.eat();                                        //调度接口技能
        goldfish.swim();
        goldfish.show();                                       //介绍鱼的类型
        System.out.println("=====================================================");
        //创建鲨鱼对象
        Shark shark = new Shark("Shark");
        shark.eat();                                           //调度接口技能
        shark.swim();
        shark.power();
        shark.show();                                          //介绍鱼的类型
    }
}
class Practice1202 {
    public static void main(String[] args) {
        //有激光，喷墨，针式等打印机类型，请调度打印机的打印方法
        //移步(接口ClassMe1200/Printer.java，父类ClassMe1200/PrintMachine.java，子类ClassMe1200/LaserPrinter.java，子类ClassMe1200/InkjetPrinter.java，子类ClassMe1200/DotPrinter.java)
        //定义打印机数组
        PrintMachine[] printer = new PrintMachine[] {new LaserPrinter(),new InkjetPrinter(),new DotPrinter()};
        for (PrintMachine printers : printer) {                //printers对象接收printer数组里的单个元素
            printers.show();                                   //打印打印机的介绍
            printers.print();                                  //打印打印机的工作
            ///父类实现了某个接口，子类就不用再单独实现，而是父类统一调用，这样结构图就会很清晰
            ///编写阶段，看到的是父类变量.方法名()，但是运行时会根据父类变量保存子类对象，执行对应子类方法
            ///最终执行子类行为，子类代码
        }
    }
}
class Practice1203 {
    public static void main(String[] args) {
        //创建根据输入不同的数字，代表相应图形的shape接口，根据用户输入的数字计算图形
        //移步(接口ClassMe1200/Shape.java，类ClassMe1200/Rectangle.java，类ClassMe1200/Square.java)
        System.out.println("Press : 1.(rectangle) 2.(square)");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        Shape shape = null;                                //定义父类接口变量为空
        //
        if (num == 1) {                                //1代表长方形
            System.out.println("Please enter the height and width");
            int height = input.nextInt();
            int weight = input.nextInt();
            shape = new Rectangle(height,weight);      //将子类带着输入结果参数传给父类变量
        } else if (num == 2) {                         //2代表正方形
            System.out.println("Please enter the side");
            int side = input.nextInt();
            shape = new Square(side);                  //将子类带着输入结果参数传给父类变量
        } else {
            System.out.println("Number not found, please try again");
            return;                                   //添加return让程序直接退出，shape.getArea()为null就不会被执行而报错
        }
        System.out.println(shape.getArea());          //然后父类变量调度子类方法输出
    }
}
