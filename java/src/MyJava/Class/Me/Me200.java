package MyJava.Class.Me;

import java.util.Scanner;
//程序三大结构
// 顺序结构: (1234567890)从头开始执行，中间不能跳过，直到结束，
// 选择结构: (13579)打破限制，让代码有选择地执行，即某段条件不成立时不执行，
// 循环结构: (246 246 246)让某段代码可重复执行多次

public class Me200 {
    public static void main(String[] args) {
        //关系运算符，其用关系符链接的算式称关系表达
        System.out.println("4 > 3");                            //大于符
        System.out.println("4 >= 3");                           //大于或等于符
        System.out.println("3 == 3");                           //等于符，注等于符是(==)双等符,(=)单等符是赋值符
        System.out.println("3 < 4");                            //小于符
        System.out.println("3 <= 4");                           //小于或等于符
        System.out.println("3 != 4");                           //不等于符
    }
}
class  Me201 {
    public static void main(String[] args) {
        //关系表达是逻辑值(boolean)，即真(true)或假(false)两种而已
        boolean IfTrue = true;
        boolean IfFalse = false;
        //当条件成立即为"真"时，执行语句1，否则跳过执行下一个语句2
        if (IfTrue == true) {
            System.out.println("yes");                         //条件成立，真，执行
        } else {
            System.out.println("no");                          //条件不成立，假，未执行
        }
    }
}
class Me202 {
    public static void main(String[] args) {
        //if else天然对立，不能同时执行if和else
        //当条件成立即为if"真"时，执行语句1，否则else执行下一个语句2
        int a = 1;
        if (a < 0) {                                           //意思如果，if若成立，else不执行，if后面要小括号
            System.out.println("yes");
        } else {                                               //意思否则，else若成立，if不执行，else后面不需要小括号
            System.out.println("no");
        }
    }
}
class Me203 {
    //简单流程图符号例子
    public static void main(String[] args) {                   //椭圆/圆 (Ellipse / Circle) ＝ 起点 / 终点(S)
        Scanner input = new Scanner(System.in);                //矩形 (Rectangle) ＝ 处理 / 操作(P)
        System.out.println("Enter: ");                         //平行四边形 (Parallelogram) ＝ 输入 / 输出(IO)
        int num = input.nextInt();                             //(IO)
        //
        if (num < 5) {                                         //菱形 (Diamond) ＝ 判断 / 分支(D)
            int a = 1;                                         //(P)
            System.out.println("no");                          //(IO)
        } else if (num > 10){                                  //(D)
            System.out.println("no");                          //(IO)
        } else {                                               //(D)
            System.out.println("yes");                         //(IO)
        }
        input.close();                                         //(P)
        //箭头(Arrow) ＝ 流程线 / 顺序(→)
    }                                                          //(S)
}
class Me204 {
    public static void main(String[] args) {
        //如果阮期中考试考取成绩大于96分便会获得篮球奖励，现在他考取了98分
        Scanner input = new Scanner(System.in);
        int marks = input.nextInt();
        //
        if (marks >= 96) {
            System.out.println("Nguyen's exam marks is " + marks + ", he can take the basketball for his rewards.");
        }
    }
}
class Me205 {
    public static void main(String[] args) {
        //尝试编程一个记录小明跳绳的程序，如果达到200，输出"Jump Rope Adult",否则输出"Keep Up The Good Work"
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        //
        if (num >= 200) {
            System.out.println("Jump Rope Adult");
        } else {
            System.out.println("Keep Up The Good Work");
            //选择结构题目在测试结果时，要多方面考虑，将所有可能出现的数据结果进行测试，做到测试数据覆盖全面
        }
    }
}
class Me206{
    public static void main(String[] args) {
        //多重if
        //对学生考试分数进行评测，>= 90 excellent, >=75 good >=50 medium, >=25 passed, <25 failed
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        //
        if ( i >= 90 ) {
            System.out.println("excellent");
        } else if ( i >= 75 ) {                                //如果多个条件不成立，可套用多个else if
            System.out.println("good");                        //写多个分支结构if时数字必须从高到低或从低到高有序的写代码，否则执行结果和预期不一样
        } else if ( i >= 50 ) {
            System.out.println("medium");
        } else if ( i >= 25 ) {
            System.out.println("passed");
        } else {                                               //如果套用多个else if条件仍不成立，最后用else收尾
            System.out.println("failed");
//      } else if ( i < 25 ) {                                //多重if可以最后不用else收尾，用else if判定收尾，也不会报错
//          System.out.println("failed");
        }
    }
}
class Me207 {
    public static void main(String[] args) {
        //嵌套if
        //写一个登陆程序，指定用户名为ERIC，密码是12345，如果全正确，输出"欢迎",否则输出"用户名不正确""密码不正确"
        final String name = "ERIC";
        final String password = "12345";
        //输入提示名，用户名与密码
        System.out.println("Please enter your username");
        Scanner input = new Scanner(System.in);                //在if中嵌套多个if else，称为语句嵌套
        String NAME = input.next();
        System.out.println("Please enter your password");
        String PASSWORD = input.next();
        //嵌套if，即if里包含if和else，else里又包含if和else
        if (NAME.equals(name)) {                               //先检查用户名
            if (PASSWORD.equals(password)) {                   //再检查密码 //比较字符串时，使用.equals()进行字符比较,==则是数字比较
                System.out.println("Both correct, welcome!");
            }else {
                System.out.println("Your password is incorrect, please try again!");
            }
        } else {
            if (PASSWORD != password ) {                       //用户名错误，再检查密码，密码错输出if，反之则输出else
                System.out.println("Both incorrect, please try again!");
            } else {
                System.out.println("Your username is incorrect, please try again!");
            }
        }
    }
}
class Me208 {
    public static void main(String[] args) {
        //逻辑运算符
        System.out.println("&&");                             //逻辑与,等价and
        System.out.println("||");                             //逻辑或,等价or
        System.out.println("!");                              //逻辑非,等价not
        //

        if (3 > 1 && 1 < 3 ) {                               //逻辑与中如果表达式A与b都同时为真,整体结果都是真
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
        //
        if (3 > 1 || 1 > 3 ) {                              //逻辑或中如果表达式A与b其中一个为真,整体结果都是真
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
        if ( !(3 > 1) ) {                                  //逻辑非，取反，即取得反向的结果，原本真，取反后假
            System.out.println("yes");                     //运行优先级大于关系运算符和逻辑与和或
        } else {                                           //表达取反时建议加上括号
            System.out.println("no");
        }
    }
}
class Me209 {
    public static void main(String[] args) {
        //switch选择结构
        //根据输入数字代表周几并打印该日菜单
        System.out.println("MENU TODAY");                  //多重if既可做等值判断，又可范围判断
        Scanner input = new Scanner(System.in);            //多重switch只能等值判断，所以switch应用场景有限的
        int day = input.nextInt();                         //每个case后的值编译时必须是常量: int char String
        //
        switch (day) {                                     //相比if，switch只在表达式处需要()和{，每个case只需写常量:,后跟语句,无需额外括号
            case 1:
                System.out.println("Burger");
                break;                                     //case和default后面根据情况放break,否则case穿透(执行下一个case直)到下一个break
            case 2:                                        //如果想输入多个语句相同的值，可以switch (num) {
                System.out.println("Fried chicken");                                     //case 1:
                break;                                                                   //case 2:
            case 3:                                                                         //sout("");
                System.out.println("Nuggets");
                break;
            case 4:
                System.out.println("French fries");
                break;
            case 5:
                System.out.println("Hot dog");
                break;
            case 6:
                System.out.println("Onion rings");
                break;
            case 7 :
                System.out.println("NO OPEN TODAY :)");
                break;
            default :
                System.out.println("WTF BRO :(");
                break;
        }
    }
}