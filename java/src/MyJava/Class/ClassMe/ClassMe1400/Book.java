package MyJava.Class.ClassMe.ClassMe1400;

public class Book {                                               //定义图书类
    //真实开发中为了封装尽可能加上private
    private String name;                                          //定义书名变量
    private int price;                                            //定义价格
    private String author;                                        //定义作者

    //进行无参构造
    public Book() {

    }
    public Book(String name,int price,String author) {          //进行无参构造，给书加上输入参数
        this.name = name;
        this.price = price;
        this.author = author;

    }
    //重写toString方法
    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
    //进行书名封装
    public String getName(){                                    //返回书名名称
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getPrice(){                                      //返回书类价格
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public String getAuthor(){                                    //返回书本作者
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }
}
