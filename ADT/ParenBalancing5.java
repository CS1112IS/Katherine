
import java.util.*;

public class ParenBalancing5 {

    public static void main (String[] argv)
    {
	String s = "()(())()";

        // Use this stack implementation for the first example.
        StackImpl1 stack1 = new StackImpl1 ();
	ParenCheckTool.check (s, stack1);

	s = "((())";

        // Use another stack implementation for the second example.
        StackImpl2 stack2 = new StackImpl2 ();
	ParenCheckTool.check (s, stack2);
    }

}
