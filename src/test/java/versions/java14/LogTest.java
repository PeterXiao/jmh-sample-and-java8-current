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
}
