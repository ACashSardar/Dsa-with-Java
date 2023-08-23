package datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordAlgorithm {
	
	static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
		int[] dist = new int[V];
		Arrays.fill(dist, 100000000);
		dist[S] = 0;

		for (int i = 0; i < V; i++) {
			for (ArrayList<Integer> edge : edges) {
				int u = edge.get(0);
				int v = edge.get(1);
				int wt = edge.get(2);
				if (dist[u] != 100000000 && dist[u] + wt < dist[v]) {
					dist[v] = dist[u] + wt;
				}
			}
		}
		// N-th relaxation to check if there is an negative cycle
		// By (N-1)-th iteration all the relaxations should have completed
		for (ArrayList<Integer> edge : edges) {
			int u = edge.get(0);
			int v = edge.get(1);
			int wt = edge.get(2);
			if (dist[u] != 100000000 && dist[u] + wt < dist[v]) {
				int[] temp = { -1 };
				return temp;
			}
		}

		return dist;
	}

	public static void main(String[] args) {
		

	}

}
