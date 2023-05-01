package datastructure.array;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumFromArray {

	public static void main(String[] args) {
		String[] arr = {"mom", "dad",  "sis" };
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		for (String s : arr)
			System.out.println(s);
	}

}
