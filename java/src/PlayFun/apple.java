package PlayFun;

class apple {
    public static void main(String[] args) {
        //1 apple is RM2
        final int apple = 2;
        //if customer buy 5 apples
        int customerBought = 5;
        //calculate how much customer need to pay
        int money = apple * customerBought;
        //output result
        System.out.println("RM" + money);
    }
}

class apple2 {
    private boolean angry;

    public boolean getAngry() {
        return angry;
    }

    public void setAngry(boolean angry) {
        this.angry = angry;
    }

    public apple2 (String personality) {
        this.angry = false;
    }
}
