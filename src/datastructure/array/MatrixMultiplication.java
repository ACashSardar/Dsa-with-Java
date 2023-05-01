package datastructure.array;

public class MatrixMultiplication {

	public static int[][] Mutliply(int[][] matrixA, int[][] matrixB) {

		int R = matrixA.length;
		int C = matrixB[0].length;
		int[][] ans = new int[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				for (int k = 0; k < matrixA[0].length; k++)
					ans[i][j] += matrixA[i][k] * matrixB[k][j];
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		int[][] A = new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		int[][] B = new int[][] { { 2, 2, 2 }, { 2, 2, 2 }, { 2, 2, 2 } };
		int[][] ans = Mutliply(A, B);
		for (int[] row : ans) {
			for (int elem : row) {
				System.out.print(elem + " ");
			}
			System.out.println();
		}
	}

}
