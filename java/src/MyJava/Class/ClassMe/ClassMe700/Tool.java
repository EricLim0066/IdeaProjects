package MyJava.Class.ClassMe.ClassMe700;

public class Tool {
    ////全局变量和局部变量，变量声明的位置决定其作用域
    ////全局变量，在类里，整个对象可访问，随对象存在，全局可用，不被类方法包含
    public int num;                                   //定义一个全局变量，如果整数类型没有赋值，系统默认值为0
    public void f1() {
        num = 3;
    }
    public void f2() {
        num = 5;
    }
    ////局部变量，在方法里，随方法存在，只能在当前方法里用，出了方法{}就会失效
    public void f3() {
        int a = 1;                                    //定义局部变量
    }

}
