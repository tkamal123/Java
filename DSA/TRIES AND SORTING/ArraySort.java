import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author sunil
 *
 */
public class ArraySort {

	/**
	 * Insertion sort of an array
	 * 
	 * @param arr the array to be sorted in-place
	 */
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int cur = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > cur) {
				arr[j + 1] = arr[j--];
				arr[j + 1] = cur;
			}
		}
	}

	/**
	 * Insertion sort of an array
	 * 
	 * This is Question 3
	 * 
	 * TODO Where N is the number of elements in the array 'arr' the complexity is:
	 *
	 * O(N^2)
	 * 
	 * @param arr the array to be sorted in-place
	 */
	public static void bubbleSort(int[] arr) {
		// swapeSomething is a boolean variable to track
		// whether any swapping occurred during a pass through the array.
		boolean swapSomething = true;
		// Continue looping until no swaps are performed during a pass through the
		// array.
		while (swapSomething) {
			// If no swaps occur, the loop will exit.
			swapSomething = false;
			// Iterate through the array.
			for (int i = 0; i < arr.length - 1; i++) {
				// Compare current index with the next index and swap them
				// if the current index is more than the next one
				if (arr[i] > arr[i + 1]) {
					// Set swapSomething to true to indicate that a swap has occurred.
					swapSomething = true;
					// Swap the elements using a temporary variable.
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
	}

	/**
	 * Quick sort of an array. This method creates a new array with its values
	 * sorted, based on the values in the unsorted input array S.
	 * 
	 * This is Question 5
	 * 
	 * TODO Where N is the number of elements in the array 'S' the complexity is:
	 *
	 * O(n log n)
	 * 
	 * @param S the unsorted input array
	 * @return the sorted output array
	 */
//did
	public static ArrayList<Integer> quickSort(ArrayList<Integer> S) {
		// If the size of the arrayList is less than or equal to 1, we return the
		// ArrayList
		if (S.size() <= 1) {
			return S;
		}
		// Else we are taking the first element as the pivot so that we can compare it
		int pivot = S.get(0);
		// Declaring 3 new ArrayLists for storing values which are greater than, equal,
		// or less than the pivot
		ArrayList<Integer> L = new ArrayList<>();
		ArrayList<Integer> E = new ArrayList<>();
		ArrayList<Integer> G = new ArrayList<>();
		int size = S.size();
		// For loop till the size of the ArrayList to populate 3 new ArrayLists
		for (int i = 0; i < size; i++) {
			int val = S.remove(0);
			// Checking if the value is less than the value of the pivot, then we will add
			// it to the L ArrayList
			if (val < pivot) {
				L.add(val);
			}
			// Else If the value is equal to the value of pivot, then we will add it to the
			// E ArrayList
			else if (val == pivot) {
				E.add(val);
			}
			// Else If the value is greater than the value of pivot, then we will add it to
			// the G ArrayList
			else {
				G.add(val);
			}
		}
		// Creating 2 new ArrayLists for sorted lists L and G
		ArrayList<Integer> sortedL = quickSort(L);
		ArrayList<Integer> sortedG = quickSort(G);
		// Creating one more new ArrayList for storing all the result
		ArrayList<Integer> result = new ArrayList<>();
		result.addAll(sortedL);
		result.addAll(E);
		result.addAll(sortedG);

		return result;
	}

	/**
	 * predicate to check if array is sorted
	 * 
	 * @param arr the array to be checked
	 * @return true if the array is sorted, false otherwise
	 */

	public static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++)
			if (arr[i] > arr[i + 1])
				return false;
		return true;
	}

	/**
	 * predicate to check if arrayList is sorted. Useful for checking
	 * ArrayList<Integer> lists returned from Quick Sort.
	 * 
	 * @param arr the array to be checked
	 * @return true is the aray is sorted, flalse otherwise
	 */
	public static boolean isSorted(ArrayList<Integer> arr) {
		Iterator i = arr.iterator();
		int val;
		if (i.hasNext())
			val = (int) i.next();
		else
			return true;
		while (i.hasNext()) {
			int nv = (int) i.next();
			if (val > nv)
				return false;
			val = nv;
		}
		return true;
	}

	/**
	 * Helper printing methods for testing
	 * 
	 * @param arr the array to print
	 */
	private static void printIntArray(int[] arr) {
		System.out.print("[ ");
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}

	private static void printIntArrayList(ArrayList<Integer> arr) {
		System.out.print("[ ");
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}

	public static void main(String[] args) {
		// testing part1
		int[] arr1 = { 5, 4, 3, 2, 1 };
		bubbleSort(arr1);
		printIntArray(arr1);

		// testing part2
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(3);
		arr2.add(1);
		arr2.add(6);
		arr2.add(5);
		ArrayList<Integer> arr2_sorted = quickSort(arr2);
		printIntArrayList(arr2_sorted);
		// {5,4,3,5,1};

	}

}
