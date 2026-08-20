package MyJava.Class.ClassMe.ClassMe900;

import java.util.Scanner;

public class Bird {
    ///现有两种访问修饰符 public和private，public代表公有，private代表私有
    ///在对象直接赋值操作会报错
    private int age;
    private String name;                                  //alt + enter快速生成取值和赋值
    ///有两种可以访问当前方法的方式 1.赋值 2.取值
    ///这两种方式都是公开public的
    //set, 赋值
    public void setAge(int age) {
        this.age = age;
    }
    //get,取值
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name != "Chop") {                              //代码执行到这里，证明名字是错误的非法的
            name = null;
        } else {
            this.name =name;                               //代码执行到这里，证明名字是对的
        }
    }
}
