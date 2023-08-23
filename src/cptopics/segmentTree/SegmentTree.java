package cptopics.segmentTree;

public class SegmentTree {
	int[] seg;

	SegmentTree(int n) {
		this.seg = new int[4 * n];
	}

	public void build(int ind, int low, int high, int[] arr) {
		if (low == high) {
			seg[ind] = arr[low];
			return;
		}
		int mid = low + (high - low) / 2;
		build(2 * ind + 1, low, mid, arr);
		build(2 * ind + 2, mid + 1, high, arr);
		seg[ind] = Math.min(seg[2 * ind + 1], seg[2 * ind + 2]);
	}

	public int query(int ind, int low, int high, int l, int r) {
		// No overlap
		if (high < l || r < low) {
			return Integer.MAX_VALUE;
		}
		// Full Overlap
		else if (low >= l && high <= r) {
			return seg[ind];
		}
		// Partial Overlap
		int mid = low + (high - low) / 2;
		int left = query(2 * ind + 1, low, mid, l, r);
		int right = query(2 * ind + 2, mid + 1, high, l, r);
		return Math.min(left, right);
	}

	public void update(int ind, int low, int high, int i, int val) {
		if (low == high) {
			seg[ind] = val;
			return;
		}
		int mid = low + (high - low) / 2;
		if (i <= mid) {
			update(2 * ind + 1, low, mid, i, val);
		} else {
			update(2 * ind + 2, mid + 1, high, i, val);
		}
		seg[ind] = Math.min(seg[2 * ind + 1], seg[2 * ind + 2]);
	}

	public static void main(String[] args) {
		// index----> 0, 1, 2, 3, 4, 5
		int[] arr = { 2, 1, 0, 4, 3, 7 };
		int n = arr.length;
		SegmentTree st = new SegmentTree(n);
		st.build(0, 0, n - 1, arr);
		int[][] queries = { { 0, 2 }, { 2, 4 }, { 3, 5 } };
		for (int[] query : queries) {
			int min = st.query(0, 0, n - 1, query[0], query[1]);
			System.out.println("Minimum value in range [" + query[0] + ", " + query[1] + "]=" + min);
		}
		int[][] updateQueries = { { 2, 4 } };
		for (int[] updateQuery : updateQueries) {
			int i = updateQuery[0];
			int val = updateQuery[1];
			st.update(0, 0, n - 1, i, val);
			arr[i] = val;
			System.out.println("Index " + i + " is updated with value=" + val);
		}
		System.out.println("After update: ");
		// arr = { 2, 1, 4, 4, 3, 7 };
		for (int[] query : queries) {
			int min = st.query(0, 0, n - 1, query[0], query[1]);
			System.out.println("Minimum value in range [" + query[0] + ", " + query[1] + "]=" + min);
		}

	}

}
