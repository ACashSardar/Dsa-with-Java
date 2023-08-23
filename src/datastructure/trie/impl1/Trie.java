package datastructure.trie.impl1;

class Node {
	char data;
	Node[] links;
	boolean wordEnd;

	Node(char data) {
		this.data = data;
		this.links = new Node[26];
		this.wordEnd = false;
	}

	boolean containsChild(char ch) {
		return links[ch - 'a'] != null;
	}

	void putChild(char ch, Node node) {
		links[ch - 'a'] = node;
	}

	Node getChild(char ch) {
		return links[ch - 'a'];
	}

	void setEnd() {
		wordEnd = true;
	}

	boolean isEndSet() {
		return wordEnd;
	}
}

public class Trie {
	private Node root;

	public Trie() {
		this.root = new Node('_');
	}

	public void insert(String word) {
		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!node.containsChild(ch)) {
				node.putChild(ch, new Node(ch));
			}
			node = node.getChild(ch);
		}
		node.setEnd();
	}

	public boolean search(String word) {
		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!node.containsChild(ch)) {
				return false;
			}
			node = node.getChild(ch);
		}
		return node.isEndSet();
	}

	public boolean startsWith(String prefix) {
		Node node = root;
		for (int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
			if (!node.containsChild(ch)) {
				return false;
			}
			node = node.getChild(ch);
		}
		return true;
	}

}
