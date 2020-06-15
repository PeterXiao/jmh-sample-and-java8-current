package algorithms.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinNumer {

	public class Solution {
		public int minNumberInRotateArray(int[] array) {
			if (array.length == 0) {
				return 0;
			}
			int min = array[0];
			for (int i = 1; i < array.length; i++) {
				if (array[i] < min) {
					min = array[i];
				}
			}
			return min;
		}

	}

	public int minNumberInRotateArray(int[] array) {
		int n = array.length;
		if (n == 0) {
			return 0;
		}
		Arrays.sort(array);
		return array[0];
	}

	public int minNumberInRotateArrayS(int[] array) {
		int n = array.length;
		if (n == 0) {
			return 0;
		}
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			queue.add(array[i]);
		}
		return queue.poll();
	}

	public int minNumberInRotateArrayBinarySearch(int[] array) {
		int i = 0;
		int j = array.length - 1;
		while (i < j) {
			if (array[i] < array[j]) {
				return array[i];
			}
			int mid = (i + j) / 2;
			if (array[mid] > array[i]) {
				i = mid + 1;
			} else if (array[mid] < array[j]) {
				j = mid; // 证明进入了有序数组，直接输出
			} else {
				i++;
			}
		}
		return array[i];
	}
}
