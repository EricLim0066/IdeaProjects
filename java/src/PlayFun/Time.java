package PlayFun;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Time {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}

class Ti {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Hello World");
    }
}
class Tim {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(new Dimension(400,300));
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Hello World");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(label);
        panel.add(Box.createVerticalGlue());

        jFrame.add(panel);

        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
class Me {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random randInput = new Random();
        int studentNum = 0;
        int countPass = 0;
        int countFail = 0;


        int studentScore = 0;

        boolean numFlag = true;
        while (numFlag) {
            studentNum++;
            studentScore = randInput.nextInt(100)+1;

            if (studentScore >= 50) {
                countPass++;
            } else {
                countFail++;
            }
            System.out.println(studentScore);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (studentNum == 100) {
                numFlag = false;
            }
        }

        System.out.println("Total Pass:" + countPass);
        System.out.println("Total Fail:" + countFail);
    }
}
class p {
    public static void main(String[] args) {
        boolean we = true;
        while (we) {
        }
    }
}