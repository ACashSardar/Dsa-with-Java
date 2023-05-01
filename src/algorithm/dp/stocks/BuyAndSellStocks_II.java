package algorithm.dp.stocks;

public class BuyAndSellStocks_II {
	public static int func(int i, int buy, int[] prices, int n, int[][] dp) {
		if (i == n)
			return 0;

		if (dp[i][buy] != -1)
			return dp[i][buy];

		int profit = 0;
		if (buy == 1) {
			profit = Math.max((-prices[i] + func(i + 1, 0, prices, n, dp)), func(i + 1, 1, prices, n, dp));
		} else {
			profit = Math.max((prices[i] + func(i + 1, 1, prices, n, dp)), func(i + 1, 0, prices, n, dp));
		}
		return dp[i][buy] = profit;
	}

	public static int maxProfit(int[] prices) {
		int n = prices.length;
		int[][] dp = new int[n + 1][2];

		for (int buy = 0; buy <= 1; buy++) {
			dp[n][buy] = 0;
		}

		for (int i = n - 1; i >= 0; i--) {
			for (int buy = 0; buy <= 1; buy++) {
				int profit = 0;
				if (buy == 1) {
					profit = Math.max((-prices[i] + dp[i + 1][0]), dp[i + 1][1]);
				} else {
					profit = Math.max((prices[i] + dp[i + 1][1]), dp[i + 1][0]);
				}
				dp[i][buy] = profit;
			}
		}
		return dp[0][1];
	}

	public static void main(String[] args) {
		System.out.println(maxProfit(new int [] {7,1,5,3,6,4}));

	}

}
