package datastructure.graph;

import java.util.ArrayList;

public class CycleDetectionDirectedGraph {

//	 Using DFS

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

//	Using BFS & Topological sort
	
//    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adjList) {
//        int[] indegree = new int[v];
//		for (ArrayList<Integer> nodes : adjList) {
//			for (int dest : nodes) {
//				indegree[dest]++;
//			}
//		}
//        int cnt=0;
//		Queue<Integer> q = new LinkedList<>();
//		for (int i = 0; i < v; i++) {
//			if (indegree[i] == 0) {
//				q.add(i);
//			}
//		}
//		while (!q.isEmpty()) {
//			int curr = q.poll();
//			cnt++;
//			for (int adjNode : adjList.get(curr)) {
//				if (indegree[adjNode] > 0) {
//					indegree[adjNode]--;
//					if (indegree[adjNode] == 0) {
//						q.add(adjNode);
//					}
//				}
//			}
//		}
//		return cnt<v;
//    }
}
