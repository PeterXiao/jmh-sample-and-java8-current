package versions.java8.concurrence;

public class VisibilityDemo8 {

	static int x = 0;

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(() -> {
			x = x + 2;
		});
		thread1.start();
		thread1.join();
		System.out.println("main-thread x = " + x);
	}

}