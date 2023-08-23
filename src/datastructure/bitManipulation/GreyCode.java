package datastructure.bitManipulation;

import java.util.ArrayList;
import java.util.List;

public class GreyCode {
	static class Pair {
		int val;
		String str;
		Pair(int val, String str) {
			this.val = val;
			this.str = str;
		}
	}

	public static void solve(List<Pair> ans, int p, int n) {
		if (p == n)
			return;
		List<Pair> upper = new ArrayList<>();
		List<Pair> lower = new ArrayList<>();

		for (int i = 0; i < ans.size(); i++) {
			upper.add(new Pair(ans.get(i).val, "0" + ans.get(i).str));
		}
		for (int i = ans.size() - 1; i >= 0; i--) {
			lower.add(new Pair((int) Math.pow(2, p) + ans.get(i).val, "1" + ans.get(i).str));
		}
		ans.clear();
		for (int i = 0; i < upper.size(); i++) {
			ans.add(upper.get(i));
		}
		for (int i = 0; i < lower.size(); i++) {
			ans.add(lower.get(i));
		}
		solve(ans, p + 1, n);
	}

	public static void main(String[] args) {

		List<Pair> ans = new ArrayList<>();
		int n = 5;
		ans.add(new Pair(0, ""));
		solve(ans, 0, n);
		for (Pair p : ans) {
			System.out.println(p.str + " ---> " + p.val);
		}
	}

}
