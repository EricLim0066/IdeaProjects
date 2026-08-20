package MyJava.Class.Training;

import MyJava.Class.ClassMe.ClassMe700.Calc;
import MyJava.Class.ClassMe.ClassMe700.Movie;

import java.util.Scanner;

public class Practice701 {
    public static void main(String[] args) {
        //创建一个movie类，有电影名称，导演，演员三个属性，写一个打印所有属性信息的方法
        ////类可以包含基本类型，（数组，String，自定义）引用类型
        //定义类名 (移步ClassMe700/Movie.java)
        Movie movie = new Movie();                        //创建了一个电影
        movie.movieName = "Summer in closed eyes";
        movie.director = "Mr.Shin";
        movie.initData();                                 //相当于直接给每个演员（数组）赋值
        //打印自我介绍
        movie.show();
        System.out.println("================================================");
        Movie movie2 = new Movie();
        movie2.movieName = "Back to 2077";
        movie2.director = "Ms.Alin";
        movie2.initData();                                //缺点，只能面向单个对象，要么多个对象都使用同个类
        movie2.show();
    }
}
class Practice702 {
    public static void main(String[] args) {
        //输入三门课的分数，并计算其平均分和总成绩，编写成绩计算类实现功能
        //定义计算类，移步(ClassMe700/Calc.java)
        Scanner input = new Scanner(System.in);
        Calc cal = new Calc();
        //输入各自分数
        System.out.println("Enter your english score");
        cal.english = input.nextInt();                      //输入英语成绩
        System.out.println("Enter your chinese score");
        cal.chinese = input.nextInt();                      //输入中文成绩
        System.out.println("Enter your math score");
        cal.math = input.nextInt();                         //输入数学成绩
        //求总分
        int total = cal.getTotal();
        double avetotal = cal.getAvetotal();
        String result = String.format("%.2f",avetotal);     //为严谨，保留后两位小数
        //
        System.out.println("Total score is " + total);
        System.out.println("Total average score is " + avetotal);

    }
}