package MyJava.Class.ClassMe.ClassMe800;

public class Account {
    //定义银行类
    double money;                               //定义账号金额
    public double getMoney() {
        return money;
    }
    public void check() {
        //查询金额
        System.out.println("Your current amount is " + money);
    }
    public void save(double num) {              //存钱
        money += num;
        System.out.println("Saving successful !");
        System.out.println("Your current amount is " + money);
    }
    public void get (double num) {             //取钱
        if (money >= num) {                    //判定取的钱是否超过你的金额
            money -=num;
            System.out.println("withdraw successful !");
            System.out.println("Your current amount is " + money);
        } else {
            System.out.println("Sorry your amount is insufficient, please try again");
            System.out.println("Your current amount is " + money);
        }

    }
}
