package algorithm.dp;

public class LongestPalindromicSubsequence {
	// Finding the LPS length=Finding the LCS length with it's reversed version
	public static int longestPalindromeSubseq(String s) {
		int n = s.length();
		String rev = "";
		for (char ch : s.toCharArray())
			rev = ch + rev;
		int[][] dp = new int[n + 1][n + 1];

		for (int i1 = 0; i1 <= n; i1++)
			dp[i1][0] = 0;
		for (int i2 = 0; i2 <= n; i2++)
			dp[0][i2] = 0;

		for (int i1 = 1; i1 <= n; i1++) {
			for (int i2 = 1; i2 <= n; i2++) {
				if (s.charAt(i1 - 1) == rev.charAt(i2 - 1)) {
					dp[i1][i2] = 1 + dp[i1 - 1][i2 - 1];
				} else
					dp[i1][i2] = Math.max(dp[i1][i2 - 1], dp[i1 - 1][i2]);
			}
		}
		return dp[n][n];
	}

	public static void main(String[] args) {
		System.out.println(longestPalindromeSubseq("cbbd"));// 2

	}

}
