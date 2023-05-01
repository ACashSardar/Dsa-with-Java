package datastructure.graph;

import java.util.ArrayList;

public class CycleDetectionDirectedGraph {
	public boolean dfs(int curr, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis) {
		vis[curr] = 1;
		pathVis[curr] = 1;

		for (int i = 0; i < adj.get(curr).size(); i++) {
			int adjNode = adj.get(curr).get(i);
			if (vis[adjNode] != 1) {
				if (dfs(adjNode, adj, vis, pathVis) == true)
					return true;
			} else if (pathVis[adjNode] == 1) {
				return true;
			}
		}

		pathVis[curr] = 0;
		return false;
	}

	public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
		int[] vis = new int[V];
		int[] pathVis = new int[V];
		for (int i = 0; i < V; i++) {
			if (vis[i] != 1 && dfs(i, adj, vis, pathVis)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
