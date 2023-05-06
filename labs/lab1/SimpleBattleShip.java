import java.util.Arrays;

public class SimpleBattleShip {

	private int[] shipCoordinates;
	private int numOfHits;
	
	public String updateStatus(int guess) {
		if ((guess < 0) || (guess > 6)) {
			return "Invalid input";
		} else {
			for (int i = 0; i < shipCoordinates.length; i++) {
				if (guess == shipCoordinates[i]) {
					// increment number of hits
					numOfHits++;
					// eliminate the coordinates
					shipCoordinates[i] = -1;
					
					if (numOfHits == 3) {
						return "kill";
					} else {
						return "hit";
					}
				}
			}
		}
		return "miss";
	}
	
	public void setPosition(int[] coords) {
		shipCoordinates = coords;
	}
}