package datastructure.bitManipulation;

public class SingleOrruranceElement {

	public static int getSingleOccurElem(int[] arr) {
		int ans = 0;
		for (int elem : arr)
			ans = ans ^ elem;
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 2, 5, 6, 5, 7, 7, 1 };
		/*
		 * Since XOR operation is Commutative,
		 * 2 ^ 1 ^ 2 ^ 5 ^ 6 ^ 5 ^ 7 ^ 7 ^ 1 
		 * = 2 ^ 2 ^ 5 ^ 5 ^ 1 ^ 1 ^ 7 ^ 7 ^ 6
		 * =0 ^ 0 ^ 0 ^ 0 ^ 6
		 * =6
		 * */
		
		System.out.println(getSingleOccurElem(arr));
	}

}
