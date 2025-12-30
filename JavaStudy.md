# Collection集合：

​																					`Collection`

​													`list<E>             	       		  Set<E>`

​						`ArrayList<E>  		LinkedList<E>		HashSet<E>   		TreeSet<E>`

​																							`LinkedHashSet<E>`

#### List系列集合： 添加的元素是有序、可重复、有索引

- ArrayList、LinkedList:有序、可重复、有索引

#### Set系列集合:添加的元素是无序、不重复、无索引

- HashSet：无序、不重复、无索引
- LinkedHashSet：有序、不重复、无索引
- TreeSet:按照大小默认升序排序、不重复、无索引

#### ArrayList和LinkedList区别：

- ArrayList底层是基于数组存储数据的；
- LinkedList底层是基于双向链表存储数据的；

#### 数组的特点：

- ​	查询速度快（根据索引查询数据快）：查询时数据通过地址值和索引定位，查询任意数据耗时相同。
- ​    增删效率低：需要将后面的数据前移。

#### ArrayList源码理解：

- 默认创建一个空数组。
- 在添加数据的时候直接创建一个长度为10的数组对象。
- 后续扩容都是1.5倍扩容。

#### 单向链表的特点：

- 由单个的结点组成的，结点在内存中是不连续的，每个结点半酣数据值和下一个结点的地址
- 查询比较慢（无论查哪个都要从头开始查）
- 增删数据相对数组来讲比较快

#### 双链表的特点：

- 双向链表在单链表的基础上每个数据增加了前一个结点的地址值。添加了头节点与尾结点。
- 对首尾元素的增删改查的速度是极快的。

#### 队列：

- 先进先出，后进后出

#### 栈：

- 先进后出，后进先出
- 压/进栈 （push）
- 弹/出栈 （pop）

#### 关键字transient

- java中代表序列的关键字。
- 详情可看[java中的transient关键字详解_java transient-CSDN博客](https://blog.csdn.net/qq_44543508/article/details/103232007)

#### HashSet:

- **哈希值**：就是一个int类型的随机值，java中的每一个对象都有一个哈希值.
- java中的所有对象，都可以调用Object类提供的hashCode方法，返回对象自己的哈希值.
	- 对象哈希值的特点：
		- 同一个对象多次调用hashCode方法返回的哈希值是相同的。
		- 不同的对象，它们的哈希值大概率不相等，也有可能会相等（哈希碰撞）。
		- int（-21亿多 ~ 21亿多）    =====   42亿
- **HashSet是基于哈希表存储数据的**
	- 哈希表：
		- jdk1.8前：哈希表= 数组+链表
			- 1.创建一个默认长度为16的数组，默认加载因子（负载因子）为0.75，数组名为table
			- 使用元素的哈希值对数组的长度做运算（可理解为取余运算，实际为位与运算）计算出对应存入的位置
			- 判断当前位置是否位null，如果是直接存入
			- 如果不为null，代表有元素，则调用equals方法比较
				- 相等则不存，不相等则存入数组
				- jdk8前：新元素存入数组，占老元素位置，老元素挂下面
				- jdk8后：新元素直接挂在老元素下面。
			- 哈希表的总长度达到了数组长度 * 负载因子 即扩容
		- jdk8后：**哈希表 = 数组+链表+红黑树**
			- 当链表长度超过8，且数组长度>= 64时，在自动将链表转为红黑树。
			- **二叉排序树**：https://img-blog.csdnimg.cn/020a2e7844454467b006a3a6a8ee2cf5.png
			- **平衡二叉树**：在满足查找二叉树的大小规则下， 让树尽可能矮小，以此提高查数据的性能。（左右子树的高度差不超过一）
			- **红黑树**:可自平衡的二叉树。
				- https://imgconvert.csdnimg.cn/aHR0cDovL2ltZy1ibG9nLmNzZG5pbWcuY24vMjAxOTAzMTExMDAxNTcxNS5wbmc?x-oss-process=image/format,png
				- 是一种增删改查效率都跟高的数据结构

#### LinkedHashSet：

- 依然基于哈希表实现的
- 它的每个元素都额外的多了一个双链表的机制，记录的他前后元素的位置。  

#### TreeSet:

- 特点:不重复、无索引、可排序（默认升序排序）
- 底层时基于红黑树实现的排序。
- 可自定义排序。

```java
/*
    * t2.compareTo(t1)
    * t2 == this  比较者
    * t1 == o 被比较者
    * 规定一： 如果认为左边大于右边，请返回正整数。
    * 规定二： 如果认为左边小于右边，请返回负整数。
    * 规定三： 如果认定左右相等，返回0。
    * 相等等于零时，不保存该条数据，如果想保存可以改变返回值
     */
    @Override
    public int compareTo(Teacher o) {
//        if (this.getAge() > o.getAge()) return 1;
//        if (this.getAge() < o.getAge()) return -1;
//        return 0;
        return this.getAge() - o.getAge();
//        return Double.compare(this.getSalary(), o.getSalary());
    }
```

# Map集合:

- Map集合也成为键值对集合：{Key1 ： value1，。。。。}

- Map集合的所有键是不允许重复的，但值可以重复。键和值是一一对应的，每一个键只能找到自己的值

	​												Map<K,V>

	​			HashMap<K,V> 			。。。			TreeMap<K,V>

LinkedHashMap<K,V>

#### 特点：

- Map系列集合的特点都是由键决定的，值只是一个附属品
- HashMap由键决定特点：无序、不重复、无索引（用的最多）
- LinkedHashMap ：有序、不重复、无索引
- TreeMap：按大小默认升序排序、不重复、无索引

#### 遍历：

- 键找值： keySet获取或有键，在集合中遍历用get方法取值
- 键值对：使用Entry接口实现将KV封装成一个对象。

```java
Set <Map.Entry<String ,Double>>  entries = map.entrySet();

for（Map.Entry<String,Double> entry : entries）{

}
```

- Lambda遍历：

```java
map.forEach(new BiConsumer<String, Integer>() {
    @Override
    public void accept(String s, Integer integer) {
        System.out.println(s + ":" + integer);
    }
});
 map.forEach((s, integer) -> System.out.println(s + ":" + integer));
```

# Stream流：

#### 认识：

- jdk8开始新增的一套API（java.util.stream.*）,可以用于操作集合或者数组的数据
- 优势：
	- Stream流大量的结合了Lambda的语法风格。
	- 功能强大，性能高效，代码简洁，可读性好。

#### 使用：

- 数据源（集合/数组...）
- 调用流水线的各种方法，对数据进行处理计算。
- 获取处理的结果。

```java
//        获取Stream流
//        1.获取集合的Stream流，调用stream()方法
        Collection<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

//        2.Map的Stream流，调用stream()方法
        Map<String, String> map = new HashMap<>();
        Stream<String> stream1 = map.values().stream();
        Stream<String> stream2 = map.keySet().stream();
        Stream<Map.Entry<String, String>> stream3 = map.entrySet().stream();

//        3.数组获取Stream流，调用Arrays.stream()方法
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        IntStream stream4 = Arrays.stream(arr);
        
//        public static <T> Stream<T> of(T... values)
        Stream<String> stream5 = Stream.of("张三", "张三丰", "张无忌", "张三", "张强");
        
```

- 三个点参数为可变参数。

```java
        list2.stream().sorted().forEach(System.out::println);  // 升序
        list2.stream().sorted((o1, o2) -> o2.compareTo(o1)).limit(2).forEach(System.out::println); // 降序 并取前两个
        list2.stream().sorted((o1, o2) -> o2.compareTo(o1)).skip(2).forEach(System.out::println);  // 降序 并跳过前两个
//        如果自定义对象要去重复，则需要重写equals和hashCode方法
        list2.stream().sorted((o1, o2) -> o2.compareTo(o1)).distinct().forEach(System.out::println);  // 去重
//        加工方法（映射方法） 将流上原来的数据拿出来，进行加工，返回加工后的数据
        list2.stream().map(s -> "加10分后" + (s + 10)).forEach(System.out::println);
//        合并流
        Stream<String> s1 = Stream.of("张无忌", "周芷若", "赵敏");
        Stream<String> s2 = Stream.of("张强", "张三丰", "张翠山");
        Stream<Integer> s3 = Stream.of(1, 2, 3);
        Stream<Object> s4 = Stream.concat(s2, s3);
        s4.forEach(System.out::println);
```

- #### 终结方法（常用的四种）：

```java
        list.stream().filter(t -> t.getSalary() > 5000).forEach(System.out::println);

        System.out.println("=============================================================");

        long count = list.stream().filter(t -> t.getSalary() > 5000).count();
        System.out.println(count);

        System.out.println("=============================================================");

        List<Teacher> list2 = list.stream().filter(t -> t.getSalary() > 5000).collect(Collectors.toList());
        System.out.println(list2);

        System.out.println("=============================================================");

//        Optional<T> max(Comparator<? super T> comparator)   Optional可放任何对象包括null
        Optional<Teacher> max = list.stream().max((t1, t2) -> Double.compare(t1.getSalary(), t2.getSalary()));
        Teacher teacher = max.get();   // get()方法可拿到数据
        Teacher max1 = list.stream().max((t1, t2) -> Double.compare(t1.getSalary(), t2.getSalary())).get();
        System.out.println(max1);
        
        System.out.println("=============================================================");
        Optional<Teacher> min = list.stream().min((t1, t2) -> Double.compare(t1.getSalary(), t2.getSalary()));
        System.out.println(min.get());  
```

- #### 收集Stream流

```java
//       收集到集合或者数组中。
//        流只能收集一次，第二次收集会报错。
        List<String> list4 = list3.stream().map(Teacher::getName).collect(Collectors.toList());
        System.out.println(list4);

    //      收集到Set集合中
        Set<String> set = list3.stream().map(Teacher::getName).collect(Collectors.toSet());
        System.out.println(set);

//        收集到数组中
        String[] arr = list3.stream().map(Teacher::getName).toArray(String[] :: new);
        System.out.println(Arrays.toString(arr));

        System.out.println("============================收集到Map集合=============================");
        Stream<Teacher> s = list.stream().sorted((t1, t2) -> Double.compare(t1.getSalary(), t2.getSalary()));
//        收集到Map集合，键是老师名称，值是老师薪水
        Map<String, Double> map = s.collect(Collectors.toMap(Teacher::getName, Teacher::getSalary));
        
        Map<String, Double> map1 = s.collect(Collectors.toMap(t -> t.getName(), t -> t.getSalary()));
        System.out.println(map);
```

# 方法中的可变参数：

- 是一种特殊形参，定义在方法、构造器的形参列表，格式是： 数据类型... 参数名称；
- 特点： 可以不传参数给它，可以穿一个或者同时传多个参数，也可以传一个数据。
- 好处：常常用来灵活的接收数据。

```java
    public static void main(String[] args) {
//        可变参数：
        show();
        show(1,2,3,4,5,6,7,8,9,10);
        show(new int[]{1,2,3,4,5,6,7,8,9,10});
    }
//    可变参数只能有一个，而且只能是参数列表的最后一个参数
    public static void show(int... a) {
//        内部怎么拿数据
//        可变参数对内其实就是一个数组，a就是数组
        for (int i : a) {
            System.out.println(i);
        }
    }
```

# Collections工具类：

- addAll(Collection<? super T> c  , T...  elements)   给单列集合批量添加元素
- shuffle(List<?> list)   打乱List集合的元素顺序
- sort(List<T>  list)  对List集合中的元素进行升序排序
- sort(List<T> list , Comparator<? super T> c)  对List集合中元素按照比较器对象指定的规则进行排序

# File:

- File类的对象可以代表文件/文件夹，并可以调用其提供的方法对象文件进行操作。

- File对象既可以代表文件，也可以代表文件夹。

- File封装的对象仅仅是一个路径名，这个路径可以是存在的，也允许是不存在的。

- 绝对路径：只要带盘符的都称之为绝对路径。

- 相对路径:   不带盘符的。默认时到idea工程下直接寻找文件，一般用来找工程下的文件

- 可以创建对象代表不存在的文件（文件夹（一级文件夹）），再新建这个文件（文件夹）。

- 可以创建对象代表存在的文件或目录  只能删除空文件或文件夹，并不会进回收站，直接删除。

- #### 遍历

  - listFiles()方法遍历文件。

  - ##### 使用listFiles方法的注意事项：

  	- 当主调是文件，或路径不存在时，返回null；
  	- 当主调是空文件夹时，返回一个长度为0的数组；
  	- 当主调是一个有内容的文件夹是，将里面所有一级文件和文件夹的路径放在File数组中放回；
  	- 当主调是一份文件夹，且里面有隐藏文件时，将里面所有文件和文件夹的路径放在File数组中返回，包含隐藏文件。
  	- 当主调是一个文件夹，但是没有权限访问该文件夹时，返回null；

- #### 递归算法：

  - 方法调用自身的形式称为方法递归。
  - 递归死循环：无结束条件。导致栈内存溢出。
  - 公式： f(n) = f(n-1) * n;
  - 递归的终结点：1
  - 递归的方向必须走向终结点；

# 字符集：

- **GBK** ：汉字编码字符集，包含了2万多个汉字等字符，GBK中一个中文字符编码成两个字节的形式存储。
- GBK兼容了ASCII字符集。
- 规定：汉字的第一个字节的第一位必须是1.
- Unicode字符集（统一码，也称万国码）
- **UTF-8字符集**：
	- 是Unicode字符集的一种编码方案，采取可变长编码方案。
	- 公分四个长度区：1个字节区，2个字节区，3个字节区，4个字节区。
	- 英文字符、数字等只占1个字节（兼容标准ASCII码）汉字字符占三个字节。
	- 0xxxxxxx     (ASCII码) 1字节区
	- 110xxxxx     10xxxxxx     2字节
	- 1110xxxx     10xxxxxx     10xxxxxx     3字节
	- 11110xxx     10xxxxxx     10xxxxxx     10xxxxxx

# IO流：

- #### 按照流的方向可分为：

	- ##### 输入流

	- ##### 输出流

- #### 按照流的内容可分为：

	- ##### 字节流：

		- 适合操作索里有类型的文件
		- 适合做文件的复制的操作。（任何文件的底层都是字节，字节流做复制，可以一字不漏的转移全部字节，复制前后的文件格式一定要相同）

	- ##### 字符流：

		- 只适合操作纯文本文件

- #### 四大金刚：

	- ##### 字节输入流

		- 以内存为基准，可以把磁盘文件中的数据以字节的形式读入到内存中
		- InputStream(抽象类)
		- FileInputStream（实现类）

	- ##### 字节输出流

		- 以内存为基准，可以把内存中的数据以字节的形式写出到文件中
		- OutputStream(抽象类)
		- FileOutputStream（实现类）

	- ##### 字符输入流

		- 以内存为基准，可以把磁盘文件中的数据以字符的形式读入到内存中
		- Reader(抽象类)
		- FileReader（实现类）

	- ##### 字符输出流

		- 以内存为基准，可以把内存中的数据以字符的形式写出到文件中
		- Writer(抽象类)
		- FileWriter（实现类）

- #### try—with—resource:

	```java
	try (
	    //资源
	) {
	    //执行代码
	    }
	}
	```

	- 资源：一般指的是最终实现了AutoCloseable接口
	- 会自动执行close方法关闭流。

- ##### 刷新流或者关闭流写出去的数据才能生效

	- **flush()**;   //刷新缓冲区，将缓冲区的数据全部写出去   刷新后，流可以继续使用
	- **close()**;   //关闭资源，关闭包含了刷新，关闭后流不可继续使用
	- 写满内存缓冲区才调用一次IO进行写入

- ##### 缓冲流：

	- **BufferedInputStream**等
	- 先向内存中存入8kb的数据，然后字节数组从内存中直接读取。性能提升
	- 从字节数组中读取8kb的数据，然后直接向目标地址放入8kb数据。
	- 其余缓冲流与缓冲字节输入流相同

- ##### 字符输入转换流

	- 继承自字符输入流
	- 解决不同编码时，字符流读取文本内容乱码的问题。
	- 先获取文件的原始字节流，再讲其按真是得分字符集编码转成字符输入流，这样字符输入流中的字符就不乱码了。

- ##### 打印流

	- *PrintStream*
	- *PrintWriter*
	- 打印流可以实现更方便、更高效的打印数据出去，能实现打印啥出去就是啥。

- ##### 特殊数据流

	- *DataOutputStream*（数据输出流）
		- 允许把数据和类型一并写出去
	- *DataInputStream*（数据输入流）
		- 允许把数据和类型一并写进来
		- 不可跳位读取，必须怎么发怎么读

- ##### 框架：

	- 是一个预先写好的代码库或一组工具，旨在简化和加速开发过程。

	- IO框架

# 多线程：

- #### 创建线程:

  - ##### 继承Thread类

  	- 优缺点：
  		- 编码简单
  		- 线程类已经继承了Thread，无法继承其他的类，不利于功能的拓展。
  	- 启动是必须调用**start()**方法，而不是run()
  		- 直接调用run方法会当成普通方法执行，此时相当于还是单线程执行。
  		- 只有调用start方法才是启动一个新的线程执行。
  		- 不要把主线程任务放在启动子线程之前。

  - ##### 实现Runnable接口：

  	- 优缺点：
  		- 任务类只是实现接口，可以继续继承其他类，实现其他接口，扩展性强。
  		- 需要多一个Runnable对象。
  	- 可创建匿名内部类

  - ##### 实现Callable接口：

  	- 前两种方法不可返回数据。
  	- 优缺点：
  		- 线程任务类只是实现接口，可以继续继承类和实现接口，拓展性强；
  		- 可以在线程执行完毕后获取线程执行的结果。
  		- 编码复杂。
  	- 创建方式：
  		- 1.创建任务对象
  			- 定义一个类实现Callable接口，重写call方法，封装要做的事情和要返回的数据。
  			- 把Callable类型的对象封装成FutureTask（线程任务对象）。
  		- 2.把线程任务对象交给Thread对象。
  		- 3.调用Thread对象的start方法启动线程。
  		- 线程执行完毕后，通过FutureTask对象的**get方法**去获取线程任务执行的结果。
  		- 如果主线程发现第一个线程还没有执行完毕，会让出cpu，等第一个线程执行完毕，再获取结果。

- ##### 线程常用方法：

  - 默认的线程名为：Thread- 索引；

  - 主线程名字就叫main； 

  	- ```java
  		Thread m2 = Thread.currentThread();
  		```

  - 获取名字：getName();

  - 设置名字： setName();或调用有参构造器实现设置名字。

- ##### 线程安全问题：

  - 多个线程，同时操作同一个共享资源的时候，可能会出现业务安全问题。					

- ##### 线程同步：

	- **同步代码块**：

		- synchronized(与线程是唯一对象)

		- 锁对象的使用规范：

			- 建议使用共享资源作为锁对象，对于实例方法，建议**使用this作为锁对象**。

			- ```java
				public void drawMoney(double d) {
				    synchronized (this) {
				        if (d <= money) {
				            System.out.println(Thread.currentThread().getName() + "取钱成功，取钱金额：" + d);
				            money -= d;
				            System.out.println("余额为：" + money);
				        } else {
				            System.out.println(Thread.currentThread().getName() + "取钱失败，余额不足");
				        }
				    }
				}
				```

			- 对于静态方法建议**使用字节码（类名.class）对象作为锁对象**。

			- ```java
				public static void drawMoney(double d) {
				    synchronized (Account.class) {
				        if (d <= money) {
				            System.out.println(Thread.currentThread().getName() + "取钱成功，取钱金额：" + d);
				            money -= d;
				            System.out.println("余额为：" + money);
				        } else {
				            System.out.println(Thread.currentThread().getName() + "取钱失败，余额不足");
				        }
				    }
				}
				```

	- **同步方法**：

		- 把访问共享资源的核心方法上锁，以此保证线程安全。

		- ```java
			    public synchronized void drawMoney(double d) {
			        if (d <= money) {
			            System.out.println(Thread.currentThread().getName() + "取钱成功，取钱金额：" + d);
			            money -= d;
			            System.out.println("余额为：" + money);
			        } else {
			            System.out.println(Thread.currentThread().getName() + "取钱失败，余额不足");
			        }  
			    }
			```

		- 底层原理：
			- 同步方法其实底层也是由隐式锁对象的，只是**锁的范围是整个方法代码**。
			- 如果方法是实例方法，同步方法默认用this做锁对象。
			- 如果是静态方法，同步方法默认用字节码做锁对象。

	- ##### Lock锁：

		- Lock锁是JDK5开始提供的一个新的锁定操作，通过它可以创建出所兑现那个进行加锁和解锁，更灵活、更方便、更强大。
		- Lock是接口，不能直接实例化，可以采用他的实现类ReentrantLock来构建Lock锁对象。

```java
//    定义锁
    private final Lock lk = new ReentrantLock();   //final 修饰锁对象，保证锁对象不会被修改
//    两人都在这里取钱
    public void drawMoney(double d) {
        lk.lock();
        try {
            if (d <= money) {
                System.out.println(Thread.currentThread().getName() + "取钱成功，取钱金额：" + d);
                money -= d;
                System.out.println("余额为：" + money);
            } else {
                System.out.println(Thread.currentThread().getName() + "取钱失败，余额不足");
            }
        } finally {
            lk.unlock();
        }

    }
```

**线程池：**

- 是一个可以复用线程的技术。
- **创建线程池:**
	- 接口：ExecutorService
		- 实现类：ThreadpoolExecutor
			- 参数一：corePoolSize：指定线程池的核心线程数量。
			- 参数二：maximumPoolSize：指定线程池的最大线程数量。
			- 参数三：keepAliveTime：指定临时线程的存活时间。
			- 参数四：unit：指定临时线程存活的时间单位（时分秒天）
			- 参数五：workQueue：指定线程池的任务队列。
			- 参数六：threadFactory：指定线程池的线程工厂。
			- 参数七：handler：指定线程池的任务拒绝策略（线程都在忙，任务队列也满了的时候，新任务怎么处理）。
		- 创建临时线程：
			- 新任务提交时发现核心线程都在忙，任务队列也满了，并且还可以创建临时线程。
		- 拒绝策略：
			- 核心线程和临时线程都在忙，任务队列也满了，就拒绝。

```java
   1.使用实现类ThreadPoolExecutor声明七个参数来创建线程池对象
        ThreadPoolExecutor threadPoolDemo = new ThreadPoolExecutor(3,5
        ,10, TimeUnit.SECONDS,new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        Runnable target = new MyRunnableDemo();
        threadPoolDemo.execute(target);
        threadPoolDemo.execute(target);
        threadPoolDemo.execute(target);
        threadPoolDemo.execute(target); //复用线程
        threadPoolDemo.execute(target); //复用线程

//        关闭线程池，一般不关闭线程池
//        threadPoolDemo.shutdown(); //等所有任务执行完毕，再关闭线程池
        threadPoolDemo.shutdownNow(); //不等所有任务执行完毕，就关闭线程池
```

- 工具类：Executors

### 线程池核心线程配置原则：

- **CPU 密集型任务**
	- **核心线程数: corePoolSize = CPU核心数 + 1**
	- 最大线程数: 与核心线程数相同或略高
	- 原因：CPU密集型任务会大量占用CPU资源，过多线程会导致频繁上下文切换，降低性能
- **I/O 密集型任务**
	- **核心线程数: corePoolSize = CPU核心数 * 2 或更高**
	- 最大线程数: 可以设置得较高，因为I/O操作不会一直占用CPU
	- 原因：I/O密集型任务经常等待I/O完成，可以利用更多线程提高并发度

# 进程：

- 正在运行的程序就是一个独立的进程。
- 线程是属于进程的，一个进程中可以同时运行很多个线程。
- 进程中的多个线程其实是并发和并行执行的。

# 并发/并行：

- ##### 并发的含义：

	- 进程中的线程时由CPU负责调度执行的，但CPU能同时处理线程的数量有限，为了保证全部线程都能往前执行，CPU会轮询为系统的每个线程服务，由于CPU切换的速度很快，给我们的感觉这些线程在同时执行，这就是并发。

- ##### 并行的含义：

	- 在同一时刻上，同时有多个线程在被CPU调度执行。

# JAVA网络编程：

- 可以让设备中的程序与网络上的其他设备中的程序进行数据交互的技术。

- ### 基本通信架构：

  - **CS架构**（Client客户端/Server服务端）
  - **BS架构**（Browser浏览器/Server服务端）

- ##### IP地址

  - 全称：“互联网协议地址”，是分配给上网设备的唯一标识。

  - 广泛采用的两种地址形式：IPV4、IPV6.

  - ##### IPV4:

  	- **32位标记地址**，通常以**点分十进制**表示。

  - ##### IPV6:

  	- **128位标记地址**，以**冒分十六进制**表示。

  - ##### IP域名：

  	- ##### DNS域名解析器：

  		- 是互联网中用于将域名转换为对应IP地址的分布式命名系统。

  - ##### 公网IP：

  	- 是可以连接到互联网的IP地址。

  - ##### 内网IP:

  	- 也称局域网IP，是只能组织结构内部使用的IP。
  	- 常见的局域网地址范围：
  		- 192.168.0.0 -- 192.168.255.255.

- ##### 端口

  - 标记正在设备上运行的应用程序。

  - 规定为**16位的二进制**，范围为：**0~65535.**

  - ##### 周知端口:

  	- **0~1023**，被预先定义的知名应用占用（如HTTP占用80，FTP占用21）

  - ##### 注册端口：

  	- **1024~49151**,分配给用户进程或某些应用程序
  	- 一般都是用注册端口，且一个设备中不能出现两个程序的端口号一样。

  - ##### 动态端口：

  	- **49152~65535**，之所以被称为动态端口，是因为他一般不固定分配某种进程，而是动态分配。

- ##### 协议

  - 网络上通信的设备，事先规定的连接规则，以及传输数据的规则被成为网络通信协议。

  - 开放式网络互联标准：**OSI网络参考模型**。

  - **TCP/IP网络模型**:

    - 特点：**面向连接、可靠通信**。

    - TCP的最终目的：**要保证在不可靠的信道上实现可靠的数据传输**。

    - #### 三次握手：

      - 可靠连接：**全双工模式**。
      - 最开始的时候客户端和服务器都是处于CLOSED关闭状态。**主动打开连接的为客户端，被动打开连接的是服务器**。
      - TCP服务器进程先创建传输控制块TCB，时刻准备接受客户进程的连接请求，此时服务器就进入了 **LISTEN** 监听状态
      - **第一次握手** ：TCP客户进程也是先创建传输控制块TCB，然后向服务器发出连接请求报文，这是报文首部中的同部位**SYN=1**，同时选择一个初始序列号 **seq=x** ，此时，TCP客户端进程进入了 **SYN-SENT 同步已发送状态**
      - **第二次握手** ：TCP服务器收到请求报文后，如果同意连接，则会向客户端发出确认报文。确认报文中应该 **ACK=1**，**SYN=1**，**确认号是ack=x+1**，同时也要为自己**初始化一个序列号 seq=y**，此时，TCP服务器进程进入了 **SYN-RCVD 同步收到状态**
      - **第三次握手** ：TCP客户端收到确认后，还要向服务器给出确认。确认报文的**ACK=1，ack=y+1，自己的序列号seq=x+1**，此时，TCP连接建立，客户端进入**ESTABLISHED已建立连接状态** 触发三次握手

    - #### 四次挥手：

      - 数据传输完毕后，双方都可释放连接。最开始的时候，客户端和服务器都是处于**ESTABLISHED状态**，然后客户端主动关闭，服务器被动关闭。

      - 第一次挥手 客户端发出连接释放报文，并且停止发送数据。释放数据报文首部，**FIN=1**，其序列号为**seq=u**（等于前面已经传送过来的数据的最后一个字节的序号加1），此时，客户端进入**FIN-WAIT-1（终止等待1）状态**

      - 第二次挥手 服务器端接收到连接释放报文后，发出确认报文，**ACK=1，ack=u+1**，并且带上自己的序列号seq=v，此时，服务端就进入了**CLOSE-WAIT 关闭等待状态**

      - 第三次挥手 客户端接收到服务器端的确认请求后，客户端就会进入**FIN-WAIT-2（终止等待2）状态**，等待服务器发送连接释放报文，服务器将最后的数据发送完毕后，就向客户端发送连接释放报文，服务器就进入了**LAST-ACK（最后确认）状态**，等待客户端的确认。

      - 第四次挥手 客户端收到服务器的连接释放报文后，必须发出确认，**ACK=1**，ack=w+1，而自己的序列号是**seq=u+1**，此时，客户端就进入了**TIME-WAIT（时间等待）状态**，但此时TCP连接还未终止，必须要经过**2MSL后（最长报文寿命）**，当客户端撤销相应的TCB后，客户端才会进入CLOSED关闭状态，服务器端接收到确认报文后，会立即进入CLOSED关闭状态，到这里TCP连接就断开了，四次挥手完成

    - ##### B/S架构原理：

    	- 服务器必须给浏览器响应HTTP协议规定的数据格式，否则浏览器不识别返回的数据。
    	- HTTP协议规定
    		- 协议版本/空格/状态码/空格/状态符  回车换行
    		- 头部字段名：值；   回车换行
    		- .......；                       回车换行
    		- 头部字段名：值；    回车换行
    		- **必须单独换一行**
    		- 响应正文

  - **UDP协议**:

    - 特点：**无连接、不可靠通信**。
    - 不事先建立连接，数据按照包法，一包数据包含：**自己的IP、端口、目的地IP、端口和数据**（限制在64kb内）
    - 发送方不管对象是否在线，数据在中间丢失也不管，如果接收方收到数据也不返回确认，所以是不可靠的。

# Time：

- ```java
	    Date date = new Date();
	        System.out.println(date);
	
	//        格式化：SimpleDateFormat
	        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
	        String format = sdf.format(date);
	        System.out.println(format);
	
	//        jdk8 新特性：LocalDate、LocalTime、LocalDateTime
	        LocalDateTime localTime = LocalDateTime.now();
	        System.out.println(localTime);
	
	//        格式化：
	        System.out.println(localTime.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss EEE a")));
	```

# 字符串高效拼接：

- #### StringBuilder：对象是可变内容的容器，底层是基于数组实现的。

	- 只是拼接字符串的手段，结果还是要恢复成字符串。

	- 支持链式编程。

	- ```java
		StringBuilder sb = new StringBuilder();
		sb.append(s1).append(s2);
		System.out.println(sb);
		```

# BigDecimal：

- 用于解决浮点型运算，出现**结果失真**的问题。

- 浮点数存储的时候，会进行四舍五入。底层存储小数时只能无限靠近于这个数，无法直接计算出该数。

- ```java
	//        使用BigDecimal  BigDecimal(String val)
	        BigDecimal bd1 = new BigDecimal("0.05");
	        BigDecimal bd2 = new BigDecimal("0.01");
	        //优化
	        BigDecimal a1 = BigDecimal.valueOf(0.05);
	        BigDecimal a2 = BigDecimal.valueOf(0.01);
	        System.out.println( (a1.add(a2)).doubleValue());
	//        除法
	        System.out.println(bd1.divide(bd2,2,BigDecimal.ROUND_HALF_UP));
	```

# Junit单元测试：

- ```java
	//    测试方法：必须是公开public、无参、无返回值的
	//    测试方法必须加@Test注解
	    @Test
	    public void test1() {
	
	        StringUtil.printNumber("123");
	        StringUtil.printNumber("123.456");
	        StringUtil.printNumber("123.456.789");
	        StringUtil.printNumber(null);
	    }
	    @Test
	    public void test2() {
	
	        System.out.println(StringUtil.printMaxIndex("123"));
	        System.out.println(StringUtil.printMaxIndex("123.456"));
	        System.out.println(StringUtil.printMaxIndex("123.456.789"));
	
	        System.out.println(StringUtil.printMaxIndex(null));
	
	        //做断言测试：测试结果是否与预期结果一致
	        Assertions.assertEquals(StringUtil.printMaxIndex("123"), 3, "测试结果不一致");
	        Assertions.assertEquals(StringUtil.printMaxIndex("123.456"), 7, "测试结果不一致");
	        Assertions.assertEquals(StringUtil.printMaxIndex("123.456.789"), 10, "测试结果不一致");
	        Assertions.assertEquals(StringUtil.printMaxIndex(null), -1, "测试结果不一致");
	        assert StringUtil.printMaxIndex("123") == 3;
	        assert StringUtil.printMaxIndex("123.456") == 7;
	        assert StringUtil.printMaxIndex("123.456.789") == 10;
	        assert StringUtil.printMaxIndex(null) == -1;
	```

- 单元测试中某个方法测试失败了，不会影响其他测试方法的测试。
- Junit可以选择执行哪些测试方法，可以一键执行全部测试方法的测试。
- Junit可以生成测试报告，如果测试良好是绿色；如果测试失败则是红色。

# 反射：

- **加载类，并允许以编程的方式解剖类中的各种成分**

	1. 加载类，获取类的字节码：class对象。

		- 获取Class对象的三种方式：

			- Class c1 = 类名.class

			- 调用Class提供的方法：public static Class forName(String package);

			- Object提供的方法：public Class getClass();     Calss c3 = 对象.getClass();

			- ```java
				//        反射第一步：获取Class对象
				//        1.获取类本身，类名.class
				        Class c1 = studentDemo.class;
				//        2.获取类本身，class.forName("类名")
				        Class c2 = Class.forName("com.Reflect.studentDemo");
				        //3.获取对象，对象.getClass()
				        studentDemo s = new studentDemo();
				        Class c3 = s.getClass();
				```

	2. 获取类的构造器：Constructor对象。

		- ```java
			  @Test
			    public void getConstructor() throws Exception {
			//        2.获取构造方法
			        Class c1 = studentDemo.class;
			        System.out.println(c1.getConstructors());   //获取共有的构造方法
			        System.out.println(c1.getDeclaredConstructors());  //获取所有构造方法
			        System.out.println(c1.getConstructor(String.class, int.class));   //获取指定共有的构造方法
			        System.out.println(c1.getDeclaredConstructor(String.class));  //获取指定的构造方法
			
			//        5.获取构造器的作用：依然是创建对象
			//        私有构造器,方法,属性可以暴力反射,直接访问
			        Constructor constructor = c1.getConstructor();//获取无参构造方法
			        constructor.setAccessible(true); //暴力反射
			        Object obj = constructor.newInstance();
			        studentDemo s = (studentDemo) constructor.newInstance();  //创建对象
			    }
			```

	3. 获取类的成员变量：Field对象

		- ```java
			 @Test
			    public void getField() throws Exception {
			        //3.获取成员变量
			        Class c1 = studentDemo.class;
			        Field[] files = c1.getDeclaredFields();
			        for (Field f : files){
			            System.out.println(f.getName() + "(" + f.getType().getName() + ")");
			        }
			        //获取指定成员变量
			        Field f = c1.getDeclaredField("name");
			        System.out.println(f.getName() + "(" + f.getType().getName() + ")");
			
			//        6.获取成员变量的目的：获取成员变量的值，修改成员变量的值
			        Field name = c1.getDeclaredField("name");
			        name.setAccessible(true);   //绕过访问权限修饰符,暴力反射
			        studentDemo s = new studentDemo();
			        name.set(s,"张三");
			        System.out.println(name.get(s));
			        System.out.println(s.getName());
			    }
			```

	4. 获取类的成员方法：Method对象。

		- ```java
			@Test
			public void getMethod() throws Exception {
			    //4.获取成员方法
			    Class c1 = studentDemo.class;
			    Method[] methods = c1.getDeclaredMethods();
			    for (Method m : methods){
			        System.out.print(m.getName() + "(");
			        Class[] params = m.getParameterTypes();
			        for (Class c : params){
			            System.out.print(c.getName() + ",");
			        }
			        System.out.println(")");
			    }
			    //获取指定成员方法
			    Method m = c1.getDeclaredMethod("getAge");
			    System.out.print(m.getName() + "(");
			    Class[] params = m.getParameterTypes();
			    for (Class c : params){
			        System.out.print(c.getName() + ",");
			    }
			    System.out.println(")");
			
			    //获取成员方法的作用：获取方法值，调用方法
			    Method m1 = c1.getDeclaredMethod("getAge");
			    m1.setAccessible(true);
			    studentDemo s = new studentDemo();
			    int age = (int) m1.invoke(s);  //唤醒s对象的getAge方法 ,相当于调用s.getAge()
			    System.out.println(age);
			}
			```

- ##### 	作用、应用场景：

	- 可以得到一个类的全部成分然后操作。

	- 可以破坏封装性。

	- 可以绕过泛型的约束。

	- **最重要的用途：适合做Java的框架，基本上，主流的框架都会基于反射设计出一些通用的功能。**

	- ```java
		//       反射的基本作用：
		//        1.获取类的全部成分
		//        2.可以破坏封装性
		//        3.可以绕过泛型的约束
		        ArrayList<String> list = new ArrayList<>();
		        list.add("hello");
		        list.add("world");
		        list.add("java");
		
		        Class c1 = list.getClass();
		        Method add = c1.getDeclaredMethod("add", Object.class);
		        add.invoke(list,100);   //翻墙加入100
		        System.out.println(list);
		```

# 注解：

- 就是Java代码里的特殊标记，作用就是：**让其他程序根据注解信息来决定怎么执行该程序**。

- 注解可以用在类、构造器、方法、成员变量、参数等位置上。

- **自定义注解：**

  - ```java
  	@XiaoRuiFristAnnotation(name = "小锐", age = 18, address = {"北京", "上海"})
  	@ScondAnnotation("delete")
  	public class AnnotationDemo {
  	    @XiaoRuiFristAnnotation(name = "王菲", age = 50, address = {"香港", "上海"})
  	    public static void main(String[] args) {
  	        
  	    }
  	}
  	```

  - 特殊属性名：**value**

  	- 如果注解中只有一个value属性，使用注解时，value名称可以不写；

  - 注解本质时一个接口，Java中所有注解都是继承了Annotation接口的。

  - @注解(...)：其实就是一个**实现类对象**，实现了该注解以及Annotation接口。

- **元注解：**

	- 注解注解的注解。
	- **@Target(ElementType.xxx)**
		- 声明被修饰的注解只能在哪些位置使用
			- TYPE:类、接口
			- FIELD：成员变量
			- METHOD:成员方法
			- PARAMETER:方法参数
			- CONSTRUCTOR:构造器
			- LOCAL_VARIABLE:局部变量
	- **@Retention(RetentionPolicy.xxx)**
		- 声明注解的保留周期
			1. SOURCE:只作用在源码截断，字节码文件中不存在。
			2. CLASS(默认值): 保留到字节码文件阶段，运行阶段不存在。
			3. RUNTIME(开发常用):一直保留到运行阶段。

- ##### 注解的解析：

	- 判断类、方法、成员变量上是否存在注解，并把注解里的内容解析出来。

# 动态代理：

- 找个经纪人代替做一些事情

- ```java
	//代理工具类
	public class ProxyUtil {
	    //创建一个明星对象的代理对象返回
	    public static StarService getProxyInstance(Star obj){
	        /**
	         * 参数一：用于执行用哪个类加载器去加载生成的代理类
	         * 参数二：用于指定代理对象实现哪个接口
	         * 参数三：用于提供代理对象方法调用的实现
	         */
	        StarService proxy = (StarService) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(),
	                obj.getClass().getInterfaces(), new InvocationHandler() {
	                    @Override
	                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	                        //用来声明代理要干的活
	                        //参数一：代理对象本身
	                        //参数二：代理对象要调用的方法
	                        //参数三：代理对象要调用的方法的参数
	                        if (method.getName().equals("sing")){
	                            System.out.println("准备话筒，收钱20w");
	                        } else if (method.getName().equals("dance")) {
	                            System.out.println("准备场地，收钱100w");
	                        }
	                        //把明星对象叫过来干过
	                        Object invoke = method.invoke(obj, args);
	                        return invoke;
	                    }
	                });
	        return proxy;
	    }
	}
	```
