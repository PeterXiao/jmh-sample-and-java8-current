package versions.java8.concurrence;

public class RunnableInterrupt {
	public static void main(String[] args) {
		Thread thread1 = new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				System.out.println("running...");
			}
		});
		thread1.start();
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread1.interrupt();
	}
}
