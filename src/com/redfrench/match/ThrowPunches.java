package com.redfrench.match;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import com.redfrench.main.Player_setup;	

public class ThrowPunches {
	
	Randomizer randomizer = new Randomizer();
	private static Player_setup player = new Player_setup();
	private static List<Punch> thePunch;
	
	static {  // TODO: make these constants in their own class
		List<Punch> boxerPunch = new ArrayList<>();
	    boxerPunch.add(new Punch("body", -1));
	    boxerPunch.add(new Punch("jab", -2));
	    boxerPunch.add(new Punch("hook", -3));
	    boxerPunch.add(new Punch("combination", -3.5f));
	    boxerPunch.add(new Punch("low blow", -4));
	    boxerPunch.add(new Punch("uppercut", -5));
	    boxerPunch.add(new Punch("best punch", -7));
	    thePunch = boxerPunch;
	}
	
	public void throwPunches() throws InterruptedException {
//		this way uses a HashMap (just to learn; not a good use case)
//	    Map<Integer, ArrayList<Punch>> punchmap = new HashMap<Integer, ArrayList<Punch>>();
//	    ArrayList<Punch> boxerPunch2 = new ArrayList<Punch>();
//	    boxerPunch2.add(new Punch("body", -1));
//	    boxerPunch2.add(new Punch("jab", -2));
//	    List<Punch> thepunch2 = boxerPunch;
//	    punchmap.put(0, (ArrayList<Punch>) thepunch2);
//	    System.out.println("hash punch type = " + punchmap.get(0).get(0).getPunchType());
//	    System.out.println("hash punch power = " + punchmap.get(0).get(0).getPunchPower());
		
		for(int i = 0; i < 5; i++) {
			int boxer = randomizer.randomNum(2);
			int punch = randomizer.randomNum(7);
			int drama = randomizer.randomNum(4);
			
			String bestPunch = (punch % 6 == 0) ? (String) player.getDuksters().get(boxer).getBestPunch() : null;
		    System.out.println("bestPunch = " + bestPunch);
			String activeBoxer = player.getDuksters().get(boxer).getName();
			String thisPunch = thePunch.get(punch).getPunchType();
		    float punchPower = thePunch.get(punch).getPunchPower();
			
		    if (bestPunch != null) {
		    	System.out.println(activeBoxer + " throws " + bestPunch + "! HIS BEST PUNCH!!! A power of " + thePunch.get(6).getPunchPower() + "!!!");
		     } else {
		    	 switch( drama ) {
		         	case 0:
		              System.out.println(activeBoxer + " throws a strong " + thisPunch + "! Power of " + punchPower);
		              break;
		            case 1:
		              System.out.println(activeBoxer + " throws a good " + thisPunch + "! Power of " + punchPower);
		              break;
		            case 2:
		              System.out.println(activeBoxer + " throws a weak " + thisPunch + "! Power of " + punchPower);
		              break;
		            case 3:
		              System.out.println(activeBoxer + " MISSES a " + thisPunch + "!");
		    	 };    
		     }
		    Thread.sleep(1000);  // TODO: alter this time between punches; add announcer banter when time is long
		}
	}
	
}