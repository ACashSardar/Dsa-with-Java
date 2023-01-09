package algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinPathSumTriangle {

	public static int func(int i, int j, int n, List<List<Integer>> triangle, int[][] dp) {
		if (i == n - 1)
			return triangle.get(n - 1).get(j);
		if (dp[i][j] != -1)
			return dp[i][j];
		int dwn = triangle.get(i).get(j) + func(i + 1, j, n, triangle, dp);
		int dg = triangle.get(i).get(j) + func(i + 1, j + 1, n, triangle, dp);
		return dp[i][j] = Math.min(dwn, dg);
	}

	public static int tabulation(int n, List<List<Integer>> triangle, int[][] tb) {
		for (int j = 0; j <= n - 1; j++) {
			tb[n - 1][j] = triangle.get(n - 1).get(j);
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = i; j >= 0; j--) {
				int dwn = triangle.get(i).get(j) + tb[i + 1][j];
				int dg = triangle.get(i).get(j) + tb[i + 1][j + 1];
				tb[i][j] = Math.min(dwn, dg);
			}
		}

		return tb[0][0];
	}

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 2 }, { 3, 4 }, { 6, 5, 2 }, { 4, 1, 8, 3 } };
		List<List<Integer>> triangle = new ArrayList<>();
		for (int[] row : arr) {
			List<Integer> temp = new ArrayList<>();
			for (int elem : row) {
				temp.add(elem);
			}
			triangle.add(temp);
		}
		int n = triangle.size();
		int[][] dp = new int[n][n];
		for (int[] row : dp)
			Arrays.fill(row, -1);
		System.out.println("Memoization: " + func(0, 0, n, triangle, dp));

		int[][] tb = new int[n][n];
		System.out.println("Tabulation: " + tabulation(n, triangle, tb));
	}

}
