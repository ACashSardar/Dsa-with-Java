package datastructure.stack;

import java.util.Stack;

public class NextGreaterElement {

	// Function to find the next greater element for each element of the array.
	public static int[] nextLargerElement(int[] arr, int n) {
		// Your code here
		Stack<Integer> stk = new Stack<>();
		int[] ans = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			if (stk.size() == 0) {
				ans[i] = -1;
			} else {
				while (stk.size() > 0 && stk.peek() <= arr[i]) {
					stk.pop();
				}
				if (stk.size() == 0) {
					ans[i] = -1;
				} else {
					ans[i] = stk.peek();
				}
			}
			stk.push(arr[i]);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 6, 8, 0, 1, 3 };
		int[] res = nextLargerElement(arr, arr.length);
		for (int ans : res)
			System.out.print(ans + " ");
	}

}
