package cptopics.segmentTree;

import java.util.Scanner;

class SGtreeXABOP {
	int[] seg;

	SGtreeXABOP(int n) {
		this.seg = new int[4 * n];
	}

	public void build(int ind, int low, int high, int[] arr, boolean flag) {
		if (low == high) {
			seg[ind] = arr[low];
			return;
		}
		int mid = low + (high - low) / 2;
		build(2 * ind + 1, low, mid, arr, !flag);
		build(2 * ind + 2, mid + 1, high, arr, !flag);
		if (flag) {
			seg[ind] = seg[2 * ind + 1] | seg[2 * ind + 2];
		} else {
			seg[ind] = seg[2 * ind + 1] ^ seg[2 * ind + 2];
		}
	}

	public void update(int ind, int low, int high, int i, int val, boolean flag) {
		if (low == high) {
			seg[ind] = val;
			return;
		}
		int mid = low + (high - low) / 2;
		if (i <= mid) {
			update(2 * ind + 1, low, mid, i, val, !flag);
		} else {
			update(2 * ind + 2, mid + 1, high, i, val, !flag);
		}
		if (flag) {
			seg[ind] = seg[2 * ind + 1] | seg[2 * ind + 2];
		} else {
			seg[ind] = seg[2 * ind + 1] ^ seg[2 * ind + 2];
		}
	}

	public int getRoot() {
		return seg[0];
	}
}

public class XeniaAndBitOperationsCF {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n & q");
		int n = sc.nextInt();
		int q = sc.nextInt();
		int size = (int) Math.pow(2, n);
		SGtreeXABOP st = new SGtreeXABOP(4 * size);
		System.out.println("Enter " + size + " space separated integers");
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		if (n % 2 == 1)
			st.build(0, 0, size - 1, arr, true);
		else
			st.build(0, 0, size - 1, arr, false);

		System.out.println("Enter queries");
		while (q-- > 0) {
			int ind = sc.nextInt();
			int val = sc.nextInt();
			if (n % 2 == 1)
				st.update(0, 0, size - 1, ind - 1, val, true);
			else
				st.update(0, 0, size - 1, ind - 1, val, false);
			int res = st.getRoot();
			System.out.println(res);
		}
		sc.close();
	}
}
