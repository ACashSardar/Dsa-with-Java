package algorithm.recursion;

public class StringAllPermutations {

	public static void swapChars(char[] s, int i, int j) {
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}

	public static void findPermutations(int ind, char[] arr, int n) {
		if (ind == n - 1) {
			for (char ch : arr)
				System.out.print(ch + " ");
			System.out.println();
		}
		for (int i = ind; i < n; i++) {
			swapChars(arr, ind, i);
			findPermutations(ind + 1, arr, n);
			swapChars(arr, ind, i);
		}
	}

	public static void main(String[] args) {
		String s = "abc";
		int n=s.length();
		findPermutations(0, s.toCharArray(), n);
	}

}
