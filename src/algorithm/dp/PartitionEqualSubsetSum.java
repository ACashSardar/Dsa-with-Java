package algorithm.dp;

public class PartitionEqualSubsetSum {

	public static boolean subsetSum(int indx, int[] arr, int target, int[][] dp) {
		if (target == 0)
			return true;
		if (indx == 0)
			return target == arr[0];
		if (dp[indx][target] != -1)
			return dp[indx][target] == 1;
		boolean notPick = subsetSum(indx - 1, arr, target, dp);
		boolean pick = false;
		if (arr[indx] <= target)
			pick = subsetSum(indx - 1, arr, target - arr[indx], dp);
		dp[indx][target] = (pick || notPick) ? 1 : 0;
		return pick || notPick;
	}

	public static boolean subsetSumTabulation(int[] arr, int n, int k) {
		boolean[][] tb = new boolean[n + 1][k + 1];

		for (int i = 0; i < n; i++)
			tb[i][0] = true;
		tb[0][arr[0]] = true;

		for (int i = 1; i < n; i++) {
			for (int target = 1; target <= k; target++) {
				boolean notPick = tb[i - 1][target];
				boolean pick = false;
				if (arr[i] <= target)
					pick = tb[i - 1][target - arr[i]];
				tb[i][target] = pick || notPick;
			}
		}

		return tb[n - 1][k];
	}

	public static boolean canPartition(int[] arr, int n) {
		int sum = 0;
		for (int elem : arr)
			sum += elem;
		if (sum % 2 == 1)
			return false;
		
// For memoization purpose
//		int[][] dp = new int[n + 1][(sum / 2) + 1];
//		for (int[] row : dp) {
//			for (int c = 0; c < row.length; c++) {
//				row[c] = -1;
//			}
//		}
//		return subsetSum(n - 1, arr, sum / 2, dp);

		return subsetSumTabulation(arr, n, sum / 2);
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 8, 7, 6, 12, 4, 5 };
		System.out.println(canPartition(arr, arr.length));

	}

}
