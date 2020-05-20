package problems;

import java.util.concurrent.TimeUnit;

/**
 * @author xiaoy
 * @date 2020/05/17
 */
class MyTest {
    static int number = 0;

    public void addNumber() {
        number = 100;
    }
}

public class VoientMain {
    public static void main(String[] args) {
        MyTest mt = new MyTest();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            mt.addNumber();

            // System.out.println(Thread.currentThread().getName() + "\t update value is " + mt.number);

        }, "AAA").start();

        while (mt.number == 0) {

        }

        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }
}