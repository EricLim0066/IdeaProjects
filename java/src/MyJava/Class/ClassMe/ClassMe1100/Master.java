package MyJava.Class.ClassMe.ClassMe1100;

public class Master {
    //定义主人类，给宠物喂食
    public void feed(Dog dog,int num){                            //定义喂食方法,参数1要喂的狗类，参数2喂了增加能量
        dog.eat(num);                                             //投喂狗时，调度狗类eat方法，表示增加了多少能量值
    }
    public void feed(Cat cat,int num){                            //定义喂食方法,参数1要喂的猫类，参数2喂了增加能量
        cat.eat(num);                                             //投喂猫时，调度猫类eat方法，表示增加了多少能量值
    }
}
