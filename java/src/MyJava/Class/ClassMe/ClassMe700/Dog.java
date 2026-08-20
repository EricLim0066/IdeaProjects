package MyJava.Class.ClassMe.ClassMe700;

//定义Dog类
//创建一个Dog类，首字母要大写

public class Dog {                                           //类名
    //实例属性，每个对象独有
    public String name;                                      //名字，跨包访问，要public，同包不用
    public int age;                                          //年龄，跨包访问，要public，同包不用
    int ages;
    //实例方法 (面向对象可执行的操作）
    public void sayHello() {
        System.out.println("Hi,my name is " + name +", I'm " + age + " years old.");
    }
    public void bark() {
        System.out.println(name + " is barking.");
    }
}

