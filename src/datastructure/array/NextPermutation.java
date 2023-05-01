package datastructure.array;

import java.util.ArrayList;
import java.util.List;

public class NextPermutation {
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void decToInc(int[] arr, int i, int j) {
		while (i < j) {
			swap(arr, i, j);
			i++;
			j--;
		}
	}

	static List<Integer> nextPermutation(int N, int arr[]) {
		// code here
		int r = N - 1;

		while (r >= 0) {
			if (r - 1 >= 0 && arr[r - 1] < arr[r]) {
                int i=r;
                while(i<N){
                    if(arr[i]<=arr[r-1]){
                        break;
                    }
                    i++;
                }
				swap(arr, r - 1, i - 1);
				decToInc(arr, r, N - 1);
				break;
			} else if (r - 1 < 0) {
				decToInc(arr, r, N - 1);
				break;
			} else {
				r--;
			}
		}
		List<Integer> ans = new ArrayList<>();
		for (int e : arr)
			ans.add(e);

		return ans;
	}

	public static void main(String[] args) {
		System.out.println(nextPermutation(5, new int[] { 2, 4, 6, 1, 3 }));
	}

}
