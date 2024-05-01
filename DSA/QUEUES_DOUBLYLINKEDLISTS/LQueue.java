
/*
 * Queue implementation with a linked list.
 */
public class LQueue implements QueueADT {

	private class Node {
		Object element;
		Node next;

		public Node(Object e, Node n) {
			element = e;
			next = n;
		}

		public Node(Object e) {
			element = e;
			next = null;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public LQueue() {
		head = null;
		tail = null;
		size = 0;
	}

	/*
	 * Part 3: complete the following methods
	 */

	// Part 3: complete
	/**
	 * Returns true if the queue is empty, false otherwise.
	 * 
	 * TODO Where N is the number of elements in the queue the complexity is:
	 *
	 * O(?)
	 */
	// Is empty the notation is O(1), which is constant time complexity.
	public boolean isEmpty() {
		// if the size == to 0 return true to the empty list else false
		if (size == 0) {
			return true;
		}
		return false; // dummy value
	}

	// Part 3: complete
	/**
	 * Returns how many elements are in the queue.
	 * 
	 * TODO Where N is the number of elements in the queue the complexity is:
	 *
	 * O(?)
	 */
	// Int size the notation is O(1), which is constant time complexity.
	public int size() {
		// returns the size
		return size; // dummy value
	}

	// Part 3: complete
	/**
	 * Adds a new element to the end of the queue.
	 * 
	 * TODO Where N is the number of elements in the queue the complexity is:
	 *
	 * O(?)
	 */
	// Enqueue the notation is O(1), which is constant time complexity.
	public void enqueue(Object o) {
		// New node n holder object o
		Node n = new Node(o);
		// if head is == to null then tail and head stores n
		if (head == null) {
			tail = n;
			head = n;
			// else tail next holdes n and tail holdes n
		} else {
			tail.next = n;
			tail = n;

		}
		// size incrementing by 1
		size = size + 1;

	}

	// Part 3: complete
	/**
	 * Removes the element at the front of the queue.
	 * 
	 * TODO Where N is the number of elements in the queue the complexity is:
	 *
	 * O(?)
	 */
	// Dequeue the notation is O(1), which is constant time complexity.
	public Object dequeue() throws QueueException {
		// if the queue is empty then throw exception error
		if (isEmpty()) {
			throw new QueueException("Queue is empty");
		}
		// element holdes the head element
		Object element = head.element;
		// head is updated to next value
		head = head.next;
		// size decrementing by 1
		size = size - 1;
		// return the element
		return element; // dummy value
	}

	// Part 3: complete
	/**
	 * Returns the element at the front of the queue without removing it.
	 * 
	 * TODO Where N is the number of elements in the queue the complexity is:
	 *
	 * O(?)
	 */

	// front the notation is O(1), which is constant time complexity.
	public Object front() throws QueueException {
		// if queue is empty then throws QueueException else return the head element
		if (isEmpty()) {
			throw new QueueException("Queue is empty");

		} else {

			return head.element;
		}

		// dummy value
	}

}
