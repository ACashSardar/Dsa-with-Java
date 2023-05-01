package datastructure.bitManipulation;

public class XORof1toN {

	public static int getXORfrom1toN(int n) {
		if (n % 4 == 0) {
			return n;
		} else if (n % 4 == 1) {
			return 1;
		} else if (n % 4 == 2) {
			return n + 1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		int n = 8;
		System.out.println("XOR of all numbers from (1 to " + n + ") is " + getXORfrom1toN(n));
	}

}
/*
 * N XOR (1 to N) 
 * -------------- 
 * 1 1 
 * 2 3 
 * 3 0 
 * 4 4
 * 
 * 5 1 
 * 6 7 
 * 7 0 
 * 8 8
 * 
 * 9 1 
 * 10 11 
 * 11 0 
 * 12 12
 * 
 * etc.
 */
