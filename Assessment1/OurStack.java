public class OurStack{

static String array[] = new String[100];
static int count = -1;

public OurStack(){}

public static void push(String s)
{
	count++;
	array[count]=s;
}

public static String pop()
{
	String temp = array[count];
	count--;
	return temp;
}

public static boolean isEmpty()
{
	if(count==-1)
	{
		return true;
	}
	return false;
}

public static int size()
{
	return count+1;
}

public static String peek()
{
	return array[count];
}








}
