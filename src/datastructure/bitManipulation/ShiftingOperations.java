package datastructure.bitManipulation;

public class ShiftingOperations {

	public static void main(String[] args) {
		int num = 13; // 1101;
		System.out.println("Num=" + num);

		// Right-shift
		int rs = num >> 1; // 110->6, Division by 2 (floor)
		System.out.println(num + " after 1 right shift becomes " + rs);

		// Left-shift
		int ls = num << 1; // 11010->26, Multiplication by 2
		System.out.println(num + " after 1 left shift becomes " + ls);
		
		/*
		 *  num>>k is equivalent to num/(2^k)
		 *  num<<k is equivalent to num * (2^k)
		 */

	}

}
