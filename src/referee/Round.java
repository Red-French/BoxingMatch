package referee;

import main.Player_setup;
import match.Punches;
import java.util.Timer;
import java.util.TimerTask;

public class Round extends Punches {
    
    Player_setup player = new Player_setup();
    
    Timer timer;
    int round = 0;
 
    public void newRound() throws InterruptedException {
    	System.out.println("Come out fighting!");
    	timer = new Timer();
    	timer.schedule(new BeginRound(), 2000);
    }
    
    public void endRound() throws InterruptedException {
    	this.round = round +1;
    	System.out.println("\nDING DING DING DING DING!!!!! \nEnd of round " + round + "!");
    	System.out.println("\nEND OF ROUND " + round + " BOXER REPORT\n");
    	System.out.print(player.getDuksters().get(0).getName() + "'s ENERGY: ");
    	System.out.println(player.getDuksters().get(0).getEnergy());
    	System.out.print(player.getDuksters().get(1).getName() + "'s ENERGY: ");
    	System.out.println(player.getDuksters().get(1).getEnergy() + "\n");
    	if (this.round < 4) {
    		// TODO: add countdown to next round beginning
    		timer.schedule(new BeginRound(), 3000);
    	} else {
    		timer.cancel();
    	}
    }
    
    public class BeginRound extends TimerTask {
        public void run() {
        try {
			throwPunches();
			endRound();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }    
    }

}