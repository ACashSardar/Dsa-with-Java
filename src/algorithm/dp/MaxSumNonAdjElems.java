package algorithm.dp;

import java.util.Arrays;
import java.util.List;

public class MaxSumNonAdjElems {

	// Memoization
	public static int func(int indx, List<Integer> nums, int[] dp) {
		if (indx == 0)
			return nums.get(0);
		if (indx < 0)
			return 0;
		if (dp[indx] != -1)
			return dp[indx];
		int pick = nums.get(indx) + func(indx - 2, nums, dp);
		int notpick = 0 + func(indx - 1, nums, dp);
		return dp[indx] = Math.max(pick, notpick);
	}

	// Tabulation
	public static int maxSumNonAdj(List<Integer> nums) {
		int n = nums.size();
		int[] tb = new int[n];
		tb[0] = nums.get(0);
		for (int i = 1; i < n; i++) {
			int pick = nums.get(i);
			if (i > 1)
				pick += tb[i - 2];
			int notpick = tb[i - 1];
			tb[i] = Math.max(pick, notpick);
		}
		return tb[n - 1];
	}

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(2, 4, 1, 5, 12, 5);
		int n = nums.size();
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		System.out.println("By memoization: " + func(nums.size() - 1, nums, dp));
		System.out.println("By tabulation: " + maxSumNonAdj(nums));
	}

}
