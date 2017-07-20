package match;

import main.Player_setup;
import main.Values;
import punches.Score;
import referee.Commentator;
import match.EndFight;
import match.KnockoutStatus;

import java.util.Timer;
import java.util.TimerTask;


public class Round extends ThrowPunches {
    
    private Player_setup player = new Player_setup();
    private Commentator commentator = new Commentator();
    private Score score = new Score();
    private EndFight endFight = new EndFight();
    private KnockoutStatus knockoutStatus = new KnockoutStatus();
    
    private Timer timer;
    private int round = 1;
    
 
    public void beginFight() throws InterruptedException {
    	Thread.sleep(2000);
    	System.out.println("When the bell rings, come out fighting! \n");
    	timer = new Timer();
    	timer.schedule(new BeginRound(), 2000);
    }
    
    public TimerTask endRound() throws InterruptedException, InstantiationException, IllegalAccessException {
    	
    	System.out.println("\nDING DING DING DING DING!!!!! \nEnd of round " + round + "!");
    	score.roundWon();  // overall count of rounds won
    	
    	Thread.sleep(4000);
    	
    	System.out.println("\nEND OF ROUND " + round + " BOXER REPORT\n");
    	System.out.println(player.getBoxerName(0) + "'s ENERGY:  " + player.getDuksters().get(0).getEnergy() + " - Round " + round + " score: " + player.getDuksters().get(0).getScore());
    	System.out.println(player.getBoxerName(1) + "'s ENERGY:  " + player.getDuksters().get(1).getEnergy() + " - Round " + round + " score: " + player.getDuksters().get(1).getScore());
    	
    	if (this.round < Values.numRoundsToFight) {
    		int indexOfLosingBoxer;
    		
    		if (player.getDuksters().get(0).getEnergy() > player.getDuksters().get(1).getEnergy()) {
    			indexOfLosingBoxer = 1;
    		} else {
    			indexOfLosingBoxer = 0;
    		}
    		
    		// print message if boxers' energy level difference is wide
    		float energyDifference = player.getDuksters().get(0).getEnergy() - player.getDuksters().get(1).getEnergy();
    		if(Math.abs(energyDifference) > 9) {
    			commentator.afterRound(indexOfLosingBoxer);
    			
        		// add energy to losing boxer
        		player.getDuksters().get(indexOfLosingBoxer).setEnergy(-5);
        		Thread.sleep(2250);
        		System.out.println(player.getDuksters().get(indexOfLosingBoxer).getName() + " gets smelling salts in the corner and gains some energy! \n");
    		}
    		
    		score.resetRoundsScore();  // reset round's score for next round
    		
    		// countdown to next round
    		Thread.sleep(1500);
    		System.out.print("\nRound " + (++round) + " begins in");
    		for(int i=10; i>-1; i--) {
    			Thread.sleep(250);
    			System.out.print(".");
    			Thread.sleep(250);
    			System.out.print(".");
    			Thread.sleep(500);
    			System.out.print("" + i);
    		}
    		timer.schedule(new BeginRound(), 500);
    		
    	} else {
    		endFight();
    	}
    	
		return null;
    }
    
    public void endFight() throws InstantiationException, IllegalAccessException, InterruptedException {
    	timer.cancel();
		endFight.endFight();
    }
        
    
    public class BeginRound extends TimerTask {
    	
        public void run() {
	        try {
	        	System.out.println("\nDINGGGGG.... ROUND " + (round) + "\n");
				throwPunches();  // throwPunches will 'break' if a boxer is knocked down
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        
	        // if a knockout, end fight, else end round
	        if(knockoutStatus.isKnockout()) {
				try {
					endFight();
				} catch (InstantiationException | IllegalAccessException | InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				try {
					endRound();
				} catch (InstantiationException | IllegalAccessException | InterruptedException e) {
					e.printStackTrace();
				}	
			}
	        
        }    
    }

}