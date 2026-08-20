package MyJava.Class.ClassMe.ClassMe1800;

import java.io.Serializable;

public class UserInfo implements Serializable {
    //定义用户变量
    ///如果类要在网络上传输类型，必须使用Serializable接口
    private String name;
    private String password;

    //定义构造方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
