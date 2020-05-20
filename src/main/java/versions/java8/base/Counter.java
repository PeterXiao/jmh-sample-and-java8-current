package versions.java8.base;

/**
 * @author xiaoy
 * @date 2020/05/20
 */
class Counter {
    private int c = 0;

    public void increment() {
        c++;
    }

    public void decrement() {
        c--;
    }

    public int value() {
        return c;
    }

}