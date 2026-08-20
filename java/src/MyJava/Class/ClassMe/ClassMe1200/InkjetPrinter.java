package MyJava.Class.ClassMe.ClassMe1200;

public class InkjetPrinter extends PrintMachine implements Printer{
    //定义第二个子类型，喷墨打印机
    @Override
    public void show() {                                     //调用打印机类型
        System.out.println("Im inkjet printer");
    }

    @Override
    public void print() {                                   //调用打印机工作
        System.out.println("Inkjet printer printing");
    }
}