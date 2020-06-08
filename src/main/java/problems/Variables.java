/**
 * 
 */
package problems;

/**
 * @author xiaoy
 * 
 * 变量a就是类变量，存放在方法区，线程共享。

变量b就是成员变量，随着对象一起存放在堆内存，线程共享。

变量c和d是局部变量，存放在栈内存，线程独享。
 *
 */
public class Variables {

    /**
     * 类变量
     */
    private static int a;

    /**
     * 成员变量
     */
    private int b;

    /**
     * 局部变量
     * @param c
     */
    public void test(int c){
        int d;
    }
}
