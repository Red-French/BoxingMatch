package match;

import java.util.ArrayList;
import java.util.List;

import com.redfrench.match.Punch;

import main.Player_setup;

public class ThrowPunches {
	
	Randomizer randomizer = new Randomizer();
	private static Player_setup player = new Player_setup();
	private static List<Punch> thepunch;

	static {  // TODO: make these constants in their own class
	  System.out.println("in static initializer");
	  List<Punch> boxerPunch = new ArrayList<>();
	  boxerPunch.add(new Punch("body blow", 1));
	  boxerPunch.add(new Punch("jab", 2));
	  boxerPunch.add(new Punch("hook", 3));
	  boxerPunch.add(new Punch("combination", 3.5f));
	  boxerPunch.add(new Punch("low blow", 4));
	  boxerPunch.add(new Punch("uppercut", 5));
	  boxerPunch.add(new Punch("best punch", 8));
	  thepunch = boxerPunch;
	}

	public void throwPunches() throws InterruptedException {
	  for(int i = 0; i < 5; i++) {
	    int boxer = randomizer.randomNum(2);
	    int punch = randomizer.randomNum(6);
	    int strengthOfPunch = randomizer.randomNum(4);

	    String activeBoxer = player.getDuksters().get(boxer).getName();
	    String boxersBestPunch = (String) player.getDuksters().get(boxer).getBestPunch();
	    String thisPunch = thepunch.get(punch).getPunchType();
	    float punchPower = thepunch.get(punch).getPunchPower();
	    
	    if (strengthOfPunch != 3) { // remove energy from boxer who got punched
	      if (boxer == 0) {
	        if (!thisPunch.equals(boxersBestPunch)) {
	            player.getDuksters().get(1).setEnergy(punchPower);

	        } else {  // boxer threw his best punch
	          int powerOfBestPunch = (int) thepunch.get(6).getPunchPower();
	          player.getDuksters().get(1).setEnergy(powerOfBestPunch);
	        }
	      } else { // remove energy from boxer who got punched
	        if (!thisPunch.equals(boxersBestPunch)) {
	          player.getDuksters().get(0).setEnergy(punchPower);
	        } else {  // boxer threw his best punch
	          int powerOfBestPunch = (int) thepunch.get(6).getPunchPower();
	          player.getDuksters().get(0).setEnergy(powerOfBestPunch);
	        }
	      }
	    } else {  // remove energy from boxer who threw a missed punch
	      if (boxer == 0) {
	        float powerOfMissedPunch = (float) (punchPower/2);
	        player.getDuksters().get(0).setEnergy(powerOfMissedPunch);
	      } else {
	        float powerOfMissedPunch = (float) (punchPower/2);
	        player.getDuksters().get(1).setEnergy(powerOfMissedPunch);
	      }
	    }

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
	    Thread.sleep(1000);  // TODO: alter this time between punches; add announcer banter when time is long
	  }
   }
}

