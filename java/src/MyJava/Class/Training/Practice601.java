package MyJava.Class.Training;

import java.util.Scanner;

public class Practice601 {
    public static void main(String[] args) {
        //输入一个整数，输出一个n行数字三角形
        /*输入5 1
               2  3
               4  5  6
               7  8  9  10
               11 12 13 14 15
         */
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int[][] matrix = new int[10][10];
        int temp = 1;
        //
        System.out.println("Result: ");
        for (int i = 1; i <= num; i++) {                  //和普通打印三角形不一样，数组打印有两段
            for (int j = 1; j <= i; j++) {                //第一段赋值
                matrix[i][j] = temp++;                    //每循环一次，temp+1，然后赋值
            }
        }
        for (int i = 1; i <= num; i++) {                  //普通打印是边循环边输出
            for (int j = 1; j <= i; j++) {                //第二段才是输出
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
class Practice602 {
    public static void main(String[] args) {
        //已知n*n( 2 < n < 20)的方阵，把矩阵的两条对角线的元素(\/线)+10，然后输出新方阵
        /* 10 10 10 10 10
           10 10 10 10 10
           10 10 10 10 10
           10 10 10 10 10
           10 10 10 10 10
           变成
           20 10 10 10 20
           10 20 10 20 10
           10 10 20 10 10
           10 20 10 20 10
           20 10 10 10 20
         */
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int[][] matrix = new int[20][20];
        //
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                matrix[i][j] = input.nextInt();             //循环打印赋值
                //
                if (i == j || i + j == num + 1) {           //左边对标\线，右边对标/线
                    //代码执行到这里，代表ij的位置已对标对角线
                    matrix[i][j] += 10;
                }
            }
        }
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
class Practice603 {
    public static void main(String[] args) {
        //给一个5*5的矩阵，第n行和第m行进行交换，输出交换后的结果
        /*
        10 10 10 10 10
        20 20 20 20 20
        30 30 30 30 30
        40 40 40 40 40
        50 50 50 50 50
           变成
        50 50 50 50 50
        20 20 20 20 20
        30 30 30 30 30
        40 40 40 40 40
        10 10 10 10 10
         */
        Scanner input = new Scanner(System.in);
        int[][] matrix = new int[10][10];
        int a = 5;                                          //5*5矩阵，赋5
        //动态赋值
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= a; j++) {                  //循环赋值
                matrix[i][j] = input.nextInt();
            }
        }
        //第n和第m的值
        int n = input.nextInt(),m = input.nextInt();
        int temp = 0;
        for (int i = 1; i <= a; i++) {
            temp  = matrix[n][i];                           //换位
            matrix[n][i] = matrix[m][i];
            matrix[m][i] = temp;
        }
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= a; j++) {                  //循环输出
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
class Practice604 {
    public static void main(String[] args) {
        //(矩阵相加）输入两个n行n列的矩阵a和b，输出他们的和(a+b)
        /*  1 2 3     1 2 3
            1 2 3  +  4 5 6
            1 2 3     7 8 9  */
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of n (rows) and m (columns) : ");
        //
        System.out.print("n: ");
        int n = input.nextInt();                           //定义n行
        System.out.print("m: ");
        int m = input.nextInt();                           //定义m列
        //
        int[][] num = new int[10][10];                   //第一个数组
        int[][] numtwo = new int[10][10];                //第二个数组
        int[][] result = new int[10][10];                //结果数组
        //接下来会有2个矩阵，都是n行m列
        System.out.println("Enter the number of first matrix : ");
        for (int i = 1; i <= n; i++) {                    //i对应n代表行
            for (int j = 1; j <= m; j++) {                //j对应m代表列
                num[i][j] = input.nextInt();              //第一个矩阵循环赋值
            }
        }
        //
        System.out.println("Enter the number of second matrix : ");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {                  //第二个矩阵循环赋值
                numtwo[i][j] = input.nextInt();
            }
        }
        //
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {                  //结果矩阵一定也是n行m列
                result[i][j] = num[i][j] + numtwo[i][j];    //新矩阵的i行j列，等于第一矩阵的i行j列,加上第二矩阵的i行j列
            }
        }
        //执行到这里，合并完毕，准备输出
        System.out.println("The result of sum of the matrix : ");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {                  //循环输出
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
class Practice605 {
    public static void main(String[] args) {
        //矩阵旋转，输入n行m列的矩阵，将其顺时针90°后输出
        /* 1 2 3       7 4 1
           4 5 6  变成  8 5 2
           7 8 9       9 6 3 */
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();                          //n行
        int m = input.nextInt();                          //m列
        int[][] num = new int[10][10];
        //
        for (int i = 1; i <= n; i++) {                    //i对应n代表行
            for (int j = 1; j <= m; j++) {                //j对应m代表列
                num[i][j] = input.nextInt();              //n行m列赋值
            }
        }
        //顺时针90°后，n行与m列互换成m行n列，这时n从原矩阵索引最大值开始计算，需要回退
        for (int i = 1; i <= m; i++) {                    //i代替n的位置成为m
            for (int j = n; j >= 1; j--) {                //j代替m的位置成为n，需要从最大值回退，方程式(n-j+1)
                System.out.print(num[j][i] + "\t");    //因为nm行列互换了，所以变成j控制行，i控制列
            }
            System.out.println();
        }
    }
}