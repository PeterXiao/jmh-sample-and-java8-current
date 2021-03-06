package versions.java8.concurrence;

public class ThreadSuspend {
	public static void main(String[] args) {
		Thread mt = new Thread(() -> {
			while (true) {
				System.out.println("running....");
			}
		});
		mt.start();
		try {
			Thread.currentThread().sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mt.suspend();
		System.out.println("can you get here?");
		mt.resume();
	}
}
