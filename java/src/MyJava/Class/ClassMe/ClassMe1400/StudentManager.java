package MyJava.Class.ClassMe.ClassMe1400;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {                     //定义学生管理类，提供添加和查询学生
    //定义一个泛型集合保存学生数据
    List<Student> list = new ArrayList<Student>();
    //添加学生
    public boolean addStudent(Student stu) {
        Boolean flag = list.add(stu);             //使用布尔值反馈类型，表示学生添加成功的反馈
        return flag;
    }
    //查询学生
    public void checkStudent() {
        System.out.println("Student name\t\tStudent age\t\tStudent id");
        for (Student stu : list) {               //把学生列表赋给stu，然后调度student类
            System.out.println(stu.getName() + "\t\t\t\t\t" + stu.getAge() + "\t\t\t\t\t" + stu.getId());
        }
    }
}
