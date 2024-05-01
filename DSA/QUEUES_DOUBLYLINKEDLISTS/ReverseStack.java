public class ReverseStack {

	/*
	 * 1: complete implementation
	 */
	/**
	 * Reverses the order of elements in the given stack
	 * 
	 * TODO Where N is the number of elements in the stack the complexity is:
	 *
	 * O(?)
	 * 
	 * @param st the stack to be reversed
	 */
	// The time complexity of this method is O(N), where N is the number of elements
	// in the stack.

	public static void reverseStack(Stack st) {
		// make a variable number and store the stacks size
		int number = st.size();
		// made a Queue and stored size + 1
		Queue q = new Queue(st.size() + 1);
		// while stack is not empty we pop the element from the back of queue
		while (!st.isEmpty()) {
			q.enqueue(st.pop());
		}
		// while queue is not empty we push element to the start of the queue
		while (!q.isEmpty()) {
			st.push(q.dequeue());

		}

	}

}
