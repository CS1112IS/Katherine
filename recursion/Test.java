public class Test {

	public static void main(String[] args) 
	{
		ArrayToolbox tool = new ArrayToolbox();
		int[] A = {1, 4, 72, 65, 23, 17, 57, 94, 54, 10, 100, 3, 22, 1001, 34, 8};

		/*these are for non-recursive
		boolean flag = tool.search(A, 3, 0);
		
		if(flag) System.out.println(3 + " was found!");
		
		else System.out.println(3 + " was not found");
		*/

		boolean flag2 = tool.searchRecurse(A, 1001, 0);

		if(flag2) System.out.println(1001 + " was found!");
		else System.out.println(1001 + " was not found");

		boolean flag3 = tool.searchRecurse(A, 6, 0);
		if(flag3) System.out.println(6 + " was found!");
		else System.out.println(6 + " was not found");
	}
}
