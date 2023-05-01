package datastructure.heap.impl;

// Implementing a max Heap
public class Heap {

	private int[] heap;
	private int size;

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public Heap(int capacity) {
		heap = new int[capacity];
	}

	public boolean isFull() {
		return size == heap.length;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getParent(int index) {
		return (index - 1) / 2; // No need to use Math.floor()
	}

	public int getChild(int index, boolean left) {
		return 2 * index + (left ? 1 : 2);
	}

	public void fixHeapAbove(int index) {
		int newValue = heap[index];
		while (index > 0 && newValue > heap[getParent(index)]) {
			heap[index] = heap[getParent(index)];
			index = getParent(index);
		}
		heap[index] = newValue;
	}

	public void fixHeapBelow(int index, int lastHeapIndex) {
		int childToSwap = 0;

		while (index <= lastHeapIndex) {
			int leftChild = getChild(index, true);
			int rightChild = getChild(index, false);

			if (leftChild <= lastHeapIndex) {
				if (rightChild > lastHeapIndex) {
					childToSwap = leftChild;
				} else {
					childToSwap = heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
				}

				if (heap[index] < heap[childToSwap]) {
					int temp = heap[index];
					heap[index] = heap[childToSwap];
					heap[childToSwap] = temp;
				} else {
					break;
				}
				index = childToSwap;
			} else {
				break;
			}
		}
	}

	public void insert(int value) {
		if (isFull()) {
			System.out.println("Heap is full ");
			return;
		}

		heap[size] = value;
		fixHeapAbove(size);
		size++;
	}

	public int delete(int index) {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Heap is empty!");
		}
		int parent = getParent(index);
		int deletedValue = heap[index];
		heap[index] = heap[size - 1];

		if (index == 0 || heap[index] < heap[parent]) {
			fixHeapBelow(index, size - 1);
		} else {
			fixHeapAbove(index);
		}
		size--;
		return deletedValue;
	}

	public int peek() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Heap is empty!");
		}
		return heap[0];
	}

	public void heapSort() {
		for (int i = 0; i < size; i++) {
			int last = heap[size - 1 - i];
			heap[size - 1 - i] = heap[0];
			heap[0] = last;
			fixHeapBelow(0, size - 2 - i);
		}
	}

	public void printHeap() {
		System.out.print("[ ");
		for (int i = 0; i < size; i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println("]");
	}

}
