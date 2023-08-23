package datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



// Topological sort using BFS
public class KahnsAlgorithm {
	static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adjList) {
		int[] indegree = new int[v];
		for (ArrayList<Integer> nodes : adjList) {
			for (int dest : nodes) {
				indegree[dest]++;
			}
		}
		int[] topo = new int[v];
		int j = 0;
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < v; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			int curr = q.poll();
			topo[j++] = curr;
			for (int adjNode : adjList.get(curr)) {
				if (indegree[adjNode] > 0) {
					indegree[adjNode]--;
					if (indegree[adjNode] == 0) {
						q.add(adjNode);
					}
				}
			}
		}
		return topo;
	}

	public static void main(String[] args) {

	}

}
