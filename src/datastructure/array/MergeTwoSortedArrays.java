package datastructure.array;

public class MergeTwoSortedArrays {

//	TC-O(n*m)
	public static void merge(long arr1[], long arr2[], int n, int m) {

		int i = 0;
		while (i < n) {
			if (arr1[i] > arr2[0]) {
				long temp = arr1[i];
				arr1[i] = arr2[0];
				arr2[0] = temp;

				// repositioning arr2[0]-O(m)
				for (int j = 0; j + 1 < m; j++) {
					if (arr2[j] > arr2[j + 1]) {
						long temp2 = arr2[j];
						arr2[j] = arr2[j + 1];
						arr2[j + 1] = temp2;
					}
				}
			}
			i++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] arr1 = new long[] { 0, 1, 3, 5, 7 };
		long[] arr2 = new long[] { -2, 2, 6, 8, 9, 12 };
		merge(arr1, arr2, arr1.length, arr2.length);
		System.out.println("Sorted arrays-");
		for (long elem : arr1)
			System.out.print(elem + " ");
		for (long elem : arr2)
			System.out.print(elem + " ");
	}

}
