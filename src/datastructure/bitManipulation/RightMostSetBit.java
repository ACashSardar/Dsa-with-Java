package datastructure.bitManipulation;

public class RightMostSetBit {

	public static void main(String[] args) {
		// 1 0 0 1 0 0 0 ----> x=72 in Binary
		// 0 1 1 1 0 0 0 ----> 2's complement of x
		// 0 0 0 1 0 0 0 ----> x & x'' = 8
		int x = 72;
		int rmsb=x & (-x);
		System.out.println(Integer.toBinaryString(rmsb));
		System.out.println(rmsb);
	}

}
