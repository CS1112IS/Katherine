public class ArrayToolbox {

	public ArrayToolbox() 
	{
		
		

	}

	/*
	*	This is a function to search over an array for a value
	*	@value is the item we are searching for
	*	@index is the current location in the array
	*	@A is the array we are searching
	*	The function returns true if found, false if not.
	*/

	public static boolean search(int[] A, int value, int index)
	{
		// this is the non-recursive solution
		for(int i = 0; i < A.length; i++)
		{
			if(value == A[i])
			{
				return true;

			}

		}

		return false;
				
	} 

	public static boolean searchRecurse(int[] A, int value, int index)
	{
		if(index >= A.length)
		{
			//System.out.println("Element not found");
			return false;
		}

		if(value == A[index])
		{
			//System.out.println("Element found");
			return true;			
		}
		
		return searchRecurse(A, value, index + 1);

	}

	public static void quickSort(int[] A, int left, int right)
	{
		if(left < right)
		{
			
	

		}
	} 
}
