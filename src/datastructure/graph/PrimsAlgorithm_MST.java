package datastructure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class NodeMST implements Comparable<NodeMST> {
	int val;
	int par;
	int wt;

	NodeMST(int val, int par, int wt) {
		this.val = val;
		this.par = par;
		this.wt = wt;
	}

	@Override
	public int compareTo(NodeMST n1) {
		return this.wt - n1.wt == 0 ? this.val - n1.val : this.wt - n1.wt;
	}

	@Override
	public String toString() {
		return "[ " + val + "," + par + "," + wt + " ]";
	}
}

public class PrimsAlgorithm_MST {
	static int spanningTree(int V, int E, int edges[][]) {
		List<List<NodeMST>> adjList = new ArrayList<>();
		for (int i = 0; i < V; i++)
			adjList.add(new ArrayList<NodeMST>());
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			int wt = edge[2];
			adjList.get(u).add(new NodeMST(v, -1, wt));
			adjList.get(v).add(new NodeMST(u, -1, wt));
		}
		int[] vis = new int[V];
		Queue<NodeMST> q = new PriorityQueue<>();
		q.add(new NodeMST(0, -1, 0));
		int sum = 0;
		List<NodeMST> mst = new ArrayList<>();
		while (!q.isEmpty()) {
			NodeMST curr = q.poll();
			if (vis[curr.val] == 0) {
				vis[curr.val] = 1;
				sum += curr.wt;
				mst.add(curr);
				for (NodeMST adjNodeMST : adjList.get(curr.val)) {
					if (vis[adjNodeMST.val] == 0) {
						q.add(new NodeMST(adjNodeMST.val, curr.val, adjNodeMST.wt));
					}
				}
			}
		}
		System.out.println("MST : "+mst);
		return sum;
	}

	public static void main(String[] args) {
		int[][] edge = new int[][] { { 0, 1, 5 }, { 1, 2, 3 }, { 0, 2, 1 } };
		int minCost=spanningTree(3, 3, edge);
		System.out.println(minCost);

	}

}
