package PlayFun;

class user {
    public static void main(String[] args) {
        int num = 2;
        int num2 = 3;
        double e = (double)num/num2;
        System.out.println(e);
    }
}

class user2 {
    static String x = "global";

    public static void f() {
        x = "local";
        System.out.println(x);
    }
    public static void main(String[] args) {
        f();
    }
}

class user3 {
    static String x = "global";

    public static void main(String[] args) {
        x = "local";
        System.out.println(x);
    }
}