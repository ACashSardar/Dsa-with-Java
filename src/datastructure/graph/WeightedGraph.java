package datastructure.graph;

import java.util.ArrayList;

public class WeightedGraph {

	static class Edge {
		int src;
		int dest;
		int wt;

		public Edge(int src, int dest, int wt) {
			this.src = src;
			this.dest = dest;
			this.wt = wt;
		}

		@Override
		public String toString() {
			return "Edge [src=" + src + ", dest=" + dest + ", wt=" + wt + "]";
		}
	}

	public static void createGraph(ArrayList<Edge>[] graph) {
		for (int i = 0; i < graph.length; i++)
			graph[i] = new ArrayList<Edge>();

		// vertex-0
		graph[0].add(new Edge(0, 2, 2));

		// vertex-1
		graph[1].add(new Edge(1, 2, 10));
		graph[1].add(new Edge(1, 3, 0));

		// vertex-2
		graph[2].add(new Edge(2, 0, 2));
		graph[2].add(new Edge(2, 1, 10));
		graph[2].add(new Edge(2, 3, -1));

		// vertex-3
		graph[3].add(new Edge(3, 1, 0));
		graph[3].add(new Edge(3, 2, -1));
	}

	public static void main(String[] args) {
		int V = 4;
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = new ArrayList[V];
		createGraph(graph);

		// printing the graph
		System.out.println("The graph representation: [src-dest]");
		for (ArrayList<Edge> edgeList : graph) {
			for (int i = 0; i < edgeList.size(); i++) {
				Edge edge = edgeList.get(i);
				System.out.println("edge->"+edge.src + "-" + edge.dest + ": wt=" + edge.wt);
			}
		}

	}

}
