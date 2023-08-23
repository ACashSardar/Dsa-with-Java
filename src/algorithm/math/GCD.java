package algorithm.math;

public class GCD {

	public static int gcdRecursive(int a, int b) {
		if (a == b)
			return a;
		if (a > b)
			return gcdRecursive(a - b, b);
		return gcdRecursive(a, b - a);
	}

	public static int gcdItrative(int a, int b) {
		while (a != b) {
			if (a > b)
				a = a - b;
			else
				b = b - a;
		}
		return a;
	}

	public static int getGCD(int a, int b) {
		while (b > 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	public static void main(String[] args) {
		int a = 10;
		int b = 30;
		System.out.println(getGCD(a, b));
	}

}
