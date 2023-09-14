package datastructure.map;

class Node {
	int key;
	int val;
	Node next;

	Node(int key, int val) {
		this.key = key;
		this.val = val;
		this.next = null;
	}
}

public class MyHashMap {

	int LIMIT = 1000;
	Node[] bucket;

	public MyHashMap() {
		this.bucket = new Node[LIMIT];
	}

	public void put(int key, int value) {
		int loc = key % LIMIT;
		if (bucket[loc] == null) {
			bucket[loc] = new Node(key, value);
			return;
		}
		Node temp = bucket[loc];
		Node prev = null;
		while (temp != null) {
			prev = temp;
			if (temp.key == key) {
				temp.val = value;
				return;
			}
			temp = temp.next;
		}
		prev.next = new Node(key, value);
	}

	public int get(int key) {
		int loc = key % LIMIT;
		Node temp = bucket[loc];
		while (temp != null) {
			if (temp.key == key) {
				return temp.val;
			}
			temp = temp.next;
		}
		return -1;
	}

	public void remove(int key) {
		int loc = key % LIMIT;
		Node temp = bucket[loc];
		if (temp == null)
			return;
		if (temp != null && temp.key == key) {
			bucket[loc] = temp.next;
			return;
		}
		while (temp.next != null) {
			if (temp.next.key == key) {
				temp.next = temp.next.next;
				return;
			}
			temp = temp.next;
		}
	}

}
