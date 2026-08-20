package MyJava.Class.Me;

import java.util.Scanner;

public class Me600 {
    public static void main(String[] args) {
        //二维数组，也叫二重数组，一个数组里面包含多个数组
        int[][] matrix = new int[4][5];         //用两个中括号，左边的4是行数rows,右边的5是列数column,4*5=20有20个元素
        //每次下标还是从0开始
        matrix[0][0] = 1;
        matrix[2][3] = 17;
        //二维数组也算矩阵，本质是个table
        /*基本类型:
        * 整形: int short
        * 浮点型: double float
        * 字符型: char
        * 布尔类型: boolean
        * 引用类型: String 数组 自定义
        基本类型只有栈(stack)占空间，引用类型栈(stack)和堆(heap)占用空间 */
        int[][] Matrix = new int[][] {{10,85,92,78,54},{76,63,80},{87},{14,67}};
        //赋值方式，每个框代表每行从上到下，每行从左到右赋值
    }
}
class Me601 {
    public static void main(String[] args) {
        //输入一个正整数，输出n*n的回型方阵
        //打散成数个小方阵，先观察其中一个方阵怎么解决，然后根据对称性解决其他方阵组合回来
        /*比如n = 5
        1 1 1 1 1
        1 2 2 2 1
        1 2 3 2 1
        1 2 2 2 1
        1 1 1 1 1
         */
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int[][] matrix = new int[10][10];
        //
        for (int i = 1; i <= (num + 1)/ 2; i++) {
            for (int j = 1; j <= (num + 1)/ 2; j++) {             //三行三列
                matrix[i][j] = Math.min(i,j);                     //Math.min挑出较小值 //左上角
                matrix[i][num + 1 - j] = Math.min(i,j);                              //右上角
                matrix[num + 1 - i][j] = Math.min(i,j);                              //左下角
                matrix[num + 1 - i][num + 1 - j] = Math.min(i,j);                    //右下角
            }
        }
        for (int i = 1; i <= num; i++){
            for (int j = 1; j <= num; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
