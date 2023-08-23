package test;

import java.util.HashSet;
import java.util.Set;

public class EnglishAlphabetFinder {

	public int findAlphabets(String input1) {
		Set<Character> set = new HashSet<>();
		for (char ch : input1.toCharArray()) {
			if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
				set.add(ch);
			}
		}
		return set.size();
	}

	public static void main(String[] args) {
		EnglishAlphabetFinder obj = new EnglishAlphabetFinder();
		int ans = obj.findAlphabets("pqr pqr");
		System.out.println(ans);
	}

}
