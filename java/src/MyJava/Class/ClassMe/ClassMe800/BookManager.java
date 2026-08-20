package MyJava.Class.ClassMe.ClassMe800;

public class BookManager {
    //定义book类
    //制作一个显示所有图书列表和添加图书功能系统，让用户可以更加方便添加和查看图书
    //针对图书管理，用于维护数组，图书类型等对象数组
    Book[] books = new Book[50];                     //从Book数组对象化，假设定义储存50本书讯
    //对books初始化，给前两个数组赋值
    public void InitBooks() {
        //构建一个图书对象
        Book book = new Book();                     //从Book定义单一对象，属性赋值，类作为类的对象
        book.bookname ="It's Party PlayFun.Time";
        book.bookauthor ="MERY";
        book.bookprice =20;
        //图书对象和book数组进行关联
        books[0] = book;
        //
        Book book2 = new Book();                    //第二个属性赋值
        book2.bookname ="Dream of Saigon";
        book2.bookauthor ="Minh";
        book2.bookprice =25;
        //图书对象和book数组进行关联
        books[1] = book2;
    }
    //制作图书列表
    public void BookList() {
        System.out.println("Here is the book list for all books");
        System.out.println("Book Name" + "\t\t\t" + "Author" + "\t\t\t" + "Price");
        for (int i = 0; i < books.length;i++ ) {
            if (books[i] != null) {                 //如果直接打印可能会有空的地方，数据没有进来，所以添加null判定是否为空
                System.out.println(books[i].bookname + "\t\t" + books[i].bookauthor + "\t\t\t" + books[i].bookprice);
            }
        }
    }
    //添加图书
    public boolean AddBook(Book book) {            //(添加数组，添加对象) //设置布尔类型，告诉用户是否添加成功
        boolean flag = false;
        for (int i = 0; i < books.length;i++) {
            if (books[i] == null) {                //循环扫描第几个位置为空，用null比较
                books[i] = book;                   //如果为空，添加图书
                flag = true;                       //代码执行到这里，证明添加成功
                break;
            }
        }
        return flag;
    }
}
