package algorithm.slidingwindow;

import java.util.Arrays;
import java.util.List;

public class MaxSumSubArrayOfSizeK {
	public static long maximumSumSubarray(int K, List<Integer> Arr, int N) {
		// code here
		int i = 0;
		int j = 0;
		long sum = 0;
		long maxi = Long.MIN_VALUE;
		while (j < N) {
			sum += Arr.get(j);
			if (j - i + 1 < K) {
				j++;
			} else if (j - i + 1 == K) {
				maxi = Math.max(maxi, sum);
				sum -= Arr.get(i);
				i++;
				j++;
			}
		}
		return maxi;
	}

	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(100, 200, 300, 400);
		int n = arr.size();
		int k = 2;
		System.out.println(maximumSumSubarray(k, arr, n));

	}

}
