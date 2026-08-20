package MyJava.Class.ClassMe.ClassMe1600;

import java.io.Serializable;

public class Book implements Serializable {                        //要实例化Book类，implements实现Serializable接口
    //定义私有成员变量,书名，价格，作者
    private String name;
    private int price;
    private String author;
    //定义构造方法
    public Book(){

    }
    public Book(String name, int price, String author){
        this.name = name;
        this.price = price;
        this.author = author;
    }

    //定义getter和setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
