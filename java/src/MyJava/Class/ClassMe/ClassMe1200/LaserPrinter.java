package MyJava.Class.ClassMe.ClassMe1200;

public class LaserPrinter extends PrintMachine implements Printer{
    //定义第一个子类型，激光打印机
    @Override
    public void show() {                                     //调用打印机类型
        System.out.println("Im laser printer");
    }

    @Override
    public void print() {                                   //调用打印机工作
        System.out.println("Laser printer printing");
    }
}
