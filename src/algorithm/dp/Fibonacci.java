package algorithm.dp;

import java.util.Arrays;

public class Fibonacci {

	public static int fibo(int n) {
		if (n <= 1)
			return n;
		return fibo(n - 1) + fibo(n - 2);
	}

	// Recursion to dp
	public static int fiboMemo(int n, int[] dp) {
		if (n <= 1)
			return n;
		if (dp[n] != -1)
			return dp[n];
		return dp[n] = fiboMemo(n - 1, dp) + fiboMemo(n - 2, dp);
	}

	public static void main(String[] args) {
		int n = 10;

		System.out.println("Recursion: TC-O(2^n), SC-O(n) [Aux Stack space]");
		for (int i = 0; i <= n; i++) {
			System.out.print(fibo(i) + " ");
		}

		System.out.println("\nMemoization: TC-O(n), SC-O(n) [Aux Stack space]+ O(n) [extra dp array]");

		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		for (int i = 0; i <= n; i++) {
			System.out.print(fiboMemo(i, dp) + " ");
		}

		System.out.println("\nTabulation: TC-O(n), SC-O(n)");

		int[] tb = new int[n + 1];
		
		tb[0] = 0;
		tb[1] = 1;
		for (int i = 2; i <= n; i++) {
			tb[i] = tb[i - 1] + tb[i - 2];
		}

		for (int i = 0; i <= n; i++) {
			System.out.print(tb[i] + " ");
		}
	}

}
