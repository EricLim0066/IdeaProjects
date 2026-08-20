package MyJava.Class.Training;

import MyJava.Class.ClassMe.ClassMe1500.Gender;
import MyJava.Class.ClassMe.ClassMe1500.Student;

import java.util.Scanner;

public class Practice1501 {
    public static void main(String[] args) {
        //定义学生类，将性别定义为枚举类型，实例化学生对象，给学生姓名和性别属性赋值
        //实例化学生对象
        //移步(ClassMe1500/Gender.java和ClassMe1500/Student.java)
        Student student = new Student();
        student.name = "YajuSenpai";
        student.sex = Gender.Male;              //使用枚举常量，变量取值被限制，不能随意选择其他属性
        System.out.println("Hi,my name is " + student.name + ", my gender is " + Gender.Male);
        ///目前所学自定义类型 class常规类, interface接口, enum枚举
        ///java有很多种类型，但在项目中，我们可以定义自己的类型
    }
}
class Practice1502{
    public static void main(String[] args) {
        //统计字符次数
        //输入几个字符串，统计该字符串的大写，小写，数字字符串出现次数
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a sentences");
        String word = input.next();
        //定义三个计数器
        int bigChar = 0, smallChar = 0, number = 0;
        //遍历字符串的大写小写及字符串，把字符串拆成单个数组
        for (char words : word.toCharArray()) {         ///toCharArray字符串转成数组集合
            //遍历每个字符串数组，一个words一个字符
            if(words >= 'A' && words <= 'Z') {
                bigChar++;
            }else if (words >= 'a' && words <= 'z') {
                smallChar++;
            } else if (words >= '0' && words <= '9') {
                number++;
            } else {
                System.out.println("Not Found :(");
            }
        }
        //出了循环，统计字符
        System.out.println("total big letter: " + bigChar);
        System.out.println("total small letter: " + smallChar);
        System.out.println("total number: " + number);
    }
}