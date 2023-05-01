package datastructure.graph;

import java.util.ArrayList;
import java.util.Stack;

public class AlienDictionary {
	public void dfs(int curr, ArrayList<Character>[] graph, int[] vis, Stack<Character> stk) {

		vis[curr] = 1;
		if (graph[curr] == null) {
			stk.push("abcdefghijklmnopqrstuvwxyz".charAt(curr));
			return;
		}
		for (int i = 0; i < graph[curr].size(); i++) {
			char tar = graph[curr].get(i);
			if (vis[tar - 'a'] != 1) {
				vis[tar - 'a'] = 1;
				dfs(tar - 'a', graph, vis, stk);
			}
		}

		stk.push("abcdefghijklmnopqrstuvwxyz".charAt(curr));
	}

	public String findOrder(String[] dict, int N, int K) {
		// Write your code here
		ArrayList<Character>[] graph = new ArrayList[K];
		for (int i = 0; i < N - 1; i++) {
			String s1 = dict[i];
			String s2 = dict[i + 1];
			int l = 0;
			int r = 0;
			while (l < s1.length() && r < s2.length()) {
				if (s1.charAt(l) != s2.charAt(r)) {
					if (graph[s1.charAt(l) - 'a'] == null) {
						ArrayList<Character> temp = new ArrayList<>();
						temp.add(s2.charAt(r));
						graph[s1.charAt(l) - 'a'] = temp;
					} else {
						ArrayList<Character> temp = graph[s1.charAt(l) - 'a'];
						temp.add(s2.charAt(r));
						graph[s1.charAt(l) - 'a'] = temp;
					}
					break;
				}
				l++;
				r++;
			}
		}

		Stack<Character> stk = new Stack<>();
		int[] vis = new int[K];
		for (int i = 0; i < K; i++) {
			if (vis[i] != 1) {
				dfs(i, graph, vis, stk);
			}
		}

		String ans = "";

		while (!stk.isEmpty()) {
			ans += stk.pop();
		}

		return ans;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
