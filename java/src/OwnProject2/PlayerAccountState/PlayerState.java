package OwnProject2.PlayerAccountState;

public class PlayerState {

    private int amount;
    private int stake;
    private int bet;
    private int win;
    private int lose;

    // money -> amount (money)
    // 1 dollar -> 100 cents
    public void addMoney(int money) {
        if (money > 0) {
            this.amount += money * 100;
        }
    }

    // 10 cents to 1 stake
    private void stakeExchange(int moneyExchange) {
        this.amount -= moneyExchange * 100;
        this.stake += moneyExchange * 10;
    }

    // 1 stake to 10 cents
    private void stakeOut(int stakeWithdraw) {
        this.stake -= stakeWithdraw;
        this.amount += stakeWithdraw * 10;
    }

    // 1 set to 1 cent
    private void changeBet(int bet) {
        this.stake -= bet;
        this.bet += bet;
    }

    private boolean judgeExchangeAndMoneyOut(int currentAmount, int resources) {
        return currentAmount >= resources && resources > 0;
    }

    // max bet or min bet to can play
    private boolean MinMaxExchangeBets (int current, int maxExchange, int minExchange) {
        return current < maxExchange && current > minExchange;
    }

    // amount -> stake (money)
    public boolean verifyExchange(int moneyExchange) {
        if (judgeExchangeAndMoneyOut(this.amount,moneyExchange * 100)) {
            stakeExchange(moneyExchange);
            return true;
        }
        return false;
    }

    // stake -> amount (stake)
    public boolean verifyWithdraw(int stakeOut) {
        if (judgeExchangeAndMoneyOut(this.stake, stakeOut)) {
            stakeOut(stakeOut);
            return true;
        }
        return false;
    }

    // stake -> bet (stake)
    public boolean verifyPlaceBet (int bet) {
        if (judgeExchangeAndMoneyOut(this.stake, bet)) {
            changeBet(bet);
            return true;
        }
        return false;
    }

    public void clearBet (int payOut) {
        this.bet = 0;
        this.stake = payOut;
    }

    public void recordWin() {
        this.win++;
    }

    public void recordLose() {
        this.lose++;
    }

    public boolean isBroke() {
        return this.amount < 100 && this.stake <= 0 && this.bet <= 0;
    }

    public int getCentAmount() {
        return this.amount;
    }

    public double getDollarAmount() {
        return this.amount / 100.0;
    }

    public int getStake() {
        return this.stake;
    }

    public int getBet() {
        return this.bet;
    }

    public int getWin() {
        return this.win;
    }

    public int getLose() {
        return this.lose;
    }

    public int getRounds() {
        return this.win + this.lose;
    }

    public double getWinRate() {
        int rounds = getRounds();
        return rounds == 0 ? 0 : (double) this.win / rounds;
    }

    public PlayerState(int money) {
        this.amount = Math.max(0, money) * 100;
        this.stake = 0;
        this.bet = 0;
        this.win = 0;
        this.lose = 0;
    }
}
