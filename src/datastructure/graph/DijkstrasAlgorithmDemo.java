package datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class PairDijkstra implements Comparable<PairDijkstra> {
	int node;
	int wt;
	public PairDijkstra(int node, int wt) {
		this.node = node;
		this.wt = wt;
	}
	@Override
	public int compareTo(PairDijkstra p) {
		return this.wt == p.wt ? (this.node - p.node) : (this.wt - p.wt);
	}
}

public class DijkstrasAlgorithmDemo {
	static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
		Queue<PairDijkstra> q = new PriorityQueue<>();
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[S] = 0;
		q.add(new PairDijkstra(S, 0));
		while (!q.isEmpty()) {
			PairDijkstra pair = q.poll();
			int curr = pair.node;
			for (ArrayList<Integer> node : adj.get(curr)) {
				int adjNode = node.get(0);
				int wt = node.get(1);
				if (dist[adjNode] > dist[curr] + wt) {
					dist[adjNode] = dist[curr] + wt;
					q.add(new PairDijkstra(adjNode, dist[adjNode]));
				}
			}
		}
		return dist;
	}

	public static void main(String[] args) {
		

	}

}
