package MyJava.Class.Training;

import MyJava.Class.ClassMe.ClassMe1100.*;

import java.util.Random;

public class Practice1101 {
    //使用多态完成中英马打招呼方法
    //创建国家对应的三人对象
    //移步(父类ClassMe1100/Person.java,子类ClassMe1100/Chinese.java,子类ClassMe1100/American.java,子类ClassMe1100/Malays.java)
    public static void main(String[] args) {
        Chinese chinese = new Chinese();
        American american = new American();
        Malays malays = new Malays();
        //对象数组
        Person[] persons = new Person[3];                       //三个对象都有个统一的父类person，创建person数组
        persons[0] = chinese;
        persons[1] = american;                                  //把对象传进数组
        persons[2] = malays;
        //使用多态让各国人打招呼
        for (Person p:persons) {                                //(数组类型 迭代变量(每次循环数组取出来的对象)；数组名(persons[i])
            p.SayHallo();                                       //父类调度各个人对应的sayhello方法
        }
        ///多态的终极价值，实现统一调用，增强扩展性
    }
}
class Practice1102{
    public static void main(String[] args) {
        //蛋糕店可以根据客户不同需求生产不同尺寸的蛋糕，6，8，10寸是蛋糕尺寸，慕斯，泡芙，水果是蛋糕类型
        //客户预定蛋糕，不同口味的
        //移步(父类ClassMe1100/Cake.java,子类ClassMe1100/MousseCake.java,子类ClassMe1100/PuffsCake.java,子类ClassMe1100/FruitCake.java,子类ClassMe1100/Shop.java)
        Cake cake1 = new MousseCake();                           //定义父类变量,指向各种类型蛋糕
        Cake cake2 = new PuffsCake();
        Cake cake3 = new FruitCake();
        //开蛋糕店
        Shop shop = new Shop();
        String[] types = {"Mousse","Puffs","Fruit"};              //定义蛋糕类型数组
        int[] size = {6,8,10};                                    //定义蛋糕尺寸数组
        ///为模拟真实客户的不同需求，给随机值
        Random ramdom = new Random();                             ///import ramdom随机值
        for(String type : types){                                 //for增强
            Cake cake = shop.makeCake(type);                      //再定义父类变量，指向店的蛋糕类型
            int num = ramdom.nextInt(3);                   //从0到2下标范围数，0，1，2对应6，8，10不同尺寸
            cake.getCake(type,size[num]);                         //父类cake调用并输入for增强的type，和num随机数尺寸等参数给对应的子类
        }
    }
}
