package datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int m = image.length;
		int n = image[0].length;
		int[][] vis = new int[m][n];
		int prevColor = image[sr][sc];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });
		image[sr][sc] = newColor;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int di = -1; di <= 1; di++) {
				for (int dj = -1; dj <= 1; dj++) {
					int i1 = curr[0] + di;
					int j1 = curr[1] + dj;
					if (Math.abs(di) != Math.abs(dj) && i1 >= 0 && i1 < m && j1 >= 0 && j1 < n && vis[i1][j1] != 1
							&& image[i1][j1] == prevColor) {
						image[i1][j1] = newColor;
						q.add(new int[] { i1, j1 });
						vis[i1][j1] = 1;
					}
				}
			}
		}
		return image;
	}

	public static void main(String[] args) {

	}

}
