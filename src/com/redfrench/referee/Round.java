package com.redfrench.referee;

import com.redfrench.main.Player_setup;
import com.redfrench.match.Punches;

public class Round {

    int round = 0;
 
    public void newRound() throws InterruptedException {
    	Punches punches = new Punches();
    	
    	System.out.println("Come out fighting!");
    	
    	punches.throwPunches();
    }
    
    public void endOfRound() {
    	this.round = round +1;
    	System.out.println("\nDING DING DING DING DING!!!!! \nEnd of round " + round + "!");
    	System.out.println("\nEND OF ROUND " + round + " BOXER REPORT\n");
    	System.out.print(Player_setup.getDuksters().get(0).getName() + "'s ENERGY: ");
    	System.out.println(Player_setup.getDuksters().get(0).getEnergy());
    	System.out.print(Player_setup.getDuksters().get(1).getName() + "'s ENERGY: ");
    	System.out.println(Player_setup.getDuksters().get(1).getEnergy() + "\n");
    }
}
