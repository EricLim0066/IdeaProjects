package MyJava.Class.ClassMe.ClassMe900;

public class Truck {
    //运用面向对象思想抽象出Truck类，卡车有品牌，型号，生产年份，驶程里速
    //对驶程里速进行封装，保证有效性，使用带参构造对属性赋值
    //
    //定义属性
    public String brand;                                   //品牌
    public String model;                                   //型号
    public int years;                                      //生产年份
    private int kilometer;                                  //驶程里速
    //构造方法
    //构造带参方法
    public Truck (String brand, String model, int years) {
        this.brand = brand;
        this.model = model;
        this.years = years;
    }
    public int getKilometer() {
        return kilometer;
    }
    public void setKilometer(int kilometer) {
        if (kilometer < 0) {
            kilometer = 0;
        } else {
            this.kilometer = kilometer;
        }
    }
    //写个show方法
    public void show() {
        System.out.println("Brand of truck is " + brand + ", model is " + model + ", it's made since " + years + " ago, it's current mile is " + kilometer + "km right now.");
    }
}
