package MyJava.Class.ClassMe.ClassMe1100;

public class OldMan {
    //定义吹糖人
    //开参数，根据客户要求接收字符串指令
    public Animal BlowSugar(String type) {                          //返回父类，如果写具体子类动物名称需要额外开方法返回
        Animal animal;                                              //定义父类变量
        if (type.equals("dog")){                                    //判定接收的对象是否和输出的相同
            animal = new LittleDog();                               //如果相同,创建对象，将其赋给父类变量animal
        } else if (type.equals("cat")){
            animal = new LittleCat();
        } else {
            animal = new LittlePig();
        }
        return animal;                                              //返回给自定义类型animal

    }
}
