package datastructure.bitManipulation;

public class DecToBin {

	public static String decToBin(int num) {
		String bin = "";
		while (num > 0) {
			int rem = num % 2;
			bin = rem + bin;
			num /= 2;
		}
		return bin;
	}

	public static void main(String[] args) {
		int dec = 12;
		String bin = decToBin(dec);
		System.out.println("Binary equivalent of " + dec + " is " + bin);
	}

}
