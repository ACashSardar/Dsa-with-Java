package algorithm.sorting;

public class InsertionSortDemo {

	public static void insertionSort(int[] arr, int n) {
		for (int i = 1; i < n; i++) {
			int temp = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] >= temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 4, 1, 7, 6, 9, 3, 2, 5, 8, 0, 2, 7, 6, 1, 6, 9 };
		int n = arr.length;
		insertionSort(arr, n);
		for (int elem : arr)
			System.out.print(elem + " ");
	}

}
