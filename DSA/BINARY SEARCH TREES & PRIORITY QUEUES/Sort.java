
/**
 * @author sunil
 *
 */
public class Sort {

	/*
	 * Part 4: complete method
	 */
	/**
	 * Sorts an array using a priority queue.
	 * 
	 * The effect of calling this method is that the input 'arr' array is updated
	 * in-place, rather than creating a new array holding the sorted value.
	 * 
	 * @param arr the array to be sorted in-place
	 */
	public static void sort(int[] arr) {
		// Creating queue as a variable of priority queue with size of length of array
		PriorityQueue queue = new PriorityQueue(arr.length);
		// Iterate through the array to insert values into the priority queue
		for (int i = 0; i < arr.length; i++) {
			// Calling the insert function to insert value in the priority queue
			queue.insert(arr[i]);
		}
		// Replace elements in the array by removing the minimum element from the
		// priority queue
		for (int i = 0; i < arr.length; i++) {
			// Change the element by removing the minimum value from the queue
			arr[i] = queue.removeMin();
		}
	}

	public static void main(String[] args) {
		int[] arr = { 53, 3, 5, 2, 4, 67 };
		Sort.sort(arr);
		// should be printed in order
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		System.out.println(arr[5]);
	}

}
