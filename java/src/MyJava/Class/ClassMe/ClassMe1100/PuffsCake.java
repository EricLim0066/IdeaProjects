package MyJava.Class.ClassMe.ClassMe1100;

public class PuffsCake extends Cake{
    //定义第二个子类型，泡芙蛋糕类型
    @Override
    public void getCake(String type, int size) {                          //重写蛋糕方法，并输入类型，尺寸等参数
        System.out.println(size + "-inch with "  + type + " flavour");    //输出蛋糕尺寸和口味类型
    }
}