package datastructure.inbuilt.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); // min-heap
//		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder()); // max-heap
		priorityQueue.add(6);
		priorityQueue.add(1);
		priorityQueue.add(2);
		priorityQueue.add(4);
		System.out.println(priorityQueue);
		System.out.println(priorityQueue.poll() + " deleted");
		System.out.println(priorityQueue);
		System.out.println("Front element(Minimum Element)=" + priorityQueue.peek());
	}

}

/*
 * parent=arr[i-1/2], left=arr[2*i+1], right=arr[2*i+2]
 */
