package GamblingBall.src;

/**
 * 赌球游戏状态管理
 */
public class GameState {

    private double cash;
    private double chips;
    private double lastBet;
    private int wins;
    private int losses;

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getChips() {
        return chips;
    }

    public void setChips(double chips) {
        this.chips = chips;
    }

    public double getLastBet() {
        return lastBet;
    }

    public void setLastBet(double lastBet) {
        this.lastBet = lastBet;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getTotalRounds() {
        return wins + losses;
    }

    public double getWinRate() {
        int total = getTotalRounds();
        if (total == 0) {
            return 0;
        }
        return (double) wins / total * 100;
    }

    public void recordWin() {
        wins++;
    }

    public void recordLoss() {
        losses++;
    }

    /** 0~4 为小，5~9 为大 */
    public static boolean isSmall(int number) {
        return number >= 0 && number <= 4;
    }

    public static String categoryName(int number) {
        return isSmall(number) ? "小" : "大";
    }

    /**
     * 判定胜负
     *
     * @return 0=输, 1=赢(翻倍), 2=猜中(翻三倍)
     */
    public static int evaluateRound(int playerPick, int systemNumber) {
        boolean sameCategory = isSmall(playerPick) == isSmall(systemNumber);
        if (!sameCategory) {
            return 0;
        }
        if (playerPick == systemNumber) {
            return 2;
        }
        return 1;
    }
}
