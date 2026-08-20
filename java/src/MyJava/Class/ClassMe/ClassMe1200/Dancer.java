package MyJava.Class.ClassMe.ClassMe1200;

public class Dancer implements Dance {                    ///implements实现，和extends继承类似
    //定义舞蹈家类
    ///类与接口之间的关系为实现
    @Override
    public void dance() {                                //重写和实现接口
        System.out.println("Dancer Dance");              //输出舞蹈家跳舞
    }
}
