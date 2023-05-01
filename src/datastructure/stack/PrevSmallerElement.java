package datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrevSmallerElement {
	public static List<Integer> leftSmaller(int n, int a[]) {
		// code here
		Stack<Integer> stk = new Stack<>();
		List<Integer> ans = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (stk.size() == 0) {
				ans.add(-1);
			} else {
				while (stk.size() > 0 && stk.peek() >= a[i]) {
					stk.pop();
				}
				if (stk.size() == 0) {
					ans.add(-1);
				} else {
					ans.add(stk.peek());
				}
			}
			stk.push(a[i]);
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
