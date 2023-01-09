package datastructure.inbuilt.priorityQueue;

import java.util.Comparator;

public class CustomerOrder implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) {

		return o1.getAmount() < o2.getAmount() ? 1 : -1;
	}

}
