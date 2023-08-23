package test;

public class Main {
	public static void func(int num, String path) {
		if (num == 1) {
			System.out.print(path + " " + num);
			return;
		}
		if (num % 2 == 0) {
			func(num / 2, path + " " + num);
		} else {
			func(3 * num + 1, path + " " + num);
		}
	}

	public static void main(String[] args) {
		func(12564, "");
	}
}
