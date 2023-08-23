package datastructure.bitManipulation;

// Kernighan's algorithm
public class CountSetBits {

	public static void main(String[] args) {
		int x = 21;
		System.out.println(x + " ---> " + Integer.toBinaryString(x));
		int cnt=0;
		while (x > 0) {
			int rmsb = x & (-x);
			x = x ^ rmsb;
			cnt++;
		}
		System.out.println(cnt);
	}

}
