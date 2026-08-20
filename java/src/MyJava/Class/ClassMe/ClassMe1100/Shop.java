package MyJava.Class.ClassMe.ClassMe1100;

public class Shop {
    //定义一家蛋糕店
    ///类的名称尽可能遵循帕斯卡命名法，即所有有意义字词的首字母大写
    //根据客户需求生产出不同尺寸和口味的蛋糕，需要返回不同的蛋糕类型
    public Cake makeCake(String type) {                            //生产蛋糕的方法，定义生产的类型
        Cake cake;                                                 //定义父类
        if (type.equals("Mousse")) {                               //如果接收进来的参数是“慕斯”
            cake = new MousseCake();                               // 父类引用cake指向慕斯蛋糕对象
        } else if (type.equals("Puffs")) {
            cake = new PuffsCake();
        } else {
            cake = new FruitCake();
        }
        return cake;
    }
}
