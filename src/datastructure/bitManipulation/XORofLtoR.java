package datastructure.bitManipulation;

public class XORofLtoR {

	public static int getXORfromLtoR(int L, int R) {
		int xor1 = XORof1toN.getXORfrom1toN(L-1);
		int xor2 = XORof1toN.getXORfrom1toN(R);
		return xor1^ xor2;
	}

	public static void main(String[] args) {
		int L = 5;
		int R = 7;
		System.out.println("XOR of all numbers between " + L + " to " + R + " is " + getXORfromLtoR(L, R));
	}

}
