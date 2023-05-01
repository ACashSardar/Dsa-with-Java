package datastructure.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipertiteGraph {

	public boolean bfsTraversal(int[][] graph, int V, int[] color) {
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < V; i++) {
			if (color[i] == -1) {

				// bfs
				color[i] = 1;
				q.add(i);
				while (!q.isEmpty()) {
					int curr = q.poll();
					System.out.print(curr + " ");
					for (int dest : graph[curr]) {
						if (color[dest] == -1) {
							color[dest] = 1 - color[curr];
							q.add(dest);
						} else if (color[dest] == color[curr]) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	public boolean dfs(int curr, int[][] graph, int[] color, int col) {
		color[curr] = col;
		System.out.print(curr + " ");
		for (int dest : graph[curr]) {
			if (color[dest] == -1) {
				if (dfs(dest, graph, color, 1 - col) == false)
					return false;
			} else if (color[dest] == col)
				return false;
		}
		return true;
	}

	public boolean dfsTraversal(int[][] graph, int V, int[] color) {
		for (int i = 0; i < V; i++) {
			if (color[i] == -1 && dfs(i, graph, color, 1) == false) {
				return false;
			}
		}
		return true;
	}

	public boolean isBipartite(int[][] graph) {
		int V = graph.length;
		int[] color = new int[V];
		Arrays.fill(color, -1);
		return bfsTraversal(graph, V, color);
	}

	public static void main(String[] args) {

	}

}
