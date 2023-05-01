package datastructure.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CycleDetection {
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

		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 2));

		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 3));

		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 4));

		graph[3].add(new Edge(3, 1));
		graph[3].add(new Edge(3, 4));
		graph[3].add(new Edge(3, 5));

		graph[4].add(new Edge(4, 2));
		graph[4].add(new Edge(4, 3));
		graph[4].add(new Edge(4, 5));

		graph[5].add(new Edge(5, 3));
		graph[5].add(new Edge(5, 4));
		graph[5].add(new Edge(5, 6));

		graph[6].add(new Edge(6, 5));

		graph[8].add(new Edge(8, 9));
		graph[8].add(new Edge(8, 10));

		graph[9].add(new Edge(9, 8));

		graph[10].add(new Edge(10, 8));

		graph[11].add(new Edge(11, 12));
		graph[12].add(new Edge(12, 11));
	}

	public static boolean detectCycle(int curr, ArrayList<Edge>[] graph, Set<Integer> visited, int parent) {
		if (!visited.contains(curr)) {
			visited.add(curr);
			for (int i = 0; i < graph[curr].size(); i++) {
				Edge edge = graph[curr].get(i);
				if (!visited.contains(edge.dest)) {
					if (detectCycle(edge.dest, graph, visited, curr)) {
						return true;
					}
				} else {
					if (edge.dest != parent) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int V = 13;

//		  1---3		         9
//		 /    | \		    /
//		0     |  5--6      8      11-12
//		 \    | /           \
//		  2---4              10

		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = new ArrayList[V];
		createGraph(graph);
		Set<Integer> visited = new HashSet<>();
		boolean cycleDetected = false;
		for (int i = 0; i < V; i++) {
			if (!visited.contains(i)) {
				cycleDetected = cycleDetected || detectCycle(0, graph, visited, -1);
			}
		}
		if (cycleDetected) {
			System.out.println("cycle detected");
		} else {
			System.out.println("cycle not found");
		}
	}

}
