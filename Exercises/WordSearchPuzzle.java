
public class WordSearchPuzzle {

    public static void main (String[] argv)
    {
        char[][] puzzle = {
            {'v', 'h', 'n', 'b', 'u', 'b', 'q', 's', 'b', 'r'},
            {'p', 'k', 'j', 'w', 's', 'y', 'a', 'd', 'd', 'o'},
	    {'y', 'c', 'e', 's', 'd', 'r', 'n', 'c', 'e', 'k'},
	    {'d', 'd', 'a', 'e', 't', 'w', 'r', 'z', 'v', 'x'},
	    {'g', 'l', 'g', 'a', 'l', 'a', 'u', 'b', 'r', 't'},
	    {'c', 'n', 'c', 'f', 'z', 's', 't', 'd', 'n', 'l'},
	    {'w', 'o', 'w', 'h', 'i', 'l', 'e', 'i', 'g', 'b'},
	    {'h', 'y', 'm', 'j', 'h', 'k', 'r', 'o', 'c', 'e'},
	    {'n', 'n', 's', 'j', 'k', 'm', 'g', 'v', 'u', 'm'},
	    {'v', 'v', 'j', 'y', 'y', 'c', 'u', 'e', 'v', 'z'}
        };
        String[] words = {"class", "else", "int", "return", "static", "void", "while"};
        
	System.out.println(findWordsLR (puzzle, words));
	
	String[] foundWordsDiagRU = findWordsDiagRU(puzzle, words);
	for(int i = 0; i < foundWordsDiagRU.length; i++)
	{
		System.out.println(foundWordsDiagRU[i]);	
	}
	
	String[] foundWordsUp = findWordsUp(puzzle, words);
	for(int i = 0; i < foundWordsUp.length; i++)
	{
		System.out.println(foundWordsUp[i]);
	}
    	
	String[] foundWordsDiagRD = findWordsDiagRD(puzzle, words);
	for(int i = 0; i < foundWordsDiagRD.length; i++)
	{
		System.out.println(foundWordsDiagRD[i]);
	}
    }

    static String[] findWordsDiagRU (char[][] puzzle, String[] words)
    {
	String[] wordsFound = new String[words.length];
	for(int x = 0; x < words.length; x++)
	{
		char[] letters = words[x].toCharArray();
		
		//i is rows
		for(int i = letters.length; i < puzzle.length; i++)
		{
			//j is columns
			for(int j = 0; j < puzzle[i].length; j++)
			{
				boolean flag = true;
				//check to see if first letter of word is in puzzle
				if(puzzle[i][j] != letters[0])
				{
					flag = false;
				}

				else if(j == puzzle[i].length - 1)
				{
					flag = false;
				}

				else if(puzzle[i][j] == letters[0])
				{

					//check to see if next column, previous row contains next letter
					for(int l = i - 1, k = j + 1, m = 1; l >= 0 && k < puzzle[l].length && m < letters.length; l--, k++, m++)
					{
						if(puzzle[l][k] != letters[m])
						{
							flag = false;
							break;
						}
					}
				}

				if(flag == true)
				{
					wordsFound[x] = words[x] + " found at [" + (i+1) + "," + j + "] going diagonally right and up";
				} 
			}	
		} 
	}
	
	return wordsFound;
    }

    static String findWordsLR (char[][] puzzle, String[] words)
    {
	for(int x = 0; x < words.length; x++)
	{
		char[] letters = words[x].toCharArray();

		for(int i = 0; i < puzzle.length; i++)
		{
			for(int j = 0; j < puzzle[i].length; j++)
			{
				boolean found = true;
			
				for(int k = 0; k < letters.length; k++)
				{
					if( (j+k >= puzzle[i].length) || (letters[k] != puzzle[i][j+k]))
					{
						found = false;
						break;
					}
				}

				if(found)
				{
					return words[x] + " found at [" + (i+1) + "," + j + "] going left to right";
				}
			}
	
		}
	}
    return "null";
    }

    static String[] findWordsUp (char[][] puzzle, String[] words)
    {
	String[] foundWords = new String[words.length];
	for(int x = 0; x < words.length; x++)
	{
		char[] letters = words[x].toCharArray();
				
		//i is rows
		for(int i = letters.length; i < puzzle.length; i++)
		{	
			//j is columns
			for(int j = 0; j < puzzle[i].length; j++)
			{	
				boolean flag = true;
				//check to see if first letter of word is in puzzle
				if(puzzle[i][j] != letters[0])
				{
					flag = false;
				}

				else if(puzzle[i][j] == letters[0])
				{
					//check to see if the same column, previous row contains the previous letter
					for(int l = i-1, k = 1; l >= 0 && k < letters.length; l--, k++)
					{
						if(puzzle[l][j] != letters[k])
						{
							flag = false;
							break;
						}
					}
				}
				
				if(flag == true)
				{
					foundWords[x] = words[x] + " found at [" + (i+1) + "," + j + "] going upwards";
				}

			}
		}
	}
	return foundWords;
    }

    static String[] findWordsDiagRD (char[][] puzzle, String[] words)
    {
	String[] wordsFound = new String[words.length];
	for(int x = 0; x < words.length; x++)
	{
		char[] letters = words[x].toCharArray();

		//i is rows
		for(int i = 0; i < puzzle.length; i++)
		{
			//j is columns
			for(int j = 0; j < puzzle[i].length; j++)
			{
				boolean flag = true;
				//check to see if first letter of word is in puzzle
				if(puzzle[i][j] != letters[0])
				{
					flag = false;
				}
				
				else if(j == puzzle[i].length - 1 || i == puzzle.length - 1)
				{
					flag = false;
				}

				else if(puzzle[i][j] == letters[0])
				{
					//check to see if next column, next row contains next letter
					for(int l = i + 1, k = j + 1, m = 1; l < puzzle.length && k < puzzle[i].length &&  m < letters.length; l++, k++, m++)
					{
						if(puzzle[l][k] != letters[m])
						{
							flag = false;
						}
					}
				}
				
				if(flag == true)
				{
					wordsFound[x] = words[x] + " found at [" + i + "," + j + "] going diagonally right and down";
				} 
			}	
		} 
	}
	
	return wordsFound;
    }

}
