package MyJava.Class.Me;

import MyJava.Class.ClassMe.ClassMe1800.MyThread;
import MyJava.Class.ClassMe.ClassMe1800.UserInfo;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Me1800 {
    public static void main(String[] args) {
        //IP地址
        ///两台计算机之间的通信，双方必须都有地址
        ///(Internet Protocol Address)指网络协议地址，可以唯一标识网络上的每一台计算机，简称IP地址
        ///IPd地址有32位数(4个8位二进制)，二进制不方便记忆所以IP地址格式为 IPv4:192.168.1.5(完整设备地址)
        ///因为8位数，每一个分割点范围之间都是0~255
        ///A.B.C.D,A代表网络号高位，BC代表网络地位或子网号，D代表主机编号
        ///子网掩码：255.255.255.0 (/24)(前24位网络号范围) DHCP：192.168.1.2 – 192.168.1.254(后8位主机号)
    }
}

class Me1801{
    public static void main(String[] args) {
        //网络协议
        ///为了在不同的计算机之间进行通信所建立的规则，标准或约定的集合
        ///第一层:应用层 HTTP网站服务器 FTP文件服务器
        ///第二层:传输层 TCP UDP
        ///第三层:网络层 IP ARP
        ///第四层：数据链路层：底层网络定义协议
    }
}
class Me1802{
    public static void main(String[] args) {
        //socket
        ///由IP地址IPv4:192.168.1.5和端口号0~65535(16位进制)组成，用于两个计算机之间的通信
        ///因为端口号存在，传输数据不会造成混乱
        //TCP socket协议
        ///进行通信时，socket需要借助数据流完成传递工作(ClientSocket客户端和ServerSocket服务端)
        ///打电话，自身电话主动发起并请求链接，获得客户端socket，对方服务端被动监听，Accept()接收链接并创建通信socket
        ///如果确认请求和连接建立成功，两方socket便可互相发送和接收通信
        //==========================================================================================
    }
}
class Me1803{
    public static void main(String[] args) {
        //TCP协议
        ///服务端ServerSocket，监听有没有客户端发送数据过来
        ///Socket通过ServerSocket的accept()创建，客户端一旦连到，就会创建一个socket用于通信接受发送等操作
        ///socket网络编程 1.建立连接，2.打开socket相关联的输入输出流，3.读取信息，4.关闭流和socket
        //实现客户端和服务端相互发送讯息
        ///服务端有两个socket，一个建立通讯，一个监听
        ServerSocket socket = null;
        Socket accept = null;
        InputStream input = null;
        OutputStream output = null;
        BufferedReader reader = null;
        Scanner sms = new Scanner(System.in);
        //
        try {
            //1段，服务端铺垫
            //创建负责监听的socket
            socket = new ServerSocket(16400);              //port端口地址
            //创建负责通信的socket
            accept = socket.accept();                           //用null分开创建，用于抓捕socket异常 //accept接受连接请求
            //从通信socket建立输入输出流，用于传输和接收数据
            input = accept.getInputStream();
            output = accept.getOutputStream();
            ///BufferReader包装，一次性读取来自input的整行数据流
            ///InputStream读字节 -> InputStreamReader转成可读字符 -> BufferedReader高效接收字符串
            reader = new BufferedReader(new InputStreamReader(input));
            //============================================================================
            //2段，服务端接收消息
            //创建字符串变量，用于接收客户端发送的消息
            String message = "";
            //用while循环判断还有内容可读
            while ((message = reader.readLine()) != null) {
                //接收到的消息
                System.out.println(message);
            }
            //通信socket关闭输入流
            accept.shutdownInput();
            //3段，服务端发送消息
            //发给客户端的消息
            message = sms.nextLine().trim();
            //将消息转换为字节发送给客户端
            output.write(message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ///流是稀缺资源，用完后必须关闭，先开的后关
                socket.close();                                 //抓捕socket关闭异常
                input.close();
                output.close();
                accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
class Me1804{
    public static void main(String[] args) {
        //TCP协议
        ///客户端ClientSocket，构造可以链接服务器的socket，但需要提供服务器的IP和监听端口
        ///可以通过socket对象的InputStream()和OutputStream()获取输入输出流，便可发送和接收数据
        ///Socket通过ServerSocket的accept()创建，客户端一旦连到，就会创建一个socket用于通信接受发送等操作
        //负责和服务端通信的客户端
        ///客户端只需一个socket
        Socket accept = null;
        InputStream input = null;
        OutputStream output = null;
        BufferedReader reader = null;
        System.out.println("Enter some message");
        Scanner sms = new Scanner(System.in);
        try {
            ///主动链接服务器，host服务器ip指向要连的ip地址，port服务器端口指向指定要连的的监听端口
            ///这里本地客户端端口，由系统随机分配，被隐藏起来了
            accept = new Socket("localhost",16400);
            // 建立输入输出流，用于接受和发送数据
            input = accept.getInputStream();
            output = accept.getOutputStream();
            //输入消息
            String message = sms.nextLine().trim();
            //给服务端发送消息
            output.write(message.getBytes());
            //关闭输出流
            accept.shutdownOutput();
            //接收服务端发送的消息
            reader = new BufferedReader(new InputStreamReader(input));
            // 读取服务器返回消息示例
            String msg = " ";
            //while循环判断还有内容可读
            while ((msg = reader.readLine()) != null) {
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ///流是稀缺资源，用完后必须ose();
                input.close();
                output.close();
                accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
class Me1805 {
    public static void main(String[] args) {
        //发送对象类型数据
        ///服务端通过ObjectInputStream反序列化对象，然后拆解并整合对象属性
        ServerSocket socket = null;
        Socket accept = null;
        InputStream input = null;
        OutputStream output = null;
        BufferedReader reader = null;
        //序列化对象
        ObjectInputStream ois = null;
        try {
            //创建监听端口
            socket = new ServerSocket(11451);
            //accept接受，并创建接口接通
            accept = socket.accept();
            // 建立输入输出流，用于接受和发送数据
            input = accept.getInputStream();
            output = accept.getOutputStream();
            //包装输入流,反序列化手段
            ois = new ObjectInputStream(input);
            //强制转换，接收对象信息
            UserInfo info = (UserInfo)ois.readObject();
            System.out.println("message: " + info.getName() + "\t" + info.getPassword());
            accept.shutdownInput();
            //发送给客户端的讯息
            String message = "Huh?";
            output.write(message.getBytes());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
                input.close();
                ois.close();
                accept.close();
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
class Me1806 {
    public static void main(String[] args) {
        ///客户端组合类对象，然后通过ObjectOutputStream发送对象数据给服务端
        Socket socket = null;
        InputStream input = null;
        OutputStream output = null;
        ObjectOutputStream oos = null;
        BufferedReader reader = null;
        Scanner scanner = new Scanner(System.in);
        //
        try {
            //锁定发送的ip和接口
            socket = new Socket("localhost",11451);
            // 建立输入输出流，用于接受和发送数据
            input = socket.getInputStream();
            output = socket.getOutputStream();
            //反序列化
            oos = new ObjectOutputStream(output);
            //定义调度对象
            String name = scanner.nextLine();
            String password = scanner.nextLine();
            UserInfo user = new UserInfo();
            user.setName(name);
            user.setPassword(password);
            //调用类讯息后，返还给oos
            oos.writeObject(user);
            socket.shutdownOutput();
            //后续代码主要负责接收服务器发送过来的消息
            reader = new BufferedReader(new InputStreamReader(input));
            String message = " ";
            while ((message = reader.readLine()) != null) {
                System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
                output.close();
                reader.close();
                socket.close();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
class Me1807 {
    public static void main(String[] args) {
        //多线程
        ///一个服务端，通过线程接收多个客户端
        //移步(Me1808与Me1809 ，ClassMe1800/UserInfo.java和ClassMe1800/MyThread.java)
        ServerSocket socket = null;
        Socket accept = null;
        InputStream input = null;
        OutputStream output = null;
        BufferedReader reader = null;
        ObjectInputStream ois = null;
        //
        try {
            socket = new ServerSocket(25634);
            //客户端不止一个，构建多个用于之间通信的socket
            while (true) {
                //每当来一个客户端链接，就创建一个socket，然后赋给线程
                accept = socket.accept();
                //线程类想要构造出来，传socket构造函数实例化
                MyThread t1 = new MyThread(accept);
                t1.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
class Me1808 {
    public static void main(String[] args) {
        ///一个服务端，通过线程接收多个客户端
        //移步(Me1807与Me1809 ，ClassMe1800/UserInfo.java和ClassMe1800/MyThread.java)
        Socket socket = null;
        InputStream input = null;
        OutputStream output = null;
        ObjectOutputStream oos = null;
        BufferedReader reader = null;
        Scanner scanner = new Scanner(System.in);
        //
        try {
            //锁定发送的ip和接口
            socket = new Socket("localhost",25634);
            // 建立输入输出流，用于接受和发送数据
            input = socket.getInputStream();
            output = socket.getOutputStream();
            //反序列化
            oos = new ObjectOutputStream(output);
            //定义调度对象
            String name = scanner.nextLine();
            String password = scanner.nextLine();
            UserInfo user = new UserInfo();
            user.setName(name);
            user.setPassword(password);
            //调用类讯息后，返还给oos
            oos.writeObject(user);
            socket.shutdownOutput();
            //后续代码主要负责接收服务器发送过来的消息
            reader = new BufferedReader(new InputStreamReader(input));
            String message = " ";
            while ((message = reader.readLine()) != null) {
                System.out.println(socket.getLocalPort() + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
                output.close();
                reader.close();
                socket.close();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
class Me1809 {
    public static void main(String[] args) {
        ///一个服务端，通过线程接收多个客户端
        //移步(Me1807与Me1808 ，ClassMe1800/UserInfo.java和ClassMe1800/MyThread.java)
        Socket socket = null;
        InputStream input = null;
        OutputStream output = null;
        ObjectOutputStream oos = null;
        BufferedReader reader = null;
        Scanner scanner = new Scanner(System.in);
        //
        try {
            //锁定发送的ip和接口
            socket = new Socket("localhost",25634);
            // 建立输入输出流，用于接受和发送数据
            input = socket.getInputStream();
            output = socket.getOutputStream();
            //反序列化
            oos = new ObjectOutputStream(output);
            //定义调度对象
            String name = scanner.nextLine();
            String password = scanner.nextLine();
            UserInfo user = new UserInfo();
            user.setName(name);
            user.setPassword(password);
            //调用类讯息后，返还给oos
            oos.writeObject(user);
            socket.shutdownOutput();
            //后续代码主要负责接收服务器发送过来的消息
            reader = new BufferedReader(new InputStreamReader(input));
            String message = " ";
            while ((message = reader.readLine()) != null) {
                System.out.println(socket.getLocalPort() + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
                output.close();
                reader.close();
                socket.close();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
class Me1810 {
    public static void main(String[] args) {
        //基于UDP协议的Socket编程
        ///利用Datagram Socket发送和接收数据报
        ///利用Datagram Packet对象封装和处理数据报
        ///Receive和Send通常与(DatagramSocket和DatagramPacket)结合使用
        ///UDP不分客户端和服务端，默认有接收端和发送端
        //使用UDP实现接收和发送数据的程序
        //创建socket
        DatagramSocket socket = null;
        try {
            //接收端
            socket = new DatagramSocket(22222);
            System.out.println("Waiting receive the data...");
            //如果想使用UDP协议发送数据，封装成数据报
            byte[] bytes = new byte[1024];              //1kb缓冲区
            //构建数据报，需要字节数组缓冲区
            DatagramPacket packet = new DatagramPacket(bytes,bytes.length);
            //接收来自socket的数据，放进packet数据报
            socket.receive(packet);
            //从数据报提取字节组数据
            bytes = packet.getData();
            ///还原成字符串，String(字节数据，起始位置，数据报长度)
            String message = new String(bytes,0, packet.getLength());
            System.out.println(message);
            //发送数据(转字节数组)
            bytes = "message received".getBytes();
            //又转成字符串发给目标计算机(IP地址，端口）
            packet = new DatagramPacket(bytes,0, bytes.length,InetAddress.getByName("localhost"),packet.getPort());
            //发给发送端
            socket.send(packet);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            socket.close();
        }
    }
}
class Me1811 {
    public static void main(String[] args) {
        //使用UDP实现接收和发送数据的程序
        //发送端
        DatagramSocket socket = null;
        try {
            //发动段不需要端口号
            socket = new DatagramSocket();
            byte[] bytes = "java2026".getBytes();
            //要发送数据报，指定发给谁(IP地址和端口)
            DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length,InetAddress.getByName("localhost"),22222);
            //发送消息
            socket.send(packet);
            //接收消息
            bytes = new byte[1024];                           //1kb缓冲区
            packet = new DatagramPacket(bytes,bytes.length);
            socket.receive(packet);
            int length = packet.getLength();
            //获取字节数据
            bytes = packet.getData();
            //转成字符串
            String message = new String(bytes,0,length);
            System.out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
}