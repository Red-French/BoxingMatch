package referee;

import main.Player_setup;
import match.ThrowPunches;
import match.Randomizer;

import java.util.Timer;
import java.util.TimerTask;
import java.lang.Math;

public class Round extends ThrowPunches {
    
    private Player_setup player = new Player_setup();
    private Randomizer randomizer = new Randomizer();
    private Announcer announcer = new Announcer();
    
    Timer timer;
    int roundsToFight = 6;
    int round = 0;
    
 
    public void newRound() throws InterruptedException {
    	System.out.println("When the bell rings, come out fighting!");
    	timer = new Timer();
    	timer.schedule(new BeginRound(), 2000);
    }
    
    public TimerTask endRound() throws InterruptedException {
    	System.out.println("\nDING DING DING DING DING!!!!! \nEnd of round " + round + "!");
    	Thread.sleep(4000);
    	System.out.println("\nEND OF ROUND " + round + " BOXER REPORT\n");
    	System.out.print(player.getDuksters().get(0).getName() + "'s ENERGY: ");
    	System.out.println(player.getDuksters().get(0).getEnergy());
    	System.out.print(player.getDuksters().get(1).getName() + "'s ENERGY: ");
    	System.out.println(player.getDuksters().get(1).getEnergy() + "\n");
    	
    	if (this.round < roundsToFight) {
    		int indexOfLosingBoxer;
    		
    		if (player.getDuksters().get(0).getEnergy() > player.getDuksters().get(1).getEnergy()) {
    			indexOfLosingBoxer = 1;
    		} else {
    			indexOfLosingBoxer = 0;
    		}

    		// print message if boxers' energy level difference greater than 9.5
    		float energyDifference = player.getDuksters().get(0).getEnergy() - player.getDuksters().get(1).getEnergy();
    		if(Math.abs(energyDifference) > 9) {
    			announcer.commentatorTrashTalk(indexOfLosingBoxer);
    		}

    		// end of round, so add energy to one of the boxers
    		int boxer = randomizer.randomNum(2);
    		player.getDuksters().get(boxer).setEnergy(-5);
    		Thread.sleep(2250);
    		System.out.println(player.getDuksters().get(boxer).getName() + " gets smelling salts in the corner and gains some energy! \n");

    		timer.schedule(new BeginRound(), 10000);  // TODO: add countdown to next round beginning
    	} else {
    		timer.cancel();
    	}
		return null;
    }
    
    public class BeginRound extends TimerTask {
        public void run() {
	        try {
	        	System.out.println("DINGGGGG.... ROUND " + (++round) + "\n");
				throwPunches();
				endRound();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }    
    }

}