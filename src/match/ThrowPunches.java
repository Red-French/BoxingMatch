package match;

import main.Player_setup;
import referee.Announcer;

public class ThrowPunches {
	
	Randomizer randomizer = new Randomizer();
	PunchTypes punchTypes = new PunchTypes();
	Announcer announcer = new Announcer();
	TrashTalk trashTalk = new TrashTalk();
	private static Player_setup player = new Player_setup();
	
	
	public void throwPunches() throws InterruptedException {

		long time = System.currentTimeMillis();
		long end = time + 10000;  // 10-second rounds
		
		while(System.currentTimeMillis() < end) {
			
			int boxer = randomizer.randomNum(2);
			int punch = randomizer.randomNum(6);
			int strengthOfPunch = randomizer.randomNum(4);
			int boxerBanter = randomizer.randomNum(80);
			boolean boxerTrashTalk = (boxerBanter % 20 == 0) ? true : false;
	
			String activeBoxer = player.getDuksters().get(boxer).getName();
			String boxersBestPunch = (String) player.getDuksters().get(boxer).getBestPunch();
			String thisPunch = punchTypes.getThepunch().get(punch).getPunchType();
			float punchPower = punchTypes.getThepunch().get(punch).getPunchPower();
			
			if (strengthOfPunch != 3) { // remove energy from boxer who got punched
				if (boxer == 0) {
					if (!thisPunch.equals(boxersBestPunch)) {
						player.getDuksters().get(1).setEnergy(punchPower);
					} else {  // boxer threw his best punch
						int powerOfBestPunch = (int) punchTypes.getThepunch().get(6).getPunchPower();
						player.getDuksters().get(1).setEnergy(powerOfBestPunch);
					}
				} 
				else { // remove energy from boxer who got punched
					if (!thisPunch.equals(boxersBestPunch)) {
						player.getDuksters().get(0).setEnergy(punchPower);
					} else {  // boxer threw his best punch
						int powerOfBestPunch = (int) punchTypes.getThepunch().get(6).getPunchPower();
						player.getDuksters().get(0).setEnergy(powerOfBestPunch);
					}
				}
			} else {  // remove energy from boxer who threw a missed punch
				if (boxer == 0) {
					float powerOfMissedPunch = (float) (punchPower/2);
					player.getDuksters().get(0).setEnergy(powerOfMissedPunch);
				} 
				else {
					float powerOfMissedPunch = (float) (punchPower/2);
					player.getDuksters().get(1).setEnergy(powerOfMissedPunch);
				}
			}
			
			// vary time between punches
			int timeBetweenPunches = randomizer.randomNumGen();
			Thread.sleep(timeBetweenPunches);
			
			announcer.commentator(activeBoxer, boxersBestPunch, thisPunch, strengthOfPunch);
			if (boxerTrashTalk) {
				trashTalk.banter(boxer);
			}
		}
	}
}