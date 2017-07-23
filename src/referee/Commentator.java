package referee;

import java.util.ArrayList;

import main.Player_setup;
import main.Values;
import match.Randomizer;


public class Commentator {
	
	private int theBoxerPunching;
	private int theBoxerPunched;

	private static Player_setup player = new Player_setup();
	private Randomizer randomizer = new Randomizer();
	
	
	public void duringRound(String activeBoxersName, String boxersBestPunch, String thisPunch, int strengthOfPunch) {
		
		// energy level of boxers
		float punchedBoxersEnergy = player.getDuksters().get(theBoxerPunched).getEnergy();
		float punchingBoxersEnergy = player.getDuksters().get(theBoxerPunching).getEnergy();
		String energyLevelVisual = "";
		
		
		// calc visual energy level of punched boxer (blank spaces to place in front of energy printout below)
		for (int knockoutVisualLevel = ((int) Values.knockoutLevel); knockoutVisualLevel > 0; knockoutVisualLevel--) {
			energyLevelVisual += "-";
		}
		energyLevelVisual += Integer.toString((int)Values.knockoutLevel);
		if(strengthOfPunch != 3) { // if boxer landed punch, adjust opponent's energy visual
			for(int energyAmount = (int) ((int)punchedBoxersEnergy - Values.knockoutLevel); energyAmount > 0; energyAmount--) {
				energyLevelVisual += Values.energyLevelRepresentation;	
			}
		} else { // if boxer missed punch, adjust his own energy visual
			for(int energyAmount = (int) ((int)punchingBoxersEnergy - Values.knockoutLevel); energyAmount > 0; energyAmount--) {
				energyLevelVisual += Values.energyLevelRepresentation;
			}
		}
		
//		// calc visual energy level of punched boxer (blank spaces to place in front of energy printout below)
//		for (int knockoutVisualLevel = (int) Values.knockoutLevel; knockoutVisualLevel > 0; knockoutVisualLevel--) {
//			energyLevelVisual += "|";
//		}
//		for(float energyAmount = (boxerPunchedEnergy - Values.knockoutLevel); energyAmount > 0; energyAmount--) {
//			energyLevelVisual += Values.energyLevelRepresentation;
//		}
		
		
		if(thisPunch.equals(boxersBestPunch) && (strengthOfPunch != 3)) {  // if boxer landed his best punch
			System.out.println(activeBoxersName + " throws " + boxersBestPunch + "! HIS BEST PUNCH!!!");
			System.out.println(energyLevelVisual + player.getDuksters().get(theBoxerPunched).getName() + ":" + punchedBoxersEnergy);
		} else {
			switch( strengthOfPunch ) {
		     case 0:
		    	 System.out.println(activeBoxersName + " throws a strong " + thisPunch + "!");
		    	 System.out.println(energyLevelVisual + player.getDuksters().get(theBoxerPunched).getName() + ":" + punchedBoxersEnergy);
		         break;
		     case 1:
		    	 System.out.println(activeBoxersName + " throws a good " + thisPunch + "!");
		    	 System.out.println(energyLevelVisual + player.getDuksters().get(theBoxerPunched).getName() + ":" + punchedBoxersEnergy);
		         break;
		     case 2:
		    	 System.out.println(activeBoxersName + " throws a weak " + thisPunch + "!");
		    	 System.out.println(energyLevelVisual + player.getDuksters().get(theBoxerPunched).getName() + ":" + punchedBoxersEnergy);
		    	 break;
		     case 3:
		    	 System.out.println(activeBoxersName + " MISSES the " + thisPunch + "!");
		    	 System.out.println(energyLevelVisual + player.getDuksters().get(theBoxerPunching).getName() + ":" + punchingBoxersEnergy);
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
		
		// add energy to losing boxer
		player.getDuksters().get(indexOfLosingBoxer).setEnergy(-5);
		Thread.sleep(2250);
		System.out.println("He gets smelling salts and gains some energy! \n");
		
	}
	
	public void shapeOfBoxer(ArrayList<String> boxersDescription, int attributeToRemove, int boxerPunched) {

		if(boxerPunched == 0) {
			theBoxerPunching = 1;
		} else {
			theBoxerPunching = 0;
		}

		// commentary, then remove punchedBoxer's physical attribute from array (since it's now been mentioned by commentator)
		if(attributeToRemove != -1) {
			String buildCommentary = "SPORTSCASTER: " + player.getDuksters().get(boxerPunched).getName() + " " + boxersDescription.get(0) + " " + boxersDescription.get(1) + "!!";
			String commentaryLine = buildCommentary.toUpperCase();
			System.out.println(commentaryLine + "\n");
			
			player.getDuksters().get(boxerPunched).setFighterAttributes(attributeToRemove);
		}
	}
	
	public void postRoundReport(int round) throws InterruptedException {
//    	System.out.println("\nEND OF ROUND " + round + " BOXER REPORT\n");
    	String postRoundReportBanner = "\nEND OF ROUND " + round + " BOXER REPORT\n";
    	for(char c : postRoundReportBanner.toCharArray()) {
    		System.out.print(c);
    		Thread.sleep(50);
    	}
    	Thread.sleep(1500);
    	System.out.println("Round " + round + " score: " + player.getDuksters().get(0).getScore() + " (" + player.getBoxerName(0) + ")");
    	Thread.sleep(2000);
    	System.out.println("Round " + round + " score: " + player.getDuksters().get(1).getScore() + " (" + player.getBoxerName(1) + ")");
	}
	
	public void knockDown(String knockedOutBoxersName) {
		System.out.println("\n" + knockedOutBoxersName.toUpperCase() + " GOES DOWN!!  HE'S DOWN!!");
	}
	
	
	public void setBoxerPunching(int boxerPunching) {
		theBoxerPunching = boxerPunching;
	}

	public void setBoxerPunched(int boxerPunched) {
		theBoxerPunched = boxerPunched;
	}
}