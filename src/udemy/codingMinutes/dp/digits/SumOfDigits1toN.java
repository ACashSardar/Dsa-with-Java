package udemy.codingMinutes.dp.digits;

public class SumOfDigits1toN {
	public static int solve(int i, int sum, boolean last, String s) {
		if (i == s.length()) {
			return sum;
		}
		int hi = last ? s.charAt(i) - '0' : 9;
		int ans = 0;
		for (int digit = 0; digit <= hi; digit++) {
			ans += solve(i + 1, sum + digit, (last && digit == hi), s);
		}
		return ans;
	}

	public static void main(String[] args) {
		String s = "13";
		int ans = solve(0, 0, true, s);
		System.out.println(ans);

	}

}
