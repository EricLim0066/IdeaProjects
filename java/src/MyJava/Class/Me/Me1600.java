package MyJava.Class.Me;

import MyJava.Class.ClassMe.ClassMe1600.Book;

import java.io.*;
import java.util.*;

public class Me1600 {
    public static void main(String[] args) {
        //IO流
        //java程序访问电脑文件
        ///Java Application Programming Interface: Java本质就是一堆类和编程接口
        ///Java API : java.io.File类访问电脑文件
        ///读取C:\Users\jingx\work\读\1.txt文件信息，不是内容
        //创建文件对象，指向文件
        File file = new File("C:\\Users\\jingx\\work\\读\\1.txt");
        ///boolean类型 exists()判断文件或目录存不存在
        if (file.exists()) {
            ///boolean类型 isFile()判断是不是文件
            if(file.isFile()) {
                ///String类型 getPath()获取相对路径，即File参数里的路径
                System.out.println(file.getPath());
                ///String类型 getAbsolutePath()获取绝对路径，即完整文件地址
                System.out.println(file.getAbsoluteFile());
                ///String类型 getName()获取文件名
                System.out.println(file.getName());
                ///Long类型 length()文件大小
                System.out.println(file.length());
            }
            ///boolean类型 isDirectory()判断是不是目录
            if (file.isDirectory()) {
                ///boolean类型 delete()删除硬盘上指定目录或文件
                ///<<<<<<注意:可能误删重要文件，不进回收站，非常危险，慎用>>>>>>>
                System.out.println(file.delete());
                try {
                    ///boolean类型 createNewFile()创建空文件
                    System.out.println(file.createNewFile());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            System.out.println("no");
        }
    }
}
class Me1601{
    public static void main(String[] args) {
        //创建文件
        //输入要创建的新文件到参数
        File file = new File("C:\\Users\\jingx\\work\\读\\4.txt");
        if (!file.exists()){
            ///boolean类型 createNewFile()创建空文件
        try {
            file.createNewFile();                                  ///直接输入createNewFile会IO异常
        } catch (IOException e) {                                  ///需要创建try catch finally捕捉异常
            e.printStackTrace();                                   ///如果有异常，输出简洁异常信息
        }
            System.out.println("File created !");
        } else {
            System.out.println("File existed !");
        }
    }
}
class Me1602{
    public static void main(String[] args) {
        ///流是一连串流动字符，以先进先出发送信息通道
        ///相对于内存而言，流方向分为输入和流输出流，通过流实现文件读写，
        ///读取文本文件4步骤 1.引入类  2.创建FileInputStream对象  3.读取数据  4.关闭流
        //第一套读取字节流方案
        ///FileInputStream -> InputStream /输入流: 硬盘 -> 内存
        //1.引入import java.io.FileInputStream  2.创建对象
        FileInputStream file = null;                     ///设置null声明变量，方便后续包括关闭资源等多个操作
        ///文件可能在硬盘上但不存在目录上，添加try catch异常捕捉
        try {
            file = new FileInputStream("C:\\Users\\jingx\\work\\读\\2.txt");
            //3.读取数据
            byte[] bytes = new byte[1024];              //创建1kb字节数组的空间，1kb = 1024bytes
            ///int available()可以从输入流中读取字节数目
            while (file.available() != 0) {             //判断也没有到达流的末尾，即还有没有内容未读完
                ///int类型 read()返回下一个字节，即读取文件的二进制字节
                ///int类型 read(byte[] b)返回缓冲区数据总量，即读取文件的二进制字节
                int data = file.read(bytes);            //read(bytes)每次一组一组字节读取后保存到内存bytes，然后内容赋给data
                ///read (byte[] bytes, int offset, int length)读取字节，但需要把字节内容转换成可读文本
                ///bytes存放读入的二进制，offset下标位置，length字节长度
                String temp = new String (bytes,0,data);
                System.out.println(temp);
            }
        } catch (FileNotFoundException e) {             //捕捉文件不存在异常
            System.out.println("File not exist");
        } catch (IOException e) {                       //捕捉IO异常
            e.printStackTrace();
        }finally {
            //4.释放资源
            ///用完后记得关闭流
            try {
                ///void close()关闭流
                file.close();
                //再次添加捕捉异常，确认是否能释放资源，不能就输出简短异常讯息
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
class Me1603 {
    public static void main(String[] args) {
        ///读取文本文件4步骤 1.引入类  2.创建FileInputStream对象  3.读取数据  4.关闭流
        ///FileOutputStream -> OutputStream /输出流: 内存 -> 硬盘
        //1.引入import java.io.FileInputStream  2.创建对象
        FileOutputStream file = null;                    //设置null声明变量，方便后续包括关闭资源等多个操作
        ///还是一样需要异常捕捉
        try {
            file = new FileOutputStream("C:\\Users\\jingx\\work\\读\\5.txt");
            //3.写入数据
            String data = "Are you ok?";
            //将字符串数据转换成字节
            ///getBytes()将字符串转成数组
            byte[] bytes = data.getBytes();
            ///void write()读取字节后写入硬盘文件
            ///void write (byte[] buf)写入字节组到文件
            ///void write(byte[] byte, int offset, int length)把字节内容写出去
            ///str存放读入的字符，offset下标位置，length字节长度
            file.write(bytes);                           //自动调度flush方法，指flush将内存数据写入硬盘
            System.out.println("Write in successfully! ");

        } catch (FileNotFoundException e) {             //捕捉文件不存在异常
            System.out.println("Files not found");
        } catch (IOException e) {
            e.printStackTrace();                        //输出简洁异常讯息
        } finally {
            //4.释放资源
            ///用完后记得关闭流
            try {
                file.close();                           //无法关闭就捕捉IO异常
            } catch (IOException e) {
                e.printStackTrace();                    //输出简洁异常讯息
            }
        }
        ///写入时，注意文件地址和名称，否则覆盖重要文件
    }
}
class Me1604{
    public static void main(String[] args) {
        //第二套读取字节流方案
        ///FileReader读取字符流文件 -> InputStreamReader -> Reader
        FileReader file = null;                         //设置null声明变量，方便后续包括关闭资源等多个操作
        StringBuffer buffer = null;                     ///StringBuffer()，拼接字符串
        //添加异常捕捉查看是否文件不存在异常
        try {
            file = new FileReader("C:\\Users\\jingx\\work\\读\\5.txt");
            buffer = new StringBuffer();
            //字符流方式读取文件
            ///char[]保存文本字符
            char[] chars = new char[1024];             ///char[]创建字符流文件，bytes[]是字节流文件
            ///int类型 read()返回下一个字符，即读取文件的字符串
            ///int类型 read(char[] c)返回缓冲区数据总量，即读取文件的字符串
            ///read(char[] char, int offset, int length)直接读取字符内容
            ///char存放读入的字符，offset下标位置，length字节长度
            int length = file.read(chars);             //read(chars)每次一组一组字符读取后保存到内存char，然后内容赋给length
            ///只要文件没到末尾，继续读取
            while (length != -1) {
                //拼接字符串
                buffer.append(chars,0,length);
                //读取新的字符流，继续while循环拼接，知道length -1结束
                length = file.read(chars);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");;
            //添加捕捉IO类异常
        } catch (IOException e) {
            e.printStackTrace();                        //输出异常简短信息
        } finally {
            //添加异常捕捉关闭资源时的IO异常
            try {
                ///close()关闭流
                file.close();
            } catch (IOException e) {
                e.printStackTrace();                    //输出异常简短信息
            }
        }
        //读取StringBuffer拼接的字符串
        System.out.println(buffer.toString());
    }
}
class Me1605{
    public static void main(String[] args) {
        ///FileWriter写入字符流文件 -> OutputStreamWriter -> Writer
        FileWriter file = null;
        try {
            //创建需要保存的文件
            file = new FileWriter("C:\\Users\\jingx\\work\\读\\7.txt");
            //写入需要的文件
            String data = "I love my country!";
            ///write (String str)写入字符到文件
            ///write(String str, int offset, int length)把字符内容写出去
            ///str存放读入的字符，offset下标位置，length字节长度
            file.write(data);                          //读取data字节后保存到硬盘file
            ///flush()刷新缓冲
            file.flush();
            System.out.println("Write in successfully");
        } catch (IOException e) {
            e.printStackTrace();                       //输出字符流异常内容
        } finally {
            try {
                ///close()关闭流
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
class Me1606{
    public static void main(String[] args) {
        //第三套 缓冲流读取方案
        ///BufferedReader -> Reader 读取缓冲流
        BufferedReader buffer = null;                     //创建两种读取流
        Reader reader = null;
        try {
            //创建需要读取的文件
            ///先创建FileReader，再用BufferedReader包装,既能读字符，又能按行读取并提高效率
            reader = new FileReader("C:\\Users\\jingx\\work\\读\\7.txt");
            buffer = new BufferedReader(reader);
            ///readLine(),直接读取一整串字符内容，不需要创建数组一个个保存
            String line = buffer.readLine();
            while (line != null) {                        //如果文件没读完，继续读
                System.out.println(line);
                line = buffer.readLine();
            }
        } catch (FileNotFoundException e ){
            System.out.println("File not found");
        }catch (IOException e) {
            e.printStackTrace();                           //输出字符流异常内容
        } finally {
            try {
                ///close()关闭流
               ///后开的先关闭
                buffer.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
class Me1607{
    public static void main(String[] args) {
        //缓冲流写入方案
        ///BufferedWriter -> Writer 写入缓冲流
        BufferedWriter buffer = null;                     //创建两种写入流
        Writer writer = null;
        try {
            //创建需要写入的文件
            ///先创建Filewriter，再用BufferedWriter包装,既能写入字符，又能按行写并提高效率
            writer = new FileWriter("C:\\Users\\jingx\\work\\读\\7.txt");
            buffer = new BufferedWriter(writer);
            ///write(),直接写入一整串字符内容，不需要创建数组一个个保存
            buffer.write("You are my special one");
            System.out.println("Write in successful !");
        } catch (FileNotFoundException e ){
            System.out.println("File not found");
        }catch (IOException e) {
            e.printStackTrace();                           //输出字符流异常内容
        } finally {
            try {
                ///close()关闭流
                ///后开的先关闭
                buffer.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
class Me1608 {
    public static void main(String[] args) {
        //第四套方案流读写方案
        ///使用二进制读写方案DataInputStream DataOutputStream实现文件复制
        DataInputStream dis = null;                      //类
        FileInputStream fis = null;                      ///子类，与父类结合使用读取二进制文件
        //
        DataOutputStream dos = null;                     //类
        FileOutputStream fos = null;                     ///子类，与父类结合使用写入二进制文件
        //
        try {
            //源文件路径
            fis = new FileInputStream("C:\\Users\\jingx\\work\\读\\屏幕截图 2026-02-21 001331.png");
            //目标文件路径
            fos = new FileOutputStream("C:\\Users\\jingx\\work\\读\\屏幕截图 副本.png");
            //包装以上两个类
            dis = new DataInputStream(fis);             //InputStream父类指定InputStream子类
            dos = new DataOutputStream(fos);            //OutputStream父类指定OutputStream子类
            //一边读取数据，一边写入数据
            int data;
            //声明data变量，假设在while循环，读取未达到末尾，dos写入数据
            while ((data = dis.read()) != -1) {        ///while每次循环，read()的新结果存变量，否则死循环或丢字节
                dos.write(data);
            }
            System.out.println("copied successful !");
        } catch (FileNotFoundException e ){
            System.out.println("File not found");
        }catch (IOException e) {
            e.printStackTrace();                        //输出字符流异常内容
        } finally {
            try {
                //关闭资源，哪个后开先关哪个
                dis.close();
                dos.close();
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
class Me1609{
    public static void main(String[] args) {
        //序列化和反序列化
        ///序列化，把对象写入特定流中
        ///序列化可以保存对象全图，实现Serializable接口
        ///反序列化，把特定流中的数据还原成对象
        //把图书序列化到book.bin文件中
        //创建泛型集合对象
        //移步(ClassMe1600/Book.java)
        List <Book> list = new ArrayList <>();
        //创建书本对象
        Book b1 = new Book("Camon", 20,"Milano");
        Book b2 = new Book("StoryDay", 30,"Puno");
        //添加到集合
        list.add(b1);
        list.add(b2);
        //序列化文件
        ///FileOutputStream 硬盘读取二进制文件
        ///ObjectOutputStream 把要存进去的对象序列化
        FileOutputStream fos = null;                      ///二进制序化器
        ObjectOutputStream oos = null;
        try {
            //创建要写入的文件
            fos = new FileOutputStream("C:\\Users\\jingx\\work\\读\\book.bin");
            //oos包装fos，方便写入对象
            oos = new ObjectOutputStream(fos);
            ///list写入文件，调度writeObject实现序列化
            oos.writeObject(list);
            System.out.println("write in successful !");
            //直接打开文件就会发现乱码，那是序列化后的二进制代码·
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
class Me1610{
    public static void main(String[] args) {
        //反序列化
        //Book类已创建
        //序列化文件
        ///FileInputStream 从磁盘文件中读取字节数据
        ///ObjectInputStream 把读取到的字节流还原成对像
        FileInputStream fis = null;
        ObjectInputStream ois = null;                     ///二进制反序化器
        try {
            //创建要读取的文件
            fis = new FileInputStream("C:\\Users\\jingx\\work\\读\\book.bin");
            //ois包装fis，方便把字节流还原成对象
            ois = new ObjectInputStream(fis);
            ///读取的是Object类型，需要强制转换为泛型
            List <Book> list = (List<Book>)ois.readObject();
            for (Book book : list) {
                System.out.println(book.getName() + "\t" + book.getPrice() + "\t" + book.getAuthor());
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } finally {
            try {
                fis.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ///注意:反序列化时的类型必须和序列化的类型一致否则异常(包名，类名，名称要一致)
            ///尽可能不要用序列化进行文件加密，因为不具备加密功能，可以被反序列化
            ///java中String类本身已具备Serializable接口，可以被序列化
        }
    }
}