package udemy.codingMinutes.dp.digits;

public class Investigation {

	public static int solve(int i, long sum, long num_mod, boolean last, String s, int k) {
		if (i == s.length()) {
			return sum % k == 0 && num_mod == 0 ? 1 : 0;
		}
		int hi = last ? s.charAt(i) - '0' : 9;
		int ans = 0;
		for (int digit = 0; digit <= hi; digit++) {
			ans += solve(i + 1, sum + digit, ((num_mod * 10) % k + digit) % k, (last && digit == hi), s, k);
		}
		return ans;
	}

	public static void main(String[] args) {
		int a = 1;
		int b = 1000;
		int k = 4;
		int ans = solve(0, 0, 0, true, b + "", k) - solve(0, 0, 0, true, (a - 1) + "", k);
		System.out.println(ans);

	}
}
