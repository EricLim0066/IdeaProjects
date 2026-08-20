package MyJava.Class.Me;

import MyJava.Class.ClassMe.ClassMe1700.MyRunnable;
import MyJava.Class.ClassMe.ClassMe1700.MyTask;
import MyJava.Class.ClassMe.ClassMe1700.MyThread;
import MyJava.Class.ClassMe.ClassMe1700.YouThread;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Me1700 {
    public static void main(String[] args) {
        //线程与进程
        ///进程(process)一个正在运行的程序，操作系统用来分配资源(内存,CPU等)和安排执行的基本单位
        ///Ctrl+Shift+Esc便可查看进程
        ///线程(thread)进程里的一个执行路线，通过CPU分配时间独立按顺序执行代码的最小单位
        ///线程与进程关系: 一个线程只能有一个进程，但一个进程必须有至少一个和可以多个线程
        ///多线程: 一个运行的程序同时拥有多个线程同时做不同的工作，本质上cpu在多个线程快速切换执行
        ///主线程：1.main()所在函数为主线程，2.生产其他子线程的线程，3.主线程最后执行，因为要做关闭操作
        //打印主线程名称
        ///currentThread()当前线程
        Thread thread = Thread.currentThread();        //main()本身已经是个线程不需要再new一个了，直接使用当前线程
        ///thread名字不修饰时默认main
        System.out.println("thread is " + thread.getName());     ///thread本身不是private，但名字是，所以使用getter和setter
        //重新修饰thread名字
        thread.setName("peppa");
        System.out.println("thread is " + thread.getName());
    }
}
class Me1701{
    public static void main(String[] args) {
        //创建线程
        ///使用extends继承java.lang.Thread类
        ///使用implements实现java.lang.Runnable接口
        //继承Thread类方式
        ///创建MyThread类继承Thread
        ///重写run方法
        ///到main函数创建线程对象，并调度Start线程
        //移步(ClassMe1700/MyThread.java)
        //============================================
        //获取当前main()线程
        System.out.println(Thread.currentThread().getName());
        //创建线程对象
        MyThread thread = new MyThread();
        //对象调度start启动线程
        thread.start();
        ///当前main线程和thread子线程同时执行，各跑各的，也叫多线程
        ///线程启动后，就默认run()方法，你要做的事必须写在run()里，不然线程啥也不干
    }
}
class Me1702{
    public static void main(String[] args) {
        //实现runnable接口创建线程
        //接口thread类方式
        ///创建MyRunnable类实现Runnable接口
        ///重写run方法
        ///到main函数创建接口对象，并调度Start线程
        ///编写简单，适合单继承
        //===================================================
        //移步(ClassMe1700/MyRunnable.java)
        //获取当前main()线程
        System.out.println(Thread.currentThread().getName());
        //创建线程接口
        MyRunnable runnable = new MyRunnable();
        ///runnable不是线程，没有start()方法，只是负责定义任务，所以交给Thread对象启动线程
        Thread thread = new Thread(runnable);
        //对象调度start启动线程
        thread.start();
        ///当前main线程和runnable接口调给thread的子线程同时执行，各跑各的，也叫多线程
        ///线程启动后，就默认run()方法，你要做的事必须写在run()里，不然线程啥也不干
    }
}
class Me1703{
    public static void main(String[] args) {
        //实现多线程交替执行
        ///基于单继承局限性，适合多继承
        //移步(ClassMe1700/MyThread.java和ClassMe1700/MyRunnable.java)
        //调度MyThread类
        MyThread t1 = new MyThread();
        //调度MyRunnable接口
        MyRunnable runnable = new MyRunnable();
        Thread t2 = new Thread(runnable);
        //同时运行
        t1.start();
        t2.start();
        ///多线程交替执行，线程每次执行顺序不可预测，看起来像随机
    }
}
class Me1704{
    public static void main(String[] args) {
        //线程同步问题
        ///多个线程共享同一资源时会造成数据不安全问题
        ///同步代码块，使用synchronized修饰代码块，同步对象通常为this，或自定义object
        ///在类添加synchronized线程加锁让t1先执行完再执行t2
        //移步(ClassMe1700/YouThread.java)
        YouThread youthread = new YouThread();
        //把接口赋给对象启动
        Thread t1 = new Thread(youthread);
        t1.start();
        //把接口赋给对象启动
        Thread t2 = new Thread(youthread);
        t2.start();
    }
}
class Me1705{
    public static void main(String[] args) {
        //线程安全
        ///所谓线程安全，就是数据上加锁synchronized，不同的集合都有不同的效率
        ///所以在真实开发时，根据synchronized特性灵活选择
        //Vector和Arraylist集合
        ///Arraylist内部不含synchronized，非线程按全，适合单线程
        ArrayList <String> list = new ArrayList<>();
        list.add("MYR");
        list.add("SGD");
        ///Vector内部含有synchronized，线程安全，适合多线程
        Vector <String> vector = new Vector<>();
        vector.add("MYR2");
        vector.add("SGD2");
        //Hashmap和Hashtable双重集合
        ///Hashmap内部不含synchronized，非线程按全，适合单线程
        HashMap <String,String> map = new HashMap<>();
        map.put("Ali","al");
        map.put("Abu","ab");
        ///Hashtable内部含有synchronized，线程安全，适合多线程
        Hashtable <String,String> table = new Hashtable<>();
        table.put("Ali2","al2");
        table.put("Abu2","ab2");
    }
}
class Me1706{
    public static void main(String[] args) {
        //线程池
        ///实现多线程编程机制，帮助有效管理多个线程，提高程序性能和效率
        //创建2个线程池，然后创建3个任务，用submit()提交任务，最后使用shutdown()关闭线程池
        //移步(ClassMe1700/MyTask.java)
        //线程池步骤:
        ///1.ExecutorService创建线程池，管理多个线程，newFixedThreadPool(int)线程数量
        ExecutorService pool = Executors.newFixedThreadPool(2);
        ///要从更高维度看继承架构，ThreadPoolExecutor继承从抽象AbstractExecutorService,往上又接口从ExecutorService
        ///2.创建任务
        ///看哪个先抢到cpu执行权，抢不到的只能等上一个用完
        Runnable t1 = new MyTask("Task1");       //父类接口指向子类对象
        Runnable t2 = new MyTask("Task2");
        Runnable t3 = new MyTask("Task3");
        ///3.submit()提交任务到线池
        ///submit()会让线程池的线程调用run()执行任务，Runnable只是提供任务逻辑
        pool.submit(t1);
        pool.submit(t2);
        pool.submit(t3);
        ///4.shutdown()关闭线程池
        pool.shutdown();
        ///线程启动后，就默认run()方法，你要做的事必须写在run()里，不然线程啥也不干
    }
}