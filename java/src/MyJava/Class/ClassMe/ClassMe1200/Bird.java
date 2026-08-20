package MyJava.Class.ClassMe.ClassMe1200;

public class Bird implements Fly,Run {                  //定义Bird类实现Fly和Run接口
    ///一个类可以实现多种能力（接口）
    ///实现类必须实现接口所有方法，即接口有多少方法，类就必须实现多少方法，少一个就报错
    @Override
    public void fly() {

    }
    @Override
    public void fly1() {

    }
    @Override
    public void fly2() {

    }
    @Override
    public void run() {
        ///通过类名/接口名点出变量名，都是静态调用的方式
        //Run.num = 10;                                  //报错提示为常量
    }
}
