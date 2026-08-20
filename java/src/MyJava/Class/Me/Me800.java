package MyJava.Class.Me;

import MyJava.Class.ClassMe.ClassMe800.*;

import java.util.Scanner;

public class Me800 {
    public static void main(String[] args) {
        //带参数的方法
        //移步(ClassMe800/Dog.java)
        ////<访问修饰符> 返回类型 <方法名> (类型 参数列表) 即public void xx() {}
        ////方法主体({}里面的内容)
        Dog dog = new Dog();
        dog.name = "Chop";
        dog.eat("meat");                     //对象实参
    }
}
class Me801 {
    public static void main(String[] args) {
        //带2个参数
        //移步(ClassMe800/Calc.java)
        Calc calc = new Calc();
        int num1 = 1,num2 = 3;
        int result = calc.add(num1,num2);          //两个参数//对象函数调用
        System.out.println(result);
        ////函数定义和函数调用的名称可以不一样，但参数个数，类型和顺序必须保持一致
        ////如果多个包有同名类，导入时多留意
    }
}
class Me802 {
    public static void main(String[] args) {
        //带3个参数
        //移步(ClassMe800/Cal.java)
        Cal cal = new Cal();
        //
        Scanner input =new Scanner(System.in);     //输入号码
        System.out.println("Enter number");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        //
        System.out.println("Enter symbol");
        char oper = input.next().charAt(0);        //输入第一个位置的符号
        //
        int result = cal.CalData(num1,num2,oper);  //三个参数 //确保顺序，类型正确
        if (result == -1) {
            System.out.println("Divisor cannot be 0, please try again");
        } else if (result == -2){
            System.out.println("Symbol error");
        } else {                                   //如果都正确，输出结果
            System.out.println(result);
        }
    }
}
class Me803 {
    public static void main(String[] args) {
        //数组作为参数
        //有5位学员去参加比赛，实例化输出比赛的平均成绩和最高成绩
        //移步(ClassMe800/Score.java)
        Score scores = new Score();
        int[] score = new int[5];                      //数组长度在对象main函数定义
        //
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the scores of participants");
        for (int i = 0; i < score.length; i++) {       //构造循环赋值
            score[i] = input.nextInt();
        }
        //
        double avescore = scores.GetAveScore(score);   //Alt+Enter快速
        int max = scores.GetMaxScore(score);
        //
        System.out.println(avescore);
        System.out.println(max);
    }
}
class Me804{
    public static void main(String[] args) {
        //数组作为参数
        //创建一个movie类，有电影名称，导演，演员三个属性，写一个打印所有属性信息的方法，但是要有2个电影阵容
        //移步(ClassMe800/Movie.java)
        Movie movie = new Movie();                     //创建对象
        movie.name = "Summer In Closed Eyes";
        movie.director = "Mr.Siro";
        String[] actors = new String[5];
        actors[0] = "Takafumi";
        actors[1] = "Jack";
        actors[2] = "Tanako";
        actors[3] = "Franklin";
        actors[4] = "Anh Mai";
        movie.InitActors(actors);                      //初始化演员到方法
        movie.show();
        //
        System.out.println("========================================");
        //
        Movie movie2 = new Movie();                    //创建对象
        movie2.name = "Our Story";
        movie2.director = "Doen";
        String[] actors2 = new String[5];
        actors2[0] = "Torean";
        actors2[1] = "Punk Lee";
        actors2[2] = "Ito Mayuki";
        actors2[3] = "Frank";
        actors2[4] = "Lord";
        movie2.InitActors(actors2);                      //初始化演员方法
        movie2.show();
    }
}
class Me805 {
    public static void menu() {
        System.out.println("Welcome to library !");
        System.out.println("1. Check the book list");                 //检查图书列表
        System.out.println("2. Add your book to the list");           //添加图书
        System.out.println("Please enter what you choose, can just press number");
    }
    public static void main(String[] args) {
        //对象作为参数
        //制作一个显示所有图书列表和添加图书功能系统，让用户可以更加方便添加和查看图书
        //移步(ClassMe800/Book.java)和(ClassMe800.BookManager.java)
        BookManager manager = new BookManager();
        manager.InitBooks();                                          //从BookManager类调度
        menu();                                                       //如果希望再次调度菜单，添加menu方法
        //
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        while (num != 0) {                                               //如果希望选完后再次跳出菜单，用while循环
            if (num == 1) {                                              //判定是不是输入1或2,并且导入到该去的地方
                manager.BookList();
                menu();
                num = input.nextInt();
            } else if (num == 2) {
                System.out.println("Here is the book addition interface");
                Book books = new Book();
                System.out.println("Please enter the book name");
                input.nextLine();                                        //清除nextInt()输入后残留的回车，否则后面的nextLine()会直接读取空字符串
                books.bookname = input.nextLine();
                System.out.println("Please enter the author's name");
                books.bookauthor = input.nextLine();
                System.out.println("Please enter the price");
                books.bookprice = input.nextInt();
                boolean flag = manager.AddBook(books);
                if (flag = true) {
                    System.out.println("Added successfully ! ");
                }
                menu();
                num = input.nextInt();
            } else if (num == 0) {
                break;
            }
        }
        System.out.println("Thanks for visiting,see you next time !");
    }
}
class Me806{
    //定义一个方法计算阶乘
    public static int func(int num) {                  //返回当前方法时，使用本层num参数，返回给上层的func参数
        if (num == 1) {                                //当num等于1时，1! = 1，直接返回1，替换func(1)原来的位置，不再继续调用
            return 1;
        } else {                                       //递归调用，当前数乘以下一个更小的数，往里递调用自己，拿到结果再层层回退
            //每一层的num都是自己的参数，而不是上一层的num
            return num*func(num - 1);            //回退阶乘时，回退的是本层参数里的num,而不是return旁边的num
        }
    }
    public static void main(String[] args) {
        ////递归方法，方法调用自己，其称为"递归"调用，其方法称为"递归方法"
        ////递归思想本质，一层一层往里深入“套娃”，直到找到结束条件，然后再一层一层退出来
        //求n阶乘的值，n! = 1*2*2*3....*(n-1)*n
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        System.out.println(func(num));

    }
}