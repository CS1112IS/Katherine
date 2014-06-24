
import java.util.*;


// Use an instance of this for all subwords of a certain length.
// Thus, one instance of this for subwords of length 3, one instance
// for subwords of length 4 etc.

class WordInfo {

    String originalWord;            // Store the full word here. You must do this.
    int subWordLength;              // What is the length of each subword here. Again, you need to set this correctly.
    LinkedList<String> subWords;    // The list of subwords of that length.

    // This will print out all the subwords into a string.
    public String toString ()
    {
	String s = "Subwords of string \"" + originalWord + "\" of length " + subWordLength + ": \n";
	if ( (subWords == null) || (subWords.size() == 0) ) {
	    s += "  NONE";
	    return s;
	}
	for (int i=0; i<subWords.size(); i++) {
	    s += "  " + subWords.get(i) + "\n";
	}
	return s;
    }

} // end-WordInfo



public class SubWordFinder {

    static String[] dictionary;

    public static void main (String[] argv)
    {
	// Read in the dictionary. Should be used later to 
	// check whether a given letter combination is a real word.
	dictionary = WordTool.getDictionary("words.txt");

	// The method findSubWords returns an array of WordInfo
	// instances. Thus, subWordInfo[3] is an instance of 
	// WordInfo that has all the info about subwords of length 3.
	
	WordInfo[] subWordInfo = findSubWords ("house");
	findSubWords("house");
	for (int i=3; i<=5; i++) {
	    System.out.println (subWordInfo[i]);
	}
    }


    // Check if a given string is in the dictionary.
    // You will find this useful to check whether a given
    // arrangement of letters is in the dictionary.

    static boolean isDictionaryWord (String word)
    {
	for (int i=0; i<dictionary.length; i++) {
	    if ( dictionary[i].equalsIgnoreCase (word) ) {
		return true;
	    }
	}
	return false;
    }


    // A variation of the above method that might be more useful.

    static boolean isDictionaryWord (char[] letters)
    {
	String s = new String (letters);
	return isDictionaryWord (s);
    }

	
    static WordInfo[] findSubWords(String s)
    {
	char[] letters = s.toCharArray();
	
	WordInfo[] subWordsAll = new WordInfo[letters.length+1];

	//goal: permute letters of combination from size 3 to size s.length(), 
	//then check combinations against dictionary to see if they are valid words

    	for(int i = 0; i < subWordsAll.length; i++)
	{
		if(i < 3)
		{
			subWordsAll[i] = null;
		}
		
		else
		{
			subWordsAll[i] = new WordInfo();
			subWordsAll[i].originalWord = s;
			subWordsAll[i].subWordLength = i;
			LinkedList<String> subWordsFound = new LinkedList<String>();

			findSmaller(letters, i, subWordsFound);

			subWordsAll[i].subWords = subWordsFound;
		}

	}

	return subWordsAll;

    }
    // INSERT YOUR CODE HERE

    static void findSmaller(char[] wordToLetter, int wordLength, LinkedList<String> subWordsActual)
    {
	if(wordLength == wordToLetter.length - 1)
	{
		for(int i = 0; i < wordToLetter.length; i++)
		{
			char[] subWordFound = new char[wordLength];
			
			for(int j = 0; j < wordLength; j++)
			{
				int position = j + i;
				if(position >= wordToLetter.length)
				{
					position = (Math.abs(wordToLetter.length-position));
				}

				subWordFound[j] = wordToLetter[position];
			}

			char[] numSubWord = new char[wordLength];
		
			for(int k = 0; k < numSubWord.length; k++)
			{
				numSubWord[k] = '$';
			}

			permute(wordLength, numSubWord, subWordFound, 0, wordToLetter, subWordsActual);
		}
	}

	else if(wordLength == wordToLetter.length)
	{
		char[] numSubWord = new char[wordLength];
			
		for(int i = 0; i < wordLength; i++)
		{
			numSubWord[i] = '$';
		}

		permute(wordLength, numSubWord, wordToLetter, 0, wordToLetter, subWordsActual);
	} 

	else
	{
		for(int i = 0; i < wordToLetter.length; i++)
		{
			char[] subWordFound = new char[wordToLetter.length - 1];
			
			for(int j = 0; j < wordToLetter.length - 1; j++)
			{
				int position = i + j;

				if(position >= wordToLetter.length)
				{
					position = (Math.abs(wordToLetter.length - position));
				}

				subWordFound[j] = wordToLetter[position];
			} 

			findSmaller(subWordFound, wordLength, subWordsActual);
		}
	}

    }

    static void permute(int numSpaces, char[] wordToLetter, char[] wordLetter, int wordNum, char[] word, LinkedList<String> subWordsReal)
    {
	if(numSpaces == 0)
	{
		String s = new String(wordToLetter);

		if(isDictionaryWord(s) && !subWordsReal.contains(s))
		{
			subWordsReal.add(s);
		}
		
		return;		

	}
	
	for(int i = 0; i < wordToLetter.length; i++)
	{
		if(wordToLetter[i] == '$')
		{
			wordToLetter[i] = wordLetter[wordNum];

			permute(numSpaces - 1, wordToLetter, wordLetter, wordNum + 1, word, subWordsReal);

			wordToLetter[i] = '$';

		}

	}

    }

} // end-SubWordFinder class



