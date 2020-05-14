package versions.bugs;

/**
 * @author xiaoy
 * @date 2020/05/11
 */
public class Hello {
    public void test() {
        int i = 8;
        while ((i -= 3) > 0);
        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        Hello hello = new Hello();
        for (int i = 0; i < 50_000; i++) {
            hello.test();
        }
    }
}
