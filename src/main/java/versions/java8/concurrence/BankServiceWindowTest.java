package versions.java8.concurrence;

public class BankServiceWindowTest {
	public static void main(String[] args) {
		final BankServiceWindow bankServiceWindow = new BankServiceWindow();
		Thread tom = new Thread(() -> {
			bankServiceWindow.handle();
			System.out.println("tom��ʼ����ҵ��");
			try {
				Thread.currentThread().sleep(5000);
			} catch (InterruptedException e) {}
			System.out.println("tom��������ҵ��");
			bankServiceWindow.unhandle();
		});
		Thread jim = new Thread(() -> {
			bankServiceWindow.handle();
			System.out.println("jim��ʼ����ҵ��");
			try {
				Thread.currentThread().sleep(5000);
			} catch (InterruptedException e) {}
			System.out.println("jim��������ҵ��");
			bankServiceWindow.unhandle();
		});
		Thread jay = new Thread(() -> {
			bankServiceWindow.handle();
			System.out.println("jay��ʼ����ҵ��");
			try {
				Thread.currentThread().sleep(5000);
			} catch (InterruptedException e) {}
			System.out.println("jay��������ҵ��");
			bankServiceWindow.unhandle();
		});
		tom.start();
		jim.start();
		jay.start();
	}
}
