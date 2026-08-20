package AI;

import java.util.Scanner;
public class AI_robot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("聊天机器人，启动！输入Bye即可退出。");
        //
        while (true) {
            System.out.println("你: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("bye")){
                System.out.println("机器人:再见!");
                break;
            }
            if (input.contains("你好") || input.contains("hello")) {
                System.out.println("机器人:你好！很高兴见到你! ");
            } else if (input.contains("你是谁")) {
                System.out.println("机器人:你是你的聊天机器人! ");
            } else if (input.contains("今天")) {
                System.out.println("机器人:今天的天气还不错吧? ");
            } else if (input.contains("什么")) {
                System.out.println("机器人:你好，有什么不明白的地方吗? ");
            } else {
                System.out.println("机器人:我不太明白，能换个说法吗? ");
            }
        }
        scanner.close();
    }
}
