import java.util.ArrayList;

/**
 * @author sunil
 *
 */
public class DLinkedList {

	private class Node {
		private int value;
		private Node nextNode;
		private Node prevNode;

		public Node(int v) {
			value = v;
			nextNode = null;
			prevNode = null;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int v) {
			value = v;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node n) {
			nextNode = n;
		}

		public Node getPrevNode() {
			return prevNode;
		}

		public void setPrevNode(Node n) {
			prevNode = n;
		}

	}

	// Holds a reference to the head and tail of the list
	private Node headNode;
	private Node tailNode;

	public DLinkedList() {
		headNode = null;
		tailNode = null;
	}

	public Object getHeadValue() {
		if (headNode == null)
			return null;
		return headNode.value;
	}

	public Object getTailValue() {
		if (tailNode == null)
			return null;
		return tailNode.value;
	}

	public void addAtHead(int o) {
		Node newNode = new Node(o);
		newNode.setNextNode(headNode);
		if (headNode != null)
			headNode.setPrevNode(newNode);
		headNode = newNode;
		// special case for empty list
		if (tailNode == null)
			tailNode = newNode;
	}

	public void addAtTail(int o) {
		Node newNode = new Node(o);
		// this means that headNode == null too!
		if (tailNode == null) {
			tailNode = newNode;
			headNode = newNode;
		} else {
			newNode.setPrevNode(tailNode);
			tailNode.setNextNode(newNode);
			tailNode = newNode;
		}
	}

	public int deleteAtHead() {
		// list is empty
		if (headNode == null) {
			headNode = null;
			tailNode = null;
			return -1;
		}
		// singleton: must update tailnode too
		if (headNode == tailNode) {
			int res = headNode.getValue();
			headNode = null;
			tailNode = null;
			return res;
		}

		int res = headNode.getValue();
		headNode = headNode.getNextNode();
		headNode.setPrevNode(null);
		return res;
	}

	public int deleteAtTail() {
		// list is empty
		if (tailNode == null) {
			headNode = null;
			tailNode = null;
			return -1;
		}
		// singleton: must update tailnode too
		if (headNode == tailNode) {
			int res = tailNode.getValue();
			headNode = null;
			tailNode = null;
			return res;
		}
		int res = tailNode.getValue();
		tailNode = tailNode.getPrevNode();
		tailNode.setNextNode(null);
		return res;
	}

	public int delete(Node n) {
		if (n == null)
			return -1;
		Node next = n.getNextNode();
		Node prev = n.getPrevNode();
		int val = n.getValue();
		if (prev != null)
			prev.setNextNode(next);
		if (next != null)
			next.setPrevNode(prev);
		// deleting at the end
		if (n == tailNode)
			tailNode = prev;
		// deleteing at beginning
		if (n == headNode)
			headNode = next;
		return val;
	}

	public void insertAfter(Node n, int val) {
		if (n == null) { // this is the headNode
			addAtHead(val);
			return;
		}
		Node next = n.getNextNode();
		Node newNode = new Node(val);
		newNode.setPrevNode(n);
		newNode.setNextNode(next);
		n.setNextNode(newNode);
		if (next == null) { // insert at tail
			tailNode = newNode;
		} else {
			next.setPrevNode(newNode);
		}
	}

	// computes the size of the list
	public int size() {
		if (headNode == null)
			return 0;
		Node n = headNode;
		int size = 0;
		while (n != null) {
			size++;
			n = n.getNextNode();
		}
		return size;
	}

	// Predicate to check if the linked list is sorted
	public boolean isSorted() {
		if (headNode == null || headNode.nextNode == null)
			return true;
		Node i = headNode.nextNode;
		while (i != null) {
			if (i.getValue() < i.getPrevNode().getValue())
				return false;
			i = i.nextNode;
		}
		return true;
	}

	// toString methods to override printing of object
	public String toString() {
		Node n = headNode;
		StringBuffer buf = new StringBuffer();
		while (n != null) {
			buf.append(n.getValue());
			buf.append(" ");
			n = n.getNextNode();
		}
		return buf.toString();
	}

	/**
	 * Sorted the doubly linked list using the insertion-sort algorithm.
	 * 
	 * This is Question 4
	 * 
	 * Look at how insertionSort in ArraySort.java does insertion sort on arrays.
	 * The task is to perform the same algorithm, but sorting nodes linked together
	 * in a doubly linked list.
	 * 
	 * TODO Where N is the number of elements in the list the complexity is:
	 *
	 * O(n^2)
	 */
	public void insertionSort() {
		// Checking if the head is null or not
		if (headNode != null) {
			// If the head is not null then storing the data of the next node in Node called
			// temp
			Node temp = headNode.getNextNode();
			// If the temporary node is not null means it has the next node
			if (temp != null) {
				// Then we will run a for loop that will iterate through whole doubly linked
				// list
				for (int i = 1; i < this.size(); i++) {
					int current = temp.getValue();
					int j = i - 1;
					Node check = temp;
					// While the j variable is greater than or equal to zero and value of previous
					// node is greater than current value
					// is true then we will swap the values
					while (j >= 0 && check.getPrevNode().getValue() > current) {
						check.value = check.getPrevNode().getValue();
						j--;
						// Changing the value of the previous node with the current value
						check.getPrevNode().value = current;
						// Updating the check with the data of its previous node
						check = check.getPrevNode();
					}
					if (temp.getNextNode() != null) {
						// If it is not null then we are updating the temp node with the address of the
						// next node
						temp = temp.nextNode;
					}
				}

			}

		}

	}

	public static void main(String[] args) {
		DLinkedList d = new DLinkedList();
		d.addAtHead(4);
		d.addAtHead(1);
		d.addAtHead(7);
		d.addAtHead(10);
		System.out.println("Before sorting: " + d); // this will call the toString method
		d.insertionSort();
		System.out.println("After sorting: " + d);
	}

}
