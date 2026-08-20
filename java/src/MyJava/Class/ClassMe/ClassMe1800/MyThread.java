package MyJava.Class.ClassMe.ClassMe1800;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MyThread extends Thread {
    //定义多线程
    Socket thesocket = null;
    //创键构造方法
    public MyThread(Socket socket) {
        this.thesocket = socket;
    }
    //线程需要run方法
    @Override
    public void run(){
        InputStream input = null;
        OutputStream output= null;
        ObjectInputStream ois = null;
        //捕捉输入流异常
        try {
            input =thesocket.getInputStream();
            output = thesocket.getOutputStream();
            //输入流包装成对象流，把原始字节变成可读对象
            ois = new ObjectInputStream(input);
            try {
                //读取反序列化而成的对象数据，然后强转给user
                UserInfo user = (UserInfo)ois.readObject();
                //打印收到的消息
                System.out.println("Info that receive: " + user.getName() + "\t" + user.getPassword());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //关闭反序列化
            thesocket.shutdownInput();
            String message = "Server message sent";
            //转换成字节发送客户端
            output.write(message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
                output.close();
                ois.close();
                thesocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
