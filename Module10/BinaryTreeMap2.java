
import java.util.*;

class TreeNode {

    String key;
    Object value;
    
    TreeNode left;
    TreeNode right;
    
}


public class BinaryTreeMap2 {

    TreeNode root = null;
    int numItems = 0;


    public void add (String key, Object value)
    {
        // If empty, create new root.
        if (root == null) {
            root = new TreeNode ();
            // Store both key and value:
            root.key = key;              
            root.value = value;
            numItems ++;
            return;
        }
        
        // Search to see if it's already there.
        if ( contains (key) ) {
            // Handle duplicates.
            return;
        }
        
        // If this is a new piece of data, insert into tree.
        recursiveInsert (root, key, value);
        
        numItems ++;
    }

    
    void recursiveInsert (TreeNode node, String key, Object value)
    {
        // Compare input key with key in current node: comparisons are only with keys.

        if ( key.compareTo (node.key) < 0 ) {
            // It's less. Go left if possible, otherwise we've found the correct place to insert.
            if (node.left != null) {
                recursiveInsert (node.left, key, value);
            }
            else {
                node.left = new TreeNode ();
                node.left.key = key;              // Store both key and value.
                node.left.value = value;
            }
            
        }
        // Otherwise, go right.
        else {
            // It's greater. Go right if possible, otherwise we've found the correct place to insert.
            if (node.right != null) {
                recursiveInsert (node.right, key, value);
            }
            else {
                node.right = new TreeNode ();
                node.right.key = key;             // Store both key and value.
                node.right.value = value;
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
        
        TreeNode node = recursiveSearch (root, str);
        if (node == null) {
            return false;
        }

        return true;
    }


    public Object getValue (String key)
    {
        if (numItems == 0) {
            return -1;
        }
        
        TreeNode node = recursiveSearch (root, key);
        if (node == null) {
            return -1;
        }

        return node.value;
    }
    
    
    TreeNode recursiveSearch (TreeNode node, String key)
    {
        // If input key is at current node, it's in the tree.
        if ( key.compareTo (node.key) == 0 ) {
            // Found.
            return node;
        }

        // Otherwise, navigate further.
        if ( key.compareTo (node.key) < 0 ) {
            // Go left if possible, otherwise it's not in the tree.
            if (node.left == null) {
                return null;
            }
            else {
                return recursiveSearch (node.left, key);
            }
        }
        else {
            // Go right if possible, otherwise it's not in the tree.
            if (node.right == null) {
                return null;
            }
            else {
                return recursiveSearch (node.right, key);
            }
        }
    }

} //end-BinaryTreeMap2
