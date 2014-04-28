public class Llist{
	

	private static Node head;
	private static int size=0;


	public static void add(String info)
	{
		Node temp = new Node();
		if(size==0)
		{
			head = new Node();
			head.data = info;
			size++;
		}else{
			temp=head;
			while(temp.next!=null){
			temp=temp.next;
			}
			temp.next = new Node();
			temp.next.data = info;
			size++;
		}
	}	
		
	

	public static void remove(int index)
	{
		if(index >= size){
		System.out.println("The number you have entered is invalid");
		}else if(size==1){
			head=null;
			System.out.println("There was only one link in your linked list. It has now been deleted");
		}else if(index==0){
			head=head.next;
		}else{
		Node temp=head;
		for(int i=0;i<index;i++){
			if(i==(index-1)){
				temp.next=temp.next.next;
			}else{
			temp = temp.next;
			}
		}
		}
		size--;
	}

	public static String get(int index)
	{
		if(index >= size){
		System.out.println("The number you have entered is invalid");
		}else{
		Node temp = head;
		for(int i=0;i<size;i++){
			if(i==(index)){
				System.out.println(temp.data);
				return temp.data;
			}else{
			temp = temp.next;
		}
		}
	}
	return null;
	}
	
	public static boolean search(Node temp, String s)
	{
		if(temp.data.equals(s))
		{
			System.out.println("This list contains " +s);
			return true;
		}else if(temp.next==null){
			System.out.println("This list does not contain "+ s);
			return false;
		}else{
			search(temp.next,s);
		}
		return false;
	}


	public static boolean contains(String s)
	{
		Node temp = head;
		return(search(temp,s));
		
	}
	
	public static int size()
	{
		System.out.println(size);
		return size;
	}

	public static void print()
	{
		if(size==0){
			System.out.println("The list is empty");
		}else{
		Node temp = new Node();
		temp = head;
		for(int i=0;i<size;i++){
			System.out.print(temp.data);
			if(i<size-1){
			System.out.print("-->");
			}
			temp=temp.next;
		}
		System.out.println();
		}
	}

}
