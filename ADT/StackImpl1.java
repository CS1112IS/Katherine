public class StackImpl1 implements OurStackInterface{

	static char[] letters = new char[30];
	
	static int count = -1;

	public StackImpl1(){}

	public void push(char x)
	{
		count++;
		letters[count] = x;
	}

	public boolean isEmpty()
	{
		if(count == -1)
		{
			return true;
		}

		return false;

	}

	public char pop()
	{
		if(count != -1)
		{
			char temp = letters[count];
			count--;
			return temp;
		}
	
		
		/*if(count == -1)
		{
			return '@';
		}
		
		char temp = letters[count];
		count--;	
		return temp;*/

		return '@';
	
	}


}
