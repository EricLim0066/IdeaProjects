package MyJava.Class.Me;

import org.dom4j.DocumentHelper;
import org.dom4j.io.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.List;

public class Me1900 {
    public static void main(String[] args) {
        ///XML(Extensible Markup Language)可扩展标记语言
        ///与操作系统和开发语言无关
        ///用于数据交互和网站配置文件
        //移步ClassMe1900/Books.xml
//        <books>                                                 //<开头自定义名称>
//                <book id = "01">                                //</带尾结束自定义名称>
//                <name>Summer in closed eyes</name>
//                <price>20</price>
//                <author>Takafumi</author>
//                </book>
//
//                <book id = "02">
//                <name>Summer in closed eyes</name>
//                <price>20</price>
//                <author>Takafumi</author>
//                </book>
//       </books>
        ///XML文档由一系列<></>标签组成
        ///标签语法<元素名 变量名 = "属性值"> 元素内容 </元素名>
        ///注意:1.一个元素可以多个属性值, 2.属性值用双引号""包裹 3.所有<xml>必须有</结束标签> 4.xml对标签特别严格(分大小写，嵌套位置)
    }
}
class Me1901{
    public static void main(String[] args) {
        //转义符
        ///当XML文档需要使用特殊符号却和里面的符号相冲突时，可以使用转义符
        ///符号 -> 转义符 1.< -> &lt; 2.> -> &gt; 3." -> &quot;4. ‘ -> &apos;5. & -> &amp;
        ///当元素需要很多特殊符号时，可以使用CDATA节点 <![CDATA[<>'"&]]>，在里面可以放多个特殊符号而不会报错
        //=====================================================================================
        //XML解析技术 DOM DOM4J
        ///DOM java自带，可以一次性把整个xml变成一棵树存进内存，官方标准通用性强，但内存占用大性能低
        ///DOM4J 第三方XML框架，也是树结构但更简洁，写法简单性能更好，但需要额外依赖版本过老
    }
}
class Me1902{
    public static void main(String[] args) {
        //DOM解析XML文档步骤
        ///创建解析器工厂对象DocumentBuilderFactory
        ///创建解析器对象DocumentBuilder
        ///通过parse方法获取Document对象
        ///进行解析操作
        //从(ClassMe/Books.xml)提取数据
        //解析器工厂对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        ///new是最低级别构建对象方式，我们还能通过静态方法构建对象，比如newInstance()
        try {
            //解析器对象
            DocumentBuilder builder = factory.newDocumentBuilder();
            //调用perse方法获取Document对象
            Document document = builder.parse("src/MyJava/Class/ClassMe/ClassMe1900/Books.xml");
            //获取Book.xml的book标签 //NodeList总节点数量
            NodeList list = document.getElementsByTagName("book");
            //for循环遍历每个book元素
            for (int i =0; i < list.getLength(); i++) {
                ///Element接口，继承Node,拿取第i个节点集合
                Element book = (Element) list.item(i);               //每一个book都是一本书
                ///getAttribute从标签获取属性值
                String id = book.getAttribute("id");
                ///getElementsByTagName元素名///item下标集合节点位置
                String name = book.getElementsByTagName("name").item(0).
                        ///getFirstChild获取xml第一个子节点，
                        getFirstChild().getNodeValue();
                String price = book.getElementsByTagName("price").item(0).
                        getFirstChild().getNodeValue();
                String author = book.getElementsByTagName("author").item(0).
                        getFirstChild().getNodeValue();
                System.out.println(id + "\t" + name + "\t" + price + "\t" + author);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
class Me1903 {
    public static void main(String[] args) {
        //对Books.xml添加数据
        addNode();
    }

    private static void addNode() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            //构建节点
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("src/MyJava/Class/ClassMe/ClassMe1900/Books.xml");
            //构建完节点后，创建元素集合,强转给book
            Element book = (Element) document.createElement("book");
            ///setAttribute创建属性值
            book.setAttribute("id","03");
            ///createElement创建元素名
            Element name = (Element) document.createElement("name");
            ///setTextContent创建文本内容
            name.setTextContent("fall of traver");
            Element price = (Element) document.createElement("price");
            price.setTextContent("25");
            Element author = (Element) document.createElement("author");
            author.setTextContent("Mr.Ito");
            ///appendChild将游离节点绑到book身上
            book.appendChild(name);
            book.appendChild(price);
            book.appendChild(author);
            //把book绑定文档上面
            document.getElementsByTagName("books").item(0).appendChild(book);
            //从内存factory落地到硬盘文件transformer
            ///transformer没有引入文件或任何地址，本质上是个空文件，用来装货发车
            TransformerFactory factory1 = TransformerFactory.newInstance();
            Transformer transformer = factory1.newTransformer();
            //构造source和result传输数据
            ///source要传输的文件，result要传到的地址
            Source source = new DOMSource(document);
            Result result = new StreamResult("src/MyJava/Class/ClassMe/ClassMe1900/Books.xml");
            transformer.transform(source,result);
            System.out.println("add successful !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Me1904{
    public static void main(String[] args) {
        //DOM4J解析XML
        ///dom4j.org出品的开源XML解析包
        ///创建读取器SAXReader
        ///获取文档对象Document
        ///获取根节点
        ///进行解析操作
        //使用DOM4J读取，添加，修改，删除
        readXML();                                               ///记得调用readXM方法，读取并打印XML内容

    }
    private static void readXML() {
        //构建一个读取器对象
        SAXReader reader = new SAXReader();
        try {
            //通过read方法读取文档对象
            org.dom4j.Document document = reader.read("src/MyJava/Class/ClassMe/ClassMe1900/Books.xml");
            //获取根节点,强转
            ///getRootElement获取根节点
            org.dom4j.Element root = document.getRootElement();
            //通过根节点获取子节点集合
            List <org.dom4j.Element> list = root.elements();
            for (org.dom4j.Element book : list){
                //每一个book都是一本书节点集合
                //获得属性值
                String id = book.attributeValue("id");
                //获取书名
                org.dom4j.Element bookname = book.elements().get(0);
                String name = bookname.getText();
                //获取价格
                org.dom4j.Element bookprice = book.elements().get(1);
                String price = bookprice.getText();
                //获取作者
                org.dom4j.Element bookauthor = book.elements().get(2);
                String author = bookauthor.getText();
                System.out.println(id + "\t" + name + "\t" + price + "\t" + author);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Me1905{
    public static void main(String[] args) {
        //DOM4J解析XML
        //使用DOM4J读取，添加，修改，删除
        addNode();                                      ///记得调用addNode方法，添加内容到XML文档
    }
    private static void addNode() {
        //构建一个添加器对象
        SAXReader reader = new SAXReader();
        try {
            //要读取的文件
            org.dom4j.Document document = reader.read("src/MyJava/Class/ClassMe/ClassMe1900/Books.xml");
            //获取根节点
            org.dom4j.Element root = document.getRootElement();
            //通过根节点获取子节点集合
            List<org.dom4j.Element> list = root.elements();
            //构建新的节点
            org.dom4j.Element book = DocumentHelper.createElement("book");
            book.setAttributeValue("id", "04");
            //构建新图书
            org.dom4j.Element name = DocumentHelper.createElement("name");
            name.setText("Sun of a Beach");
            //构建新价格
            org.dom4j.Element price = DocumentHelper.createElement("price");
            price.setText("35");
            //构建新作者
            org.dom4j.Element author = DocumentHelper.createElement("author");
            author.setText("Bunny");
            //把属性绑到book上
            book.add(name);
            book.add(price);
            book.add(author);
            //把新book绑到list上
            list.add(book);
            //导入硬盘
            Writer writer = new OutputStreamWriter(new FileOutputStream("src/MyJava/Class/ClassMe/ClassMe1900/Books.xml"), "UTF-8");
            document.write(writer);
            writer.close();
            System.out.println("Write in successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Me1906 {
    public static void main(String[] args) {
        //DOM4J解析XML
        //使用DOM4J读取，添加，修改，删除
        updateNode();                                      ///记得调用addNode方法，修改内容到XML文档
    }
    private static void updateNode() {
        //创建修改数据
        SAXReader reader = new SAXReader();
        try {
            org.dom4j.Document document = reader.read("src/MyJava/Class/ClassMe/ClassMe1900/Books.xml");
            //从文件提取根节点
            org.dom4j.Element root = document.getRootElement();
            //从根节点获取子节点
            List<org.dom4j.Element> list = root.elements();
            //先获取单个图书对象
            org.dom4j.Element book = list.get(3);                    //下标获取指定节点集合，即要修改的地方
            //获取name子节点
            org.dom4j.Element name = book.element("name");
            name.setText("Spring after you");                       //添加要修改的名字
            //修改后新位置覆盖xml文档原位置
            Writer writer = new OutputStreamWriter(new FileOutputStream("src/MyJava/Class/ClassMe/ClassMe1900/Books.xml"),"UTF-8");
            document.write(writer);
            writer.close();
            System.out.println("Change successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Me1907 {
    public static void main(String[] args) {
        //DOM4J解析XML
        //使用DOM4J读取，添加，修改，删除
        deleteNode();                                      ///记得调用addNode方法，删除XML文档中的内容
    }
    private static void deleteNode() {
        //创建删除数据
        SAXReader reader = new SAXReader();
        try {
            org.dom4j.Document document = reader.read("src/MyJava/Class/ClassMe/ClassMe1900/Books.xml");
            //从文件提取根节点
            org.dom4j.Element root = document.getRootElement();
            //从根节点获取子节点
            List<org.dom4j.Element> list = root.elements();
            //先锁定单个图书对象，再删除
            org.dom4j.Element book = list.get(1);                    //下标获取指定节点集合，即要修改的地方
            //获取要移除的节点
            list.remove(book);
            //删除后保存到xml文档
            Writer writer = new OutputStreamWriter(new FileOutputStream("src/MyJava/Class/ClassMe/ClassMe1900/Books.xml"),"UTF-8");
            document.write(writer);
            writer.close();
            System.out.println("delete successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
        //数据保存方案
        ///在java中保存数据，可以想到的方案
        ///内存保存: 用集合保存数据
        ///硬盘保存: IO流(本地文件)，序列和反序列化，xml文档
    }
}