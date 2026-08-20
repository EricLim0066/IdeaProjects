package OwnProject;

public class Player {
    //build a class record player's name, amount of money and chips
    private String name;
    private int moneyBalance;
    private int chips;
    private int win;
    private int lose;
    private double winRate;
    //
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMoneyBalance() {
        return moneyBalance;
    }
    public void setMoneyBalance(int moneyBalance) {
        this.moneyBalance = moneyBalance;
    }
    public int getChips() {
        return chips;
    }
    public void setChips(int chips) {
        this.chips = chips;
    }
    public int getWin() {
        return win;
    }
    public void setWin(int win) {
        this.win = win;
    }
    public int getLose() {
        return lose;
    }
    public void setLose(int lose) {
        this.lose = lose;
    }
    public double getWinRate() {
        return winRate;
    }
    public void setWinRate(double winRate) {
        this.winRate = winRate;
    }

    public Player(String name, int moneyBalance) {
        this.name = name;
        this.moneyBalance = moneyBalance;
        this.chips = 0;
        this.win = 0;
        this.lose = 0;
        this.winRate = 0;
    }


}
