package versions.java8.concurrence;

import versions.java8.concurrence.jdk.ArrayBlockingQueue;
import versions.java8.concurrence.jdk.BlockingQueue;

public class BlockingQueueDemo2 {

	static BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(4);

	public static void main(String[] args) throws InterruptedException {

		for (int i = 0; i < 5; i++) {
			final int index = i;
			new Thread(() -> {
				try {
					blockingQueue.put("string" + index);
					System.out.println("produced string" + index);
				} catch (InterruptedException e) {
				}
			}).start();
		}

	}
}
