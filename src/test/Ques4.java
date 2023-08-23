package test;

public class Ques4 {

	public static void main(String[] args) {
		int[] dp = new int[6];
		dp[0] = 1; // 'a'->0
		dp[1] = 2; // 'b'->1
		for (int i = 0; (char) ('a' + i) <= 'f'; i++) {
			if (i > 1) {
				dp[i] = 2 * (dp[i - 1] - dp[i - 2]);
			}
			System.out.print(dp[i]+" ");
		}
	}

}
