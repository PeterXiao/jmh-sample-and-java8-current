/**
 *
 */
package versions.java14;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

/**
 * @author xiaoy
 *
 */
import lombok.extern.slf4j.Slf4j;

@Slf4j
class LogTest {
    static Map<Integer, Integer> cache = new ConcurrentHashMap<>();

    static int fibonacci(int i) {
        if (i == 0)
            return i;
        if (i == 1)
            return 1;
        return cache.computeIfAbsent(i, (key) -> {
            System.out.println("Slow calculation of " + key);
            return fibonacci(i - 2) + fibonacci(i - 1);
        });
    }

    public static void main(String[] args) {
        System.out.println("f(" + 14 + ") =" + fibonacci(14));
    }

    @Test
    void show() {
        log.debug("Hello, {}.", "Debug");
        log.info("Hello, {}.", "Info");
        log.error("Hello, {}.", "Error");
    }

}
