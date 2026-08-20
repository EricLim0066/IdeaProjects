package MyJava.Class.ClassMe.ClassMe1200;

public class Sub implements Calc{                     //定义减法类，用于实现减法
    @Override
    public double calc(int num1, int num2) {          //重写calc接口方法
        return num1-num2;
    }
}