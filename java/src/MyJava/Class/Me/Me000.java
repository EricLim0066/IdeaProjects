package MyJava.Class.Me;

public class Me000 {
    public static void main(String[] args) {
        //psvm 快捷键
        System.out.println("hi");
        //sout 快捷键
        System.out.println("wow");
        System.out.println("smlj");
        System.out.println();
        //println 换行
    }
}
class Me001 {
    public static void main(String[] args) {
        System.out.print("hi");
        System.out.print("wow");
        System.out.print("smlj");
        //print不换行
    }
}
class Me002 {
    public static void main(String[] args) {
        System.out.print("hi\n");                  // \n换行到下一行第一格，print + \n = println
        System.out.println("wow");
        //
        System.out.println("a\tb");                //\t换到同行后面，和同个空格一样效果
        //
        System.out.println("hi\n");                //println + \n = 额外换行 double change line
        System.out.println("Hi");
    }
}
class Me003 {
    public static void main(String[] args) {
        System.out.println("//");                  // (//)单行注释，用于解释含义，给人读的，不是给计算机读的（计算机无效运行）

        System.out.println("/* */");               /* 多行/段落注释
                                                      也是用于解释含义
                                                      给人读的，不是给计算机读的（计算机无效运行）
                                                   */
    }
}
class Me004 {
    //每页第段第一行开始，用public修饰类名，同页不同段第一行就不用public
    public static void main(String[] args) {
        //但每页每段的第二行必须用public
        System.out.println("hi"); System.out.println("wow");  System.out.println("wow");
        //一行尽量一条语句/指令，还是能运作但可读性变差
    }
}
class Me005 {
    // { 左花括号在当前外层句尾，就像两个门把外层房间内容框起来，这是入口
    public static void main(String[] args) {
        // { 左花括号在当前内层句尾，就像房间里面还有一个框起来的内容，也是入口
        System.out.println();
        // 每写完一条然后{换行，前面一定空几格，表示层级关系，写越里面，层级越深，空格越大
    }   // } 右花括号在当前内层句尾，内侧房间内容出口
}   // } 右花括号在当前外层句尾，外侧房间内容出口
