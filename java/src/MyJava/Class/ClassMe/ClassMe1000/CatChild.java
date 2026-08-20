package MyJava.Class.ClassMe.ClassMe1000;

public class CatChild extends Cat {
    ////子类改写父类方法
    //定义子类
    public void cat() {                                    //public修饰符不严于父类，void相同或他的子类(范围尽可能比父类小）
        System.out.println("running fast");                //cat名称相同，()参数类型相同
    }
}
