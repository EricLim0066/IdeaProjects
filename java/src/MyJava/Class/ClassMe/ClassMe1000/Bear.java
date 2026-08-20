package MyJava.Class.ClassMe.ClassMe1000;

public final class Bear {                                     //final类
    //final的使用
    //定义final类型
    public final String name;                                 //final属性(直接赋最终值)

    public Bear(String name) {                                //final属性初始化
        this.name =name;
    }

    public final void show() {                                //final方法
        System.out.println("Im bear");
    }
}
