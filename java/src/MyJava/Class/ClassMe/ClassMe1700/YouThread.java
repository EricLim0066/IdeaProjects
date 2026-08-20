package MyJava.Class.ClassMe.ClassMe1700;

public class YouThread implements Runnable{
    //定义拥有接口的线程类
    ///同步代码块，使用synchronized修饰代码块，同步对象通常为this，或自定义object
    ///在类添加synchronized线程加锁让t1先执行完再执行t2
    //t1方法，helo循环20次
    Object obj = new Object();                    //可以定义Object确保线程指定同一对象
    public void t1() {                            //synchronized线程加锁
        synchronized(obj) {                       //this/obj锁住当前对象，保证同一时间只有一个线程执行
            for (int i = 1; i <= 20; i++){
                System.out.print(Thread.currentThread().getName() + " =" );
                System.out.print("H");
                System.out.print("E");
                System.out.print("L");
                System.out.print("O");
                System.out.println();
            }
        }
    }
    //t2方法，2026循环20次
    public void t2() {                            //synchronized线程加锁
        synchronized(obj) {                       //this锁住当前对象，保证同一时间只有一个线程执行
            for (int i = 1; i <= 20; i++){
                System.out.print(Thread.currentThread().getName() + " =");
                System.out.print("2");
                System.out.print("0");
                System.out.print("2");
                System.out.print("6");
                System.out.println();
            }
        }
    }
    //重写run方法
    ///start启动后，谁先抢到cpu资源，谁就先调用方法
    @Override
    public void run() {
        t1();
        t2();
    }
}
