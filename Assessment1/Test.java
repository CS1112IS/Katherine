public class Test{

	public static void main(String[] args){
	Llist.add("Test0");
	Llist.add("Test1");
	Llist.add("Test2");
	Llist.add("Test3");
	Llist.add("Test4");
	Llist.add("Test5");
	Llist.print();
	
	Llist.get(0);
	Llist.remove(0);

	Llist.contains("Test5");
	Llist.contains("Test10");

	Llist.print();
	Llist.size();

	//Now Testing Stack...............................//
	System.out.println("Now testing Stack");

	OurStack stack = new OurStack();

	stack.push("Test0");
	stack.push("Test1");
	stack.push("Test2");
	stack.push("Test3");
	stack.push("Test4");
	stack.push("Test5");
	
	System.out.println(stack.peek());
	System.out.println(stack.isEmpty());
	for(int i=stack.size();i>0;i--)
	{
		System.out.println(stack.pop());
	}
	System.out.println(stack.isEmpty());



	}


}

