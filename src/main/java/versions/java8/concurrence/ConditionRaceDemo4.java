package versions.java8.concurrence;

public class ConditionRaceDemo4 {

	static volatile int a = 3;

	public static void calc() {
		a = a + 2;
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(() -> calc());
		Thread thread2 = new Thread(() -> calc());
		thread2.start();
		thread1.start();
		Thread.sleep(100);
		System.out.println(a);
	}

}
