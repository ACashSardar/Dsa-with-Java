package datastructure.bitManipulation;

public class LogicalOperations {

	public static void main(String[] args) {
		int a1 = 12; // 12->1100
		int b1 = 9; // 9->1001
		
		int bwAnd = a1 & b1; // 1000->8
		System.out.println("Result of bitwise AND is "+bwAnd);

		int bwOr=a1 | b1; // 1101->13
		System.out.println("Result of bitwise OR is "+bwOr);
		
		int bwXor=a1 ^ b1; // 0101->5
		System.out.println("Result of bitwise XOR is "+bwXor);
		
		
	}

}
