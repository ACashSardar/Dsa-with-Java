package algorithm.dp;

import java.util.Arrays;

public class LongestCommonSubsequence {

	static int func(int i1, int i2, String text1, String text2, int[][] dp) {

		if (i1 < 0 || i2 < 0)
			return 0;

		if (dp[i1][i2] != -1)
			return dp[i1][i2];

		if (text1.charAt(i1) == text2.charAt(i2)) {
			return dp[i1][i2] = 1 + func(i1 - 1, i2 - 1, text1, text2, dp);
		}
		return dp[i1][i2] = Math.max(func(i1, i2 - 1, text1, text2, dp), func(i1 - 1, i2, text1, text2, dp));
	}

	public static int longestCommonSubsequence(String text1, String text2) {
		int n1 = text1.length();
		int n2 = text2.length();

//		MEMOIZATION
//		int[][] dp = new int[n1][n2];
//		for (int[] row : dp)
//			Arrays.fill(row, -1);
//		return func(n1 - 1, n2 - 1, text1, text2, dp);

//		TABULATION
//      shifting of indexes in tabulation
		int[][] dp = new int[n1 + 1][n2 + 1];

		for (int i1 = 0; i1 <= n1; i1++)
			dp[i1][0] = 0;
		for (int i2 = 0; i2 <= n2; i2++)
			dp[0][i2] = 0;

		for (int i1 = 1; i1 <= n1; i1++) {
			for (int i2 = 1; i2 <= n2; i2++) {
				if (text1.charAt(i1 - 1) == text2.charAt(i2 - 1)) {
					dp[i1][i2] = 1 + dp[i1 - 1][i2 - 1];
				} else
					dp[i1][i2] = Math.max(dp[i1][i2 - 1], dp[i1 - 1][i2]);
			}
		}
		return dp[n1][n2];
	}

	public static void main(String[] args) {
		System.out.println("Length of LCS: " + longestCommonSubsequence("abcde", "ace"));
	}

}
