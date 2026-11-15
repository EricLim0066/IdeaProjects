package GamblingBall.src;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 * 赌球小游戏 — Java Swing 实现
 *
 * 流程：输入金额 → 兑换筹码 → 下注猜大小(0~4小, 5~9大) → 继续或离开
 */
public class GamblingBallGame extends JFrame {

    private static final String PANEL_MONEY = "money";
    private static final String PANEL_EXCHANGE = "exchange";
    private static final String PANEL_BETTING = "betting";
    private static final String PANEL_SUMMARY = "summary";

    private static final DecimalFormat MONEY_FMT = new DecimalFormat("#,##0.##");

    private final GameState state = new GameState();
    private final CardLayout cardLayout = new CardLayout();
    private final JPanel mainPanel = new JPanel(cardLayout);

    // 金额输入
    private JTextField moneyInputField;

    // 兑换筹码
    private JLabel cashLabel;
    private JLabel chipsLabel;
    private JTextField exchangeInputField;

    // 赌球
    private JLabel bettingChipsLabel;
    private JLabel bettingStatsLabel;
    private JTextField betInputField;
    private JLabel resultLabel;
    private JPanel numberButtonPanel;
    private JPanel afterRoundPanel;

    // 结算
    private JLabel summaryLabel;

    public GamblingBallGame() {
        super("赌球");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(520, 480));
        setLocationRelativeTo(null);

        mainPanel.setBorder(new EmptyBorder(16, 16, 16, 16));
        mainPanel.add(createMoneyPanel(), PANEL_MONEY);
        mainPanel.add(createExchangePanel(), PANEL_EXCHANGE);
        mainPanel.add(createBettingPanel(), PANEL_BETTING);
        mainPanel.add(createSummaryPanel(), PANEL_SUMMARY);

        add(mainPanel, BorderLayout.CENTER);
        showPanel(PANEL_MONEY);
    }

    private void showPanel(String name) {
        cardLayout.show(mainPanel, name);
    }

    private static JLabel titleLabel(String text) {
        JLabel label = new JLabel(text, JLabel.CENTER);
        label.setFont(label.getFont().deriveFont(Font.BOLD, 22f));
        label.setBorder(new EmptyBorder(0, 0, 12, 0));
        return label;
    }

    private static JLabel hintLabel(String text) {
        JLabel label = new JLabel("<html><center>" + text + "</center></html>", JLabel.CENTER);
        label.setForeground(new Color(80, 80, 80));
        return label;
    }

    private static String formatMoney(double amount) {
        return MONEY_FMT.format(amount);
    }

    // ── 1. 输入金额 ──────────────────────────────────────────

    private JPanel createMoneyPanel() {
        JPanel panel = new JPanel(new BorderLayout(0, 12));

        panel.add(titleLabel("欢迎来到赌球"), BorderLayout.NORTH);
        panel.add(hintLabel("请输入你拥有的金额（元）"), BorderLayout.CENTER);

        JPanel center = new JPanel(new GridLayout(2, 1, 0, 8));
        moneyInputField = new JTextField();
        moneyInputField.setFont(moneyInputField.getFont().deriveFont(18f));
        center.add(moneyInputField);

        JButton nextBtn = new JButton("下一步：兑换筹码");
        nextBtn.setFont(nextBtn.getFont().deriveFont(Font.BOLD, 16f));
        nextBtn.addActionListener(e -> onMoneyConfirmed());
        center.add(nextBtn);

        panel.add(center, BorderLayout.SOUTH);
        return panel;
    }

    private void onMoneyConfirmed() {
        try {
            double amount = Double.parseDouble(moneyInputField.getText().trim());
            if (amount <= 0) {
                JOptionPane.showMessageDialog(this, "金额必须大于 0。", "输入错误", JOptionPane.WARNING_MESSAGE);
                return;
            }
            state.setCash(amount);
            state.setChips(0);
            state.setLastBet(0);
            refreshExchangePanel();
            showPanel(PANEL_EXCHANGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "请输入有效的数字金额。", "输入错误", JOptionPane.WARNING_MESSAGE);
        }
    }

    // ── 2. 兑换筹码 ──────────────────────────────────────────

    private JPanel createExchangePanel() {
        JPanel panel = new JPanel(new BorderLayout(0, 12));
        panel.add(titleLabel("兑换筹码"), BorderLayout.NORTH);

        JPanel info = new JPanel(new GridLayout(2, 1, 0, 6));
        cashLabel = new JLabel();
        chipsLabel = new JLabel();
        cashLabel.setFont(cashLabel.getFont().deriveFont(16f));
        chipsLabel.setFont(chipsLabel.getFont().deriveFont(16f));
        info.add(cashLabel);
        info.add(chipsLabel);
        panel.add(info, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new GridLayout(3, 1, 0, 8));
        bottom.add(hintLabel("输入要兑换的筹码数量（1 元 = 1 筹码）"));
        exchangeInputField = new JTextField();
        exchangeInputField.setFont(exchangeInputField.getFont().deriveFont(18f));
        bottom.add(exchangeInputField);

        JPanel btnRow = new JPanel(new GridLayout(1, 2, 8, 0));
        JButton exchangeBtn = new JButton("兑换");
        exchangeBtn.addActionListener(e -> onExchange());
        JButton startBtn = new JButton("开始赌球");
        startBtn.setFont(startBtn.getFont().deriveFont(Font.BOLD, 16f));
        startBtn.addActionListener(e -> onStartBetting());
        btnRow.add(exchangeBtn);
        btnRow.add(startBtn);
        bottom.add(btnRow);

        panel.add(bottom, BorderLayout.SOUTH);
        return panel;
    }

    private void refreshExchangePanel() {
        cashLabel.setText("当前现金：" + formatMoney(state.getCash()) + " 元");
        chipsLabel.setText("现有筹码：" + formatMoney(state.getChips()) + " 筹码");
    }

    private void onExchange() {
        try {
            double amount = Double.parseDouble(exchangeInputField.getText().trim());
            if (amount <= 0) {
                JOptionPane.showMessageDialog(this, "兑换数量必须大于 0。", "输入错误", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (amount > state.getCash()) {
                JOptionPane.showMessageDialog(this, "现金不足，无法兑换。", "兑换失败", JOptionPane.WARNING_MESSAGE);
                return;
            }
            state.setCash(state.getCash() - amount);
            state.setChips(state.getChips() + amount);
            exchangeInputField.setText("");
            refreshExchangePanel();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "请输入有效的数字。", "输入错误", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void onStartBetting() {
        if (state.getChips() <= 0) {
            JOptionPane.showMessageDialog(this, "请先兑换筹码再开始赌球。", "提示", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        resetBettingRound();
        refreshBettingPanel();
        showPanel(PANEL_BETTING);
    }

    // ── 3. 赌球界面 ──────────────────────────────────────────

    private JPanel createBettingPanel() {
        JPanel panel = new JPanel(new BorderLayout(0, 10));
        panel.add(titleLabel("赌球"), BorderLayout.NORTH);

        bettingStatsLabel = new JLabel(" ", JLabel.CENTER);
        bettingStatsLabel.setFont(bettingStatsLabel.getFont().deriveFont(14f));
        panel.add(bettingStatsLabel, BorderLayout.CENTER);

        JPanel south = new JPanel(new GridLayout(4, 1, 0, 10));

        bettingChipsLabel = new JLabel();
        bettingChipsLabel.setFont(bettingChipsLabel.getFont().deriveFont(16f));
        south.add(bettingChipsLabel);

        JPanel betRow = new JPanel(new BorderLayout(8, 0));
        betRow.add(new JLabel("本局赌注："), BorderLayout.WEST);
        betInputField = new JTextField();
        betInputField.setFont(betInputField.getFont().deriveFont(18f));
        betRow.add(betInputField, BorderLayout.CENTER);
        south.add(betRow);

        south.add(hintLabel("选择 0~4 为「小」，5~9 为「大」。猜中范围赢，猜中数字翻三倍！"));

        numberButtonPanel = new JPanel(new GridLayout(2, 5, 8, 8));
        for (int i = 0; i <= 9; i++) {
            final int num = i;
            JButton btn = new JButton(String.valueOf(i));
            btn.setFont(btn.getFont().deriveFont(Font.BOLD, 20f));
            String side = GameState.categoryName(i);
            btn.setToolTipText(num + " 属于「" + side + "」");
            btn.addActionListener(e -> onNumberPicked(num));
            numberButtonPanel.add(btn);
        }
        south.add(numberButtonPanel);

        resultLabel = new JLabel(" ", JLabel.CENTER);
        resultLabel.setFont(resultLabel.getFont().deriveFont(Font.BOLD, 16f));
        south.add(resultLabel);

        afterRoundPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 0));
        afterRoundPanel.setVisible(false);
        JButton continueBtn = new JButton("继续玩");
        continueBtn.addActionListener(e -> onContinuePlaying());
        JButton leaveBtn = new JButton("离开");
        leaveBtn.addActionListener(e -> onLeaveGame());
        afterRoundPanel.add(continueBtn);
        afterRoundPanel.add(leaveBtn);
        south.add(afterRoundPanel);

        panel.add(south, BorderLayout.SOUTH);
        return panel;
    }

    private void refreshBettingPanel() {
        bettingChipsLabel.setText("可用筹码：" + formatMoney(state.getChips()) + " 筹码");
        int total = state.getTotalRounds();
        if (total == 0) {
            bettingStatsLabel.setText("尚未开始赌局");
        } else {
            bettingStatsLabel.setText(String.format(
                    "已玩 %d 局 | 胜 %d | 负 %d | 胜率 %.1f%%",
                    total, state.getWins(), state.getLosses(), state.getWinRate()));
        }
    }

    private void resetBettingRound() {
        betInputField.setText("");
        betInputField.setEnabled(true);
        resultLabel.setText(" ");
        afterRoundPanel.setVisible(false);
        setNumberButtonsEnabled(true);
    }

    private void setNumberButtonsEnabled(boolean enabled) {
        for (var comp : numberButtonPanel.getComponents()) {
            comp.setEnabled(enabled);
        }
    }

    private void onNumberPicked(int playerPick) {
        double bet;
        try {
            bet = Double.parseDouble(betInputField.getText().trim());
            if (bet <= 0) {
                JOptionPane.showMessageDialog(this, "赌注必须大于 0。", "输入错误", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (bet > state.getChips()) {
                JOptionPane.showMessageDialog(this, "筹码不足，请减少赌注或先兑换更多筹码。", "筹码不足", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "请先输入有效的赌注金额。", "输入错误", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int systemNumber = (int) (Math.random() * 10);
        int outcome = GameState.evaluateRound(playerPick, systemNumber);

        state.setLastBet(bet);
        betInputField.setEnabled(false);
        setNumberButtonsEnabled(false);

        String playerSide = GameState.categoryName(playerPick);
        String systemSide = GameState.categoryName(systemNumber);

        if (outcome == 0) {
            state.setChips(state.getChips() - bet);
            state.recordLoss();
            resultLabel.setForeground(new Color(180, 0, 0));
            resultLabel.setText(String.format(
                    "你选了 %d（%s），系统开出 %d（%s）— 范围不同，输了！扣除 %s 筹码",
                    playerPick, playerSide, systemNumber, systemSide, formatMoney(bet)));
        } else if (outcome == 1) {
            state.setChips(state.getChips() + bet);
            state.recordWin();
            resultLabel.setForeground(new Color(0, 120, 0));
            resultLabel.setText(String.format(
                    "你选了 %d（%s），系统开出 %d（%s）— 同范围，赢了！赌注翻倍 +%s 筹码",
                    playerPick, playerSide, systemNumber, systemSide, formatMoney(bet)));
        } else {
            state.setChips(state.getChips() + bet * 2);
            state.recordWin();
            resultLabel.setForeground(new Color(0, 90, 180));
            resultLabel.setText(String.format(
                    "你选了 %d，系统也开出 %d — 猜中数字！赌注翻三倍 +%s 筹码",
                    playerPick, systemNumber, formatMoney(bet * 2)));
        }

        refreshBettingPanel();
        bettingChipsLabel.setText("可用筹码：" + formatMoney(state.getChips()) + " 筹码");
        afterRoundPanel.setVisible(true);

        if (state.getChips() <= 0) {
            JOptionPane.showMessageDialog(this,
                    "筹码已用完，请离开查看结算，或返回兑换界面补充筹码。",
                    "筹码耗尽", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void onContinuePlaying() {
        if (state.getChips() <= 0) {
            int choice = JOptionPane.showConfirmDialog(this,
                    "没有筹码了，是否前往兑换界面？",
                    "筹码不足", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                refreshExchangePanel();
                showPanel(PANEL_EXCHANGE);
            }
            return;
        }
        resetBettingRound();
        refreshBettingPanel();
    }

    private void onLeaveGame() {
        refreshSummaryPanel();
        showPanel(PANEL_SUMMARY);
    }

    // ── 4. 结算界面 ──────────────────────────────────────────

    private JPanel createSummaryPanel() {
        JPanel panel = new JPanel(new BorderLayout(0, 12));
        panel.add(titleLabel("游戏结算"), BorderLayout.NORTH);

        summaryLabel = new JLabel(" ", JLabel.CENTER);
        summaryLabel.setFont(summaryLabel.getFont().deriveFont(16f));
        summaryLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                new EmptyBorder(16, 16, 16, 16)));
        panel.add(summaryLabel, BorderLayout.CENTER);

        JButton restartBtn = new JButton("重新开始");
        restartBtn.setFont(restartBtn.getFont().deriveFont(Font.BOLD, 16f));
        restartBtn.addActionListener(e -> onRestart());
        panel.add(restartBtn, BorderLayout.SOUTH);
        return panel;
    }

    private void refreshSummaryPanel() {
        int total = state.getTotalRounds();
        summaryLabel.setText(String.format(
                "<html><center>"
                        + "<p><b>当前现金：</b>%s 元</p>"
                        + "<p><b>现有筹码：</b>%s 筹码</p>"
                        + "<p><b>上一局赌注：</b>%s 筹码</p>"
                        + "<hr>"
                        + "<p><b>总局数：</b>%d</p>"
                        + "<p><b>胜利：</b>%d 次 &nbsp;|&nbsp; <b>失败：</b>%d 次</p>"
                        + "<p><b>胜率：</b>%.1f%%</p>"
                        + "<p><b>总资产（现金+筹码）：</b>%s 元</p>"
                        + "</center></html>",
                formatMoney(state.getCash()),
                formatMoney(state.getChips()),
                state.getLastBet() > 0 ? formatMoney(state.getLastBet()) : "无",
                total,
                state.getWins(),
                state.getLosses(),
                state.getWinRate(),
                formatMoney(state.getCash() + state.getChips())));
    }

    private void onRestart() {
        state.setCash(0);
        state.setChips(0);
        state.setLastBet(0);
        moneyInputField.setText("");
        exchangeInputField.setText("");
        showPanel(PANEL_MONEY);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GamblingBallGame game = new GamblingBallGame();
            game.pack();
            game.setVisible(true);
        });
    }
}
