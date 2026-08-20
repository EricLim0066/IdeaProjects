import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Mines {

    static final int ROWS = 16;
    static final int COLS = 16;
    static final int MINES = 40;

    static int[][] grid = new int[ROWS][COLS];      // -1=雷, 0-8=周围雷数
    static boolean[][] revealed = new boolean[ROWS][COLS];
    static JButton[][] buttons = new JButton[ROWS][COLS];
    static JLabel statusLabel;
    static boolean gameOver = false;

    public static void main(String[] args) {
        JFrame frame = new JFrame("踩地雷");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // 顶部状态栏
        JPanel topPanel = new JPanel(new FlowLayout());
        statusLabel = new JLabel("点击格子开始！");
        JButton restartBtn = new JButton("重新开始");
        restartBtn.addActionListener(e -> restartGame());
        topPanel.add(statusLabel);
        topPanel.add(restartBtn);
        frame.add(topPanel, BorderLayout.NORTH);

        // 棋盘
        JPanel boardPanel = new JPanel(new GridLayout(ROWS, COLS, 2, 2));
        boardPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                JButton btn = new JButton();
                btn.setPreferredSize(new Dimension(36, 36));
                btn.setFont(new Font("Monospaced", Font.BOLD, 13));
                btn.setFocusPainted(false);
                btn.setBackground(new Color(220, 220, 220));

                final int row = r, col = c;
                btn.addActionListener(e -> onCellClick(row, col));

                buttons[r][c] = btn;
                boardPanel.add(btn);
            }
        }

        frame.add(boardPanel, BorderLayout.CENTER);

        initGame();

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static void initGame() {
        // 清空数组
        for (int r = 0; r < ROWS; r++)
            for (int c = 0; c < COLS; c++) {
                grid[r][c] = 0;
                revealed[r][c] = false;
            }
        gameOver = false;

        // 随机放雷
        Random rand = new Random();
        int placed = 0;
        while (placed < MINES) {
            int r = rand.nextInt(ROWS);
            int c = rand.nextInt(COLS);
            if (grid[r][c] != -1) {
                grid[r][c] = -1;
                placed++;
            }
        }

        // 计算每格周围雷数
        int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == -1) continue;
                int count = 0;
                for (int[] d : dirs) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && grid[nr][nc] == -1)
                        count++;
                }
                grid[r][c] = count;
            }
        }

        // 重置按钮外观
        for (int r = 0; r < ROWS; r++)
            for (int c = 0; c < COLS; c++) {
                buttons[r][c].setText("");
                buttons[r][c].setEnabled(true);
                buttons[r][c].setBackground(new Color(220, 220, 220));
            }

        statusLabel.setText("点击格子开始！共 " + MINES + " 颗地雷");
    }

    static void restartGame() {
        initGame();
    }

    static void onCellClick(int r, int c) {
        if (gameOver || revealed[r][c]) return;

        if (grid[r][c] == -1) {
            // 踩雷
            gameOver = true;
            revealed[r][c] = true;
            buttons[r][c].setText("✕");
            buttons[r][c].setBackground(new Color(240, 100, 100));
            revealAllMines(r, c);
            statusLabel.setText("💥 踩到地雷！游戏结束");
        } else {
            floodFill(r, c);
            checkWin();
        }
    }

    // 递归扩散翻开空格
    static void floodFill(int r, int c) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS) return;
        if (revealed[r][c] || grid[r][c] == -1) return;

        revealed[r][c] = true;
        buttons[r][c].setEnabled(false);
        buttons[r][c].setBackground(new Color(245, 245, 245));

        if (grid[r][c] > 0) {
            // 数字格：显示数字和颜色
            buttons[r][c].setText(String.valueOf(grid[r][c]));
            Color[] numColors = {
                    null,
                    new Color(25, 95, 165),   // 1 蓝
                    new Color(59, 109, 17),   // 2 绿
                    new Color(163, 45, 45),   // 3 红
                    new Color(60, 52, 137),   // 4 紫
                    new Color(133, 79, 11),   // 5 橙
                    new Color(15, 110, 86),   // 6 青
                    new Color(114, 36, 62),   // 7 粉
                    new Color(68, 68, 65),    // 8 灰
            };
            buttons[r][c].setForeground(numColors[grid[r][c]]);
        } else {
            // 空格：递归扩散
            int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
            for (int[] d : dirs)
                floodFill(r + d[0], c + d[1]);
        }
    }

    static void revealAllMines(int hitR, int hitC) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == -1 && !(r == hitR && c == hitC)) {
                    buttons[r][c].setText("★");
                    buttons[r][c].setBackground(new Color(200, 180, 180));
                    buttons[r][c].setEnabled(false);
                }
            }
        }
    }

    static void checkWin() {
        int safeTotal = ROWS * COLS - MINES;
        int safeRevealed = 0;
        for (int r = 0; r < ROWS; r++)
            for (int c = 0; c < COLS; c++)
                if (revealed[r][c] && grid[r][c] != -1)
                    safeRevealed++;

        statusLabel.setText("已翻开 " + safeRevealed + " / " + safeTotal + " 个安全格");

        if (safeRevealed == safeTotal) {
            gameOver = true;
            statusLabel.setText("🏆 恭喜！全部安全格翻开，胜利！");
        }
    }
}