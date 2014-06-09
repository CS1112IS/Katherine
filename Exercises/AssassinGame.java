
class ListItem {

    String data;
    ListItem next;

}


class CircularList {

    // The usual list variables.
    ListItem front = null;
    ListItem rear = null;

    // To keep track of the size.
    int numItems = 0;
	

    public void add (String s)
    {
	if(front == null)
	{
		front = new ListItem();
		front.data = s;
		rear = new ListItem();
		rear.data = s;
		front = rear;	
		rear.next = front;
	}

	else
	{
		ListItem nextOne = new ListItem();
		nextOne.data = s;
		rear.next = nextOne;
		rear = nextOne;
		rear.next = front;
       	}

	numItems ++;

    }


    public int size ()
    {
	System.out.println(numItems);
	return numItems;
    }


    public String toString ()
    {
	if(front == null)
	{
		return "empty";
	}
	
	String s = "";
	ListItem listPtr = front;
	while(listPtr != rear)
	{
		s += listPtr.data + ", ";
		listPtr = listPtr.next;
	}

	return s + rear.data;	
	
    }


    public String fire (String assassin)
    {
	ListItem temp = new ListItem();
	String s = "";
	if(numItems == 0)
	{
		return "empty";
	}

	if(numItems > 0)
	{
		temp = front;
	
		if(rear.data.equals(assassin))
		{
			s = rear.next.data;
			rear.next = rear.next.next;
			front = rear.next;
			return s;
		}
	
		while(!temp.data.equals(assassin))
		{
			temp = temp.next;
			if(temp == rear)
			{
				return "Error: no such assassin.";
			}
		}
		
		if(temp.data.equals(assassin))
		{
			s = temp.next.data;
			ListItem tempN = new ListItem();
			tempN = temp.next;

			if(tempN.data.equals(s))
			{
				tempN = tempN.next;
				temp.next = tempN;
			}

			return s;
		}

    	}	
	
	return "null";
   }

}


public class AssassinGame {

    public static void main (String[] args)
    {
        CircularList assassins = new CircularList ();
        assassins.add ("Jackal");
        assassins.add ("Mata Hari");
	assassins.add ("John Wilkes Booth");
        assassins.add ("Lee Harvey Oswald");
        assassins.add ("Gavrilo Princip");
        assassins.add ("James Earl Ray");
        assassins.add ("Jack Ruby");

        System.out.println (assassins.toString());

        String victim = assassins.fire ("Gavrilo Princip");
        System.out.println ("\nGavrilo's victim: " + victim + "\n  Remaining: " + assassins.toString());
        // Gavrilo's victim: James Earl Ray
	
	victim = assassins.fire ("Jack Ruby");
	System.out.println ("\nJack's victim: " + victim + "\n  Remaining: " + assassins.toString());
        // Jack's victim: Jackal

        victim = assassins.fire ("Mata Hari");
        System.out.println ("\nMata's victim: " + victim + "\n  Remaining: " + assassins.toString());
        // Mata's victim: John Wilkes Booth

        victim = assassins.fire ("Jackal");
        System.out.println ("\nJackal's victim: " + victim + "\n  Remaining: " + assassins.toString());
        // Victim: Error: no such assassin.

        victim = assassins.fire ("Jack Ruby");
        System.out.println ("\nJack's victim: " + victim + "\n  Remaining: " + assassins.toString());
        // Jack's second victim: Mata Hari
  
    }
    

}
