package OwnProject;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Donut extends JPanel {

    static final int WIDTH  = 80;
    static final int HEIGHT = 22;
    static final int SCREEN = WIDTH * HEIGHT;
    static final String SHADING = ".,-~:;=!*#$@";

    static final int FONT_SIZE = 18;

    private double A = 0, B = 0;
    private final double[] zBuf = new double[SCREEN];
    private final char[]  cBuf = new char[SCREEN];

    private final int[] nBuf = new int[SCREEN];

    private Clip clip;

    public void playAudio() {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("C:\\Users\\jingx\\work\\Funkytown.wav"));
            clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException exception) {
            exception.printStackTrace();
        }
    }

    public void stopAudio() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public Donut() {
        setBackground(Color.BLACK);
        playAudio();

        new Timer(30, e -> {
            if (clip != null && !clip.isRunning()) {
                ((Timer) e.getSource()).stop();
                System.exit(0);
                return;
            }
            update();
            repaint();
        }).start();
    }

    private void update() {

        for (int k = 0; k < SCREEN; k++) {
            cBuf[k] = ' ';
            zBuf[k] = 0f;
            nBuf[k] = 0;
        }

        double sinA = Math.sin(A), cosA = Math.cos(A);
        double sinB = Math.sin(B), cosB = Math.cos(B);

        for (double j = 0; j < 6.28; j += 0.07) {
            double sinJ = Math.sin(j);
            double cosJ = Math.cos(j);

            for (double i = 0; i < 6.28; i += 0.02) {
                double sinI = Math.sin(i);
                double cosI = Math.cos(i);

                double h = cosJ + 2;
                double D = 1 / (sinI * h * sinA + sinJ * cosA + 5);
                double t = sinI * h * cosA - sinJ * sinA;

                int x = (int) ((double) WIDTH / 2 + 30 * D * (cosI * h * cosB - t * sinB));
                int y = (int) ((double) HEIGHT / 2 + 15 * D * (cosI * h * sinB + t * cosB));
                int o = x + WIDTH * y;

                int N = (int) (8 * ((sinJ * sinA - sinI * cosJ * cosA) * cosB
                        - sinI * cosJ * sinA
                        - sinJ * cosA
                        - cosI * cosJ * sinB));

                if (y > 0 && y < HEIGHT && x > 0 && x < WIDTH && D > zBuf[o]) {
                    zBuf[o] = D;
                    nBuf[o] = Math.max(N, 0);
                    cBuf[o] = SHADING.charAt(nBuf[o]);
                }
            }
        }

        A += 0.04;
        B += 0.02;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g2.setFont(new Font("Monospaced", Font.BOLD, FONT_SIZE));
        FontMetrics fm = g2.getFontMetrics();
        int charW = fm.charWidth('@');
        int charH = fm.getHeight();

        for (int k = 0; k < SCREEN; k++) {
            if (cBuf[k] == ' ') continue;

            int col = k % WIDTH;
            int row = k / WIDTH;

            int brightness = nBuf[k]; // 0-11
            Color color = getColor(brightness);
            g2.setColor(color);

            g2.drawString(
                    String.valueOf(cBuf[k]),
                    col * charW,
                    (row + 1) * charH
            );
        }
    }

    private Color getColor(int n) {
        double ratio = (double) n / 11;
        int r = (int) (80  + 175 * ratio);
        int g = (int) (20  + 200 * ratio);
        int b = (int) (0   + 180 * ratio);
        return new Color(
                Math.min(r, 255),
                Math.min(g, 255),
                Math.min(b, 255)
        );
    }

    @Override
    public Dimension getPreferredSize() {

        FontMetrics fm = getFontMetrics(new Font("Monospaced", Font.BOLD, FONT_SIZE));
        return new Dimension(fm.charWidth('@') * WIDTH, fm.getHeight() * (HEIGHT + 1));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Donut");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);

            Donut panel = new Donut();
            frame.add(panel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}