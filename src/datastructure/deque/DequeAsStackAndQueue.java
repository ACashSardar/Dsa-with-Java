package datastructure.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeAsStackAndQueue {

	public static void main(String[] args) {

		Deque<Integer> deque = new ArrayDeque<>();
//		System.out.println("Deque as Stack");
//		// When we use push() function, only the head pointer moves, tail remains fixed. Behaves as a Stack.
//		deque.push(10);
//		deque.push(20);
//		deque.push(30);
//		System.out.println(deque);
//		deque.pop();
//		System.out.println(deque);

		System.out.println("Deque as Queue");
		// When we use offer() function, only the head pointer moves, tail remains
		// fixed. Behaves as a Stack.
		deque.offer(10);
		deque.offer(20);
		deque.offer(30);
		System.out.println(deque);
		deque.pop();
		System.out.println(deque);

	}

}
