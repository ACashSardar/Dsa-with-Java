package datastructure.bitManipulation;

public class BinToDec {

	public static int binToDecUnsigned(String bin) {
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

	public static String getTwosComplement(String s) {
		String onesComp = "";
		for (char ch : s.toCharArray()) {
			if (ch == '1') {
				onesComp += '0';
			} else {
				onesComp += '1';
			}
		}
		String twosComp = "";
		int carry = 1;
		for (int i = onesComp.length() - 1; i >= 0; i--) {
			char ch = onesComp.charAt(i);
			if (carry == 0) {
				twosComp = ch + twosComp;
			} else if (ch == '0') {
				twosComp = 1 + twosComp;
				carry = 0;
			} else {
				twosComp = 0 + twosComp;
			}
		}
		if (carry == 1) {
			twosComp = 1 + twosComp;
		}
		return twosComp;
	}

	public static int binToDecSigned(String bin) {
		if (bin.charAt(0) == '1') {
			String twosComp = getTwosComplement(bin);
			return -binToDecUnsigned(twosComp);
		}
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
		String bin = "1111";
		int unsignedInt = binToDecUnsigned(bin);
		int signedInt = binToDecSigned(bin);
		System.out.println("Decimal (unsigned) equivalent of " + bin + " is " + unsignedInt);
		System.out.println("Decimal (signed) equivalent of " + bin + " is " + signedInt);
	}

}
