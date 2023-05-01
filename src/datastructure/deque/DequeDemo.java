package datastructure.deque;

import java.util.ArrayDeque;
import java.util.Deque;

// Insert and Delete can be performed at both ends
/** Operations in Deque
 * 
 * (Functions that does not Throw Exception)
 * 
 * offerFirst
 * offerLast
 * peekFirst
 * peekLast
 * pollFirst
 * pollLast
 * 
 * (Functions that Throw Exception)
 * 
 * addFirst
 * addLast
 * getFirst
 * getLast
 * removeFirst
 * removeLast
 *
 * */

public class DequeDemo {

	public static void main(String[] args) {
		System.out.println("Java Deque demo\n\n");
		Deque<Integer> deque = new ArrayDeque<>();
		deque.addFirst(5);
		deque.addFirst(9);
		deque.addFirst(6);
		System.out.println(deque);
		deque.addLast(7);
		System.out.println(deque);
		deque.removeFirst();
		System.out.println(deque);
		deque.removeLast();
		System.out.println(deque);
		System.out.println(deque.getFirst()+" "+ deque.getLast());
	}

}
