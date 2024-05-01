
public class Reverse {

	// Part 2
	//
	// TODO Where N is the length of array 'arr' the complexity is:
	//
	// O(2N)

	public static void reverse(String[] arr) {
     int length = arr.length;
     
     Stack st = new Stack(length);

     for (int i = 0 ; i < length ; i++) {
    	 st.push(arr[i]);
     }
     for (int i = 0 ; i<length ; i++) {
    	arr[i] =  (String) st.pop();
     }


}


//// created a stack within the array length
//Stack st = new Stack(arr.length);
//
//// created a for loop that pushes the index in the array to the stack
//for (int i = 0; i < arr.length; i++) {
//
//	st.push(arr[i]);
//
//}
//// created a for loop that pops the stack and stores it into the array
//for (int p = 0; p < arr.length; p++) {
//	arr[p] = (String) st.pop();
//
//}
	}
