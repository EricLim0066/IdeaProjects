package MyJava.Class.ClassMe.ClassMe800;

public class Score {
    //有5位学员去参加比赛，求平均成绩和最高成绩
    //定义求平均成绩的方法
    public double GetAveScore(int[] score) {         // 定义数组参数
        //计算总分
        int sum = 0;
        for (int i = 0; i< score.length; i++) {
            sum += score[i];                         //循环累加
        }
        //计算平均分
        double avescore = sum*1.0/ score.length;
        return avescore;
    }
    //定义求最高成绩的方法
    public int GetMaxScore(int[] score) {           //多个类型相同都可以封装成数组，即说明参数可以为类型
        int max = score[0];
        //打擂台
        for (int i = 1; i < score.length; i++) {
            if (max < score[i]) {
                max = score[i];
            }
        }
        return max;
    }
}
