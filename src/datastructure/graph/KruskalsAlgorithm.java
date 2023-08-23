package datastructure.graph;

import java.util.Arrays;

public class KruskalsAlgorithm {
    static class DisjointSet {
    	private int[] rank, parent;
    
    	public DisjointSet(int n) {
    		rank = new int[n + 1];
    		parent = new int[n + 1];
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
    }
	static int spanningTree(int V, int E, int edges[][]){
	   Arrays.sort(edges, (e1, e2)->e1[2]-e2[2]);
	   DisjointSet ds=new DisjointSet(V);
	   int ans=0;
	   for(int[] edge: edges){
	       int u=edge[0], v=edge[1], wt=edge[2];
	       if(ds.findUPar(u)==ds.findUPar(v)) continue;
	       ds.unionByrank(u, v);
	       ans+=wt;
	   }
	   return ans;
	}
	public static void main(String[] args) {

	}
}
