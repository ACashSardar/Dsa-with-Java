package algorithm.sorting;

public class QuickSortDemo {

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void quickSort(int[] arr, int low, int high) {
		if (low >= high)
			return;

		int pivot = arr[low];
		int l = low;
		int r = high;

		while (l < r) {
			while (l <= high && arr[l] <= pivot) {
				l++;
			}
			while (r >= low && arr[r] > pivot) {
				r--;
			}
			if (l < r) {
				swap(arr, l, r);
			}
		}
		swap(arr, r, low);
		quickSort(arr, low, r - 1);
		quickSort(arr, r + 1, high);
	}

	public static void main(String[] args) {
		System.out.println("Quick Sort: TC-O(nlog(n)), SC-O(1)");
		int[] arr = new int[] { 4, 2, 6, 9, 7, 3, 1, 8, 5 };
		int n = arr.length;
		quickSort(arr, 0, n - 1);
		for (int x : arr)
			System.out.print(x + " ");
	}

}
