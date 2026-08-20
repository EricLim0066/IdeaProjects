package MyJava.Class.Training;

import MyJava.Class.ClassMe.ClassMe1400.Student;
import MyJava.Class.ClassMe.ClassMe1400.StudentManager;

import java.util.Scanner;

public class Practice1401 {
    public static void main(String[] args) {
        //使用泛型集合实现学生管理系统
        //1.添加学生 2.查询学生资讯
        //移步(ClassMe1400/Student.java和ClassMe1400/StudentManager.java)
        StudentManager studentmanager = new StudentManager();      //创建学生管理类
        //准备添加学生对象
        Scanner input = new Scanner(System.in);
        String YesOrNo = "Y";                                     //创建YesOrNo变量，表示继续添加学生
        while (YesOrNo.equals("Y")) {                             //当YesOrNo是y时，添加学生身份
            System.out.println("Please enter your name");
            String name = input.nextLine();
            System.out.println("Please enter your age");
            int age = input.nextInt();
            System.out.println("Please enter your id");
            String id = input.next();
            //实例化学生对象
            Student student = new Student(name,age,id);
            //布尔值判断是否添加成功
            Boolean flag = studentmanager.addStudent(student);   //把studentmanager调度给flag
            if (flag == true) {
                System.out.println("Add Successful !");
                System.out.println("Still need add more students ? (y/n)");
                YesOrNo = input.next();
            } else {
                System.out.println("Add failed please try again");
                YesOrNo = input.next();
            }
            studentmanager.checkStudent();
        }
    }
}
class Practice1402 {
    public static void main(String[] args) {

    }
}
