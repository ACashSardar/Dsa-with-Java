package algorithm.sorting;

public class SelectionSortDemo {

	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void selectionSort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int minValIndx = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minValIndx])
					minValIndx = j;
			}
			swap(arr, i, minValIndx);
		}
	}

	public static void main(String[] args) {
		int[] A = new int[] { 3, 2, 6, 9, 7, 4, 8, 10, 5, 0, 1 };
		selectionSort(A);
		for (int i : A) {
			System.out.print(i + " ");
		}

	}

}
