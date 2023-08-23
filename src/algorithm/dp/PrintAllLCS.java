package algorithm.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintAllLCS {
	/*
	 * The intuition is simple I would find the substring having maxLength ( if more
	 * than one string have same length , doesn't matters as I just want to find
	 * what Is the maxLength) as I am done finding the maxLength, I would be finding
	 * all the substring , to find them I can definitely do recursion approach, but
	 * but I will take a hashSet as the strings will be repeated. as I find the
	 * string which have size that of the maxLength I would add them into my ans,
	 * and also to the set which will keep track of the string be already added. Now
	 * I would only be handling the case when the character of string are equal and
	 * in else way would be handled by my base case. Now while returning I would
	 * definitely sort my ans as I have to return in Lexicographical order.
	 */

	class Solution {
		private int findLCS(String s, String t, int n, int m) {
			int[][] dp = new int[n + 1][m + 1];
			for (int i = 0; i <= n; i++)
				dp[i][0] = 0;
			for (int i = 0; i <= m; i++)
				dp[0][i] = 0;

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (s.charAt(i - 1) == t.charAt(j - 1)) {
						dp[i][j] = 1 + dp[i - 1][j - 1];
					} else {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
					}
				}
			}
			return dp[n][m];
		}

		private void findAllLCS(String s, String t, StringBuilder temp, int i, int j, int length, List<String> ans,
				Set<String> st) {
			if (length == 0) {
				if (st.contains(temp.toString()) == false) {
					ans.add(temp.toString());
					st.add(temp.toString());
				}
				return;
			}

			if (i >= s.length() || j >= t.length())
				return;

			for (int it1 = i; it1 < s.length(); it1++) {
				for (int it2 = j; it2 < t.length(); it2++) {
					if (s.charAt(it1) == t.charAt(it2)) {
						temp.append(s.charAt(it1));
						findAllLCS(s, t, temp, it1 + 1, it2 + 1, length - 1, ans, st);
						temp.deleteCharAt(temp.length() - 1);
					}
				}
			}
		}


		public List<String> all_longest_common_subsequences(String s, String t) {
			List<String> ans = new ArrayList<>();
			Set<String> st = new HashSet<>();
			int maxLength = findLCS(s, t, s.length(), t.length());
			StringBuilder temp = new StringBuilder();
			findAllLCS(s, t, temp, 0, 0, maxLength, ans, st);
			Collections.sort(ans);
			return ans;
		}
	}

	public static void main(String[] args) {

	}

}
