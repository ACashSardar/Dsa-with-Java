package datastructure.graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

	public static void dfs(int curr, ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> stk) {
		vis[curr] = 1;
		for (int i = 0; i < adj.get(curr).size(); i++) {
			int target = adj.get(curr).get(i);
			if (vis[target] != 1) {
				dfs(target, adj, vis, stk);
			}
		}
		stk.push(curr);
	}

	static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
		Stack<Integer> stk = new Stack<>();
		int[] vis = new int[V];
		for (int i = 0; i < V; i++) {
			if (vis[i] != 1) {
				dfs(i, adj, vis, stk);
			}
		}
		int[] ans = new int[V];
		for (int i = 0; i < V; i++) {
			ans[i] = stk.pop();
		}

		return ans;
	}

	public static void main(String[] args) {

	}

}
