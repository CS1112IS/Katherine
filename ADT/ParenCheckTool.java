
public class ParenCheckTool {

    // NOTE: checkParens() is written to accept an interface instead
    // of an actual class.

    static void check (String inputStr, OurStackInterface stack)
    {
        // This code below is complete unchanged from before ...

	char[] letters = inputStr.toCharArray();

	boolean unbalanced = false;
	for (int i=0; i<letters.length; i++) {
	    if (letters[i] == '(') {
		stack.push (letters[i]);
	    }
	    else if (letters[i] == ')') {
		// We should have a match on the stack.
		char ch = ')';
		if (! stack.isEmpty() ) {
		    ch = stack.pop ();
		}
		if (ch != '(') {
		    // Mismatch => unbalanced.
		    unbalanced = true;
		    break;
		}
	    }
	}
	
	if ( (unbalanced) || (! stack.isEmpty()) ) {
	    System.out.println ("String " + inputStr + " has unbalanced parens");
	}
	else {
	    System.out.println ("String " + inputStr + " has balanced parens");	
        }
    }

}
