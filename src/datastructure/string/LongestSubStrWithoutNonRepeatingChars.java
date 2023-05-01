package datastructure.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStrWithoutNonRepeatingChars {
	public static int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<>();
		int n = s.length();

		if (n <= 1)
			return n;

		int maxLen = -1;
		int l = 0;
		int r = 0;

		while (l < n && r < n) {
			char ch = s.charAt(r);
			if (!set.contains(ch)) {
				maxLen = Math.max(maxLen, r - l + 1);
				set.add(ch);
				r++;
			} else {
				while (set.contains(ch)) {
					set.remove(s.charAt(l));
					l++;
				}
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {
		String inp = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(inp));

	}

}
