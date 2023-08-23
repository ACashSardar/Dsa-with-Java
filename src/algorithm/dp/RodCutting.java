package algorithm.dp;

public class RodCutting {
	public static int func(int i, int[] price, int N, int[][] dp) {
		if (N == 0)
			return 0;
		if (i == 0)
			return price[0] * N;
		if (dp[i][N] != -1)
			return dp[i][N];
		int rodlength = i + 1;
		int notpick = 0 + func(i - 1, price, N, dp);
		int pick = Integer.MIN_VALUE;
		if (N >= rodlength)
			pick = price[i] + func(i, price, N - rodlength, dp);
		return dp[i][N] = Math.max(pick, notpick);
	}

	public static int cutRod(int price[], int n) {
//		int[][] dp = new int[n][n + 1];

//		MEMOIZATION
//		for (int[] row : dp) {
//			for (int c = 0; c < row.length; c++)
//				row[c] = -1;
//		}
//		return func(n - 1, price, n, dp);

		
//		TABULATION
//		for (int i = 0; i < n; i++) {
//			dp[i][0] = 0;
//		}
//		for (int N = 1; N <= n; N++) {
//			dp[0][N] = price[0] * N;
//		}
//		for (int i = 1; i < n; i++) {
//			for (int N = 1; N <= n; N++) {
//				int rodlength = i + 1;
//				int notpick = dp[i - 1][N];
//				int pick = Integer.MIN_VALUE;
//				if (N >= rodlength)
//					pick = price[i] + dp[i][N - rodlength];
//				dp[i][N] = Math.max(pick, notpick);
//			}
//		}
//		return dp[n - 1][n];

		
//		TABULATION(Space Optimized)
		int[] prev = new int[n + 1];
		int[] curr = new int[n + 1];

		for (int N = 1; N <= n; N++) {
			prev[N] = price[0] * N;
		}
		for (int i = 1; i < n; i++) {
			for (int N = 1; N <= n; N++) {
				int rodlength = i + 1;
				int notpick = prev[N];
				int pick = Integer.MIN_VALUE;
				if (N >= rodlength)
					pick = price[i] + curr[N - rodlength];
				curr[N] = Math.max(pick, notpick);
			}
			prev = curr;
		}
		return prev[n];
	}

	public static void main(String[] args) {
		int[] price = new int[] { 3, 5, 8, 9, 10, 17, 17, 20 };
		int n = price.length;
		System.out.println(cutRod(price, n));// 24
	}

}
