
public class BinaryTreeIntExample {

    public static void main (String[] argv)
    {
        // Make an instance of the tree.
        BinaryTreeInt tree = new BinaryTreeInt ();

        // Add stuff.
        tree.add (5);
        tree.add (9);
        tree.add (1);
        tree.add (3);
        tree.add (7);
        tree.add (13);
        tree.add (11);

        // Test a search:
        if ( tree.contains (11) ) {
            System.out.println ("Tree contains 11");
        }
        
        tree.print ();
        tree.printRecursively ();
    }

}
