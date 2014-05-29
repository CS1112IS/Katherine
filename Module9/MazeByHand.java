
import java.util.*;

public class MazeByHand {

    public static void main (String[] argv)
    {
        Maze maze = new Maze (5, 5);

	maze.breakWall(new Coord(3,4), new Coord(2,4));
	maze.breakWall(new Coord(2,4), new Coord(2,3));
	maze.breakWall(new Coord(2,3), new Coord(2,2));
	maze.breakWall(new Coord(2,2), new Coord(2,1));
	maze.breakWall(new Coord(2,1), new Coord(1,1));
        maze.display ();

	LinkedList<Coord> solutionPath = new LinkedList<Coord>();
	solutionPath = {(3,4), (2,4)};
	maze.setSolutionPath(solutionPath);        
    }

    

}

