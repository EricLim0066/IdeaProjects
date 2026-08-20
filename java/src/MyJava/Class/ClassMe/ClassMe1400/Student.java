package MyJava.Class.ClassMe.ClassMe1400;

public class Student {                           //定义学生类
    private String name;                         //定义成员变量
    private int age;
    private String id;

    public Student() {

    }

    public Student(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }
}