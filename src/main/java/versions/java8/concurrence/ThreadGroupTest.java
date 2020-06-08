package versions.java8.concurrence;

public class ThreadGroupTest {
	public static void main(String[] args) {
		System.out.println("A���̣߳�" + Thread.currentThread().getName() + ", �����̣߳�"
				+ Thread.currentThread().getThreadGroup().getName() + ", �������߳���������"
				+ Thread.currentThread().getThreadGroup().activeGroupCount());
		ThreadGroup group = new ThreadGroup("�µ���");
		System.out.println("B���̣߳�" + Thread.currentThread().getName() + ", �����̣߳�"
				+ Thread.currentThread().getThreadGroup().getName() + ", �������߳���������"
				+ Thread.currentThread().getThreadGroup().activeGroupCount());
		ThreadGroup[] tg = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
		Thread.currentThread().getThreadGroup().enumerate(tg);
		for (int i = 0; i < tg.length; i++)
			System.out.println("��һ���߳�������Ϊ��" + tg[i].getName());
	}
}
