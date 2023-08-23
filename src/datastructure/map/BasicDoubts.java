package datastructure.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BasicDoubts {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		Pair a = new Pair(2, 3);
		Pair b = new Pair(2, 3);
		String s1=new String("akash");
		String s2=new String("akash");
		List<Integer> list1=Arrays.asList(2,3,4);
		List<Integer> list2=Arrays.asList(2,3,4);
		System.out.println(list1==list2);
		map.put(s1, 20);
		System.out.println(map.get(s2));
	}

}
