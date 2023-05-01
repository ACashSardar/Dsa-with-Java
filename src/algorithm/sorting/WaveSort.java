package algorithm.sorting;

public class WaveSort {
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 4, 3, 5, 6, 8, 7 };
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			if ((i % 2 == 0 && a[i] > a[i + 1]) || (i % 2 == 1 && a[i] < a[i + 1])) {
				swap(a, i, i + 1);
			}
		}
		for (int e : a)
			System.out.print(e + " ");
	}

}
