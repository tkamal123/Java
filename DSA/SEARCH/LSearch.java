public class LSearch {


	private class Node {
		private Entry value;
		private Node nextNode;

		public Node(Entry v) {
			value = v;
			nextNode = null;
		}

		public Entry getValue() {
			return value;
		}

		public Node getNextNode() {
			return nextNode;
		}

		// Sets the NextNode to the given Node
		public void setNextNode(Node n) {
			nextNode = n;
		}
	}

	// Holds a reference to the head of the list
	private Node headNode;

	public LSearch() {
		headNode = null;
	}

	public void addAtHead(Entry e) {
		Node newNode = new Node(e); 
		newNode.setNextNode(headNode); 
		headNode = newNode; 
	}
	
	/*
	 * Part 3: complete
	 */	
	/**
	 * Uses linear search to look up a given name in the catalogue and returns the
	 * number if the name is in the catalogue. Otherwise it returns -1.
	 * 
	 * TODO Where N is the number of entries in the catalogue the (worst case) complexity is:
	 *
	 * O(N) 
	 *  Because you would need to iterate through all N entries in the catalog to find the person's number.
	 * @param name is the person name to look for in the catalogue
	 * @return the number of that person, otherwise -1 to indicate an error
	 */
	public int linearSearch(String name){
		//Checking if head node is null or not
				if(headNode==null)
				{
					return -1; 
				}
				Node temp = headNode;
				// start a loop till the next node is not empty
				while(temp!=null)
				{
					//If the name is equal to the name in linked list then returning the number of the user
					if(temp.getValue().getName().equals(name))
					{
						return temp.getValue().getNumber();
					}
					temp = temp.nextNode;
				}
				//if nothing is found then returning -1
				return -1;
	}
}
