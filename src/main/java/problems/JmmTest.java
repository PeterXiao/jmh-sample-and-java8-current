package problems;

import lombok.SneakyThrows;

/**
 * @author xiaoy
 * @date 2020/05/15
 */
public class JmmTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Test a = new Test();
        a.start();
        /*        for (;;) {
            if (a.isFlag()) {
                System.out.println("1");
            }
        }*/
        for (;;) {
            if (a.isFlag()) {
                System.out.println("1");
            } else {
                System.out.println("2");
            }
        }
    }

    static class Test extends Thread {

        private boolean flag = false;

        public boolean isFlag() {
            return flag;
        }

        @SneakyThrows
        @Override
        public void run() {
            Thread.sleep(1000);
            flag = true;
            System.out.println(flag);

        }
    }

}
