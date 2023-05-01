package datastructure.linkedlist;

public class Add1toTheNumberRepresentedByLL {
	
	public static Node reverse(Node head) {

		Node prev = null;
		Node curr = head;
		Node temp = null;

		while (curr != null) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		head = prev;

		return head;
	}

	public static Node addOne(Node head) {
		head = reverse(head);
		Node temp = head;

		int carry = 1;

		while (temp != null) {

			int sum = (temp.data + carry) % 10;
			carry = (temp.data + carry) / 10;
			temp.data = sum;

			if (carry == 1 && temp.next == null) {
				temp.next = new Node(carry);
				break;
			}
			temp = temp.next;
		}

		head = reverse(head);

		return head;
	}

	public static void main(String[] args) {

	}

}
