package com.extendbase;

/**
 * @author xiaoy
 * @date 2020/05/14
 */
public class Apple extends Fruit {

    @Override
    public void eat() {
        super.num = 10;
        System.out.println("eat " + num + " Apple");
    }

    public static void main(String[] args) {
        Fruit fruit = new Apple();
        fruit.eat();
    }
}
