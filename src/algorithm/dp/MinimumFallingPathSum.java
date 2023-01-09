package algorithm.dp;

import java.util.Arrays;

public class MinimumFallingPathSum {

	// function for variable start-fixed end path sum
	public static int func(int i, int j, int[][] matrix, int n, int[][] dp) {
		if (i < 0 || j < 0 || j >= n)
			return Integer.MAX_VALUE;
		if (i == 0)
			return matrix[0][j];
		if (dp[i][j] != -1)
			return dp[i][j];
		int up = func(i - 1, j, matrix, n, dp);
		int upLeft = func(i - 1, j - 1, matrix, n, dp);
		int upRight = func(i - 1, j + 1, matrix, n, dp);
		return dp[i][j] = matrix[i][j] + Math.min(up, Math.min(upLeft, upRight));
	}

	// Tabulation
	public static int tabulation(int[][] matrix, int n, int[][] tb) {
		for (int j = 0; j < n; j++) {
			tb[0][j] = matrix[0][j];
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int up = tb[i - 1][j];
				int upLeft = Integer.MAX_VALUE;
				int upRight = Integer.MAX_VALUE;
				if (j > 0)
					upLeft = tb[i - 1][j - 1];
				if (j + 1 < n)
					upRight = tb[i - 1][j + 1];
				tb[i][j] = matrix[i][j] + Math.min(up, Math.min(upLeft, upRight));
			}
		}
		int minVal = tb[n - 1][0];
		for (int j = 1; j < n; j++)
			minVal = Math.min(minVal, tb[n - 1][j]);
		return minVal;
	}

	public static void main(String[] args) {

		int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };

		int minSum = Integer.MAX_VALUE;
		int n = matrix.length;
		int[][] dp = new int[n][n];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		for (int j = 0; j < n; j++) {
			minSum = Math.min(minSum, func(n - 1, j, matrix, n, dp));
		}
		System.out.println("Memoization: " + minSum);

		int[][] tb = new int[n][n];
		System.out.println("Tabulation: " + tabulation(matrix, n, tb));
	}

}
