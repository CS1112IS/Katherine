import java.util.*;

public class StackImpl2 implements OurStackInterface{

	static LinkedList<Character> letters = new LinkedList<Character>();
	
	static int count = -1;

	public StackImpl2(){}

	public void push(char x)
	{
		count++;
		letters.add(x);
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
			char temp = letters.get(count);
			count--;
			return temp;
		}
		
		return '@';	
	}


}
