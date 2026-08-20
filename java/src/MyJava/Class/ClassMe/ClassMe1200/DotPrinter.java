package MyJava.Class.ClassMe.ClassMe1200;

public class DotPrinter extends PrintMachine implements Printer{
    //定义第三个子类型，针式打印机
    @Override
    public void show() {                                     //调用打印机类型
        System.out.println("Im dot printer");
    }

    @Override
    public void print() {                                   //调用打印机工作
        System.out.println("Dot printer printing");
    }
}