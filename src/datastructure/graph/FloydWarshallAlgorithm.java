package datastructure.graph;

// Gives shortest distance between any two nodes
// T.C-O(n^3)
public class FloydWarshallAlgorithm {
	public void shortest_distance(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == -1)
					matrix[i][j] = 99999;
			}
		}

		for (int via = 0; via < n; via++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 99999)
					matrix[i][j] = -1;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
