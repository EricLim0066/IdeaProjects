package MyJava.Class.ClassMe.ClassMe1000;

public class Shark extends Animal {
    @Override
    public void show() {                             //调用Animal抽象父类方法
        System.out.println("Im shark");              ///抽象方法必须在子类中实现，除非子类也是抽象类才不需要

    }
}
