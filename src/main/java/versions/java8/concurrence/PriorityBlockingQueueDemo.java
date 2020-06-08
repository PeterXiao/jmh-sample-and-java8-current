package versions.java8.concurrence;

import versions.java8.concurrence.jdk.PriorityBlockingQueue;

public class PriorityBlockingQueueDemo {

	static class Money implements Comparable<Money> {

		private int value;

		Money(int v) {
			this.value = v;
		}

		public int compareTo(Money o) {
			return this.value > o.value ? 1 : -1;
		}
	}

	public static void main(String[] args) throws InterruptedException {

		PriorityBlockingQueue<Money> queue = new PriorityBlockingQueue<Money>();
		int[] values = { 1, 100, 2, 20, 10, 5, 50 };

		for (int v : values)
			queue.put(new Money(v));

		for (int i = 0; i < values.length; i++)
			System.out.println(queue.take().value);

	}
}
