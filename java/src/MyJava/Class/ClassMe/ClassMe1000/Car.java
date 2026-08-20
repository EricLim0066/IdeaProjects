package MyJava.Class.ClassMe.ClassMe1000;

////我们自定义的类也是一种类型
public class Car {
    public String brand;
    public String name;
    public int price;

    public Car(String brand, String name, int price){
        this.brand = brand;
        this.name = name;
        this.price = price;
    }

    ///override注解，重写父类时，告诉编译器这个是检查重写
    ///作用：标记检查方法和是否正确重写
    ///通常可以不写，但写错了不容易发现
    @Override
    public String toString() {                               //toString()方法
        ////toString是object的其中一个方法，默认打印类名@哈希码，可以在重写object类后定义打印内容
        ///重写后是返回对象的可读字符串，默认的类名@哈希码 ，这里打印属性
        return "Car{" +                                      ///因为返回string对象，toString通常配return
                "brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
    @Override
    ///调用car.equals(car2)时，obj调用car2传进来的对象
    public boolean equals(Object obj) {                      //equals()方法
        ////因为比较和判断对象，最终结果只有两种，即true或false，所以返回值类型使用布尔值类型
        ///true内容相同，false内容不相同
        if (obj instanceof Car) {                            ////instanceof判断运算符，布尔值类型，判断是否car类型
            obj = (Car)obj;                                  //如果是car类型，obj强制转换为car类型
            if (((Car) obj).brand.equals(this.brand)) {      //比较对象是否相同
                return true;
            } else {
                return false;
            }
        } else {                                             //如果不是car类型，返回false
            return false;
        }
    }
}
