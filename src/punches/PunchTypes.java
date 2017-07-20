// a singleton; used to get energy value which is subtracted from punched boxer

package match;

import java.util.ArrayList;
import java.util.List;

public class PunchTypes {
	
	private static List<Punch> thepunch;

	static {
		List<Punch> boxerPunch = new ArrayList<>();
		boxerPunch.add(new Punch("body blow", 1));
		boxerPunch.add(new Punch("jab", 2));
		boxerPunch.add(new Punch("hook", 3));
		boxerPunch.add(new Punch("combination", 3.5f));
		boxerPunch.add(new Punch("low blow", 4));
		boxerPunch.add(new Punch("uppercut", 5));
		boxerPunch.add(new Punch("best punch", 8));  // boxer's best punch provided by user when creating fighter
		thepunch = boxerPunch;
	}

	public List<Punch> getThepunch() {
		return thepunch;
	}
	
}