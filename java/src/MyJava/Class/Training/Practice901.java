package MyJava.Class.Training;

import MyJava.Class.ClassMe.ClassMe900.Truck;
import MyJava.Class.ClassMe.ClassMe900.Vote;

public class Practice901 {
    //运用面向对象思想抽象出Truck类，卡车有品牌，型号，生产年份，驶程里速
    //对驶程里速进行封装，保证有效性，使用带参构造对属性赋值
    //移步(ClassMe900/Truck.java)
    public static void main(String[] args) {
        Truck truck = new Truck("MAN","6Ton TGM",2024);
        truck.setKilometer(34672);
        truck.show();
    }
}
class Practice902 {
    public static void main(String[] args) {
        //模拟大选投票，每个民众只能投一次票，并且投票数达到100时，停止投票
        //移步(ClassMe900/Vote.java)
        Vote vote = new Vote("Mond");
        Vote vote2 = new Vote("LK");           //设置2个候选人
        //
        vote.show();
        vote.voter();
        vote2.voter();
        vote.show();
    }
}
