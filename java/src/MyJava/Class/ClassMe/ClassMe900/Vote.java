package MyJava.Class.ClassMe.ClassMe900;

public class Vote {
    //定义属性
    public static int countVote;                          //投票次数
    public int maxVote;                                   //投票最大次数
    public static final int maxCount = 1000;              //固定投票值
    public String name;                                   //投票人
    //
    public Vote(String name) {                            //投票人
        this.name = name;
    }
    //
    public void voter() {
        //如果投票次数达到1000，停止投票
        if (countVote == maxCount) {
            System.out.println("Stop voting !");
        } else {
            countVote++;
            System.out.println("Thanks for voting");
        }
    }
    public static void show() {                           //设置静态,展示票数共享同一份
        System.out.println("Its current " + countVote + " right now !");
    }
}
