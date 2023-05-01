package datastructure.string;

import java.util.Stack;

public class LongestValidParenthesis {
	public static boolean isValid(String s) {
		Stack<Character> stk = new Stack<>();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (ch == '(')
				stk.push(ch);
			else {
				if (stk.isEmpty())
					stk.add(ch);
				else if (stk.peek() == '(')
					stk.pop();
			}
		}
		return stk.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("(((()))()"));
	}

}
