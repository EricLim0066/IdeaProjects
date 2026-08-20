package MyJava.Class.ClassMe.ClassMe1700;

public class MyTask implements Runnable{
    //定义任务,使用接口
    private String name;                                        //定义任务名为私有成员变量

    public MyTask() {

    }

    public MyTask(String name) {                               //定义任务带参变量
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " Running...");              //输出任务运行中
    }
}
