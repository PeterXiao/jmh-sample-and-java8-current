package versions.java8.concurrence;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaphoreDemo2 {
	static Semaphore semaphore = new Semaphore(6);
	static AtomicInteger value = new AtomicInteger(0);

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(() -> {
				try {
					semaphore.acquire(2);
					System.out.println("counting number : " + value.incrementAndGet());
					Thread.sleep(5000);
					semaphore.release(2);
				} catch (InterruptedException e) {
				}
			});
			thread.start();
		}
	}
}
