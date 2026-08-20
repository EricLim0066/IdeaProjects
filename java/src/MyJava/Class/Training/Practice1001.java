package MyJava.Class.Training;

import MyJava.Class.ClassMe.ClassMe1000.Fish;
import MyJava.Class.ClassMe.ClassMe1000.FlagFish;
import MyJava.Class.ClassMe.ClassMe1000.FlyFish;
import MyJava.Class.ClassMe.ClassMe1000.WhiteShark;

public class Practice1001 {
    public static void main(String[] args) {
        //有多种鱼类，游行速度为，白鲨:48km/h，飞鱼60km/h，旗鱼110km/h，输入编程根据输入时间计算行驶公里数
        //将所有子类组织在对象
        //因为抽象类无法直接创建对象，所以左边父类类型变量，右边引用子类实例化对象(多态写法）
        Fish fish1 = new WhiteShark(48);
        Fish fish2 = new FlyFish(60);
        Fish fish3 = new FlagFish(110);

        //对象去往子类各自调用calc方法回来对象，运行时会调用各自子类的实现(多态调用)
        int num1 = fish1.calc(3);
        System.out.println("White Shark moving distance is " + num1 + "km");
        int num2 = fish2.calc(3);
        System.out.println("Fly Fish moving distance is " + num2 + "km");
        int num3 = fish3.calc(3);
        System.out.println("Flag Fish moving distance is " + num3 + "km");

    }
}
class Practice1002 {
    public static void main(String[] args) {
    }
}
