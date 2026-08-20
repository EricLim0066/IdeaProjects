package MyJava.Class.Me;

import MyJava.Class.ClassMe.ClassMe1200.*;

import java.util.Scanner;

public class Me1200 {
    public static void main(String[] args) {
        //接口
        ///接口代表某种能力，即想找个舞蹈家，那就找个有舞蹈能力的人，而不是这个人本身
        ///interface 接口名称，接口中的方法都是抽象方法，所有方法不能有实现
        ///类与类的关系叫继承extends，类与接口的关系实现implements
    }
}
class Me1201 {
    public static void main(String[] args) {
        ///找个舞蹈家，那就找个有舞蹈能力的人，而不是这个人本身
        ///创建新接口时注意不是class，是interface
        ///Diagram查看关系时，父子类继承是实线，接口类实现是虚线
        //调度接口和类过来实现
        //移步(接口ClassMe1200/Dance.java,类ClassMe1200/Dancer.java，类ClassMe1200/DanceTeacher.java)
        Dance[] dances = new Dance[]{new Dancer(),new DanceTeacher()};          //定义一个接口数组，保存所有实现类的对象
        for (Dance dance: dances) {                                             //每个dance都是一个接口变量，储存dances赋过来的实现类的对象
           dance.dance();
        }
    }
}
class Me1202 {
    public static void main(String[] args) {
        //接口
        ///1.同样有不能实例化，不能有构造的抽象方法
        ///2.实现类必须实现接口所有方法，即接口有多少方法，类就必须实现多少方法，少一个就报错
        ///3.一个类可以多个接口，父子类只能单继承，但接口类可以多继承
        ///4.接口变量都是静态常量
        ///5.接口应用场景为has - a
        //移步(接口ClassMe1200/Fly.java,接口ClassMe1200/Run.java，类ClassMe1200/Bird.java)
        //抽象类
        ///1.同样有不能实例化，不能有构造的抽象方法
        ///2.抽象类可以有普通方法，构造方法和实例成员变量
        ///3.符合is - a关系的使用抽象类
    }
}
class Me1203 {
    public static void main(String[] args) {
        ///一个类只能继承一个父类，但可以有多个接口
        /// 接口比抽象类更偏向“规范”，但新版本后，接口方法可以有默认实现，不再全部都是抽象方法
        //开发一个支持加减乘除的商用计算机，使用接口实现计算功能
        //移步(接口ClassMe1200/Calc.java,类ClassMe1200/Add.java,类ClassMe1200/Sub.java,类ClassMe1200/Multi.java,类ClassMe1200/Divis.java)
        System.out.println("Enter the first number");
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();                                    //输入第一个号码
        System.out.println("Enter the second number");
        int num2 = input.nextInt();                                    //输入第二个号码
        //接口数组保存所有实现类的对象
        Calc[] calcs = new Calc[]{new Add(),new Sub(),new Multi(),new Divis()};
        for (Calc calc: calcs) {                                      //储存calcs对象赋过来的calc变量
            double result = calc.calc(num1, num2);                    //calc对象调用子类calc方法(和接收参数)，赋给result
            System.out.println(result);                               //输出结果
        }
    }
}