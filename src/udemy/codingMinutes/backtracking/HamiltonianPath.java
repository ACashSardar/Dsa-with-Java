package udemy.codingMinutes.backtracking;

import java.util.ArrayList;
import java.util.List;

public class HamiltonianPath {

	public static boolean backtrack(int curr, int cnt, int n, List<List<Integer>> adjList, int[] vis) {
		if (cnt == n) {
			return true;
		}
		vis[curr] = 1;
		for (int adjNode : adjList.get(curr)) {
			if (vis[adjNode] == 0 && backtrack(adjNode, cnt + 1, n, adjList, vis)) {
				return true;
			}
		}
		// backtracking step
		vis[curr] = 0;
		return false;
	}

	public static void main(String[] args) {

		// 4-vertices & 4-edges
		int n = 4;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 } };
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adjList.add(new ArrayList<>());
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}

		boolean flag = false;

		for (int i = 0; i < n; i++) {
			int[] vis = new int[n];
			if (backtrack(i, 1, n, adjList, vis)) {
				flag = true;
			}
		}

		if (flag) {
			System.out.println("Hamiltonian Path Exists");
		} else {
			System.out.println("Hamiltonian Path Does Not Exist");
		}
	}

}
