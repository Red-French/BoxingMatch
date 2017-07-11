package referee;

import main.Player_setup;
import match.Punches;
import java.util.Timer;
import java.util.TimerTask;

import com.redfrench.match.Randomizer;

public class Round extends Punches {

	Player_setup player = new Player_setup();
	Randomizer randomizer = new Randomizer();

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

	  if (this.round < 6) {
	    int indexOfLosingBoxer;
	    
	    if (player.getDuksters().get(0).getEnergy() > player.getDuksters().get(1).getEnergy()) {
	      indexOfLosingBoxer = 1;
	    } else {
	      indexOfLosingBoxer = 0;
	    }

	    int announcerJabber = randomizer.randomNum(6);

	    switch(announcerJabber) {
	      case 0:
	        System.out.println(player.getDuksters().get(indexOfLosingBoxer).getName() + " stumbles to the corner!");      
	        break;
	      case 1:
	        System.out.println("Does " + player.getDuksters().get(indexOfLosingBoxer).getName() + " even know where he is right now?");
	        break;
	      case 2:
	        System.out.println(player.getDuksters().get(indexOfLosingBoxer).getName() + " is gonna need the oxygen after that round.");
	        break;
	      case 3:
	        System.out.println(player.getDuksters().get(indexOfLosingBoxer).getName() + " is a real embarrassment to men everywhere.");
	        break;
	      case 4:
	        System.out.println(player.getDuksters().get(indexOfLosingBoxer).getName() + " should've wore a skirt tonight.  P-a-t-h-e-t-i-c");
	        break;
	      case 5:
	        System.out.println("Did " + player.getDuksters().get(indexOfLosingBoxer).getName() + " think he was gonna fight a girl tonight?  I mean, did he train?");
	        break;
	    };

	    int boxer = randomizer.randomNum(2);
	    player.getDuksters().get(boxer).setEnergy(-10);
	    System.out.println(player.getDuksters().get(boxer).getName() + " gets smelling salts in the corner and gains some energy! \n");
	    timer.schedule(new BeginRound(), 10000);  // TODO: add countdown to next round beginning
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