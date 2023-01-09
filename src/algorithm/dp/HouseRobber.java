package algorithm.dp;

import java.util.ArrayList;
import java.util.List;

// Same problem as Max sum non adjacent elements
// Houses are arranged in circular fashion, so if we pick first element we have to leave the last one and vice versa;
// ans=Max(leaving out the first, leaving out the last)
public class HouseRobber {

	public static int maxSumNonAdj(List<Integer> nums) {
		int n = nums.size();
		int[] tb = new int[n];
		tb[0] = nums.get(0);
		for (int i = 1; i < n; i++) {
			int pick = nums.get(i);
			if (i > 1)
				pick += tb[i - 2];
			int notpick = tb[i - 1];
			tb[i] = Math.max(pick, notpick);
		}
		return tb[n - 1];
	}

	public static int rob(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];
		List<Integer> leaveLast = new ArrayList<>();
		List<Integer> leaveFirst = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (i != 0)
				leaveFirst.add(nums[i]);
			if (i != n - 1)
				leaveLast.add(nums[i]);
		}
		return Math.max(maxSumNonAdj(leaveFirst), maxSumNonAdj(leaveLast));
	}

	public static void main(String[] args) {
		System.out.println("Max profit: " + rob(new int[] { 2, 3, 2 }));
	}

}
