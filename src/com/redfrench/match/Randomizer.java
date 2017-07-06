package com.redfrench.match;

import java.util.Random;

public class Randomizer {
	Random randomGenerator = new Random();
	
	public int boxer() {
		int randomInt;
		return randomInt = randomGenerator.nextInt(2);
	}
	
	public int punch() {
		int randomInt;
		return randomInt = randomGenerator.nextInt(6);
	}
	
}
