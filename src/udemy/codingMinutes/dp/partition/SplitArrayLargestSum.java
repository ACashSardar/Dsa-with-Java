package udemy.codingMinutes.dp.partition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SplitArrayLargestSum {

	// Recursion+Memoization
	public static int solve(int i, int n, int k, int[] nums, int[] prefix, int[][] dp) {
		if (k == 1) {
			return i > 0 ? prefix[n - 1] - prefix[i - 1] : prefix[n - 1];
		}
		if (i == n) {
			return 999999;
		}
		if (dp[i][k] != -1) {
			return dp[i][k];
		}
		int mini = Integer.MAX_VALUE;
		for (int j = i; j < n; j++) {
			int curr = i > 0 ? prefix[j] - prefix[i - 1] : prefix[j];
			int temp = solve(j + 1, n, k - 1, nums, prefix, dp);
			mini = Math.min(mini, Math.max(curr, temp));
		}
		return dp[i][k] = mini;
	}

	public static int splitArray(int[] nums, int k) {
		int n = nums.length;
		int[] prefix = new int[n];
		int ps = 0;
		for (int i = 0; i < n; i++) {
			ps += nums[i];
			prefix[i] = ps;
		}
		int[][] dp = new int[n + 1][k + 1];

		// Tabulation
		for (int i = n; i >= 0; i--) {
			for (int k1 = 1; k1 <= k; k1++) {
				if (k1 == 1) {
					dp[i][k1] = i > 0 ? (prefix[n - 1] - prefix[i - 1]) : prefix[n - 1];
				} else if (i == n) {
					dp[i][k1] = 999999;
				} else {
					int mini = Integer.MAX_VALUE;
					for (int j = i; j < n; j++) {
						int curr = i > 0 ? prefix[j] - prefix[i - 1] : prefix[j];
						int temp = dp[j + 1][k1 - 1];
						mini = Math.min(mini, Math.max(curr, temp));
					}
					dp[i][k1] = mini;
				}
			}
		}
		return dp[0][k];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] strArr = br.readLine().split(" ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(strArr[i]);
		}
		int k = Integer.parseInt(br.readLine());
		int ans = splitArray(arr, k);
		System.out.println(ans);
	}

}
