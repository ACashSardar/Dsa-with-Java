package datastructure.array;

public class TappingRainWater {
	public static int trap(int[] height) {
		int n = height.length;
		int area = 0;
		int lmax = 0;
		int rmax = 0;
		// stores max heights at any given index while going from left->right
		int[] prefixSum = new int[n];
		// stores max heights at any given index while going from left<-right
		int[] suffixSum = new int[n];
		for (int i = 0; i < n; i++) {
			lmax = Math.max(lmax, height[i]);
			prefixSum[i] = lmax;
			rmax = Math.max(rmax, height[n - i - 1]);
			suffixSum[n - i - 1] = rmax;
		}
		for (int i = 0; i < n; i++) {
			area += (Math.min(prefixSum[i], suffixSum[i]) - height[i]) * 1;
		}
		return area;
	}

	public static void main(String[] args) {
		int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println("Amount of water tapped=" + trap(height));
	}

}
