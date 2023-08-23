package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class RemoveElements {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] strArr = br.readLine().split(" ");
		if (strArr.length != n) {
			System.out.println("Invalid Input size");
			return;
		}
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(strArr[i]);
		}
		int x = Integer.parseInt(br.readLine());

		List<Integer> list = new LinkedList<>();
		boolean flag = false;
		for (int e : arr) {
			if (e != x || flag) {
				list.add(e);
			} else {
				flag = true;
			}
		}
		arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		for (int e : arr) {
			System.out.print(e + " ");
		}
	}

}
