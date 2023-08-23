package datastructure.graph;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeStates {
	public boolean checkCycle(int curr, int[][] graph, int[] vis, int[] pathVis) {
		vis[curr] = 1;
		pathVis[curr] = 1;
		for (int adjNode : graph[curr]) {
			if (vis[adjNode] == 0) {
				if (checkCycle(adjNode, graph, vis, pathVis)) {
					return true;
				}
			} else if (pathVis[adjNode] == 1) {
				return true;
			}
		}
		pathVis[curr] = 0;
		return false;
	}

	public List<Integer> eventualSafeNodes(int[][] graph) {
		int n = graph.length;
		int[] vis = new int[n];
		int[] pathVis = new int[n];
		for (int i = 0; i < n; i++) {
			if (vis[i] == 0) {
				checkCycle(i, graph, vis, pathVis);
			}
		}
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (pathVis[i] == 0) {
				ans.add(i);
			}
		}
		return ans;
	}

}
