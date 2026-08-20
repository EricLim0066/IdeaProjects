import java.util.Arrays;
import java.util.Scanner;

//
public class Abu {
   public static void main(String[] args) {
        System.out.println("hi");
        int a = 1;
        int b = 2;
        int c = 3;
        int d = a;
        if (a+b == c) {
            System.out.println("yes");
        } else {
            System.out.println("nope");
        }
    }
}

//
class Abu1 {
    public static void main(String[] args) {
        System.out.println('k'+'i'+'r'+'a');
        System.out.println("k"+"i"+"r"+"a");
    }
}

//
class Abu2 {
    public static void main(String[] args) {
        int n = 6;                              //int 设整数
        for (int i = 1; i <= n; i++) {          //i++ 先用后加，++i 先加后用
            for (int j = 1; j <= i; j++) {      //for套循环，让代码重复执行
               System.out.print("哈");          //print输出不换行, println输出换行
            }
            System.out.println(" ");
        }
        //以上正左直角三角
        for (int i = n - 1; i >= 1; i--) {      //i-- 先用后减，--i 先减后用
            for (int j = 1; j <= i; j++) {
                System.out.print("哈");
            }
            System.out.println(" ");
        }
    }   //以上倒左直角三角
}

//
class Abu3 {
    public static void main(String[] args) {
        int n = 6;
        for (int i = 1; i <= n; i++) {                  //外层for控制行数
            for (int j = 1; j <= n - i; j++) {          //内层1控制星号
                System.out.print(" ");
            }
            //
            for (int k = 1; k <= 2 * i - 1; k++) {      //内层2控制左右空格
                System.out.print("*");
            }
            System.out.println();
        }
        //以上正等腰三角
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            //
            for (int k = 1; k <= 2 * i - 1; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }   //以上倒等腰三角
}

//
class Abu4 {
    public static void main(String[] args) {
        int n = 6;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            //
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        //以上正右直角三角
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            //
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }   //以上倒右直角三角
}

//
class Abu5 {
    public static void main(String[] args) {
        int r = 5;
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i || i == r + 1)
                    System.out.print("*");
                else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
        for (int i = r - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i || i == r + 1)
                    System.out.print("*");
                else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
        //
        System.out.println(" ");
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= r - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                if (k == 1 || k == 2 * i - 1 || i == r + 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");

        }
        for (int i = r - 1; i >= 1; i--) {
            for (int j = 1; j <= r - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                if (k == 1 || k == 2 * i - 1 || i == r) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
        //
        System.out.println(" ");
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= r - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                if (k == 1 || k == i || i == r + 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
        for (int i = r - 1; i >= 1; i--) {
            for (int j = 1; j <= r - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                if (k == 1 || k == i || i == r) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
}
class Abu6 {
    public static void main(String[] args) {
        int[] a = new int[5];
        Scanner input = new Scanner(System.in);
        //
        for (int i = 0; i < a.length; i++) {
            a[i] = input.nextInt();
        }
        int max = a[0];
        for (int j = 1; j < a.length; j++) {
            if (a[j] >= max) {
                max = a[j];
            }
        }
        System.out.println(max);
    }
}