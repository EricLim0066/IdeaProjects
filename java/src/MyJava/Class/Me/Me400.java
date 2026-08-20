package MyJava.Class.Me;

import java.util.Scanner;

public class Me400 {
    public static void main(String[] args) {
        //二重循环，循环多层嵌套，循环与循环间要有前后关系
        //循环里面又有包含另一个完整循环结构
        int n = 3;
        int m = 5;                                               //i控制外层行数，j控制内层星数
        for (int i = 1; i <= n; i++) {                           //外层循环条件，打印行数
            for (int j = 1; j <= m; j++ ) {                      //内层循环条件，打印每行星数
                System.out.print("*");                           //内层循环操作，使用print，打星不换行
            }
            System.out.println(" ");                             //外层内循环操作，使用println
        }//注:外层变量不能和里面变量相同
    }
}
class Me401 {
    public static void main(String[] args) {
        /*打印 11111
              22222
              33333
              44444 */
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print(i);
            }
            System.out.println(" ");
        }
    }
}
class Me402 {
    public static void main(String[] args) {
        //打印左直角三角形
        /* *                                                      //i控制外层行数，j控制内层星数
           **
           ***
           ****
           *****
         */
        Scanner input = new Scanner(System.in);                   //输入想要的行数
        int n = input.nextInt();
        //
        for (int i = 1; i <= n; i++) {                            //n代表用户输入的行数
            for (int j = 1; j <= i; j++) {                        //根据用户输入的行数，内层也跟着打印同等数量的星
                System.out.print("*");
            }
            System.out.println(" ");
            //图形万能解法: 1.观察外层循环的结束条件 2.构建内层循环结束条件，即找到外层i与内层j的关系 3.内层输出要换行
        }
    }
}
class Me403 {
    public static void main(String[] args) {
        //打印等腰三角形
        /*      *                                               //和上几题不同，i控制外层行数，这次j控制内层左右空格，k控制星数
               ***
              *****
             *******
            *********
         */
        int n = 5;
        for (int i = 1; i <= n; i++) {
            //k代替了j控制星数，所以j这里打印空格
            for (int j = 1; j <= n - i; j++) {                  //每行i对比空格j，观察左边空格与星数，每行i加左边空格j每次都等于n，由此j=n-i
                System.out.print(" ");
            }
            //k控制星数
            for (int k = 1; k <= 2 * i - 1; k++) {              //每行i对比星数k，第一行一星往后的行都是+2的，由此 2*i-1
                System.out.print("*");
            }
            System.out.println(" ");
            //图形万能解法补充: 4.如果一行中有多个符号，内层需要多个循环分别控制不同类型的符号打印，然后找出每个内层与外层之间的关系
        }
    }
}
class Me404 {
    public static void main(String[] args) {
        //多重循环，循环1里面有个循环2，循环2里面又有个循环3，然后4，5....
        //尽可能循环次数越少，计算机压力越小，运行速度越快，代码越精良
        //3块钱可买1只公鸡，2块钱可买1只母鸡，1块钱可买3只小鸡，用100块买100只不同鸡种（每种必须买一只），公鸡母鸡小鸡各有多少只
        for (int i = 1; i <= 33; i++) {                  //外层买公鸡的数量
            for (int j = 1; j <= 50; j++) {              //内层1买母鸡的数量
                for (int k = 1; k <= 98; k++) {          //内层2买小鸡的数量
                    //假设三种鸡都100只，和买三种鸡的钱都刚好100块
                    if (i + j + k == 100 && i*3+j*2+k/3.0 == 100) {        //5/3和4/3整除都会得到1，避免这种误差，添加小数，确保没有余数
                        System.out.println(i + "\t" + j + "\t" + k);

                    }
                }
            }
        }
    }
}
class Me405 {
    public static void main(String[] args) {
        //超市购物系统
        //为计算每位顾客应付的货款，自动算出超市一天的营业额，以统计到超市一天购物的人数，试编一个超市购物程序
        Scanner input = new Scanner(System.in);
        int money, guy = 0, tur = 0, cus = 0;            //guy单人购物金额；tur营业额（所有顾客购物总额），cus顾客人数
        //
        boolean flag = true;                             //设boolean表达，表示超市开门还是关门
        while (flag) {                                   //开门了
            guy = 0;                                     //每次开门guy要清空，确保每个顾客的金额独立计算
            //
            do {                                         //顾客来购物
                money = input.nextInt();                 //顾客花销
                if (money == -1) {                       //输入-1证明超市关门，如果输入0，本来打算给客人结算金额或顾客逛逛不买，却提前关门了
                    flag = false;                        //-1证明超市关门
                    break;                               //关门了，不用执行
                }
                guy += money;                            //每买个东西，金额累加到guy，证明单人购物金额
            } while ( money != 0 );                      //不等于0时，才可以回到do执行（继续购物），否则直接结算
            //
            //因为金额累加到guy，如果购物金额不为0，证明购物了，购物了才需要打印金额
            if (guy != 0) {
                cus++;                                   //购物后，打印顾客人数
                //如果输入0，代表单人购物完成
                System.out.println("Total of shopping amount: " + guy + " dollars");
            }
            tur += guy;                                  //累加到guy的钱计入到营业额tur
        }
        //代码执行到这里代表已经关门了，统计
        System.out.println("Total of customer today: " + cus );
        System.out.println("Total of turnover today: " + tur + " dollars");
    }
}