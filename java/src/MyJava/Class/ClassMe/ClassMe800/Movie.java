package MyJava.Class.ClassMe.ClassMe800;

public class Movie {
    //定义一个电影类
    public String name;                                     //定义电影名字
    public String director;                                 //定义导演
    public String[] actors;                                 //定义演员数组
    //写一个可以给演员数组赋值的方法
    public void InitActors(String[] acts) {                 //定义参数acts，接收演员数组
        actors = acts;                                      //把传进来的数组保存到对象的actors成员变量
        //此方法可用于多个不同对象，不会冲突
    }
    //写个介绍影片阵容的方法
    public void show() {
        System.out.println("Movie Name: " + name);
        System.out.println("Director: " + director);
        System.out.println("Actors: ");
        for (int i = 0; i < actors.length; i++) {
            System.out.println(actors[i]);
        }
    }
}
