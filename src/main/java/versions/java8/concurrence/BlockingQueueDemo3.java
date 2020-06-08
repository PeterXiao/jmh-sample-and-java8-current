package versions.java8.concurrence;


import versions.java8.concurrence.jdk.ArrayBlockingQueue;
import versions.java8.concurrence.jdk.BlockingQueue;
public class BlockingQueueDemo3 {

	static BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(10);

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println(blockingQueue.take());

	}
}
