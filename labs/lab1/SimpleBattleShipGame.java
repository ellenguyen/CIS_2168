import java.util.*;

public class SimpleBattleShipGame {
	
	public static void main(String[] args) {
		int numOfGuesses = 0;
		SimpleBattleShip ship = new SimpleBattleShip();
		
		// compute random number between 0 and 4
		int rand = (int) (Math.random() * 5);
		int[] shipCoordinates = {rand, rand + 1, rand + 2};
		
		ship.setPosition(shipCoordinates);
		
		boolean isAlive;
		isAlive = true;
		while (isAlive == true) {
			GameHelper gameHelper = new GameHelper();
			// get userGuess from command line
			int userGuess = gameHelper.getInput("Enter a number");
			String result = ship.updateStatus(userGuess);
			System.out.println(result);
			
			// increment number of guesses
			numOfGuesses++;
			
			if (result.equals("kill")) {
				isAlive = false;
			}			
		}
		System.out.printf("You took %d guesses %n", numOfGuesses);
	}
	
	public static int getInput() {
		System.out.print("Enter a number: ") ;
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
}