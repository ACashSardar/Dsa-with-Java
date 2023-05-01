package datastructure.array;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithZeroSum {
	static int maxLen(int arr[], int n) {
		// Your code here
		int prefixSum = 0;
		int maxLen = 0;

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			prefixSum += arr[i];
			if (prefixSum == 0) {
				maxLen = Math.max(maxLen, i + 1);
			} else if (map.containsKey(prefixSum)) {
				int l = map.get(prefixSum);
				maxLen = Math.max(maxLen, i - l);
			} else {
				map.put(prefixSum, i);
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {

		System.out
				.println("Largest subarray having a sum=0 is: " + maxLen(new int[] { 15, -2, 2, -8, 1, 7, 10, 23 }, 8));

	}

}
