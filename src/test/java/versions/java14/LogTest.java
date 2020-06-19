/**
 * 
 */
package versions.java14;

import org.junit.jupiter.api.Test;

/**
 * @author xiaoy
 *
 */
import lombok.extern.slf4j.Slf4j;

@Slf4j
class LogTest {
	@Test
	void show() {
		log.debug("Hello, {}.", "Debug");
		log.info("Hello, {}.", "Info");
		log.error("Hello, {}.", "Error");
	}
	
	static Map<Integer, Integer> cache = new ConcurrentHashMap<>();


	    public static void main(String[] args) {
	        System.out.println("f(" + 14 + ") =" + fibonacci(14));
	    }

	    static int fibonacci(int i) {
	        if (i == 0)
	            return i;
	        if (i == 1)
	            return 1;
	        return cache.computeIfAbsent(i, (key) -&gt; {
	            System.out.println("Slow calculation of " + key);
	            return fibonacci(i - 2) + fibonacci(i - 1);
	        });
	    }


}
