package MyJava.Class.ClassMe.ClassMe1200;

public class Rectangle implements Shape{                   //定义长方形类
    double height;                                          //定义长方形的高和宽属性
    double width;
    public Rectangle() {

    }
    public Rectangle(double height, double width) {
        this.height = height;                                //定义构造方法，传回来的参数，指向成员变量
        this.width = width;
    }
    @Override
    public double getArea() {
        double area = height*width;                         //重写shape方法，计算面积
        return area;
    }
}
