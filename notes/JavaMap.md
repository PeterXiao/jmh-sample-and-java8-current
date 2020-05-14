# Java

## 什么是 Java？
  Java 是 Sun Microsystems 于1995 年首次发布的一种编程语言和计算平台。编程语言还比较好理解，那么什么是 计算平台 呢？

计算平台是在电脑中运行应用程序（软件）的环境，包括硬件环境和软件环境。一般系统平台包括一台电脑的硬件体系结构、操作系统、运行时库。

    Java 是快速，安全和可靠的。 从笔记本电脑到数据中心，从游戏机到科学超级计算机，从手机到互联网，Java 无处不在！Java 主要分为三个版本

* JavaSE(J2SE)(Java2 Platform Standard Edition，java平台标准版）
* JavaEE(J2EE)(Java 2 Platform,Enterprise Edition，java平台企业版)
* JavaME(J2ME)(Java 2 Platform Micro Edition，java平台微型版)。

## Java的特点
* Java 是一门面向对象的编程语言

什么是面向对象？面向对象(Object Oriented) 是一种软件开发思想。它是对现实世界的一种抽象，面向对象会把相关的数据和方法组织为一个整体来看待。

相对的另外一种开发思想就是面向过程的开发思想，什么面向过程？面向过程(Procedure Oriented) 是一种以过程为中心的编程思想。举个例子：比如你是个学生，你每天去上学需要做几件事情？

* Java 摒弃了 C++ 中难以理解的多继承、指针、内存管理等概念；不用手动管理对象的生命周期，这是特征二。
* Java 语言具有功能强大和简单易用两个特征，现在企业级开发，快速敏捷开发，尤其是各种框架的出现，使 Java 成为越来越火的一门语言。这是特点三。
* Java 是一门静态语言，静态语言指的就是在编译期间就能够知道数据类型的语言，在运行前就能够检查类型的正确性，一旦类型确定后就不能再更改，比如下面这个例子。

静态语言主要有 Pascal, Perl, C/C++, JAVA, C#, Scala 等。

相对应的，动态语言没有任何特定的情况需要指定变量的类型，在运行时确定的数据类型。比如有**Lisp, Perl, Python、Ruby、JavaScript **等。

从设计的角度上来说，所有的语言都是设计用来把人类可读的代码转换为机器指令。动态语言是为了能够让程序员提高编码效率，因此你可以使用更少的代码来实现功能。静态语言设计是用来让硬件执行的更高效，因此需要程序员编写准确无误的代码，以此来让你的代码尽快的执行。从这个角度来说，静态语言的执行效率要比动态语言高，速度更快。这是特点四。


* Java 具有平台独立性和可移植性

Java 有一句非常著名的口号： Write once, run anywhere，也就是一次编写、到处运行。为什么 Java 能够吹出这种牛批的口号来？核心就是 JVM。我们知道，计算机应用程序和硬件之间会屏蔽很多细节，它们之间依靠操作系统完成调度和协调，大致的体系结构如下

* Java 能够容易实现多线程

Java 是一门高级语言，高级语言会对用户屏蔽很多底层实现细节。比如 Java 是如何实现多线程的。从操作系统的角度来说，实现多线程的方式主要有下面这几种
在用户空间中实现多线程
在内核空间中实现多线程
在用户和内核空间中混合实现线程
而我认为 Java 应该是在 用户空间 实现的多线程，内核是感知不到 Java 存在多线程机制的。这是特点六。

* Java 具有高性能

我们编写的代码，经过 javac 编译器编译称为 字节码(bytecode)，经过 JVM 内嵌的解释器将字节码转换为机器代码，这是解释执行，这种转换过程效率较低。但是部分 JVM 的实现比如 Hotspot JVM 都提供了 JIT(Just-In-Time) 编译器，也就是通常所说的动态编译􏱆器，JIT 能够在运行时将􏲀热点代码编译机器码，这种方式运行效率比较高，这是编译执行。所以 Java 不仅仅只是一种解释执行的语言。这是特点七。

* Java 语言具有健壮性

Java 的强类型机制、异常处理、垃圾的自动收集等是 Java 程序健壮性的重要保证。这也是 Java 与 C 语言的重要区别。这是特点八。

* Java 很容易开发分布式项目

Java 语言支持 Internet 应用的开发，Java 中有 net api，它提供了用于网络应用编程的类库，包括URL、URLConnection、Socket、ServerSocket等。Java的 RMI（远程方法激活）机制也是开发分布式应用的重要手段。这是特点九。


## Java 基本语法

在配置完 Java 开发环境，并下载 Java 开发工具（Eclipse、IDEA 等）后，就可以写 Java 代码了，因为本篇文章是从头梳理 Java 体系，所以有必要从基础的概念开始谈起。
数据类型
在 Java 中，数据类型只有四类八种

整数型：byte、short、int、long

byte 也就是字节，1 byte = 8 bits，byte 的默认值是 0 ；
short 占用两个字节，也就是 16 位，1 short = 16 bits，它的默认值也是 0 ；
int 占用四个字节，也就是 32 位，1 int = 32 bits，默认值是 0 ；
long 占用八个字节，也就是 64 位，1 long = 64 bits，默认值是 0L；
所以整数型的占用字节大小空间为 long > int > short > byte

浮点型

浮点型有两种数据类型：float 和 double
float 是单精度浮点型，占用 4 位，1 float = 32 bits，默认值是 0.0f；
double 是双精度浮点型，占用 8 位，1 double = 64 bits，默认值是 0.0d；

字符型

字符型就是 char，char 类型是一个单一的 16 位 Unicode 字符，最小值是 \u0000 (也就是 0 )，最大值是 \uffff (即为 65535)，char 数据类型可以存储任何字符，例如 char a = 'A'。

布尔型

布尔型指的就是 boolean，boolean 只有两种值，true 或者是 false，只表示 1 位，默认值是 false。
以上 x 位都指的是在内存中的占用

### 基础语法

* 大小写敏感：Java 是对大小写敏感的语言，例如 Hello 与 hello 是不同的，这其实就是 Java 的字符串表示方式
* 类名：对于所有的类来说，首字母应该大写，例如 MyFirstClass
* 包名：包名应该尽量保证小写，例如 my.first.package
* 方法名：方法名首字母需要小写，后面每个单词字母都需要大写，例如 myFirstMethod()


运算符
运算符不只 Java 中有，其他语言也有运算符，运算符是一些特殊的符号，主要用于数学函数、一些类型的赋值语句和逻辑比较方面，我们就以 Java 为例，来看一下运算符。

赋值运算符

赋值运算符使用操作符 = 来表示，它的意思是把 = 号右边的值复制给左边，右边的值可以是任何常数、变量或者表达式，但左边的值必须是一个明确的，已经定义的变量。比如 int a = 4。
但是对于对象来说，复制的不是对象的值，而是对象的引用，所以如果说将一个对象复制给另一个对象，实际上是将一个对象的引用赋值给另一个对象。

算数运算符

算数运算符就和数学中的数值计算差不多，主要有


算数运算符需要注意的就是优先级问题，当一个表达式中存在多个操作符时，操作符的优先级顺序就决定了计算顺序，最简单的规则就是先乘除后加减，() 的优先级最高，没必要记住所有的优先级顺序，不确定的直接用 () 就可以了。

自增、自减运算符
这个就不文字解释了，解释不如直接看例子明白

    int a = 5;
    b = ++a;
    c = a++;

比较运算符

比较运算符用于程序中的变量之间，变量和自变量之间以及其他类型的信息之间的比较。
比较运算符的运算结果是 boolean 型。当运算符对应的关系成立时，运算的结果为 true，否则为 false。比较运算符共有 6 个，通常作为判断的依据用于条件语句中。

逻辑运算符

移位运算符

移位运算符用来将操作数向某个方向（向左或者右）移动指定的二进制位数。

三元运算符

三元运算符是类似 if...else... 这种的操作符，语法为：条件表达式？表达式 1：表达式 2。问号前面的位置是判断的条件，判断结果为布尔型，为 true 时调用表达式 1，为 false 时调用表达式 2。


## 面向对象

下面我们来探讨面向对象的思想，面向对象的思想已经逐步取代了过程化的思想 --- 面向过程，Java 是面向对象的高级编程语言，面向对象语言具有如下特征


* 面向对象是一种常见的思想，比较符合人们的思考习惯；


* 面向对象可以将复杂的业务逻辑简单化，增强代码复用性；


* 面向对象具有抽象、封装、继承、多态等特性。


面向对象的编程语言主要有：C++、Java、C#等。
所以必须熟悉面向对象的思想才能编写出 Java 程序。




#### 默认构造方法

默认的构造方法也被称为默认构造器或者无参构造器。

这里需要注意一点的是，即使 JVM 会为你默认添加一个无参的构造器，但是如果你手动定义了任何一个构造方法，JVM 就不再为你提供默认的构造器，你必须手动指定，否则会出现编译错误。

#### 方法重载
在 Java 中一个很重要的概念是方法的重载，它是类名的不同表现形式。我们上面说到了构造函数，其实构造函数也是重载的一种。另外一种就是方法的重载

public class Apple {

    int sum;
    String color;

    public Apple(){}
    public Apple(int sum){}
    
    public int getApple(int num){
        return 1;
    }
    
    public String getApple(String color){
        return "color";
    }

}

如上面所示，就有两种重载的方式，一种是 Apple 构造函数的重载，一种是 getApple 方法的重载。
但是这样就涉及到一个问题，要是有几个相同的名字，Java 如何知道你调用的是哪个方法呢？这里记住一点即可，每个重载的方法都有独一无二的参数列表。其中包括参数的类型、顺序、参数数量等，满足一种一个因素就构成了重载的必要条件。
请记住下面重载的条件


方法名称必须相同。


参数列表必须不同（个数不同、或类型不同、参数类型排列顺序不同等）。


方法的返回类型可以相同也可以不相同。


仅仅返回类型不同不足以成为方法的重载。


重载是发生在编译时的，因为编译器可以根据参数的类型来选择使用哪个方法。


#### 方法的重写

方法的重写与重载虽然名字很相似，但却完全是不同的东西。方法重写的描述是对子类和父类之间的。而重载指的是同一类中的。例如如下代码

    class Fruit {
    
        public void eat(){
        System.out.printl('eat fruit');
    }
    }

    class Apple extends Fruit{
    
    @Override
    public void eat(){
        System.out.printl('eat apple');
    }
    }


上面这段代码描述的就是重写的代码，你可以看到，子类 Apple 中的方法和父类 Fruit 中的方法同名，所以，我们能够推断出重写的原则

    重写的方法必须要和父类保持一致，包括返回值类型,方法名,参数列表 也都一样。

    重写的方法可以使用 @Override 注解来标识

    子类中重写方法的访问权限不能低于父类中方法的访问权限。



## 类的初始化

初始化顺序
首先先来看一下有哪些需要探讨的初始化顺序


静态属性：static 开头定义的属性


静态方法块： static {} 包起来的代码块


普通属性： 非 static 定义的属性


普通方法块： {} 包起来的代码块


构造函数： 类名相同的方法



Java 中一种数组冷门的用法就是可变参数 ，可变参数的定义如下

    public int add(int... numbers){
    int sum = 0;
    for(int num : numbers){
        sum += num;
    }
    return sum;
    }
    add();  // 不传参数
    add(1);  // 传递一个参数
    add(2,1);  // 传递多个参数
    add(new Integer[] {1, 3, 2});  // 传递数组


对象的销毁

虽然 Java 语言是基于 C++ 的，但是它和 C/C++ 一个重要的特征就是不需要手动管理对象的销毁工作。在著名的一书 《深入理解 Java 虚拟机》中提到一个观点:

    Java与C++之间有一堵有内存动态分配和垃圾收集技术所围成的“高墙”，墙外的人想进去，墙里的人却想出来。


在 Java 中，我们不再需要手动管理对象的销毁，它是由 Java 虚拟机进行管理和销毁的。虽然我们不需要手动管理对象，但是你需要知道 对象作用域 这个概念。


对象作用域
J多数语言都有作用域(scope) 这个概念。作用域决定了其内部定义的变量名的可见性和生命周期。在 C、C++ 和 Java 中，作用域通常由 {} 的位置来决定，例如
{
  int a = 11;
  {
    int b = 12;
  }
}

 变量会在两个 {} 作用域内有效，而 b 变量的值只能在它自己的 {} 内有效。
虽然存在作用域，但是不允许这样写
{
  int x = 11;
  {
    int x = 12;
  }
}

这种写法在 C/C++ 中是可以的，但是在 Java 中不允许这样写，因为 Java 设计者认为这样写会导致程序混乱。

### this 和 super

this 和 super 都是 Java 中的关键字

this 表示的当前对象，this 可以调用方法、调用属性和指向对象本身。this 在 Java 中的使用一般有三种：指向当前对象

public class Apple {

    private int num;
    
    public Apple(int num){
        this.num = num;
    }

    public static void main(String[] args) {
        new Apple(10);
    }
}

this 还可以和构造函数一起使用，充当一个全局关键字的效果

public class Apple {

    private int num;
    private String color;

    public Apple(int num){
        this(num,"红色");
    }
    
    public Apple(String color){
        this(1,color);
    }

    public Apple(int num, String color) {
        this.num = num;
        this.color = color;
    }
    
}

你会发现上面这段代码使用的不是 this, 而是 this(参数)。它相当于调用了其他构造方法，然后传递参数进去。这里注意一点：this() 必须放在构造方法的第一行，否则编译不通过

如果你把 this 理解为指向自身的一个引用，那么 super 就是指向父类的一个引用。super 关键字和 this 一样，你可以使用 super.对象 来引用父类的成员，如下

    public class Fruit {

        int num;
        String color;

        public void eat(){
            System.out.println("eat Fruit");
        }
    }

    public class Apple extends Fruit{

        @Override
        public void eat() {
            super.num = 10;
            System.out.println("eat " + num + " Apple");
        }

    }


访问控制权限
访问控制权限又称为封装，它是面向对象三大特性中的一种，我之前在学习过程中经常会忽略封装，心想这不就是一个访问修饰符么，怎么就是三大特性的必要条件了？后来我才知道，如果你信任的下属对你隐瞒 bug，你是根本不知道的。
访问控制权限其实最核心就是一点：只对需要的类可见。
Java中成员的访问权限共有四种，分别是 public、protected、default、private，它们的可见性如下

![](https://user-gold-cdn.xitu.io/2020/5/9/171f676231ae6862?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

继承
继承是所有 OOP(Object Oriented Programming) 语言和 Java 语言都不可或缺的一部分。只要我们创建了一个类，就隐式的继承自 Object 父类，只不过没有指定。如果你显示指定了父类，那么你继承于父类，而你的父类继承于 Object 类。


![](https://user-gold-cdn.xitu.io/2020/5/9/171f67628bcfe6fa?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

class Father{}

class Son extends Father{}

class Father{
  
  public void feature(){
    System.out.println("父亲的特征");
  }
}

class Son extends Father {
}

如果 Son 没有实现自己的方法的话，那么默认就是用的是父类的 feature 方法。如果子类实现了自己的 feature 方法，那么就相当于是重写了父类的 feature 方法，这也是我们上面提到的重写了。

多态

多态指的是同一个行为具有多个不同表现形式。是指一个类实例（对象）的相同方法在不同情形下具有不同表现形式。封装和继承是多态的基础，也就是说，多态只是一种表现形式而已。
如何实现多态？多态的实现具有三种充要条件

* 继承
* 重写父类方法
* 父类引用指向子类对象

组合

组合其实不难理解，就是将对象引用置于新类中即可。组合也是一种提高类的复用性的一种方式。如果你想让类具有更多的扩展功能，你需要记住一句话多用组合，少用继承。


![](https://user-gold-cdn.xitu.io/2020/5/9/171f6762566b27b9?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

代理

除了继承和组合外，另外一种值得探讨的关系模型称为 代理。代理的大致描述是，A 想要调用 B 类的方法，A 不直接调用，A 会在自己的类中创建一个 B 对象的代理，再由代理调用 B 的方法。例如如下代码


    public class Destination {

        public void todo(){
            System.out.println("control...");
        }
    }

    public class Device {

        private String name;
        private Destination destination;
        private DeviceController deviceController;

        public void control(Destination destination){
            destination.todo();
        }

    }

    public class DeviceController {

        private Device name;
        private Destination destination;

        public void control(Destination destination){
            destination.todo();
        }
    }

向上转型

向上转型代表了父类与子类之间的关系，其实父类和子类之间不仅仅有向上转型，还有向下转型，它们的转型后的范围不一样

* 向上转型：通过子类对象(小范围)转化为父类对象(大范围)，这种转换是自动完成的，不用强制。
* 向下转型 : 通过父类对象(大范围)实例化子类对象(小范围)，这种转换不是自动完成的，需要强制指定。


static

static 是 Java 中的关键字，它的意思是 静态的，static 可以用来修饰成员变量和方法，static 用在没有创建对象的情况下调用 方法/变量。

用 static 声明的成员变量为静态成员变量，也成为类变量。类变量的生命周期和类相同，在整个应用程序执行期间都有效。

static String name = "cxuan";

使用 static 修饰的方法称为静态方法，静态方法能够直接使用类名.方法名 进行调用。由于静态方法不依赖于任何对象就可以直接访问，因此对于静态方法来说，是没有 this 关键字的，实例变量都会有 this 关键字。在静态方法中不能访问类的非静态成员变量和非静态方法，

static void printMessage(){
  System.out.println("cxuan is writing the article");
}

static 除了修饰属性和方法外，还有静态代码块 的功能，可用于类的初始化操作。进而提升程序的性能。

public class StaicBlock {
    static{
        System.out.println("I'm A static code block");
    }
}

由于静态代码块随着类的加载而执行，因此，很多时候会将只需要进行一次的初始化操作放在 static 代码块中进行。

final

final 的意思是最后的、最终的，它可以修饰类、属性和方法。

* final 修饰类时，表明这个类不能被继承。final 类中的成员变量可以根据需要设为 final，但是要注意 final 类中的所有成员方法都会被隐式地指定为 final 方法。
* final 修饰方法时，表明这个方法不能被任何子类重写，因此，如果只有在想明确禁止该方法在子类中被覆盖的情况下才将方法设置为 final。
* final 修饰变量分为两种情况，一种是修饰基本数据类型，表示数据类型的值不能被修改；一种是修饰引用类型，表示对其初始化之后便不能再让其指向另一个对象。


接口和抽象类


## 泛形

在 Jdk1.5 中，提出了一种新的概念，那就是泛型，那么什么是泛型呢？

泛型其实就是一种参数化的集合，它限制了你添加进集合的类型。泛型的本质就是一种参数化类型。多态也可以看作是泛型的机制。一个类继承了父类，那么就能通过它的父类找到对应的子类，但是不能通过其他类来找到具体要找的这个类。泛型的设计之处就是希望对象或方法具有最广泛的表达能力。


用泛型表示类

泛型可以加到类上面，来表示这个类的类型

//此处 T 可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
public class GenericDemo<T>{ 
    //value 这个成员变量的类型为T,T的类型由外部指定  
    private T value;

    public GenericDemo(T value) {
        this.value = value;
    }

    public T getValue(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return value;
    }
 
 		public void setValue(T value){
	      this.value = value
    }
}

用泛型表示接口
泛型接口与泛型类的定义及使用基本相同。

//定义一个泛型接口
public interface Generator<T> {
    public T next();
}

一般泛型接口常用于 生成器(generator) 中，生成器相当于对象工厂，是一种专门用来创建对象的类。

泛型方法

可以使用泛型来表示方法

public class GenericMethods {
  public <T> void f(T x){
    System.out.println(x.getClass().getName());
  }
}


泛型通配符

List 是泛型类，为了 表示各种泛型 List 的父类，可以使用类型通配符，类型通配符使用问号(?)表示，它的元素类型可以匹配任何类型。例如


下界通配符 :  <? extends ClassType> 该通配符为 ClassType 的所有子类型。它表示的是任何类型都是 ClassType 类型的子类。

上界通配符： <? super ClassType> 该通配符为 ClassType 的所有超类型。它表示的是任何类型的父类都是 ClassType。

反射

反射是 Java 中一个非常重要同时也是一个高级特性，基本上 Spring 等一系列框架都是基于反射的思想写成的。我们首先来认识一下什么反射。

Java 
反射机制是在程序的运行过程中，对于任何一个类，都能够知道它的所有属性和方法；对于任意一个对象，都能够知道调用它的任意属性和方法，这种动态获取信息以及动态调用对象方法的功能称为java语言的反射机制。（来源于百度百科）

Java 反射机制主要提供了以下这几个功能

* 在运行时判断任意一个对象所属的类
* 在运行时构造任意一个类的对象
* 在运行时判断任意一个类所有的成员变量和方法
* 在运行时调用任意一个对象的方法

这么一看，反射就像是一个掌控全局的角色，不管你程序怎么运行，我都能够知道你这个类有哪些属性和方法，你这个对象是由谁调用的，嗯，很屌。
在 Java 中，使用 Java.lang.reflect包实现了反射机制。Java.lang.reflect 所设计的类如下

	Class 类
	在 Java 中，你每定义一个 java class 实体都会产生一个 Class 对象。也就是说，当我们编写一个类，编译完成后，在生成的 .class 文件中，就会产生一个 Class 对象，这个 Class 对象用于表示这个类的类型信息。Class 中没有公共的构造器，也就是说 Class 对象不能被实例化。下面来简单看一下 Class 类都包括了哪些方法
	toString()
	public String toString() {
	  return (isInterface() ? "interface " : (isPrimitive() ? "" : "class "))
		+ getName();
	}
	toString() 方法能够将对象转换为字符串，toString() 首先会判断 Class 类型是否是接口类型，也就是说，普通类和接口都能够用 Class 对象来表示，然后再判断是否是基本数据类型，这里判断的都是基本数据类型和包装类，还有 void类型。
	所有的类型如下

	java.lang.Boolean : 代表 boolean 数据类型的包装类
	java.lang.Character: 代表 char 数据类型的包装类
	java.lang.Byte: 代表 byte 数据类型的包装类
	java.lang.Short: 代表 short 数据类型的包装类
	java.lang.Integer: 代表 int 数据类型的包装类
	java.lang.Long: 代表 long 数据类型的包装类
	java.lang.Float: 代表 float 数据类型的包装类
	java.lang.Double: 代表 double 数据类型的包装类
	java.lang.Void: 代表 void 数据类型的包装类

	然后是 getName() 方法，这个方法返回类的全限定名称。

	如果是引用类型，比如 String.class.getName()  -> java.lang.String
	如果是基本数据类型，byte.class.getName() -> byte
	如果是数组类型，new Object[3]).getClass().getName() -> [Ljava.lang.Object

	toGenericString()
	这个方法会返回类的全限定名称，而且包括类的修饰符和类型参数信息。
	forName()
	根据类名获得一个 Class 对象的引用，这个方法会使类对象进行初始化。
	例如 Class t = Class.forName("java.lang.Thread") 就能够初始化一个 Thread 线程对象
	在 Java 中，一共有三种获取类实例的方式

	Class.forName(java.lang.Thread)
	Thread.class
	thread.getClass()

	newInstance()
	创建一个类的实例，代表着这个类的对象。上面 forName() 方法对类进行初始化，newInstance 方法对类进行实例化。
	getClassLoader()
	获取类加载器对象。
	getTypeParameters()
	按照声明的顺序获取对象的参数类型信息。
	getPackage()
	返回类的包
	getInterfaces()
	获得当前类实现的类或是接口，可能是有多个，所以返回的是 Class 数组。
	Cast
	把对象转换成代表类或是接口的对象
	asSubclass(Class clazz)
	把传递的类的对象转换成代表其子类的对象
	getClasses()
	返回一个数组，数组中包含该类中所有公共类和接口类的对象
	getDeclaredClasses()
	返回一个数组，数组中包含该类中所有类和接口类的对象
	getSimpleName()
	获得类的名字
	getFields()
	获得所有公有的属性对象
	getField(String name)
	获得某个公有的属性对象
	getDeclaredField(String name)
	获得某个属性对象
	getDeclaredFields()
	获得所有属性对象
	getAnnotation(Class annotationClass)
	返回该类中与参数类型匹配的公有注解对象
	getAnnotations()
	返回该类所有的公有注解对象
	getDeclaredAnnotation(Class annotationClass)
	返回该类中与参数类型匹配的所有注解对象
	getDeclaredAnnotations()
	返回该类所有的注解对象
	getConstructor(Class...<?> parameterTypes)
	获得该类中与参数类型匹配的公有构造方法
	getConstructors()
	获得该类的所有公有构造方法
	getDeclaredConstructor(Class...<?> parameterTypes)
	获得该类中与参数类型匹配的构造方法
	getDeclaredConstructors()
	获得该类所有构造方法
	getMethod(String name, Class...<?> parameterTypes)
	获得该类某个公有的方法
	getMethods()
	获得该类所有公有的方法
	getDeclaredMethod(String name, Class...<?> parameterTypes)
	获得该类某个方法
	getDeclaredMethods()
	获得该类所有方法
	Field 类
	Field 类提供类或接口中单独字段的信息，以及对单独字段的动态访问。
	这里就不再对具体的方法进行介绍了，读者有兴趣可以参考官方 API
	这里只介绍几个常用的方法
	equals(Object obj)
	属性与obj相等则返回true
	get(Object obj)
	获得obj中对应的属性值
	set(Object obj, Object value)
	设置obj中对应属性值
	Method 类
	invoke(Object obj, Object... args)
	传递object对象及参数调用该对象对应的方法
	ClassLoader 类
	反射中，还有一个非常重要的类就是 ClassLoader 类，类装载器是用来把类(class) 装载进 JVM的。ClassLoader 使用的是双亲委托模型来搜索加载类的，这个模型也就是双亲委派模型。ClassLoader 的类继承图如下

![](https://user-gold-cdn.xitu.io/2020/5/9/171f67630780a127?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)


### 枚举

枚举可能是我们使用次数比较少的特性，在 Java 中，枚举使用 enum 关键字来表示，枚举其实是一项非常有用的特性，你可以把它理解为具有特定性质的类。enum 不仅仅 Java 有，C 和 C++ 也有枚举的概念。下面是一个枚举的例子。

#### 枚举特性
enum 枚举这个类比较有意思，当你创建完 enum 后，编译器会自动为你的 enum 添加 toString() 方法，能够让你方便的显示 enum 实例的具体名字是什么。除了 toString() 方法外，编译器还会添加 ordinal() 方法，这个方法用来表示 enum 常量的声明顺序，以及 values() 方法显示顺序的值。

enum 可以进行静态导入包，静态导入包可以做到不用输入 枚举类名.常量，可以直接使用常量，神奇吗? 使用 ennum 和 static 关键字可以做到静态导入包

枚举和普通类一样


枚举就和普通类一样，除了枚举中能够方便快捷的定义常量，我们日常开发使用的 public static final xxx 其实都可以用枚举来定义。在枚举中也能够定义属性和方法，千万不要把它看作是异类，它和万千的类一样。

枚举神秘之处

在 Java 中，万事万物都是对象，enum 虽然是个关键字，但是它却隐式的继承于 Enum 类。我们来看一下 Enum 类，此类位于 java.lang 包下，可以自动引用

此类的属性和方法都比较少。你会发现这个类中没有我们的 values 方法。前面刚说到，values() 方法是你使用枚举时被编译器添加进来的 static 方法。可以使用反射来验证一下。
除此之外，enum 还和 Class 类有交集，在 Class 类中有三个关于 Enum 的方法

前面两个方法用于获取 enum 常量，isEnum 用于判断是否是枚举类型的。

I/O

创建一个良好的 I/O 程序是非常复杂的。JDK 开发人员编写了大量的类只为了能够创建一个良好的工具包，想必编写 I/O 工具包很费劲吧。
IO 类设计出来，肯定是为了解决 IO 相关操作的，最常见的 I/O 读写就是网络、磁盘等。在 Java 中，对文件的操作是一个典型的 I/O 操作。下面我们就对 I/O 进行一个分类。

![](https://user-gold-cdn.xitu.io/2020/5/9/171f67635b8addea?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

![](https://user-gold-cdn.xitu.io/2020/5/9/171f676367ab1217?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

除此之外，I/O 中还有其他比较重要的类

File 类
File 类是对文件系统中文件以及文件夹进行操作的类，可以通过面向对象的思想操作文件和文件夹，是不是很神奇？

文件创建操作如下，主要涉及 文件创建、删除文件、获取文件描述符等

上面只是举出来了两个简单的示例，实际上，还有一些其他对文件的操作没有使用。比如创建文件，就可以使用三种方式来创建

    File(String directoryPath);
    File(String directoryPath, String filename);
    File(File dirObj, String filename);
directoryPath 是文件的路径名，filename 是文件名，dirObj 是一个 File 对象。例如

    File file = new File("D:\\java\\file1.txt");  //双\\是转义
    System.out.println(file);
    File file2 = new File("D:\\java","file2.txt");//父路径、子路径--可以适用于多个文件的！
    System.out.println(file2);
    File parent = new File("D:\\java");
    File file3 = new File(parent,"file3.txt");//File类的父路径、子路径
    System.out.println(file3);

![](https://user-gold-cdn.xitu.io/2020/5/9/171f67638404e6ca?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

基础 IO 类和相关方法

虽然. IO 类有很多，但是最基本的是四个抽象类，InputStream、OutputStream、Reader、Writer。最基本的方法也就是 read() 和 write() 方法，其他流都是上面这四类流的子类，方法也是通过这两类方法衍生而成的。而且大部分的 IO 源码都是 native 标志的，也就是说源码都是 C/C++ 写的。这里我们先来认识一下这些流类及其方法

InputStream

InputStream 是一个定义了 Java 流式字节输入模式的抽象类。该类的所有方法在出错条件下引发一个IOException 异常。它的主要方法定义如下
![](https://user-gold-cdn.xitu.io/2020/5/9/171f6763966227fc?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

OutputStream

OutputStream 是定义了流式字节输出模式的抽象类。该类的所有方法返回一个void 值并且在出错情况下引发一个IOException异常。它的主要方法定义如下
![](https://user-gold-cdn.xitu.io/2020/5/9/171f67639a49890f?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

Reader 类

Reader 是 Java 定义的流式字符输入模式的抽象类。类中的方法在出错时引发 IOException 异常。

![](https://user-gold-cdn.xitu.io/2020/5/9/171f67639d502af8?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

Writer 类

Writer 是定义流式字符输出的抽象类。 所有该类的方法都返回一个 void 值并在出错条件下引发 IOException 异常

![](https://user-gold-cdn.xitu.io/2020/5/9/171f6763a8ba6282?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

InputStream 及其子类

	FileInputStream 文件输入流： FileInputStream 类创建一个能从文件读取字节的 InputStream 类
	ByteArrayInputStream 字节数组输入流 ： 把内存中的一个缓冲区作为 InputStream 使用
	PipedInputStream 管道输入流： 实现了pipe 管道的概念，主要在线程中使用
	SequenceInputStream 顺序输入流：把多个 InputStream 合并为一个 InputStream
	FilterOutputStream 过滤输入流：其他输入流的包装。
	ObjectInputStream 反序列化输入流 ： 将之前使用 ObjectOutputStream 序列化的原始数据恢复为对象，以流的方式读取对象
	**DataInputStream ** : 数据输入流允许应用程序以与机器无关方式从底层输入流中读取基本 Java 数据类型。
	PushbackInputStream 推回输入流： 缓冲的一个新颖的用法是实现推回 （pushback） 。 Pushback 用于输入流允许字节被读取然后返回到流。

OutputStream 及其子类

	FileOutputStream 文件输出流： 该类实现了一个输出流，其数据写入文件。
	ByteArrayOutputStream 字节数组输出流 ：该类实现了一个输出流，其数据被写入由 byte 数组充当的缓冲区，缓冲区会随着数据的不断写入而自动增长。
	PipedOutputStream 管道输出流 ：管道的输出流，是管道的发送端。
	ObjectOutputStream 基本类型输出流  ：该类将实现了序列化的对象序列化后写入指定地方。
	FilterOutputStream 过滤输出流：其他输出流的包装。
	PrintStream 打印流 通过 PrintStream 可以将文字打印到文件或者网络中去。
	**DataOutputStream ** : 数据输出流允许应用程序以与机器无关方式向底层输出流中写入基本 Java 数据类型。

Reader 及其子类

	FileReader 文件字符输入流 ： 把文件转换为字符流读入
	CharArrayReader 字符数组输入流 ： 是一个把字符数组作为源的输入流的实现
	BufferedReader 缓冲区输入流 ： BufferedReader 类从字符输入流中读取文本并缓冲字符，以便有效地读取字符，数组和行
	**PushbackReader **: PushbackReader 类允许一个或多个字符被送回输入流。
	PipedReader 管道输入流： 主要用途也是在线程间通讯，不过这个可以用来传输字符

Writer 及其子类

	FileWriter 字符输出流 ： FileWriter 创建一个可以写文件的 Writer 类。
	CharArrayWriter 字符数组输出流： CharArrayWriter 实现了以数组作为目标的输出流。
	BufferedWriter 缓冲区输出流 ： BufferedWriter是一个增加了flush( ) 方法的Writer。 flush( )方法可以用来确保数据缓冲器确实被写到实际的输出流。
	**PrintWriter ** ： PrintWriter 本质上是 PrintStream 的字符形式的版本。
	PipedWriter 管道输出流： 主要用途也是在线程间通讯，不过这个可以用来传输字符
	Java 的输入输出的流式接口为复杂而繁重的任务提供了一个简洁的抽象。过滤流类的组合允许你动态建立客户端流式接口来配合数据传输要求。继承高级流类 InputStream、InputStreamReader、 Reader 和 Writer 类的 Java 程序在将来 （即使创建了新的和改进的具体类）也能得到合理运用。

注解


Java 注解（Annotation） 又称为元数据 ，它为我们在代码中添加信息提供了一种形式化的方法。它是 JDK1.5 引入的，Java 定义了一套注解，共有 7 个，3 个在 java.lang 中，剩下 4 个在 java.lang.annotation 中。

作用在代码中的注解有三个，它们分别是

@Override： 重写标记，一般用在子类继承父类后，标注在重写过后的子类方法上。如果发现其父类，或者是引用的接口中并没有该方法时，会报编译错误。

@Deprecated ：用此注解注释的代码已经过时，不再推荐使用

@SuppressWarnings： 这个注解起到忽略编译器的警告作用

元注解有四个，元注解就是用来标志注解的注解。它们分别是

    @Retention: 标识如何存储，是只在代码中，还是编入class文件中，或者是在运行时可以通过反射访问。

    RetentionPolicy.SOURCE：注解只保留在源文件，当 Java 文件编译成class文件的时候，注解被遗弃；
    RetentionPolicy.CLASS：注解被保留到 class 文件，但 jvm 加载 class 文件时候被遗弃，这是默认的生命周期；
    RetentionPolicy.RUNTIME：注解不仅被保存到 class 文件中，jvm 加载 class 文件之后，仍然存在；

    @Documented: 标记这些注解是否包含在 JavaDoc 中。
    @Target： 标记这个注解说明了 Annotation 所修饰的对象范围，Annotation 可被用于 packages、types（类、接口、枚举、Annotation类型）、类型成员（方法、构造方法、成员变量、枚举值）、方法参数和本地变量（如循环变量、catch参数）。取值如下

public enum ElementType {
    TYPE,
    FIELD,
    METHOD,
    PARAMETER,
    CONSTRUCTOR,
    LOCAL_VARIABLE,
    ANNOTATION_TYPE,
    PACKAGE,
    TYPE_PARAMETER,
    TYPE_USE


@Inherited ： 标记这个注解是继承于哪个注解类的。

从 JDK1.7 开始，又添加了三个额外的注解，它们分别是


@SafeVarargs ：在声明可变参数的构造函数或方法时，Java 编译器会报 unchecked 警告。使用 @SafeVarargs 可以忽略这些警告


@FunctionalInterface: 表明这个方法是一个函数式接口


@Repeatable： 标识某注解可以在同一个声明上使用多次。


关于 null 的几种处理方式

对于 Java 程序员来说，空指针一直是恼人的问题，我们在开发中经常会受到 NullPointerException 的蹂躏和壁咚。Java 的发明者也承认这是一个巨大的设计错误。
那么关于 null ，你应该知道下面这几件事情来有效的了解 null ，从而避免很多由 null 引起的错误。

![](https://user-gold-cdn.xitu.io/2020/5/9/171f6763ca0b8f20?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

大小写敏感

首先，null 是 Java 中的关键字，像是 **public、static、final。**它是大小写敏感的，你不能将 null 写成 Null 或 NULL，编辑器将不能识别它们然后报错。

null 是任何引用类型的初始值

null 是所有引用类型的默认值，Java 中的任何引用变量都将null作为默认值，也就是说所有 Object 类下的引用类型默认值都是 null。这对所有的引用变量都适用。就像是基本类型的默认值一样，例如 int 的默认值是 0，boolean 的默认值是 false。
下面是基本数据类型的初始值

![](https://user-gold-cdn.xitu.io/2020/5/9/171f6763bb207928?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)


你可以看到在编译期和运行期内，将 null 转换成任何的引用类型都是可行的，并且不会抛出空指针异常。
null 只能赋值给引用变量，不能赋值给基本类型变量。
持有 null 的包装类在进行自动拆箱的时候，不能完成转换，会抛出空指针异常，并且 null 也不能和基本数据类型进行对比

    public static void main(String[] args) {
    int i = 0;
    Integer itr = null;
    System.out.println(itr == i);
    }

使用了带有 null 值的引用类型变量，instanceof 操作会返回 false

    public static void main(String[] args) {
    Integer isNull = null;
    // instanceof = isInstance 方法
    if(isNull instanceof Integer){
        System.out.println("isNull is instanceof Integer");
    }else{
        System.out.println("isNull is not instanceof Integer");
    }
    }

这是 instanceof 操作符一个很重要的特性，使得对类型强制转换检查很有用

静态变量为 null 调用静态方法不会抛出 NullPointerException。因为静态方法使用了静态绑定。


使用 Null-Safe 方法
你应该使用 null-safe 安全的方法，java 类库中有很多工具类都提供了静态方法，例如基本数据类型的包装类，Integer , Double 等。例如

public class NullSafeMethod {

    private static String number;

    public static void main(String[] args) {
        String s = String.valueOf(number);
        String string = number.toString();
        System.out.println("s = " + s);
        System.out.println("string = " + string);
    }
}

number 没有赋值，所以默认为null，使用String.value(number) 静态方法没有抛出空指针异常，但是使用 toString()却抛出了空指针异常。所以尽量使用对象的静态方法。


null 判断
你可以使用 == 或者 != 操作来比较 null 值，但是不能使用其他算法或者逻辑操作，例如小于或者大于。跟SQL不一样，在Java中 null == null 将返回 true，如下所示：


public class CompareNull {

    private static String str1;
    private static String str2;

    public static void main(String[] args) {
        System.out.println("str1 == str2 ? " + str1 == str2);
        System.out.println(null == null);
    }
}







# 参考
https://juejin.im/post/5eb5e0d7518825595138de52#heading-39