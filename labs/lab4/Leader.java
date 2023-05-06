/******************************************************************************
 *  Dependencies: SLList.java developed in class
 *
 *  Solves the Leader problem.
 * 
 *  % Leader with n = 7 and m = 2 outputs:
 *  2 4 6 1 5 3
 *  leader: 7
 *
 *  % Leader with n = 7 and m = 3 outputs:
 *  3 6 2 7 5 1
 *  leader: 4
 *
 *  % Leader with n = 9 and m = 5 outputs:
 *  5 1 7 4 3 6 9 2
 *  leader: 8
 *
 *   Leader with n = 1000000 and m = 10 outputs:
 *  .... // a bunch of eliminated numbers and, the last line is:
 *  leader: 630538
 ******************************************************************************/
import java.util.*;

public class Leader {
    public static void main(String[] args) {
        int n = 7; // n = 1000000;
        int m = 3; // m = 10;

        // place the candidates in a list
        LinkedList<Integer> circle = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            circle.addLast(i);

        while (circle.size() != 1) {                  				// keep looping until there is only 1 person left
        	for (int i = 1; i < m; i++) {
        		circle.addLast(circle.removeFirst()); 				// move the first person to the end of the list
        	}
        	System.out.print(circle.removeFirst() + " "); 			// print out the people who was eliminated
        }
        
        System.out.println("\nleader: " + circle.removeFirst()); 	// print out the last person
    }
}