package MyJava.Class.ClassMe.ClassMe1200;

public class Square implements Shape{                      //定义正方形类
    double side;                                           //因为正方形四边都一样，定义正方形的边属性
    public Square() {

    }
    public Square(double side) {
        this.side = side;                                  //定义构造方法，传回来的参数，指向成员变量
    }
    @Override
    public double getArea() {
        double area = side*side;                           //重写shape方法，计算面积
        return area;
    }
}
