package algorithm.dp;

import java.util.Arrays;

public class MinPathSum2dGrid {

	// Memoization
	public static int func(int i, int j, int[][] grid, int[][] dp) {
		if (i == 0 && j == 0)
			return grid[0][0];
		if (i < 0 || j < 0)
			return Integer.MAX_VALUE;
		if (dp[i][j] != -1)
			return dp[i][j];
		int left = func(i - 1, j, grid, dp);
		int up = func(i, j - 1, grid, dp);
		return dp[i][j] = grid[i][j] + Math.min(left, up);
	}

	// Tabulation 🔥
	public static int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] tb = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0)
					tb[i][j] = grid[i][j];
				else {
					int left = Integer.MAX_VALUE;
					int up = Integer.MAX_VALUE;
					if (i > 0)
						left = tb[i - 1][j];
					if (j > 0)
						up = tb[i][j - 1];
					tb[i][j] = grid[i][j] + Math.min(left, up);
				}
			}
		}
		return tb[m - 1][n - 1];
	}

	public static void main(String[] args) {
		int[][] grid = new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		System.out.println(func(m - 1, n - 1, grid, dp));

		System.out.println(minPathSum(grid));
	}
}
