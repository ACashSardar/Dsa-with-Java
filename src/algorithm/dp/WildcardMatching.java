package algorithm.dp;

public class WildcardMatching {
	public static boolean func(int i, int j, String s, String p, int[][] dp) {
		if (i < 0 && j < 0)
			return true;
		if (i >= 0 && j < 0)
			return false;
		if (i < 0 && j >= 0) {
			for (int k = 0; k <= j; k++)
				if (p.charAt(k) != '*')
					return false;
			return true;
		}
		if (dp[i][j] != -1)
			return dp[i][j] == 1;

		if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
			dp[i][j] = func(i - 1, j - 1, s, p, dp) ? 1 : 0;
			return dp[i][j] == 1;
		}
		if (p.charAt(j) == '*') {
			dp[i][j] = func(i - 1, j, s, p, dp) || func(i, j - 1, s, p, dp) ? 1 : 0;
			return dp[i][j] == 1;
		}
		dp[i][j] = 0;
		return false;
	}

	public static boolean isMatch(String s, String p) {
		int n = s.length();
		int m = p.length();
//		int[][] dp = new int[n][m];
//		for (int[] row : dp)
//			Arrays.fill(row, -1);
//		return func(n - 1, m - 1, s, p, dp);
		
//		TABULATION
		boolean[][] tb = new boolean[n + 1][m + 1];

		tb[0][0] = true;
		for (int i = 1; i <= n; i++) {
			tb[i][0] = false;
		}

		for (int j = 1; j <= m; j++) {
			boolean flag = true;
			for (int k = 1; k <= j; k++) {
				if (p.charAt(k - 1) != '*')
					flag = false;
			}
			tb[0][j] = flag;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
					tb[i][j] = tb[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					tb[i][j] = tb[i - 1][j] || tb[i][j - 1];
				} else
					tb[i][j] = false;
			}
		}
		return tb[n][m];
	}

	public static void main(String[] args) {
		System.out.println(isMatch("bb", "*"));
	}

}
