package datastructure.bitManipulation;

public class BinToDec {

	public static int binToDec(String bin) {
		int n = bin.length();
		if (n == 0)
			throw new RuntimeException("Empty binary string!");
		int dec = 0;
		int multiplier = 1;
		for (int i = n - 1; i >= 0; i--) {
			if (bin.charAt(i) == '1')
				dec += multiplier;
			multiplier *= 2;
		}
		return dec;
	}

	public static void main(String[] args) {
		String bin = "1110";
		int dec = binToDec(bin);
		System.out.println("Decimal equivalent of " + bin + " is " + dec);
	}

}
