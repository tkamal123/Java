public class ASearch {


	private Entry[] catalogue;
	private int current;
	
	/*
	 * Assume 10 entries
	 */
	public ASearch(){
		catalogue = new Entry[10];
		current = 0;
	}
	
	/*
	 * Ignores adding if full (should really be handled by exception...)
	 */
	public void addEntry(Entry e){
		if(current < 10){
			catalogue[current++] = e;
		}
	}
	
	/*
	 * Part 2: complete implementation
	 */
	/**
	 * Uses linear search to look up a given name in the catalogue and returns the
	 * number if the name is in the catalogue. Otherwise it returns -1.
	 * 
	 * TODO Where N is the number of entries in the catalogue the (worst case) complexity is:
	 * O(N)
	 *Because you would need to iterate through all N entries in the catalog to find the person's number.
	 *  
	 * @param name is the person name to look for in the catalogue
	 * @return the number of that person, otherwise -1 to indicate an error
	 */
	public int linearSearch(String name){
		for(int i=0;i<current;i++)
		{
			//Checking id the name exists
			if(catalogue[i].getName().equals(name))
			{
				//If the name exists then returning the number of user 
				return catalogue[i].getNumber();
			}
		}		return -1;
	}

	/*
	 * Part 4: complete implementation
	 */
	/**
	 * Uses binary search to look up a given name in the catalogue and returns the
	 * number if the name is in the catalogue. Otherwise it returns -1.
	 * 
	 * TODO Where N is the number of entries in the catalogue the (worst case) complexity is:
	 * O(log N)
	 * Binary search is a more efficient search algorithm compared to linear search and has a worst-case time complexity of O(log N
	 *  
	 * @param first the array index of the start of search space
	 * @param last the array index of the end of the search space
	 * @param name the person name being searched for
	 * @return the persons phone number if their name is found or -1 otherwise
	 */
	private int binarySearch(int first,int last,String name){
		//Variable midValue as 0
				int midValue=0;
				//Checking if first is less then last value 
				if(first<=last)
				{
					midValue = (first+last)/2;
					//If the name in the array is equal to the name to search 
					if(name.equals(catalogue[midValue].getName()))
					{
						//Then returning the number of the user
						return catalogue[midValue].getNumber();
					}
					else if(name.compareTo(catalogue[midValue].getName())>0)
					{
				    //calling the function again If yes then set the first value as value next to midValue
						return binarySearch(midValue+1,last,name);
					}
					else if(name.compareTo(catalogue[midValue].getName())<=0)
					{
						// calling the function again if yes with  last value as value previous to mid value
						return binarySearch(first,midValue-1,name);
					}
				}
		return -1;
	}

	// helper method exposed to the programmer
	public int binarySearch(String name){
		return binarySearch(0,current-1,name);
	}
	
	
}
