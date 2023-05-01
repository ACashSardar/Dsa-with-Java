package algorithm.dp;

import java.util.Arrays;

public class AssignSignsTargetSum {

	// MEMOIZATION
	public static int func(int i, int tar, int[] arr, int[][] dp) {

		if (i == 0) {
			if (tar == 0 && arr[0] == 0)
				return 2;
			else if (tar == 0 || tar == arr[0])
				return 1;
			else
				return 0;
		}

		if (dp[i][tar] != -1)
			return dp[i][tar];

		int pick = 0;
		if (tar >= arr[i])
			pick = func(i - 1, tar - arr[i], arr, dp);
		int notpick = func(i - 1, tar, arr, dp);

		return dp[i][tar] = pick + notpick;
	}

	public static int targetSum(int n, int target, int[] arr) {
		int sum = 0;
		for (int e : arr)
			sum += e;

		if ((sum - target) % 2 == 1)
			return 0;
		int s1 = (sum - target) / 2;

		// int [][] dp=new int [n][s1+1];

		// for(int [] row: dp) Arrays.fill(row, -1);
		// return func(n-1, s1, arr, dp);

		// TABULATION
		// for(int i=0; i<n; i++){
		// for(int tar=0; tar<=s1; tar++){
		// if(i==0){
		// if(tar==0 && arr[0]==0) dp[i][tar]=2;
		// else if(tar==0 || tar==arr[0]) dp[i][tar]=1;
		// else dp[i][tar]=0;
		// }
		// else{
		// int pick=0;
		// if(tar>=arr[i]) pick=dp[i-1][tar-arr[i]];
		// int notpick=dp[i-1][tar];
		// dp[i][tar]=pick+notpick;
		// }
		// }
		// }
		// return dp[n-1][s1];

		// SPACE OPTIMIZATION
		int[] prev = new int[s1 + 1];
		int[] curr = new int[s1 + 1];

		for (int i = 0; i < n; i++) {
			for (int tar = 0; tar <= s1; tar++) {
				if (i == 0) {
					if (tar == 0 && arr[0] == 0)
						prev[tar] = 2;
					else if (tar == 0 || tar == arr[0])
						prev[tar] = 1;
					else
						prev[tar] = 0;
				} else {
					int pick = 0;
					if (tar >= arr[i])
						pick = prev[tar - arr[i]];
					int notpick = prev[tar];
					curr[tar] = pick + notpick;
				}
			}
			if (i > 0) {
				for (int k = 0; k < curr.length; k++)
					prev[k] = curr[k];
				Arrays.fill(curr, 0);
			}
		}

		return prev[s1];
	}

}
