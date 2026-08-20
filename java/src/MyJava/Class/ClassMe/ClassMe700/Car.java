package MyJava.Class.ClassMe.ClassMe700;

//定义Car类
//跨包访问，尽可能分开class
public class Car {
    public String brand;                                     //品牌
    public String colour;                                    //颜色
    public int price;                                        //价格
    public void show() {                                     //方法/行为
        System.out.println("Brand of the car is " + brand + ", it's " + colour + " colour, price is " + price + " dollars.");
    }
}
