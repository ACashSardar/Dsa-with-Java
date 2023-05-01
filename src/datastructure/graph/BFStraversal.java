package datastructure.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// TC-O(V+E)
public class BFStraversal {

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

	public static void bfsTraversal(ArrayList<Edge>[] graph) {
		Queue<Integer> q = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();

		// In case we are given disconnected components
		for (int v = 0; v < graph.length; v++) {
			if (!visited.contains(v)) {

				// Actual BFS code
				visited.add(v);
				q.add(v);
				while (!q.isEmpty()) {
					int curr = q.poll();
					System.out.print(curr + " ");
					for (int i = 0; i < graph[curr].size(); i++) {
						Edge edge = graph[curr].get(i);
						if (!visited.contains(edge.dest)) {
							visited.add(edge.dest);
							q.add(edge.dest);
						}
					}
				}
				// End of BFS
			}
		}
	}

	public static void main(String[] args) {
		int V = 13;

//		  1---3		      9
//		 /    | \		 /
//		0     |  5--6   8      11-12
//		 \    | /        \
//		  2---4           10

		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = new ArrayList[V];
		createGraph(graph);
		System.out.println("BFS traversal");
		bfsTraversal(graph);

	}

}
