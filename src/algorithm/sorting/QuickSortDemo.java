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
		int l = low+1;
		int r = high;

		while (l <= r) {
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
		int[] arr = new int[] { 4, 1, 7, 6, 9, 3, 2, 5, 8, 0, 2, 7, 6, 1, 6, 9 };
		int n = arr.length;
		quickSort(arr, 0, n - 1);
		for (int x : arr)
			System.out.print(x + " ");
	}

}
