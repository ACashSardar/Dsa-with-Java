package algorithm.slidingwindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {

	public static List<Integer> maxSlidingWindow(int[] nums, int k) {

		Deque<Integer> deque = new ArrayDeque<>();
		int i = 0;
		int j = 0;
		int n = nums.length;
		List<Integer> ans = new ArrayList<>();

		while (j < n) {

			while (!deque.isEmpty() && deque.getLast() < nums[j]) {
				deque.removeLast();
			}
			deque.addLast(nums[j]);

			if (j - i + 1 == k) {
				ans.add(deque.getFirst());
				if (nums[i] == deque.getFirst()) {
					deque.removeFirst();
				}
				i++;
			}
			j++;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		List<Integer> res = maxSlidingWindow(arr, k);
		System.out.println(res);
	}

}
