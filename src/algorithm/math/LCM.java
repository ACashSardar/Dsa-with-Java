package algorithm.math;

public class LCM {

	public static int lcm(int a, int b) {
		int gcd = GCD.gcdItrative(a, b);
		return (a * b) / gcd;
	}

	public static void main(String[] args) {
		int a = 15;
		int b = 10;
		int lcm = lcm(a, b);
		System.out.println(lcm);
	}
}
