package com.base;

/**
 * @author xiaoy
 * @date 2020/05/14 这段代码比较精妙，精妙在哪呢，我一个 eatApple() 方法竟然可以调用多次，你在后面还可以继续调用，这就很神奇了，为啥呢？其实就是 this 在作祟了，我在 eatApple 方法中加了一个
 *       return this 的返回值，也就是说哪个对象调用 eatApple 方法都能返回对象的自身。
 * 
 * 
 */
public class apples {

    int i = 0;

    apples eatApple() {
        i++;
        return this;
    }

    public static void main(String[] args) {
        apples apple = new apples();
        apple.eatApple().eatApple();
    }
}
