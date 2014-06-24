
import java.util.*;


public class WordReversals {

    public static void main (String[] argv)
    {
        // Fetch the dictionary.
        String[] words = WordTool.getDictionary ("words.txt");

        // Compare a tree data structure with ArrayList and LinkedList.
        findReversalsUsingHashtable (words);
        findReversalsUsingTree (words);
        findReversalsUsingArrayList (words);
        findReversalsUsingLinkedList (words);
    	findReversalsUsingHashtable(words);
    }
    

    static void findReversalsUsingHashtable (String[] words)
    {
        // INSERT YOUR CODE HERE
   	long startTime = System.currentTimeMillis();

	int count = 0;
	
	HashSet wordSet = new HashSet();
	for(int i = 0; i < words.length; i++)
	{
		wordSet.add(words[i]);
	}

	for(int i = 0; i < words.length; i++)
	{
		String reverseStr = reverse(words[i]);
		if(wordSet.contains(reverseStr))
		{
			count++;
			System.out.println(words[i]);
		}
	}
	
	long timeTaken = System.currentTimeMillis() - startTime;
	System.out.println("Using a hash: count=" + count + " timeTaken=" + timeTaken);
    }

    

    static void findReversalsUsingTree (String[] words)
    {
        long startTime = System.currentTimeMillis();

        // Count such words.
        int count = 0;

        // First put all words into a tree.
        TreeSet wordSet = new TreeSet ();
        for (int i=0; i<words.length; i++) {
            wordSet.add (words[i]);
        }
        
        // Now perform the search for reversals.
        for (int i=0; i<words.length; i++) {
            String reverseStr = reverse (words[i]);
            if (wordSet.contains (reverseStr)) {
                count ++;
                System.out.println (words[i]);
            }
        }

        // How much time has elapsed?
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println ("Using a tree: count=" + count + "  timeTaken=" + timeTaken);
    }



    static void findReversalsUsingArrayList (String[] words)
    {
        long startTime = System.currentTimeMillis();
        int count = 0;

        ArrayList wordSet = new ArrayList ();
        for (int i=0; i<words.length; i++) {
            wordSet.add (words[i]);
        }
        
        for (int i=0; i<words.length; i++) {
            String reverseStr = reverse (words[i]);
            if (wordSet.contains (reverseStr)) {
                count ++;
            }
        }
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println ("Using an ArrayList: count=" + count + "  timeTaken=" + timeTaken);
    }


    static void findReversalsUsingLinkedList (String[] words)
    {
        long startTime = System.currentTimeMillis();
        int count = 0;

        LinkedList wordSet = new LinkedList ();
        for (int i=0; i<words.length; i++) {
            wordSet.add (words[i]);
        }
        
        for (int i=0; i<words.length; i++) {
            String reverseStr = reverse (words[i]);
            if (wordSet.contains (reverseStr)) {
                count ++;
            }
        }
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println ("Using a LinkedList: count=" + count + "  timeTaken=" + timeTaken);
    }


    // Reverse a string. This method is used above.

    static String reverse (String str) 
    {
        char[] letters = str.toCharArray ();
        char[] revLetters = new char [letters.length];
        for (int i=0; i<letters.length; i++) {
            revLetters[i] = letters[letters.length-i-1];
        }
        String revStr = new String (revLetters);
        return revStr;
    }
    

}
