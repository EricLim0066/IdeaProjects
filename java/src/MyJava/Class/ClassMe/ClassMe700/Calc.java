package MyJava.Class.ClassMe.ClassMe700;

public class Calc {
    //定义分数
    public int english;                                  //英语成绩
    public int chinese;                                  //中文成绩
    public int math;                                     //数学成绩
    //定义一个求总成绩的方法，返回值是总成绩
    public int getTotal() {
        int total = english + chinese + math;
        return total;                                    //后面没有void的必须用return返回并且类型要一致
    }
    //定义一个求总平均分的方法，返回值是平均分
    public double getAvetotal() {
        return getTotal()/3.0;                          //两个函数可以通过方法名称调度
    }
    //定义一个求总平均分的方法，返回值是平均分
//    public double getAvetotal() {
//        double avetotal = (english + chinese + math)/3.0;
//        return avetotal;
//  }
}
