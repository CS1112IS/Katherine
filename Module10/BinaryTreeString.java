
import java.util.*;

class TreeNode {

    String data;
    TreeNode left;    // Pointer to the left child.
    TreeNode right;   // Pointer to the right child.


    // For debugging:

    public String toString ()
    {
        String str = "[data=" + data;
        String leftData = "null";
        if (left != null) {
            leftData = "" + left.data;
        }
        String rightData = null;
        if (right != null) {
            rightData = "" + right.data;
        }
        str += " left=" + leftData + " right=" + rightData + "]";
        return str;
    }
    
} //end-TreeNode



public class BinaryTreeString {

    TreeNode root = null;    // Root of the tree.
    int numItems = 0;        // We'll keep track of how many elements we've added so far.


    public void add (String data)
    {
        // If empty, create new root.
        if (root == null) {
            root = new TreeNode ();
            root.data = data;
            numItems ++;
            return;
        }
        
        // Search to see if it's already there.
        if ( contains (data) ) {
            // Handle duplicates.
            return;
        }
        
        // If this is a new piece of data, insert into tree.
        recursiveInsert (root, data);
        
        numItems ++;
    }

    
    void recursiveInsert (TreeNode node, String data)
    {
        // Compare input data with data in current node.
        if ( data.compareTo (node.data) < 0 ) {
            // It's less. Go left if possible, otherwise we've found the correct place to insert.
            if (node.left != null) {
                recursiveInsert (node.left, data);
            }
            else {
                node.left = new TreeNode ();
                node.left.data = data;
            }
            
        }
        // Otherwise, go right.
        else {
            // It's greater. Go right if possible, otherwise we've found the correct place to insert.
            if (node.right != null) {
                recursiveInsert (node.right, data);
            }
            else {
                node.right = new TreeNode ();
                node.right.data = data;
            }
        }
        
    }
    

    public int size ()
    {
        return numItems;
    }
    

    public boolean contains (String str)
    {
        if (numItems == 0) {
            return false;
        }
        
        return recursiveSearch (root, str);
    }
    

    boolean recursiveSearch (TreeNode node, String str)
    {
        // If input string is at current node, it's in the tree.
        if ( str.compareTo (node.data) == 0 ) {
            // Found.
            return true;
        }

        // Otherwise, navigate further.
        if ( str.compareTo (node.data) < 0 ) {
            // Go left if possible, otherwise it's not in the tree.
            if (node.left == null) {
                return false;
            }
            else {
                return recursiveSearch (node.left, str);
            }
        }
        else {
            // Go right if possible, otherwise it's not in the tree.
            if (node.right == null) {
                return false;
            }
            else {
                return recursiveSearch (node.right, str);
            }
        }

    }


    public void print ()
    {
        if (root == null) {
            System.out.println ("Empty tree");
            return;
        }
        
        System.out.println ("Tree: " + numItems + " nodes");
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add (root);
        while ( ! queue.isEmpty() ) {
            // Extract node.
            TreeNode node = queue.removeFirst ();
            // Add it's children to queue.
            if (node.left != null) {
                queue.add (node.left);
            }
            if (node.right != null) {
                queue.add (node.right);
            }
            // Print.
            System.out.println (node);
        }
        
    }
    

    public void preOrderPrint ()
    {
        System.out.println ("Pre-Order Traversal: ");
        preOrderRecursive (root);
    }
    
    void preOrderRecursive (TreeNode node)
    {
        System.out.println ("  " + node.data);
        if (node.left != null) {
            preOrderRecursive (node.left);
        }
        if (node.right != null) {
            preOrderRecursive (node.right);
        }
    }
    

    public void inOrderPrint ()
    {
        System.out.println ("In-Order Traversal: ");
        inOrderRecursive (root);
    }


    void inOrderRecursive (TreeNode node)
    {
        if (node.left != null) {
            inOrderRecursive (node.left);
        }
        System.out.println ("  " + node.data);
        if (node.right != null) {
            inOrderRecursive (node.right);
        }
    }
    
    
    public void postOrderPrint ()
    {
        System.out.println ("Post-Order Traversal: ");
        postOrderRecursive (root);
    }
    

    void postOrderRecursive (TreeNode node)
    {
        // INSERT YOUR CODE HERE
	if(node.left != null)
	{
		postOrderRecursive(node.left);
	}

	System.out.println(" " + node.data);

	if(node.right != null)
	{
		postOrderRecursive(node.right);
	}
    }

} //end-BinaryTreeString
