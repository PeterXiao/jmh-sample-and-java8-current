package versions.java8.concurrence;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo2 {
	static CyclicBarrier barrier = new CyclicBarrier(2, new Runnable() {
		public void run() {
			System.out.println("�Һ�Ů���Ѷ��������ˣ���ʼ���");
		}
	});

	public static void main(String[] args) {
		Thread me = new Thread(() -> {
			try {
				System.out.println("�ҵ��ﷹ�ݵ�Ů����");
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
			}
		});
		Thread girlfriend = new Thread(() -> {
			try {
				System.out.println("Ů���ѻ�ױ��Сʱ");
				Thread.sleep(30 * 60 * 1000);
				System.out.println("Ů���ѵ��ﷹ��");
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
			}
		});
		me.start();
		girlfriend.start();
	}
}
