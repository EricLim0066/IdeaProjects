package MyJava.Class.ClassMe.ClassMe700;

public class Cal {
    //返回类型
    //求数字之和
    public int getsum() {                     ////int 其中返回的方法值类型
        int num1 = 1;
        int num2 = 2;
        int result = num1 + num2;
        return result;                        ////return xx 返回的真实类型(返回给main)
        //方法返回类型和return类型必须一致或兼容，(public int return int, public String return String)
    }
}
