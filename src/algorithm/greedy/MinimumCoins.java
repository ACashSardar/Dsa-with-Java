package algorithm.greedy;

public class MinimumCoins {
	
	public static int minimumCoins(int p) {
		int[] coins = new int[] { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
		int n = coins.length;
		int cnt = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (p >= coins[i]) {
				int c = p / coins[i];
				p -= (c * coins[i]);
				cnt += c;
			}
		}

		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
