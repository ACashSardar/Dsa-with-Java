package algorithm.dp;

public class MatrixChainMultiplication {
	// Memoization
	public static int func(int i, int j, int[] arr, int[][] dp) {
		if (i == j)
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];
		int mini = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int steps = arr[i - 1] * arr[k] * arr[j] + func(i, k, arr, dp) + func(k + 1, j, arr, dp);
			mini = Math.min(mini, steps);
		}
		return dp[i][j] = mini;
	}

	public static int matrixMultiplication(int[] arr, int N) {
		// Write your code here
		int[][] dp = new int[N][N];
//         for(int [] row: dp) Arrays.fill(row,-1);
//         return func(1,N-1,arr,dp);

		for (int i = N - 1; i > 0; i--) {
			for (int j = 0; j <= N - 1; j++) {
				if (i == j)
					dp[i][j] = 0;
				else {
					int mini = Integer.MAX_VALUE;
					for (int k = i; k < j; k++) {
						int steps = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
						mini = Math.min(mini, steps);
					}
					dp[i][j] = mini;
				}
			}
		}
		return dp[1][N - 1];
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 4, 5, 3, 2 };
		System.out.println(matrixMultiplication(arr, arr.length)); // 70
	}

}
