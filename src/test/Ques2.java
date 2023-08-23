package test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Ques2 {

	public static void main(String[] args) {
		String a = "My Name is Amit Mahipal";
		Map<Character, Integer> map = new LinkedHashMap<>();
		for (char ch : a.toCharArray()) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
		// If there is no non-repeating character, I will print '$'.
		char ch = '$';
		for (Map.Entry<Character, Integer> itr : map.entrySet()) {
			if (itr.getValue() == 1) {
				ch = itr.getKey();
				break;
			}
		}
		System.out.println(ch);
	}

}
