package datastructure.bitManipulation;

public class SwapUsingXOR {
	public static void main(String[] args) {
		int a = 5; // 101
		int b = 7; // 111
		System.out.println("a=" + a + " b=" + b);

		a = a ^ b; // a= 010 & b= 111
		b = b ^ a; // a= 010 & b= 101
		a = a ^ b; // a= 111 && b= 101
		System.out.println("a=" + a + " b=" + b);
	}
}
