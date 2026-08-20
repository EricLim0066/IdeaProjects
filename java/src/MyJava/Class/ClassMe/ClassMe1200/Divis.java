package MyJava.Class.ClassMe.ClassMe1200;

public class Divis implements Calc{                     //定义除法类，用于实现除法
    @Override
    public double calc(int num1, int num2) {            //重写calc接口方法
        if (num2 != 0) {
            return num1*1.0/num2;                       //因为java中任何整数除0都会报错，加入if判断num2是否为0
        } else {
            return 0;
        }
    }
}