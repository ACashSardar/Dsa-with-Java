package datastructure.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
	int val;
	int freq;

	Pair(int val, int freq) {
		this.val = val;
		this.freq = freq;
	}

	@Override
	public int compareTo(Pair o) {
		return o.freq > this.freq ? -1 : 1;
	}
}

public class TopKFrequentElemetns {

	public static void main(String[] args) {
		// Given data
		int[] nums = new int[] { 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5 };
		int k = 3;

		// Solution
		Map<Integer, Integer> map = new HashMap<>();
		for (int elem : nums) {
			if (map.containsKey(elem))
				map.put(elem, map.get(elem) + 1);
			else
				map.put(elem, 1);
		}
		PriorityQueue<Pair> minHeap = new PriorityQueue<>();
		for (Map.Entry<Integer, Integer> itr : map.entrySet()) {
			minHeap.add(new Pair(itr.getKey(), itr.getValue()));
			if (minHeap.size() > k)
				minHeap.poll();
		}
		int[] ans = new int[minHeap.size()];
		int i = 0;
		while (minHeap.size() > 0) {
			ans[i++] = minHeap.poll().val;
		}
		for (int a : ans)
			System.out.println(a + " ");
	}

}
