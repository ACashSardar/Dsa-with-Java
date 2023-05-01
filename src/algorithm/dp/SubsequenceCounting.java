package algorithm.dp;

// Counts number of occurrence of s inside t
public class SubsequenceCounting {
	public static int func(int i, int j, String t, String s, int[][] dp) {

		if (j < 0)
			return 1;
		if (i < 0)
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];

		if (t.charAt(i) == s.charAt(j)) {
			return dp[i][j] = (func(i - 1, j - 1, t, s, dp) + func(i - 1, j, t, s, dp)) % ((int) Math.pow(10, 9) + 7);
		}
		return dp[i][j] = func(i - 1, j, t, s, dp) % ((int) Math.pow(10, 9) + 7);
	}

	public static int subsequenceCounting(String t, String s, int lt, int ls) {
		// Write your code here..
		int[][] dp = new int[lt][ls];
		for (int[] row : dp) {
			for (int c = 0; c < row.length; c++) {
				row[c] = -1;
			}
		}
		return func(lt - 1, ls - 1, t, s, dp);
	}

	public static void main(String[] args) {
		System.out.println(subsequenceCounting("brootgroot", "brt", 10, 3));
	}

}
