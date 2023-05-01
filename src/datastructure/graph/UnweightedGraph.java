package datastructure.graph;

import java.util.ArrayList;

public class UnweightedGraph {

	static class Edge {
		int src;
		int dest;

		public Edge(int src, int dest) {
			this.src = src;
			this.dest = dest;
		}
	}

	public static void createGraph(ArrayList<Edge>[] graph) {
		for (int i = 0; i < graph.length; i++)
			graph[i] = new ArrayList<Edge>();

		graph[0].add(new Edge(0, 2));

		graph[1].add(new Edge(1, 2));
		graph[1].add(new Edge(1, 3));

		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 1));
		graph[2].add(new Edge(2, 3));

		graph[3].add(new Edge(3, 1));
		graph[3].add(new Edge(3, 2));
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
				System.out.println("edge->"+edge.src + "-" + edge.dest);
			}
		}

	}

}
