lombok来简化你的Java Bean

Lombok 是一种 Java Archive (JAR) 文件，可用来消除 Java 代码的冗长。

我们看这样一个例子，一个标准的 Java bean。一个典型的 Java bean 一般具有几个属性。每个属性具有一个 accessor 和 mutator（getter 和 setter）。通常还会有一个 toString() 方法、一个 equals() 方法和一个 hashCode() 方法。

使用的版本是1.16.16,有下面几个常用注解：

@Date
生成Getter、Setter、toString、equals、hashCode方法。

可标注：Class

@Value
生成Getter、toString、equals、hashCode、还有全字段的构造方法。并且会将字段全都添加final。

可标注：Class

@Builder
在类内部生成一个名为类名+Builder的内部类，用于快速构建。

可标注：Class

你可以这样使用它:

@Builder
public class Book {

    private Integer id;

    private String title;

    private Date releaseDate;

    private Double price;

    private String[] authors;

    private String publisher;

}
public static void main(String[] args) {
    Book book = Book.builder().id(1).title("书名").build();
}
@Getter/@Setter
生成Getter或Setter方法。如果标注在类上则会生成这个类中所有字段的Getter或Setter方法。

可标注：Field,Class

@NonNull
为你的构造函数、Setter添加空值校验。标注的字段赋值为空时，会抛出NullPointerException。

可标注：Field,Method,Parameter,Local Variable

为什么？
自从Java 6起，Javac就支持了一个名叫JSR 269 Pluggable Annotation Processing API的规范，它的作用就是：如果你实现了这个API，在Javac编译时就会得到调用。而lombok正是运用了这一点。

流程是这样的：

Javac编译源代码，并生成语法树（AST）

Javac寻找实现了JSR 269 .... API的代码（lombok），并调用。

lombok寻找被标注了注解的类，修改Javac生成的语法树（AST）。

Javac将语法树生成为字节码（.class）

就到这里了
它还具备很多好用的功能，你可以去这里看看。