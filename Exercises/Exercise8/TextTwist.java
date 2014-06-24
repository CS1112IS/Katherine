import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


class WordInfo {

    String originalWord;               // Store the full word here. You must do this.
    int subWordLength;                 // What is the length of each subword here. Again, you need to set this correctly.
    LinkedList<String> subWords;       // The list of subwords of that length.

    LinkedList<String> foundSubWords;  // This is all the words currently found by the user.


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



class TextTwistGUI extends JFrame {

    /////////////////////////////////////////////////////////////////////////////////
    //
    // Variables

    JTextArea textArea;             // We'll write the results into this textbox.
    JTextField stringField;         // Input a word from the user.
    JScrollPane scrollPane;         // A GUI element.
    JLabel wordLabel;               // We'll write out the word here in scrambled form.
    JLabel topLabel;                // This is where messages are written to the user.

    String[] dictionary;            // The dictionary.
    LinkedList<String> wordList;    // This is a list of words or puzzles, one per game.
    int wordListCount;              // Where we are in our list.

    String currentWord;             // The current word, unscrambled.
    WordInfo[] subWordInfo;         // For the current word, all the subword info.



    /////////////////////////////////////////////////////////////////////////////////
    //
    // Constructor. This has all the GUI building stuff.

    public TextTwistGUI ()
    {
        // Set some parameters of the frame (window) that's brought up.
        this.setSize (600, 600);
        this.setTitle ("TextTwist");
        this.setResizable (true);

        // This is how stuff is put into a frame.
	Container cPane = this.getContentPane();

	// Label at the top.
	topLabel = new JLabel("      ");
	cPane.add (topLabel, BorderLayout.NORTH);

        // Create an instance of the text area and put that in a scrollpane.
        textArea = new JTextArea ();
	scrollPane = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        cPane.add (scrollPane, BorderLayout.CENTER);
        
        // Make the controls. This has two parts.
	JPanel bottomPanel = new JPanel ();
	bottomPanel.setLayout (new GridLayout(2,1));

	JPanel topPart = new JPanel ();
	wordLabel = new JLabel ("       ");
        wordLabel.setFont (new Font ("Serif", Font.BOLD, 30));
	topPart.add (wordLabel);
	topPart.add (new JLabel ("       "));
	bottomPanel.add (topPart);

        JPanel bottomPart = new JPanel ();
        JLabel label = new JLabel ("Enter sub-word: ");
        bottomPart.add (label);
        stringField = new JTextField (10);
        bottomPart.add (stringField);
        JButton button = new JButton ("Add");
	button.addActionListener (
	  new ActionListener () {
	      public void actionPerformed (ActionEvent a)
	      {
		  handleAddButtonClick();
	      }
	  }
        );
        bottomPart.add (button);

	bottomPart.add (new JLabel ("    "));
        JButton shuffleButton = new JButton ("Shuffle");
	shuffleButton.addActionListener (
	  new ActionListener () {
	      public void actionPerformed (ActionEvent a)
	      {
		  handleShuffleButtonClick();
	      }
	  }
        );
        bottomPart.add (shuffleButton);

	bottomPart.add (new JLabel ("    "));
        JButton nextButton = new JButton ("Next word");
	nextButton.addActionListener (
	  new ActionListener () {
	      public void actionPerformed (ActionEvent a)
              {
		  handleNextButtonClick();
	      }
	  }
        );
        bottomPart.add (nextButton);
	bottomPanel.add (bottomPart);

	bottomPart.add (new JLabel ("    "));
        JButton quitButton = new JButton ("Quit");
	quitButton.addActionListener (
	  new ActionListener () {
	      public void actionPerformed (ActionEvent a)
              {
		  System.exit(0);
	      }
	  }
        );
        bottomPart.add (quitButton);

	bottomPanel.add (bottomPart);
        
        // The GUI is now built.
        cPane.add (bottomPanel, BorderLayout.SOUTH);

        // Get the list of puzzles.
	wordList = getWords();
	wordListCount = 0;
	
        // Bring up the GUI.
        this.setVisible (true);
    }
    

    LinkedList<String> getWords()
    {
	// First, the dictionary.
	dictionary = WordTool.getDictionary ("words.txt");

        // This is just a test for now, with just two puzzle words. 
        // What we should do is populate the list with "reasonable" 
        // words that don't have too many subwords. For example, 
        // "Conversation" is not a good word because it has too 
        // many subwords. One approach may be to fill this from
        // the dictionary with all words that are between 5 and 8
        // letters long.
	LinkedList<String> list = new LinkedList<String>();
   	for(int i = 0; i < dictionary.length; i++)
	{
		if(dictionary[i].length() >= 5 && dictionary[i].length() <= 8)
		{
			list.add(dictionary[i]);	
		}
	}
	return list;
     }


    /////////////////////////////////////////////////////////////////////////////////
    //
    // Handle input.


    // When the user clicks the add button, this method gets called.

    void handleAddButtonClick ()
    {
        // Extract the string from the textfield where the user typed the strings.
        String inputStr = stringField.getText ();

        // Some sanity checks.
	if (inputStr == null) {
	    writeOutput ();
	    return;
	}
	inputStr = inputStr.trim ();
	if (inputStr.length() == 0) {
	    writeOutput ();
	    return;
	}

	// Check word against those already put up.
	int len = inputStr.length();
	if (subWordInfo[len].subWords == null) {
	    writeOutput ();
	    return;
	}

        // If this is not a subword, ignore it.
	if (! subWordInfo[len].subWords.contains (inputStr) ) {
	    writeOutput ();
	    return;
	}

        // We've got a new subword, so add that to the list of "found" subwords.
	if (subWordInfo[len].foundSubWords == null) {
	    subWordInfo[len].foundSubWords = new LinkedList<String>();
	}
	subWordInfo[len].foundSubWords.add (inputStr);

        // Put the output string in the text box.
	writeOutput ();

        // Clear the textfield.
	stringField.setText ("");
    }

    

    // Build the string that goes into the text box.

    void writeOutput ()
    {
        // Sanity check.
	if (currentWord == null) {
	    return;
	}

        // This is the string we will build.
	String s = "";

	boolean finished = true;

        // Repeat for each possible subword size.
	for (int n=3; n<= currentWord.length(); n++) {

	    int numWords = subWordInfo[n].subWords.size();
	    int numWordsFound = 0;
	    if (subWordInfo[n].foundSubWords != null) {
		numWordsFound = subWordInfo[n].foundSubWords.size();
	    }
	    if (numWordsFound != numWords) {
		finished = false;
	    }
	    s += "Found " + numWordsFound + " words out of " + numWords + " words of length " + n + ":\n";
	    if (subWordInfo[n].foundSubWords != null) {
		for (int i=0; i<subWordInfo[n].foundSubWords.size(); i++) {
		    String w = subWordInfo[n].foundSubWords.get(i);
		    s += "  " + w + "\n";
		}
	    }	    
	    s += "\n";

	} //end-for

	if (finished) {
	    topLabel.setText ("Congratulations! You found all the words!");
	}
	textArea.setText (s);
    }


    // This is simple: every time the user hits the "shuffle" button,
    // we randomly permute the letters and write it back.

    void handleShuffleButtonClick ()
    {
	setPermutedWordLabel ();
    }


    void setPermutedWordLabel ()
    {
	String perm = permute (currentWord);
        // We may have to repeat a couple of times.
	while ( perm.equalsIgnoreCase (currentWord) ) {
	    perm = permute (currentWord);
	}
	wordLabel.setText (perm);
    }


    String permute (String currentWord)
    {
	LinkedList<String> permutedWords = new LinkedList<String>();

	char[] letters = currentWord.toCharArray();

	char[] permuteLetters = new char[letters.length];

	for(int i = 0; i < letters.length; i++)
	{
		permuteLetters[i] = '$';
	}
	
	permuteNow(permuteLetters.length, permuteLetters, letters, 0, letters, permutedWords);

	int random = (int)(Math.random() * permutedWords.size());

	String returnThis = new String(permutedWords.get(random));

	return returnThis;

    }

    void permuteNow(int numSpaces, char[] wordToLetter, char[] wordLetter, int wordNum, char[] word, LinkedList<String> subWordsReal)
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

			permuteNow(numSpaces - 1, wordToLetter, wordLetter, wordNum + 1, word, subWordsReal);

			wordToLetter[i] = '$';

		}

	}

    }

    void findSmaller(char[] wordToLetter, int wordLength, LinkedList<String> subWordsActual)
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

			permuteNow(wordLength, numSubWord, subWordFound, 0, wordToLetter, subWordsActual);
		}
	}

	else if(wordLength == wordToLetter.length)
	{
		char[] numSubWord = new char[wordLength];
			
		for(int i = 0; i < wordLength; i++)
		{
			numSubWord[i] = '$';
		}

		permuteNow(wordLength, numSubWord, wordToLetter, 0, wordToLetter, subWordsActual);
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



    void handleNextButtonClick ()
    {
	textArea.setText ("");
	topLabel.setText ("");

        // Get the next word.
        if (wordListCount >= wordList.size()) {
            // No more words left.
            topLabel.setText ("Game over. No more puzzles left");
            return;
        }
        
	currentWord = wordList.get (wordListCount);
        wordListCount ++;

        topLabel.setText ("Building subwords ... wait...");
        
	// Compute all sub-words.
	subWordInfo = findSubWords (currentWord);

	// Make a random perm and display it.
	setPermutedWordLabel ();
        topLabel.setText ("  ");
    }


    boolean isDictionaryWord (String word)
    {
	for (int i=0; i<dictionary.length; i++) {
	    if ( dictionary[i].equalsIgnoreCase (word) ) {
		return true;
	    }
	}
	return false;
    }

    WordInfo[] findSubWords(String s)
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


}


public class TextTwist {

    public static void main (String[] argv)
    {
	TextTwistGUI t = new TextTwistGUI ();
    }

}
