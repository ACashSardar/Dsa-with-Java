package datastructure.trie.impl2;


class Node {
	char data;
	Node[] links;
	int ew; // ends with count
    int pc; // prefix count

	Node(char data) {
		this.data = data;
		this.links = new Node[26];
		this.ew=0;
		this.pc=0;
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

	int getEndsWith(){
		return ew;
	}
	int getPrefixCount(){
		return pc;
	}
	void incrementEndsWith(){
		ew++;
	}

	void decrementEndsWith(){
		ew--;
	}
	void incrementPrefixCount(){
		pc++;
	}

	void decrementPrefixCount(){
		pc--;
	}
}

public class Trie {
    Node root;
    public Trie() {
        this.root=new Node('_');
    }

    public void insert(String word) {
        Node node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!node.containsChild(ch)) {
				node.putChild(ch, new Node(ch));
			}
			node = node.getChild(ch);
			node.incrementPrefixCount();
		}
		node.incrementEndsWith();
    }

    public int countWordsEqualTo(String word) {
        Node node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!node.containsChild(ch)) {
				return 0;
			}
			node = node.getChild(ch);
		}
		return node.getEndsWith();
    }

    public int countWordsStartingWith(String word) {
        Node node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!node.containsChild(ch)) {
				return 0;
			}
			node = node.getChild(ch);
		}
		return node.getPrefixCount();
    }

    public void erase(String word) {
        Node node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			node = node.getChild(ch);
			node.decrementPrefixCount();;
		}
		node.decrementEndsWith();
    }

}
