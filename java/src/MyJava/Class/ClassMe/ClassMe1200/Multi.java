package MyJava.Class.ClassMe.ClassMe1200;

public class Multi implements Calc{                     //定义乘法类，用于实现乘法
    @Override
    public double calc(int num1, int num2) {            //重写calc接口方法
        return num1*num2;
    }
}