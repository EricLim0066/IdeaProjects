package MyJava.Class.Training;

import java.util.Scanner;

public class Practice501 {
    public static void main(String[] args) {
        //将数组的第一个元素移到末尾，其余数据依次往前移
        System.out.println("Enter the total of peoples: ");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int[] score = new int[10];
        //
        System.out.println("Enter the scores: ");
        for (int i = 0; i < num; i++) {
            score[i] = input.nextInt();
        }
        int temp = score[0];                                //把要移动的数组保存到变量
        int index = 0;                                      //要移的是第一个，索引为0
        for (int j = index; j < num - 1; j++) {
            score[j] = score[j + 1];                        //要删除的地方往前移
        }
        score[score.length - 1] = temp;                     //把移动的数组赋给最后一个
        //
        for (int l = 0; l < num; l++) {
            System.out.print(score[l] + "\t");
        }
    }
}
class Practice502 {
    public static void main(String[] args) {
        //输入整数数组最大和最小的差
        System.out.println("Enter the total of numbers: ");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int[] score = new int[10];
        //
        System.out.println("Enter the scores in every index: ");
        for (int i = 0; i < num; i++) {
            score[i] = input.nextInt();
        }
        int max = score[0],min = score[0];                  //默认第一同时为最大和最小值
        for (int j = 0; j < num; j++) {
            if (score[j] > max) {                           //有大过就代替
                max = score[j];
            }
            if (score[j] < min) {                           //小过就代替
                min = score[j];
            }
        }
        System.out.println(max - min);                      //输出最大和最小差
    }
}
