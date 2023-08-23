package test;

public class Ques3 {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		b = a ^ b;// b=10^20
		a = a ^ b;// a=10^(10^20)->20
		b = a ^ b;// b=20^(10^20)->10
		System.out.println(a + " " + b);
	}

}
