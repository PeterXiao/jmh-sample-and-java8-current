package versions.java8.base;

import java.util.List;

/**
 * @author xiaoy
 * @date 2020/05/18
 */
public class Util {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Pair<Integer, String> p1 = new Pair<>(1, "apple");
        Pair<Integer, String> p2 = new Pair<>(2, "pear");
        boolean same = Util.<Integer, String>compare(p1, p2);
        // 已明确提供该类型，如粗体所示。通常，这可以省略，编译器将推断所需的类型：

        // Pair<Integer, String> p1 = new Pair<>(1, "apple");
        // Pair<Integer, String> p2 = new Pair<>(2, "pear");
        // boolean same = Util.compare(p1, p2);

        System.out.println(same);

    }

    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }

    // public static <T> int countGreaterThan(T[] anArray, T elem) {
    // int count = 0;
    // for (T e : anArray)
    // if (e > elem) // compiler error
    // ++count;
    // return count;
    // }
    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0)
                ++count;
        return count;
    }

    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }
}

class Pair<K, V> {

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}