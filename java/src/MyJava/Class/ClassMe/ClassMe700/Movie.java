package MyJava.Class.ClassMe.ClassMe700;

public class Movie {
    public String movieName;                              //电影名
    public String director;                               //导演
    public String[] actors = new String[5];               //演员
    //写个方法，用于给多个actors赋值
    //缺点，只能面向单个对象
    public void initData(){                               //初始化数据
        actors[0] = "Bunny";
        actors[1] = "Anh Phuc";
        actors[2] = "Zhang Ming";
        actors[3] = "Kobayashi";
        actors[4] = "Jackson";
    }
    //写介绍电影信息的方法
    public void show() {
        System.out.println("Movie Name: " + movieName);
        System.out.println("Director: " + director);
        System.out.println("Actors: ");
        //输出多个演员
        for (int i = 0; i < actors.length; i++) {      //索引从0下标
            System.out.println(actors[i]);
        }
    }
}
