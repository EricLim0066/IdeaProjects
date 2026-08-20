package MyJava.Class.Me;

import java.util.Arrays;
import java.util.Scanner;

public class Me500 {
    public static void main(String[] args) {
        //数组类型，指一组类型的变量，往往属性必须统一
        int num = 2;                           //int,定义单个
        int[] num2 = new int[5];               //int[],定义了数组num2，包括 num2[0], num2[1], num2[2], num2[3]...
        //变量类型不同，决定占用空间大小不同
        //下标从0开始，即上一个数组是从0开始算到4总共5，而不是1算到5，
        //
    }
}
class Me501 {
    public static void main(String[] args) {
        //数值定义与赋值方式
        int[] a = new int[6];                 //定义长度为6的数组
        //
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        //
        a[3] = 4;
        a[4] = 5;
        a[5] = 6;
        //
        for (int i = 0; i < a.length;i++) {   //.length用于获取数组长度
            System.out.println(a[i]);

        }
        //每次需要多次赋值，复制更改，麻烦，所以可以边声明边赋值
        int[] b = {70,80,90};                 //用大括号旁边赋值，长度为3，等同于b[0] = 70;b[1] = 80;b[2] = 90
        int[] c = new int[]{70,80,90};        //和上面一样，但是写法更完整
    }
}
class Me502 {
    public static void main(String[] args) {
        //动态赋值
        int[] a = new int[10];
        System.out.println(a);                //如果直接打印数组，输出的内容是数组在内存的地址，
        //想要输出数组，那就使用循环，依次输入数组的每一项
        Scanner input = new Scanner(System.in);
        //完成动态赋值操作
        for (int i = 0; i < a.length; i++) {
            a[i] = input.nextInt();            //根据for循环大于等于10，在输出台上给10个数组a赋值
        }
        //
        for (int j = 0; j < a.length; j++) {
            System.out.println(a[j]);          //另一个循环，循环打印刚才上边循环的数组
        }
    }
}
class Me503 {
    public static void main(String[] args) {
        //输入某次5位学员的其中最高分的成绩
        Scanner input = new Scanner(System.in);
        int[] exam = new int[5];
        //循环赋值
        for (int i = 0; i < exam.length; i++) {
            exam[i] = input.nextInt();
        }
        //5名同学分数已循环赋值到每个数组
        int max = exam[0];                            //默认max为数组最大值
        for (int j = 1; j < exam.length; j++) {       //第一个数组已定义给max，所以j从第二个数组开始
            if ( exam[j] > max ) {
               max = exam[j];                         //for循环，每次循环比较，出现比max更大数目的就更新，小的就不用
            }
        }
        System.out.println(max);
    }
}
class Me504 {
    public static void main(String[] args) {
        //继承上题，求最低分的成绩
        Scanner input = new Scanner(System.in);
        int[] exam = new int[5];
        //循环赋值
        for (int i = 0; i < exam.length; i++) {
            exam[i] = input.nextInt();
        }
        //5名同学分数已循环赋值到每个数组
        int min = exam[0];                            //默认min为数组最小值
        for (int j = 1; j < exam.length; j++) {       //第一个数组已定义给min，所以j从第二个数组开始
            if ( exam[j] < min ) {
                min = exam[j];                        //for循环，每次循环比较，出现比max更小数目的就更新，大的就不用
            }
        }
        System.out.println(min);
    }
}
class Me505{
    public static void main(String[] args) {
        //数组排序，在顶端添加import java.util.Arrays系统工具
        int[] num = {1,2,3,4,5};
        //sort(数组名）;
        Arrays.sort(num);                            //对数组进行顺序排序
        for (int i = 1; i <= num.length; i++) {
            System.out.println(i);
        }
    }
}
class Me506 {
    public static void main(String[] args) {
        //Tao院里有个每到秋天就会长出10个苹果的苹果树，每当苹果成熟他就会去摘，如果摘不到更高的苹果就会用30厘米高的板凳踩上去试试
        //已知10个苹果高度和Tao伸直手时最大高度，假设他碰到苹果，苹果就会掉下来，计算他能摘到的苹果
        int[] apple = new int[10];                              //定义10个数组保存10个苹果
        Scanner input = new Scanner(System.in);
        //
        System.out.println("Enter the high of the apples: ");
        for (int i = 0; i < apple.length;i++) {
            apple[i] = input.nextInt();                        //输入10个苹果的高度
        }
        //
        System.out.println("Enter the high of Tao: ");
        int tao = input.nextInt();                              //输入Tao的最大高度
        int count = 0;                                          //定义可摘到的苹果数量
        int bench = 30;                                         //定义凳子高30厘米
        //
        for (int j = 0; j < apple.length; j++) {
            if ( tao >= apple[j] ) {                            //不踩板凳够到的数量
                count++;
            } else if ( tao + bench >= apple[j] ) {             //踩板凳够到的数量
                count++;
            }
        }
        //
        System.out.println("Total of the apple he can touch: ");
        System.out.println(count);
    }
}
class Me507 {
    public static void main(String[] args) {
        //数组的插入与删除，经常需要移动后续所有元素
        //插入数组，循环找到插入点，元素往后，倒着移动，然后重新赋值
        //5个学生成绩为78，87，95，98，100，增加一个学生的成绩(89)然后依次升序
        int[] exam = new int[6];      //5个数组，多一个用于插入
        exam[0] = 78;
        exam[1] = 87;
        exam[2] = 95;
        exam[3] = 98;
        exam[4] = 100;
        //
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();                    //新学生成绩
        //定义一个变量保存新分数
        int index = exam.length - 1;                  //定义index，假设插入给最后一个数组exam[5]
        for (int i = 0; i < exam.length;i++) {        //循环找插入点
            if (num < exam[i]) {                      //如果输入的数目，大于数组里其中一个数目，把数组里的i赋给index，用于插入
                index = i;
                break;
            }
        }
       //
        for (int j = exam.length - 1; j > index; j--) {    //元素后移，所以倒着移（j--）
            exam[j] = exam[j - 1];                         //数字具象化j=5, exam[4]往后移赋值给exam[5]
        }
        //
        exam[index] = num;                                 //重新给新插入的地方赋值
        for (int k = 0; k < exam.length; k++) {            //循环输出插入后的新数值
            System.out.print(exam[k] + "\t");
        }
    }
}
class Me508{
    public static void main(String[] args) {
        //数据删除，循环找到删除点，元素往前，正着移动，覆盖原元素
        //有n个人，在水龙头前排队准备接水，现在第x个人有特殊情况需要离开，求他离开后的排队情况
        Scanner input = new Scanner(System.in);
        System.out.println("How many people queuing: ");
        int n = input.nextInt();                         //总人数
        //
        int[] a = new int[7];                            //假设这队伍只能容纳7个人
        System.out.println("List the serial number of queuing peoples: ");
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();                      //循环给你输入的总人数立个索引
        }
        //找要删除的位置
        System.out.println("Which person need to leave: ");
        int num = input.nextInt() - 1;                   //因为数组索引从0开始，编号从1开始，数据会对不上，所以-1对齐编号
        for (int j = num; j < n - 1; j++) {
            a[j] = a[j + 1];                             //数字具象化j=5, exam[6]往前移赋值给exam[5]
        }
        n--;                                             //队伍已经少一个人·，要记得减掉空的数组
        for (int k = 0; k < n; k++) {
            System.out.println(a[k] + "\t");             //循环打印现队伍的排队编号
        }
    }
}
class Me509 {
    public static void main(String[] args) {
        //顺序查找，按照顺序或逆序，将数组中的元素与要查的数num进行比较
        //输入一个数字num，表示学生总数，再输入num表示学生成绩，查找90分的同学为多少人
        Scanner input = new Scanner(System.in);
        System.out.println("Amount of students: ");
        int num = input.nextInt();
        int [] score = new int[5];                     //假设只有5位学生
        //
        System.out.println("Score of students: ");
        for (int i = 0; i < num; i++) {
            score[i] = input.nextInt();                //循环输入分数
        }
        //查找时，一个一个对比
        int count = 0;
        for (int j = 0; j < num ;j++) {
            if (score[j] == 90) {                      //一个个判定是不是90分
                count++;
            }
        }
        System.out.println("Total of students who get 90 marks");
        System.out.println(count);
    }
}
class Me510 {
    public static void main(String[] args) {
        //二分查找，每次砍半范围，优点次数少，查找速度块，缺点要求数据排序为递增或递减
        //Vincent心里想从1~100的数字，Mark来猜，Vincent根据Mark猜测的数字提示"猜大了"，"猜小了","猜对了"
        System.out.println("Guess a number: between 1 and 100: ");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        //动态调整边界
        int left = 1, right = 100;                                 //设置左右边界
        while (left <= right) {
            int medium = ((left+right)/2);                         //计算中间位置，每次缩小范围时，添加中间线
            if (num == medium) {                                   //如果一次猜中
                System.out.println(medium + " correct !");
                break;
            }
            //上段如果medium已经被排除，下半部分就不需要再猜medium了
            //动态调整边界
            if (num < medium) {                                    //如果计算机猜大了
                right = medium-1;                                  //中间值-1，范围变成1~49
                System.out.println(medium + " too big");
            }
            if (num > medium) {                                    //如果计算机猜小了
                left = medium+1;                                   //中间值+1，范围变成51~100
                System.out.println(medium + " too small");
            }
            //二分查找，数组必须有序
        }
    }
}
class Me511 {
    public static void main(String[] args) {
        //冒泡排序算法，比较和交换
        //底层就是二重循环
        //将数组126，80，98，158，204，进行降序排序
        int[] num = new int[]{126,80,98,158,204};
        //每趟从1递增，比较次数从4递减，所以 i + j = 5, 故得 j = 5 - i
        for (int i = 0; i <= num.length - 1 ; i++) {                //外层控制趟数，5个数字走4趟，length-1（趟）
            for (int j = 0; j <= num.length - 1 - i; j++) {         //内层控制循环次数，length-1对其索引，-i因为每趟循环尾部元素已排好，不需要比较
                //
                if (num[j] < num[j+1]) {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j+1] = temp;
                }
            }
        }
        for (int k = 0; k < num.length;k++) {
            System.out.print(num[k] + "\t");
        }
    }
}

