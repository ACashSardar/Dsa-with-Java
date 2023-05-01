package datastructure.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PathsFromSourceToTarget {
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
	}

//	O(V^V)
	public static void findUniquePaths(int start, int end, ArrayList<Edge>[] graph) {
		Set<Integer> visited = new HashSet<>();
		ArrayList<String> paths = new ArrayList<>();

		dfs(start, end, graph, visited, "", paths);

		System.out.println("Unique paths from source " + start + " to destination " + end);
		for (String path : paths) {
			System.out.println(path);
		}
	}

	public static void dfs(int curr, int target, ArrayList<Edge>[] graph, Set<Integer> visited, String trace,
			ArrayList<String> paths) {
		if (curr == target) {
			paths.add(trace + " " + curr);
			return;
		}

		visited.add(curr);
		for (int i = 0; i < graph[curr].size(); i++) {
			Edge edge = graph[curr].get(i);
			if (!visited.contains(edge.dest)) {
				dfs(edge.dest, target, graph, visited, trace + " " + curr, paths);
			}
		}
		visited.remove(curr);

	}

	public static void main(String[] args) {
		int V = 7;

//		  1---3		         
//		 /    | \		    
//		0     |  5--6 
//		 \    | /      
//		  2---4              

		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = new ArrayList[V];
		createGraph(graph);
		findUniquePaths(0, 5, graph);
	}

}
