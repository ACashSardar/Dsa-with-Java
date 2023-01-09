package datastructure.inbuilt.priorityQueue;

public class Customer implements Comparable<Customer> {
	private Integer orderId;
	private Double amount;
	private String name;

	public Customer(Integer orderId, Double amount, String name) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.name = name;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [orderId=" + orderId + ", amount=" + amount + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Customer o) {
		return o.orderId > this.orderId ? 1 : -1;
	}
}
