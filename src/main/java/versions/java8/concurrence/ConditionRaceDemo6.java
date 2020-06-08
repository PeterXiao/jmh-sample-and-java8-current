package versions.java8.concurrence;

public class ConditionRaceDemo6 {

	static volatile int a = 3;

	public static void calc() {
		a = a + 2;
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			synchronized (args) {
				a = 3;
				Thread thread1 = new Thread(() -> calc());
				Thread thread2 = new Thread(() -> calc());
				thread2.start();
				thread1.start();
				Thread.sleep(100);
				System.out.println(a);
			}
		}
	}

}
