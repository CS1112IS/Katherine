
public class BinaryTreeStringExample {

    public static void main (String[] argv)
    {
        // Create an instance.
        BinaryTreeString tree = new BinaryTreeString ();

        // Add stuff.
        tree.add ("Ewok");
        tree.add ("Aqualish");
        tree.add ("Gungan");
        tree.add ("Amanin");
        tree.add ("Jawa");
        tree.add ("Hutt");
        tree.add ("Cerean");

        tree.print ();
        
        tree.inOrderPrint ();
        tree.preOrderPrint ();
        tree.postOrderPrint ();
    }

}
