package com.base;

/**
 * @author xiaoy
 * @date 2020/05/14
 */
public class student {

    public static void main(String[] args) {
        int a = 10;
        int b = 11;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }

        int x = 40;
        if (x > 60) {
            System.out.println("x的值大于60");
        } else if (x > 30) {
            System.out.println("x的值大于30但小于60");
        } else if (x > 0) {
            System.out.println("x的值大于0但小于30");
        } else {
            System.out.println("x的值小于等于0");
        }

        int week = 0;
        switch (week) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("No Else");
                break;
        }

        Apple apple1 = new Apple();
        Apple apple2 = new Apple(1);
        Apple apple3 = new Apple("red");
        Apple apple4 = new Apple(2, "color");

    }

    public boolean name() {
        int a = 10;
        if (a > 10) {
            return true;
        }
        return false;

    }

}

class Apple {

    int sum;
    String color;

    public Apple() {}

    public Apple(int sum) {}

    public Apple(String color) {}

    public Apple(int sum, String color) {}

}

/*class student {
    void student_wakeUp(){...}
void student_cloth(){...}
void student_wash(){...}
void student_eating(){...}
void student_gotoSchool(){...}
}

class student(){
    void wakeUp(){...}
    void cloth(){...}
    void wash(){...}
    void eating(){...}
    void gotoSchool(){...}
}


while 循环语句
while 循环语句的循环方式为利用一个条件来控制是否要继续反复执行这个语句。while 循环语句的格式如下
while(布尔值){
  表达式
}
它的含义是，当 (布尔值) 为 true 的时候，执行下面的表达式，布尔值为 false 的时候，结束循环，布尔值其实也是一个表达式，比如
int a = 10;
while(a > 5){
  a--;
}
do...while 循环
while 与 do...while 循环的唯一区别是 do...while 语句至少执行一次，即使第一次的表达式为 false。而在 while 循环中，如果第一次条件为 false，那么其中的语句根本不会执行。在实际应用中，while 要比 do...while 应用的更广。它的一般形式如下
int b = 10;
// do···while循环语句
do {
  System.out.println("b == " + b);
  b--;
} while(b == 1);
for 循环语句

for 循环是我们经常使用的循环方式，这种形式会在第一次迭代前进行初始化。它的形式如下
for(初始化; 布尔表达式; 步进){}
每次迭代前会测试布尔表达式。如果获得的结果是 false，就会执行 for 语句后面的代码；每次循环结束，会按照步进的值执行下一次循环。

逗号操作符

这里不可忽略的一个就是逗号操作符，Java 里唯一用到逗号操作符的就是 for 循环控制语句。在表达式的初始化部分，可以使用一系列的逗号分隔的语句；通过逗号操作符，可以在 for 语句内定义多个变量，但它们必须具有相同的类型
for(int i = 1;j = i + 10;i < 5;i++, j = j * 2){}
for-each 语句
在 Java JDK 1.5 中还引入了一种更加简洁的、方便对数组和集合进行遍历的方法，即 for-each 语句，例子如下
int array[] = {7, 8, 9};

for (int arr : array) {
     System.out.println(arr);
}

跳转语句

Java 语言中，有三种跳转语句: break、continue 和 return
break 语句
break 语句我们在 switch 中已经见到了，它是用于终止循环的操作，实际上 break 语句在for、while、do···while循环语句中，用于强行退出当前循环，例如
for(int i = 0;i < 10;i++){
    if(i == 5){
    break;
  }
}

continue 语句

continue 也可以放在循环语句中，它与 break 语句具有相反的效果，它的作用是用于执行下一次循环，而不是退出当前循环，还以上面的例子为主
for(int i = 0;i < 10;i++){
  
  System.out.printl(" i = " + i );
    if(i == 5){
    System.out.printl("continue ... ");
    continue;
  }
}

return 语句

return 语句可以从一个方法返回，并把控制权交给调用它的语句。
public void getName() {
    return name;
}


*/