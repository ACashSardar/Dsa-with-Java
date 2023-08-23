package algorithm.dp;

public class _01Knapsack {

	// Memoization
	public static int func(int i, int[] wt, int[] val, int W, int[][] dp) {
		if (i == 0) {
			if (wt[i] <= W)
				return val[0];
			return 0;
		}
		if (dp[i][W] != -1)
			return dp[i][W];
		int notpick = 0 + func(i - 1, wt, val, W, dp);
		int pick = Integer.MIN_VALUE;
		if (wt[i] <= W)
			pick = val[i] + func(i - 1, wt, val, W - wt[i], dp);
		return dp[i][W] = Math.max(pick, notpick);
	}

	public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
		int[][] dp = new int[n][maxWeight + 1];

		// for(int [] row: dp){
		// for(int c=0; c<row.length; c++){
		// row[c]=-1;
		// }
		// }
		// return func(n-1,weight,value,maxWeight, dp);

		// Tabulation
		for (int W = weight[0]; W <= maxWeight; W++) {
			dp[0][W] = value[0];
		}
		for (int i = 1; i < n; i++) {
			for (int W = 0; W <= maxWeight; W++) {
				int notpick = dp[i - 1][W];
				int pick = Integer.MIN_VALUE;
				if (weight[i] <= W)
					pick = value[i] + dp[i - 1][W - weight[i]];
				dp[i][W] = Math.max(pick, notpick);
			}
		}
		return dp[n - 1][maxWeight];
	}

	public static void main(String[] args) {
		int[] wt = new int[] { 1, 2, 4, 5 };
		int[] val = new int[] { 5, 4, 8, 6 };
		int maxWt = 0;
		System.out.println(knapsack(wt, val, wt.length, maxWt)); // 13 ans
	}

}
