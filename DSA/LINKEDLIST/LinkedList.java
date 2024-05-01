public class LinkedList {

	private class Node {
		
		private int value;
		private Node nextNode;
		
//		public void main(String[] args) {
//			Node node = new Node(value);
//			node.addAtHead(5);
//		}

		public Node(int i) {
			value = i;
			nextNode = null;
		}

		// returns the value stored in the node
		public int getValue() {
			return value;
		}

		// sets the value stored in the node
		public void setValue(int i) {
			value = i;
		}

		// Returns the Node that this Node links to
		// Note this may return null
		public Node getNextNode() {
			return nextNode;
		}

		// Sets the NextNode to the given Node
		public void setNextNode(Node n) {
			nextNode = n;
		}

		// adds Node n to the tail of the list
		public void addNodeAtTail(Node n) {
			if (this.nextNode == null) {
				this.nextNode = n;
			} else {
				this.nextNode.addNodeAtTail(n);
			}
		}

		public Node removeAtTail(Node valueAtTail) {
			if (this.nextNode == null) { // if this is the last node
				valueAtTail.setValue(this.getValue()); // copy out the value
				return null; // return null
			} else { // move onto the next Node
				this.nextNode = this.nextNode.removeAtTail(valueAtTail);
				return this;
			}

		}
	} // End of Node Class implementation

	private Node headNode; // Holds a reference to the head of the list

	public LinkedList() {
		headNode = null;
	}

	public void addAtHead(int i) {
		Node newNode = new Node(i);
		newNode.setNextNode(headNode);
		headNode = newNode;
		System.out.println(newNode);
	}

	public void addAtTail(int i) {
		Node newNode = new Node(i);
		if (headNode == null) {
			headNode = newNode;
		} else {
			headNode.addNodeAtTail(newNode);
		}
	}

	/*
	 * removes and returns the value at the head of the list note, this may return
	 * -1 if the list is empty
	 */
	public int removeAtHead() {
		if (headNode == null) {
			return -1; // return -1 if the list is empty
		} else {
			Node returnedNode = headNode;
			headNode = headNode.getNextNode();
			return returnedNode.getValue();
		}
	}

	/*
	 * See
	 * https://web.microsoftstream.com/video/5a15e714-bf98-4bf6-9124-573638723795
	 */
	public int removeAtTail() {
		if (headNode == null) {
			return -1;
		} else {
			Node returnedNode = new Node(-1);
			headNode = headNode.removeAtTail(returnedNode);
			return returnedNode.getValue();
		}
	}

	/*
	 * PART 2: complete the following methods
	 */

	/**
	 * The number of nodes in the linked list, and 0 for an empty linked list.
	 * 
	 * TODO Where N is the length of linked list the complexity is:
	 *
	 * O(?)
	 * 
	 * @return the number of nodes in the linked list
	 */

	public int size() {
		// made a variable and put 0
		int number = 0;
		// Storing headNode in currentNode
		Node currentNode = headNode;
		// while the currentNode is not null the number then number = number + 1
		while (currentNode != null) {
			number += 1;
			// currentNode = currentNode it gets the next node
			currentNode = currentNode.getNextNode();

		}

		return number; // dummy value to remove
	}

	/**
	 * The sum of all integer nodes in the linked list, and 0 for an empty linked
	 * list.
	 *
	 * TODO Where N is the length of linked list the complexity is:
	 *
	 * O(?)
	 * 
	 * @return the sum of all nodes in the linked list
	 */
	public int total() {

		// made a variable and put 0
		int number = 0;
		// Storing headNode in currentNode
		Node currentNode = headNode;
		// while the currentNode is not null the number then number = number + 1
		while (currentNode != null) {
			// number = number + currentNode to get value
			number += currentNode.getValue();
			// currentNode = currentNode it gets the next code
			currentNode = currentNode.getNextNode();

		}

		return number; // dummy value to remove
	}

	/*
	 * Optional: reverse the linked lists so that the first element becomes the
	 * last, the second becomes the second last, and so on.
	 */
	public void reverse() {

	}

}
