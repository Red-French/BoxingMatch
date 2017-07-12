package referee;

import main.Player_setup;
import match.Randomizer;

public class Announcer {

	private static Player_setup player = new Player_setup();
	private Randomizer randomizer = new Randomizer();
	
	
	public void commentator(String activeBoxer, String boxersBestPunch, String thisPunch, int strengthOfPunch) {
	
		float player1Energy = player.getDuksters().get(0).getEnergy();
		float player2Energy = player.getDuksters().get(1).getEnergy();
		
		if(thisPunch.equals(boxersBestPunch)) {
			System.out.println(activeBoxer + " throws " + boxersBestPunch + "! HIS BEST PUNCH!!!");
			System.out.println("                                          " + player.getDuksters().get(0).getName() + "'s ENERGY: " + player1Energy);
	    	System.out.println("                                          " + player.getDuksters().get(1).getName() + "'s ENERGY: " + player2Energy);
		} else {
			switch( strengthOfPunch ) {
		     case 0:
		    	 System.out.println(activeBoxer + " throws a strong " + thisPunch + "!");
		    	 System.out.println("                                          " + player.getDuksters().get(0).getName() + "'s ENERGY: " + player1Energy);
		    	 System.out.println("                                          " + player.getDuksters().get(1).getName() + "'s ENERGY: " + player2Energy);
		         break;
		     case 1:
		    	 System.out.println(activeBoxer + " throws a good " + thisPunch + "!");
		    	 System.out.println("                                          " + player.getDuksters().get(0).getName() + "'s ENERGY: " + player1Energy);
			     System.out.println("                                          " + player.getDuksters().get(1).getName() + "'s ENERGY: " + player2Energy);
		         break;
		     case 2:
		    	 System.out.println(activeBoxer + " throws a weak " + thisPunch + "!");
		    	 System.out.println("                                          " + player.getDuksters().get(0).getName() + "'s ENERGY: " + player1Energy);
			     System.out.println("                                          " + player.getDuksters().get(1).getName() + "'s ENERGY: " + player2Energy);
		    	 break;
		     case 3:
		    	 System.out.println(activeBoxer + " MISSES the " + thisPunch + "!");
		    	 System.out.println("                                          " + player.getDuksters().get(0).getName() + "'s ENERGY: " + player1Energy);
			     System.out.println("                                          " + player.getDuksters().get(1).getName() + "'s ENERGY: " + player2Energy);
			};
		}
	}
	
	public void commentatorTrashTalk(int indexOfLosingBoxer) throws InterruptedException {
		int announcerJabber = randomizer.randomNum(6);
		Thread.sleep(4000);
		System.out.print("ANNOUNCER: ");
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
	}
}