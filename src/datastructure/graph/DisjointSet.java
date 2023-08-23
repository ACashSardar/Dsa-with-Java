package datastructure.graph;

import java.util.Arrays;

public class DisjointSet {
	private int[] rank, size, parent;

	public DisjointSet(int n) {
		rank = new int[n + 1];
		size = new int[n + 1];
		parent = new int[n + 1];
		Arrays.fill(size, 1);
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
	}

	public int findUPar(int node) {
		if (parent[node] == node) {
			return node;
		}
		return parent[node] = findUPar(parent[node]);
	}

	public void unionByrank(int u, int v) {
		int ulp_u = findUPar(u);
		int ulp_v = findUPar(v);
		if (ulp_u == ulp_v) {
			return;
		}
		if (rank[ulp_u] < rank[ulp_v]) {
			parent[ulp_u] = ulp_v;
		} else if (rank[ulp_v] < rank[ulp_u]) {
			parent[ulp_v] = ulp_u;
		} else {
			parent[ulp_v] = ulp_u;
			rank[ulp_u]++;
		}
	}

	public void unionBysize(int u, int v) {
		int ulp_u = findUPar(u);
		int ulp_v = findUPar(v);
		if (ulp_u == ulp_v) {
			return;
		}
		int newsize = size[ulp_u] + size[ulp_v];
		if (size[ulp_u] < size[ulp_v]) {
			parent[ulp_u] = ulp_v;
			size[ulp_v] = newsize;
		} else {
			parent[ulp_v] = ulp_u;
			size[ulp_u] = newsize;
		}
	}

	public static void main(String[] args) {
		DisjointSet ds = new DisjointSet(7);

		// Both UNION BY RANK & UNION BY SIZE has same time complexity

//		 UNION BY RANK DEMO

		ds.unionByrank(1, 2);
		ds.unionByrank(2, 3);
		ds.unionByrank(4, 5);
		ds.unionByrank(6, 7);
		ds.unionByrank(5, 6);

		if (ds.findUPar(3) == ds.findUPar(7)) {
			System.out.println("Same");
		} else {
			System.out.println("Not same");
		}

		ds.unionByrank(3, 7);

		if (ds.findUPar(3) == ds.findUPar(7)) {
			System.out.println("Same");
		} else {
			System.out.println("Not same");
		}

		// UNION BY SIZE DEMO
//		ds.unionBysize(1, 2);
//		ds.unionBysize(2, 3);
//		ds.unionBysize(4, 5);
//		ds.unionBysize(6, 7);
//		ds.unionBysize(5, 6);
//
//		if (ds.findUPar(3) == ds.findUPar(7)) {
//			System.out.println("Same");
//		} else {
//			System.out.println("Not same");
//		}
//
//		ds.unionBysize(3, 7);
//
//		if (ds.findUPar(3) == ds.findUPar(7)) {
//			System.out.println("Same");
//		} else {
//			System.out.println("Not same");
//		}
	}
}
