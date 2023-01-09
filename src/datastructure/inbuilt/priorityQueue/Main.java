package datastructure.inbuilt.priorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Queue<Customer> customers = new PriorityQueue<Customer>();
//		Queue<Customer> customers = new PriorityQueue<Customer>(new CustomerOrder()); // sorting based on amount

		customers.add(new Customer(6, 50.0, "Jayant"));
		customers.add(new Customer(2, 100.0, "Akash"));
		customers.add(new Customer(4, 75.0, "Ritesh"));
		customers.add(new Customer(3, 150.0, "Sayantan"));

		System.out.println(customers);

	}

}
