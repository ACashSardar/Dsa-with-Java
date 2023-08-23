package basics.userio;

import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an Integer:");
		int a=sc.nextInt();
		System.out.println(a);
		sc.nextLine(); // consumes the '\n' character from the buffer
		System.out.println("Enter a String:");
		String str=sc.nextLine();
		System.out.println(str);
		
		sc.close();
	}

}
