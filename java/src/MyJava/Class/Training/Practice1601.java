package MyJava.Class.Training;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Practice1601 {
    public static void main(String[] args) {
        //将文本中的"C:\Users\jingx\work\读"中的6.txt文本内容复制到7.txt
        FileInputStream fis = null;
        FileOutputStream fos = null;
        //
        try {
            //创建要读取的文件
            fis = new FileInputStream("C:\\Users\\jingx\\work\\读\\6.txt");
            //创建要写入的文件
            fos = new FileOutputStream("C:\\Users\\jingx\\work\\读\\7.txt");
            //创建1kb内存
            byte[] bytes = new byte[2048];
            //循环读取
            while (fis.available() != 0) {                     //循环假设还有数据可以读取
                int data = fis.read(bytes);                    //读取后存到bytes赋给data
                fos.write(bytes,0,data);                   //写入数据到fos
            }
            System.out.println("Write in successfully ");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
class Practice1602{
    public static void main(String[] args) {

    }
}