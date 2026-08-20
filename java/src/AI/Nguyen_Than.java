package AI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Nguyen_Than extends JFrame {
    private int remainingDraws; // 剩余抽数
    private int fiveStarCounter = 0; // 5星计数
    private int fourStarCounter = 0; // 4星计数
    private int totalDraws = 0; // 已抽总数

    private JTextArea resultArea;
    private JButton oneDrawButton;
    private JButton tenDrawButton;

    private Random random = new Random();

    public Nguyen_Than(int initialDraws) {
        this.remainingDraws = initialDraws;

        setTitle("原神抽卡模拟器");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        oneDrawButton = new JButton("1抽");
        tenDrawButton = new JButton("10抽");

        buttonPanel.add(oneDrawButton);
        buttonPanel.add(tenDrawButton);
        add(buttonPanel, BorderLayout.SOUTH);

        oneDrawButton.addActionListener(e -> draw(1));
        tenDrawButton.addActionListener(e -> draw(10));

        updateButtons();
        setVisible(true);
    }

    private void draw(int count) {
        for (int i = 0; i < count; i++) {
            if (remainingDraws <= 0) break;

            remainingDraws--;
            totalDraws++;
            fourStarCounter++;
            fiveStarCounter++;

            boolean gotFourStar = false;
            boolean gotFiveStar = false;

            // 4星保底
            if (fourStarCounter >= 10 || random.nextDouble() < 0.1) {
                gotFourStar = true;
                fourStarCounter = 0;
            }

            // 5星概率递增
            double fiveStarBase = 0.006;
            double pityIncrement = 0.06;
            double currentFiveStarProb = fiveStarBase + pityIncrement * Math.max(0, fiveStarCounter - 73);

            if (fiveStarCounter >= 90 || random.nextDouble() < currentFiveStarProb) {
                gotFiveStar = true;
                fiveStarCounter = 0;
            }

            // 输出结果
            if (gotFiveStar) resultArea.append(totalDraws + " 抽：获得 ★★★★★ !\n");
            else if (gotFourStar) resultArea.append(totalDraws + " 抽：获得 ★★★★\n");
            else resultArea.append(totalDraws + " 抽：未出4/5星\n");

            if (gotFiveStar) {
                JOptionPane.showMessageDialog(this, "恭喜！抽到 ★★★★★ !");
                break; // 出5星后停止
            }
        }

        updateButtons();
    }

    private void updateButtons() {
        oneDrawButton.setEnabled(remainingDraws > 0);
        tenDrawButton.setEnabled(remainingDraws >= 10);
    }

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("请输入你有多少抽：");
        int draws = Integer.parseInt(input);
        new Nguyen_Than(draws);
    }
}
