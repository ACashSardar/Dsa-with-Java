package algorithm.dp;

public class MinSubsetSumDifference {
	public static int minSubsetSumDifference(int[] arr, int n) {

		int totalSum = 0;
		for (int elem : arr)
			totalSum += elem;
		boolean[][] tb = new boolean[n][totalSum + 1];

		for (int i = 0; i < n; i++) {
			tb[i][0] = true;
		}
		tb[0][arr[0]] = true;
		for (int i = 1; i < n; i++) {
			for (int target = 1; target <= totalSum; target++) {
				boolean notPick = tb[i - 1][target];
				boolean pick = false;
				if (arr[i] <= target)
					pick = tb[i - 1][target - arr[i]];
				tb[i][target] = pick || notPick;
			}
		}

		int minDiff = totalSum;

		for (int i = 0; i <= totalSum / 2; i++) {
			if (tb[n - 1][i]) {
				minDiff = Math.abs(totalSum - 2 * i);
			}
		}
		return minDiff;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
