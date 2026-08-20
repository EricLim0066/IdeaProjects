package MyJava.Class.Me;
import javax.swing.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
//
public class Me2000 {
    //extra notes额外笔记
    //定义Player类
    static class Player {
        String name;
        int chips;

        Player(String name, int chips) {
            this.name = name;
            this.chips = chips;
        }
    }
    public static void main(String[] args) {
        //定义数组储存变量
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("A", 50));
        players.add(new Player("B", 100));
        players.add(new Player("C", 30));

        ///手动排序/冒泡排序 (按chips降序)
        for (int i = 0; i < players.size() - 1; i++) {
            for (int j = 0; j < players.size() - 1 - i; j++) {
                if (players.get(j).chips < players.get(j + 1).chips) {

                    //添加容器暂时储存和手动移动变量
                    Player temp = players.get(j);
                    players.set(j, players.get(j + 1));
                    players.set(j + 1, temp);
                }
            }
        }
        ///自动排序 (降序)
        players.sort((a,b) ->b.chips - a.chips);

        ///输出结果都会一样
        for (Player p : players) {
            System.out.println(p.name + " : " + p.chips);
        }
    }
}
class Me2001 {
    public static void main(String[] args) {
        String name = "";
        String id;
        //
        name.isEmpty();    ///isEmpty()对象没有内容
        id = null;         ///没有对象
        //
    }
}
class Me2002 {
    public static void main(String[] args) {
        ///全局项目推荐统一使用parse和nextline trim,吃掉残留换行符
        Scanner input = new Scanner(System.in);
        //
        String name = "";
        int num = 0;
        double num2 = 0;

        try {
            name = input.nextLine().trim();
            num = Integer.parseInt((input.nextLine()).trim());
            num2 = Double.parseDouble((input.nextLine()).trim());
            ///输入类型不匹配异常
        } catch (InputMismatchException e) {         ///如果使用nextInt/nextDouble,使用InputMismatchException
            e.printStackTrace();
            ///不能转换成数字异常
        } catch (NumberFormatException e) {          ///如果使用parseInt/parseDouble,使用NumberFormatException
            e.printStackTrace();
        }
        System.out.println(name+ num + num2);
    }
}
 class Me2003 {
     public static void main(String[] args) {
         int i = 0;
         while (true) {   ///无限循环
             System.out.println("Loop count: " + i);
             i++;
             try {
                 int basesleep = 1000;            //设置每1000毫秒生成一次
                 Thread.sleep(basesleep);        ///Thread.sleep设定生成速度，通常使用毫秒单位
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
     }
 }
 class Me2004 {
    //制作UI
    public static void main(String[] args) {
        ///JFrame定义窗口，设置标题
        JFrame frame = new JFrame("Betting Game");
        ///setSize设置大小
        frame.setSize(400,300);
        ///setDefaultCloseOperation 设置关闭行为，必须写，否则程序还在后台跑
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ///setVisible设置窗口可视化
        frame.setVisible(true);
    }
}
class Me2005 {
    public static void main(String[] args) {
        ///Java没有类似python可以平方的**双乘符
        ///但是可以用math.pow代替平方,是double类型
        int square = (int) Math.pow(5,5);        //等价5^5
        ///java初衷最求通用性，设置double接收更大范围的的结果
        System.out.println(square);
    }
}