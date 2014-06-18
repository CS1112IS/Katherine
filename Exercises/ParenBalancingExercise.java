
import java.util.*;

public class ParenBalancingExercise {

    public static void main (String[] argv)
    {
	String s = "((()))";
	checkParens (s);

	s = "((())";
	checkParens (s);

	s = "())))";
	checkParens (s);

	s = "(()()(";
	checkParens (s);
    }


    static void checkParens (String inputStr)
    {
	char[] parens = inputStr.toCharArray();

	char[] caret = new char[parens.length];

	for(int i = 0; i < caret.length; i++)
	{
		caret[i] = ' ';
	}

	Stack<Character> stack = new Stack<Character>();

	boolean unbalanced = false;
	
	if(parens[parens.length - 1] == '(')
	{
		unbalanced = true;
		
		//caret[parens.length - 1] = '^';
	}

	int j = 0;

	for(int i = 0; i < parens.length; i++)
	{
		if(parens[i] == '(')
		{
			stack.push(parens[i]);
		}

		else if(parens[i] == ')')
		{
			char ch = stack.pop();
			
			j = i;
			
			if(stack.isEmpty())
			{
				break;
			}	
			
			else if(ch != '(')
			{
				unbalanced = true;
				break;
			}

		}
	}

	if((unbalanced == true) || (parens.length % 2 != 0))
	{
		System.out.println("Unbalanced: " + inputStr);
		if(j+1 < caret.length)
		{
			caret[j + 1] = '^';
		}
		else if(j + 1 == caret.length)
		{
			caret[0] = '^';
		}
		String caretStr = new String(caret);
		System.out.println("            " + caretStr);
	}	

	else 
	{
		System.out.println("Balanced: " + inputStr);
	}

    }
}
