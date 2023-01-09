package algorithm.sorting;

public class MergeSortDemo {

	public static void merge(int[] arr, int low, int mid, int high) {
		int n = mid - low + 1;
		int m = high - mid;
		int left[] = new int[n];
		int right[] = new int[m];
		for (int i = 0; i < n; i++)
			left[i] = arr[low + i];
		for (int j = 0; j < m; j++)
			right[j] = arr[mid + 1 + j];

		int i = 0;
		int j = 0;
		int k = low;

		while (i < n && j < m) {
			if (left[i] < right[j])
				arr[k++] = left[i++];
			else
				arr[k++] = right[j++];
		}

		while (i < n)
			arr[k++] = left[i++];
		while (j < m)
			arr[k++] = right[j++];
	}

	public static void mergeSort(int[] arr, int low, int high) {
		if (low >= high)
			return;
		int mid = (high + low) / 2;
		mergeSort(arr, low, mid);
		mergeSort(arr, mid + 1, high);
		merge(arr, low, mid, high);
	}

	public static void main(String[] args) {
		System.out.println("Merge Sort: TC-O(nlog(n)), SC-O(n)");
		int[] arr = new int[] { 4, 2, 6, 9, 7, 3, 1, 8, 5 };
		int n = arr.length;
		mergeSort(arr, 0, n - 1);
		for (int x : arr)
			System.out.print(x + " ");
	}

}
