package match;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
	Random randomGenerator = new Random();

	public int randomNum(int num) {
		int randomInt;
		return randomInt = randomGenerator.nextInt(num);
	}
	
	public int randomTimeBetweenPunches() {
		int timeBetweenPunches;
		return timeBetweenPunches = ThreadLocalRandom.current().nextInt(250, 4000);  // returns random int between these values  
	}

}