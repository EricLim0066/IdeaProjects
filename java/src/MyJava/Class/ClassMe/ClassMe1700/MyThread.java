package MyJava.Class.ClassMe.ClassMe1700;

public class MyThread extends Thread {
    ///创建MyThread类继承Thread
    ///重写run方法
    @Override
    public void run() {
        //定义线程要完成的工作，将工作内容放进run()方法
        for (int i = 1; i <= 10; i++){
            //定义循环获取当前线程的名字
            System.out.println(Thread.currentThread().getName() + "-" + i);
        }
        ///到main函数创建线程对象并调度Start线程
    }
}
