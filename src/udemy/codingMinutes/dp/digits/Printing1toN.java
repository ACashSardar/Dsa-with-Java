package udemy.codingMinutes.dp.digits;

public class Printing1toN {
	public static void solve(int i, String path, boolean last, String s) {
		if (i == s.length()) {
			System.out.println(path);
			return;
		}
		int hi = last ? s.charAt(i) - '0' : 9;
		for (int digit = 0; digit <= hi; digit++) {
			solve(i + 1, path + digit, (last && digit == hi), s);
		}
	}

	public static void main(String[] args) {
		String s = "435";
		solve(0, "", true, s);
	}

}
