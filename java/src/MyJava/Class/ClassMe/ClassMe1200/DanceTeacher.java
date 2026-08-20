package MyJava.Class.ClassMe.ClassMe1200;

public class DanceTeacher implements Dance {                    ///implements实现，和extends继承类似
    //定义舞蹈老师类
    ///类与接口之间的关系为实现
    @Override
    public void dance() {                                       //重写和实现接口
        System.out.println("Dance teacher dance");              //输出舞蹈老师跳舞
    }
}