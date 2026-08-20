package MyJava.Class.Me;

import MyJava.Class.ClassMe.ClassMe1400.Book;

import java.util.*;
import java.util.stream.Stream;

public class Me1400 {
    public static void main(String[] args) {
        //集合框架
        ///存储一个网站每天登录人数的信息，因为每日登录人数不确定，不适合使用数组，可以使用java集合框架(Collection/Map)
        ///集合框架位于java.util包中，能保存很多种数据，提供了性能精良，方便的接口和实现类
        ///单列集合Collection接口，储存单个元素的集合，元素是否重复，是否有序，取决于具体实现
        ///List接口，储存有序，允许重复的元素 (ArrayList,LinkedList)
        ///Set接口，储存无序，不允许重复的元素 (Hashset)
        ///双列集合Map接口,储存键值对key和value映射的关系，key唯一，value可重复 (HashMap,TreeMap)
        //==============================================================================
        ///ArrayList：基于动态数组实现长度可变，元素按索引连续存储,和Array数组不同，前者数组空间弹性，后者固定
        ///优点随机访问速度快，尾部添加效率高，缺点插入或删除元素需要移动后续元素效率差
        //
        ///LinkedList：基于双向链表实现
        ///优点插入和删除节点效率高，适合频繁增删操作，缺点随机访问需要从头或尾翻阅，速度慢，且内存开销大
    }
}
class Me1401{
    public static void main(String[] args) {
        //Arraylist操作数据
        ///添加数据 add (Object obj)
        ArrayList list = new ArrayList();                  //创建集合对象
        list.add(10);                                       //object类型,基本上可以储存任何类型String,int
        list.add(11);
        list.add(12);
        list.add("==========");                            //list.add添加元素到末尾
        //遍历集合打印元素
        for (int i = 0; i < list.size();i++) {             //list.size当前集合里的元素个数
            System.out.println(list.get(i));               //list.get根据索引取元素
        }
        ///插入数据 add (int index,Object obj)
        list.add(2,1.5);                     //index要插入的索引位置，object任何元素类型
        for (int i = 0; i < list.size();i++) {             //下标索引1，索引1后面的元素整体向后移，留着索引1空着给新插入的集合
            System.out.println(list.get(i));
        }
        ///删除数据 remove (Object obj)
        ///删除整数数据 remove(Integer.valueOf(int))
        list.remove(Integer.valueOf(11));                ///如果集合储存整数，remove(2)会被java会当成index索引，而不是object元素
        for (int i = 0; i < list.size();i++) {             ///可以使用remove(Integer.valueOf(2)删除集合里面的整数元素
            System.out.println(list.get(i));
        }
        ///删除指定位置元素 remove (int index)
        list.remove(1);                              //index要删除的索引位置，object任何元素类型
        for (int i = 0; i < list.size();i++) {             //下标索引1，索引1删除后，后面的元素整体向前移，覆盖索引1
            System.out.println(list.get(i));
        }
        ///是否包含某个元素 list.contains(Object obj)
        if(list.contains(12)){
            System.out.println("Exist");                   //用if判断是否包含你要的元素
        } else {
            System.out.println("No exist");
        }
    }
}
class Me1402{
    public static void main(String[] args) {
        //定义集合保存图书信息
        //定义一个集合保存多本书
        //移步(ClassMe1400/Book.java)
        List list = new ArrayList();
        Book book1 = new Book("Sun of a Beach",40,"Mr.Brown");        //创建两本书对象
        Book book2 = new Book("Fried Melon",20,"Bryan");
        list.add(book1);                                                                //把书本信息添加到数组
        list.add(book2);
        //插入图书
        Book book3 = new Book("One Billion Dollars",60,"Marine");
        list.add(1,book3);

        //删除图书
        list.remove(book2);                                            //元素删除
        list.remove(1);                                          //索引删除

        //判断是否包含某个元素
        if(list.contains(book3)){
            System.out.println("Exist");
        } else {
            System.out.println("No exist");
        }
        for (int i = 0; i < list.size(); i++) {
            Book b = (Book)list.get(i);                                                 //把信息强制转换给b
            System.out.println(b);
        }
    }
}
class Me1403{
    public static void main(String[] args) {
        //LinkedList
        ///列表==========数据区+指针域
        //创建父类链表对象
        //移步(ClassMe1400/Book.java)
        LinkedList list = new LinkedList();
        Book book1 = new Book("Sun of a Beach",40,"Mr.Brown");        //创建三本书对象
        list.add(book1);                                                                 //把对象加入集合中
        Book book2 = new Book("Fried Melon",20,"Bryan");
        Book book3 = new Book("One Billion Dollars",60,"Marine");
        ///addFirst(Object obj)添加到第一个元素，后续元素往后移
        list.addFirst(book2);
        ///addLast(Object obj)添加到最后一个元素
        list.addLast(book3);
        //获取第一本书的名字
        ///getFirst()索取第一个元素
        Book first = (Book)list.getFirst();
        ///getLast()索取最后一个元素
        System.out.println(first.getName());
        //获取最后一本书的名字
        Book last = (Book)list.getLast();
        System.out.println(last.getName());
        System.out.println("================================");
        //删除第一本和最后一本书的名字
        ///removeFirst()删除第一个元素
        list.removeFirst();
        ///removeLast()删除最后一个元素
        list.removeLast();
        //
        for(int i = 0; i < list.size(); i++) {
            Book book = (Book)list.get(i);                                    //list get循环索取集合里的数组,然后强制转换给book对象
            System.out.println(book);
        }
    }
}
class Me1404{
    public static void main(String[] args) {
        //hashsets使用
        ///去重集合，储存无序，不允许重复的元素，输出顺序看起来随机
        ///存放对象的引用
        //移步(ClassMe1400/Book.java)
        Set set = new HashSet();                                                    //定义哈希集合
        Book book1 = new Book("Sun of a Beach",40,"Mr.Brown");   //创建书对象
        Book book2 = book1;                              //把书1赋给书2，都指向同一对象
        ///set.add(Object obj)添加去重
        set.add(book1);
        set.add(book2);                                  //添加两个一样的对象
        System.out.println(set.size());
        ///HashSet不允许重复元素，book1和book2是同一个对象，因此第二次add不会生效，集合中只有一个元素
    }
}
class Me1405{
    public static void main(String[] args) {
        ///Hashmap双列集合，既要提供key，也要提供value
        Map map = new HashMap();
        map.put("123","DBS Bank");                      ///map.put(key, value)将key对应的值放入value，若键已存在就覆盖原值
        map.put("ABC","ROS Bank");
        map.put("256","TMK Bank");
        //根据key获取value
        String value = (String)map.get("ABC");          ///map.get(指定key),把key强制转换赋给value变量
        System.out.println(value);
        System.out.println("======================");
        //获取key集合
        Set set = map.keySet();                         ///创建set对象，map.keySet()获取所有key
        System.out.println(set);
        System.out.println("======================");
        //获取value集合
        Collection values = map.values();              ///创建values对象，map.values()获取所有value
        System.out.println(values);
        System.out.println("======================");
        //获取key+value的集合
        System.out.println(map);                       ///map获取所有key+value
        System.out.println("======================");
        //获取map长度
        System.out.println(map.size());                ///map.size获取长度
        System.out.println("======================");
        //判断key是否存在
        if(map.containsKey("ABC")) {                   ///map.containsKey判断是否存在
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
        System.out.println("======================");
        ///使用Collection的Iterator迭代器遍历Map集合
        ///所有对象并非new出来的，可以通过对象方法创建对象
        Iterator iterator = set.iterator();            //注意这个set是key的集合
        while(iterator.hasNext()) {                    ///hasNext()判断是否有这个元素
            String key = (String) iterator.next();     ///如果有，next()获取该元素,强制转换给key
            String v = (String) map.get(key);          ///map.get()把上一行的String key强行转换给v
            System.out.println(key + " " + v);
        }
        ///Hashmap key value本质上就是String版数组，key为索引，value为元素，key可以是任何object类，存储范围极广
    }
}
class Me1406{
    public static void main(String[] args) {
        //泛型集合
        ///本质就是类型参数化
        ///能保存单一类型数据，一开始声明就进行类型检查，编译期报错，避免强制转换麻烦，使代码更简洁，维护效率更高
        ///编译阶段就能检查类型错误，避免运行时类型转换异常，所以在真实开发中推荐使用泛型
        //单列list
        //移步(ClassMe1400/Book.java)
        List<Book> list = new ArrayList<Book>();
        Book book1 = new Book("Sun of a Beach", 40, "Mr.Brown");
        list.add(book1);
        Book book2 = new Book("Fried Melon", 20, "Bryan");
        list.add(0, book2);                          //尝试放其他类型会报错，保证类型的单一性和安全性
        for (Book books : list) {
            System.out.println(books);
        }
        System.out.println("==================================");
        //双列map，因为有(key,value)
        Map<String, Book> map = new HashMap<String, Book>();
        map.put(book1.getName(), book1);                         //图书名称为key，value作为图书对象
        map.put(book2.getName(), book2);
        //如果希望遍历
        //方法1，用for循环key的集合
        Set<String> keys = map.keySet();                        //创建String keys对象
        for (String key : keys) {
            Book value = map.get(key);                          //用map.get(key)遍历对应的value对象
            System.out.println(value.getName() + " " + value.getAuthor());
        }
        System.out.println("====================================");
        //方法2，泛型map集合，通过获取所有值的集合打印所有元素
        Collection<Book> values = map.values();                 ///Collection : list和set三个都是接口的一种
        for (Book value : values) {
            System.out.println(value.getName() + " " + value.getAuthor());
        }
        System.out.println("====================================");
        //方法3，通过key+value方式 k+v = entry
        ///Map.entry<k，v>键值对对象 ///entrySet()Set集合，用于返回Map中所有entry
        Set<Map.Entry<String, Book>> entries = map.entrySet();
        for (Map.Entry<String, Book> entry : entries) {                //for迭代遍历，把集合丢给entry，然后调用book成员变量
            System.out.println(entry.getKey() + " " + entry.getValue().getAuthor());
        }
        System.out.println("=====================================");
        //方法4，Stream方式遍历
        ///Stream数据流，forEach流里元素操作工具
        Stream<Map.Entry<String, Book>> stream = map.entrySet().stream();
        stream.forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue().getAuthor()));
    }
}