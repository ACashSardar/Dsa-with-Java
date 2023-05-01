package datastructure.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

class MSTnode implements Comparable<MSTnode> {
	int val;
	int wt;

	public MSTnode(int val, int wt) {
		this.val = val;
		this.wt = wt;
	}

	@Override
	public int compareTo(MSTnode MSTnode) {
		return this.wt - MSTnode.wt == 0 ? (this.val - MSTnode.val) : (this.wt - MSTnode.wt);
	}

}

public class PrimsAlgorithm_MST {

	static int spanningTree(int V, int E, int edges[][]) {

		ArrayList<ArrayList<MSTnode>> adjList = new ArrayList<>();

		for (int i = 0; i < V; i++)
			adjList.add(new ArrayList<MSTnode>());

		for (int[] edge : edges) {
			int src = edge[0];
			int dest = edge[1];
			int wt = edge[2];

			ArrayList<MSTnode> temp = adjList.get(src);
			temp.add(new MSTnode(dest, wt));
			adjList.set(src, temp);

			temp = adjList.get(dest);
			temp.add(new MSTnode(src, wt));
			adjList.set(dest, temp);
		}

		int sum = 0;
		int[] vis = new int[V];
		Queue<MSTnode> q = new PriorityQueue<>();
		q.add(new MSTnode(0, 0));

		while (!q.isEmpty()) {
			MSTnode curr = q.poll();

			if (vis[curr.val] == 1)
				continue;

			vis[curr.val] = 1;
			sum += curr.wt;

			for (MSTnode adjMSTnode : adjList.get(curr.val)) {
				if (vis[adjMSTnode.val] != 1) {
					q.add(new MSTnode(adjMSTnode.val, adjMSTnode.wt));
				}
			}

		}
		return sum;
	}

	public static void main(String[] args) {
		
		int[][] edge = new int[][] { { 0, 1, 5 }, { 1, 2, 3 }, { 0, 2, 1 } };

		System.out.println(spanningTree(3, 3, edge));

	}

}
