package algorithm.dp;

import java.util.Arrays;

public class UniquePaths2dGrid {

	// Memoization
	public static int func(int i, int j, int[][] dp) {
		if (i < 0 || j < 0)
			return 0;
		if (i == 0 || j == 0)
			return 1;
		if (dp[i][j] != -1)
			return dp[i][j];
		int left = func(i - 1, j, dp);
		int up = func(i, j - 1, dp);
		return dp[i][j] = left + up;
	}

	public static void main(String[] args) {
		int m = 4;
		int n = 4;
		int[][] dp = new int[m][n];
		for (int[] row : dp)
			Arrays.fill(row, -1);
		System.out.println(func(m - 1, n - 1, dp));

		int[][] tb = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0)
					tb[i][j] = 1;
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				int left = tb[i - 1][j];
				int up = tb[i][j - 1];
				tb[i][j] = left + up;
			}
		}

		System.out.println(tb[m - 1][n - 1]);

	}

}
