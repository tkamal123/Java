class StackException extends RuntimeException {
	public StackException(String err) {
		super(err);
	}
}

public class Stack implements StackADT {

	private class Node {
		int element;
		Node next;

		public Node(int e, Node n) {
			element = e;
			next = n;
		}

		public int getValue() {
			return element;
		}

		public Node getNext() {
			return next;
		}
	}

	// this is a reference to the head node of the linked list
	private Node top;

	// keep track of the number of elements in the stack
	private int size;

	public Stack() {
		top = null;
		size = 0;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public int size() {
		return size;
	}

	// part 3: complete
	/**
	 * Adds a new element to the stack
	 * 
	 * TODO Where N is the number of elements in the stack the complexity is:
	 *
	 * O(?)
	 * 
	 * @param o the integer to add to the top of the stack
	 */
	public void push(int o) {
		// if its empty then temp will store a new node with 0,null
		if (isEmpty()) {

			Node temp = new Node(o, null);
			// The top pointer is then updated to the newly created node
			top = temp;
		} else {
			// else the temp will store a new node with 0,top
			Node temp = new Node(o, top);
			// The top pointer is then updated to the newly created node
			top = temp;
		}
		// increments the size by 1
		size += 1;

	}

	// part 3: complete
	/**
	 * Removes an element from the top of the stack
	 * 
	 * TODO Where N is the number of elements in the stack the complexity is:
	 *
	 * O(?)
	 *
	 * @return the integer that was at the top of the stack
	 * @throws StackException if the stack is empty
	 */
	public int pop() throws StackException {
		// if the stack is empty it throws an exception
		if (isEmpty())
			throw new StackException("stack is empty");
		// temp node is store in top
		Node temp = top;
		// The top pointer is then updated to point to the next node in the stack
		top = top.next;
		// The size variable is decremented by 1
		size -= 1;
		// returns the temp element
		return temp.element;
	}

	// part 3: complete
	/**
	 * Returns the integer at the top of the stack
	 * 
	 * TODO Where N is the number of elements in the stack the complexity is:
	 *
	 * O(?)
	 * 
	 * @return the integer at the top of the stack
	 * @throws StackException is the stack is empty
	 */
	public int top() throws StackException {
		// if the top is empty throws exception and returns the top element
		if (isEmpty())
			throw new StackException("stack is empty");
		return top.element;
	}

}
