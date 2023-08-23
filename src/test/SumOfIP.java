package test;

import java.util.Arrays;

public class SumOfIP {

	public static void main(String[] args) {
		String[] arr = { "198.162.0.2", "198.162.0.1", "198.162.0.9" };
		Arrays.sort(arr, (a, b) -> a.compareTo(b));
		for (String ip : arr) {
			System.out.println(ip);
		}
	}

}
