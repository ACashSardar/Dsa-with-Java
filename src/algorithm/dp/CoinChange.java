package algorithm.dp;

import java.util.Arrays;

public class CoinChange {
	public static int func(int i, int target, int[] coins, int[][] dp) {
		if (target == 0) {
			return 0;
		}
		if (i == 0) {
			if (target % coins[0] == 0)
				return target / coins[0];
			return Integer.MAX_VALUE;
		}
		if (dp[i][target] != -1)
			return dp[i][target];

		int pick = Integer.MAX_VALUE;
		if (target >= coins[i]) {
			pick = 1 + func(i, target - coins[i], coins, dp);
		}
		int notPick = func(i - 1, target, coins, dp);
		return dp[i][target] = Math.min(pick, notPick);
	}

	public static int minimumCoins(int p) {
		int[] coins = new int[] { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
		int n = coins.length;
		int[][] dp = new int[n][p + 1];
		for (int[] row : dp)
			Arrays.fill(row, -1);
		return func(n - 1, p, coins, dp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
