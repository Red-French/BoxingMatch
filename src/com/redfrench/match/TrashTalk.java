package com.redfrench.match;

import java.util.ArrayList;

import main.Player_setup;
import match.Randomizer;

public class TrashTalk {

	private static Player_setup player = new Player_setup();
	private static Randomizer randomizer = new Randomizer();	
	private static ArrayList<String> banter = new ArrayList<String>();
	
	static {  // singleton
		banter.add("was that a love tap?!");
		banter.add("quit. That tickles.");
		banter.add("are those pillows hitting me?");
		banter.add("your mama wears combat boots!");
	}
	
	
	public void banter(int boxer) throws InterruptedException {

		int banterLine = randomizer.randomNum(4);
		
		String boxerWhoPunched = player.getDuksters().get(boxer).getName();
		System.out.println("\n Trash talk: " + boxerWhoPunched + ", " + banter.get(banterLine) + "\n");
		Thread.sleep(1750);
	}
	
}
