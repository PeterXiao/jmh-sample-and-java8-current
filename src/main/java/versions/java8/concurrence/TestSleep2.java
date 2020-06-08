package versions.java8.concurrence;

public class TestSleep2 {

	public static void main(String[] args) {
		System.out.println("�ǵ�ǰ�߳�˯��3000ms");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("˯�߽���");
	}

}
