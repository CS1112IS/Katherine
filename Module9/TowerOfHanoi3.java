
public class TowerOfHanoi3 {

    public static int x = 0;

    public static void main (String[] argv)
    {
        // A 5-disk puzzle:
	solveHanoi (4, 0, 1);

	
    }

    static void solveHanoi (int n, int i, int j)
    {
	// Bottom-out.
	if (n == 0) {
            // The smallest disk.
	    move (0, i, j);
	    return;
	}

	int k = other (i, j);
	solveHanoi (n-1, i, k);    // Step 1.
	move (n, i, j);            // Step 2.
	solveHanoi (n-1, k, j);    // Step 3.
	
    }


    static void move (int n, int i, int j)
    {
	char m = ' ';
	switch(n) {
		case 0: m = 'A';
			break;
		case 1: m = 'B';
			break;
		case 2: m = 'C';
			break;
		case 3: m = 'D';
			break;
		case 4: m = 'E';
			break;
		default: m = 'w';
			break;
		} 
	
	System.out.println("Day " + x + " - " + "use disk " + m);
	x++;
     // INSERT YOUR CODE HERE.
        // Before printing, convert n=0 to 'A', n=1 to 'B' etc.
    }


    static int other (int i, int j)
    {
        // Given two towers, return the third.
        if ( (i == 0) && (j == 1) ) {
            return 2;
        }
        else if ( (i == 1) && (j == 0) ) {
            return 2;
        }
        else if ( (i == 1) && (j == 2) ) {
            return 0;
        }
        else if ( (i == 2) && (j == 1) ) {
            return 0;
        }
        else if ( (i == 0) && (j == 2) ) {
            return 1;
        }
        else if ( (i == 2) && (j == 0) ) {
            return 1;
        }

        // We shouldn't reach here.
        return -1;
    }

}
