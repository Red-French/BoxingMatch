package referee;

import main.Player_setup;
import main.Values;
import match.Randomizer;


public class Commentator {
	
	private int boxerPunching;
	private int boxerPunched;

	private static Player_setup player = new Player_setup();
	private Randomizer randomizer = new Randomizer();
	
	
	public void duringRound(String activeBoxersName, String boxersBestPunch, String thisPunch, int strengthOfPunch) {
		
		// energy level of boxers
		float boxerPunchedEnergy = player.getDuksters().get(boxerPunched).getEnergy();
		float boxerPunchingEnergy = player.getDuksters().get(boxerPunching).getEnergy();
		String energyLevelVisual = Values.energyLevelRepresentation;
		
		
		// calc visual energy level of punched boxer (blank spaces to place in front of energy printout below)
		for (int knockoutVisualLevel = (int) Values.knockoutLevel; knockoutVisualLevel > 0; knockoutVisualLevel--) {
			energyLevelVisual += "|";
		}
		for(float energyAmount = (boxerPunchedEnergy - Values.knockoutLevel); energyAmount > 0; energyAmount--) {
			energyLevelVisual += Values.energyLevelRepresentation;
		}
		
		
		if(thisPunch.equals(boxersBestPunch) && (strengthOfPunch != 3)) {  // if boxer landed his best punch
			System.out.println(activeBoxersName + " throws " + boxersBestPunch + "! HIS BEST PUNCH!!!");
			System.out.println(energyLevelVisual + player.getDuksters().get(boxerPunched).getName() + "'s ENERGY: " + boxerPunchedEnergy);
		} else {
			switch( strengthOfPunch ) {
		     case 0:
		    	 System.out.println(activeBoxersName + " throws a strong " + thisPunch + "!");
		    	 System.out.println(energyLevelVisual + player.getDuksters().get(boxerPunched).getName() + "'s ENERGY: " + boxerPunchedEnergy);
		         break;
		     case 1:
		    	 System.out.println(activeBoxersName + " throws a good " + thisPunch + "!");
		    	 System.out.println(energyLevelVisual + player.getDuksters().get(boxerPunched).getName() + "'s ENERGY: " + boxerPunchedEnergy);
		         break;
		     case 2:
		    	 System.out.println(activeBoxersName + " throws a weak " + thisPunch + "!");
		    	 System.out.println(energyLevelVisual + player.getDuksters().get(boxerPunched).getName() + "'s ENERGY: " + boxerPunchedEnergy);
		    	 break;
		     case 3:
		    	 System.out.println(activeBoxersName + " MISSES the " + thisPunch + "!");
		    	 System.out.println(energyLevelVisual + player.getDuksters().get(boxerPunching).getName() + "'s ENERGY: " + boxerPunchingEnergy);
			};
		}
		
	}
	
	public void afterRound(int indexOfLosingBoxer) throws InterruptedException {
		int announcerJabber = randomizer.randomNum(6);
		Thread.sleep(4000);
		System.out.println("\nSPORTSCASTER: ");
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
	
	
	public void setBoxerPunching(int boxerPunching) {
		this.boxerPunching = boxerPunching;
	}

	public void setBoxerPunched(int boxerPunched) {
		this.boxerPunched = boxerPunched;
	}
}