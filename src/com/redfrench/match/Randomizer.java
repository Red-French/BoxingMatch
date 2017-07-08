package com.redfrench.match;

import java.util.Random;

public class Randomizer {
	Random randomGenerator = new Random();

	public int randomNum(int num) {
		int randomInt;
		return randomInt = randomGenerator.nextInt(num);
	}
	
}
