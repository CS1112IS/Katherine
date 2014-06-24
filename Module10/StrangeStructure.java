
class Node {

    String data;      // The data to be stored.

    Node left;        // Two pointers.
    Node right;

}


public class StrangeStructure {

    public static void main (String[] argv)
    {
        // Step 1:
        Node root = new Node ();
        root.data = "Ewok";                  
        
        // Step 2:
        root.right = new Node ();
        root.right.data = "Gungan";

      	root.right.right = new Node();
	root.right.right.data = "Jawa";

	root.right.right.left = new Node();
	root.right.right.left.data = "Gungan";
	
 	// Step 3:
        root.left = new Node ();
        root.left.data = "Aqualish";

        // Step 4:
        root.left.left = new Node ();
        root.left.left.data = "Amanin";

        // Step 5:
        root.left.right = new Node ();
        root.left.right.data = "Cerean";
    }

}
