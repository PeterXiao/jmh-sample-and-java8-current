package versions.java8.concurrence;

public class BankServiceWindowSharedTest {
	public static void main(String[] args) {
		final BankServiceWindowShared bankServiceWindows = new BankServiceWindowShared(2);
		Thread tom = new Thread(() -> {
			bankServiceWindows.handle();
			System.out.println("tom��ʼ����ҵ��");
			try {
				Thread.currentThread().sleep(5000);
			} catch (InterruptedException e) {}
			System.out.println("tom��������ҵ��");
			bankServiceWindows.unhandle();
		});
		Thread jim = new Thread(() -> {
			bankServiceWindows.handle();
			System.out.println("jim��ʼ����ҵ��");
			try {
				Thread.currentThread().sleep(5000);
			} catch (InterruptedException e) {}
			System.out.println("jim��������ҵ��");
			bankServiceWindows.unhandle();
		});
		Thread jay = new Thread(() -> {
			bankServiceWindows.handle();
			System.out.println("jay��ʼ����ҵ��");
			try {
				Thread.currentThread().sleep(5000);
			} catch (InterruptedException e) {}
			System.out.println("jay��������ҵ��");
			bankServiceWindows.unhandle();
		});
		tom.start();
		jim.start();
		jay.start();
	}
}
