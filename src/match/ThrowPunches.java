package match;

import main.Player_setup;
import main.Values;
import punches.PunchTypes;
import punches.Score;
import referee.Commentator;
import referee.Referee;
import match.KnockoutStatus;


public class ThrowPunches {
	
	private static Player_setup player = new Player_setup();
	private Randomizer randomizer = new Randomizer();
	private PunchTypes punchTypes = new PunchTypes();
	private Commentator commentator = new Commentator();
	private Referee referee = new Referee();
	private TrashTalk trashTalk = new TrashTalk();
	private Score score = new Score();
	private KnockoutStatus knockoutStatus = new KnockoutStatus();
	
	
	public void throwPunches() throws InterruptedException {

		int boxerPunching;
		int boxerPunched;
		int punch;
		int strengthOfPunch;
		int boxerBanter;
		boolean boxerTrashTalk;
		String activeBoxersName;
		String boxersBestPunch;
		String thisPunch;
		float punchPower;
		
		long time = System.currentTimeMillis();
		long end = time + Values.lengthOfRounds;
		
		
		while(System.currentTimeMillis() < end) {
			
			boxerPunching = randomizer.randomNum(2);
			punch = randomizer.randomNum(6);
			strengthOfPunch = randomizer.randomNum(4);
			boxerBanter = randomizer.randomNum(80);
			boxerTrashTalk = (boxerBanter % 20 == 0) ? true : false;
	
			activeBoxersName = player.getDuksters().get(boxerPunching).getName();
			boxersBestPunch = (String) player.getDuksters().get(boxerPunching).getBestPunch();
			thisPunch = punchTypes.getThepunch().get(punch).getPunchType();
			punchPower = punchTypes.getThepunch().get(punch).getPunchPower();

			
			if (boxerPunching == 0) {
				boxerPunched = 1;
			} else {
				boxerPunched = 0;
			}
			
			
			// set vars in Commentator class
			commentator.setBoxerPunching(boxerPunching);
			commentator.setBoxerPunched(boxerPunched);
			
			score.scoreRound(thisPunch, boxerPunched);
			
			
			// if boxer landed punch, remove energy from boxer who got punched
			if (strengthOfPunch != 3) {
				if (!thisPunch.equals(boxersBestPunch)) {
					player.getDuksters().get(boxerPunched).setEnergy(punchPower);
				} else {  // boxer threw his best punch
					int powerOfBestPunch = (int) punchTypes.getThepunch().get(6).getPunchPower();
					player.getDuksters().get(boxerPunched).setEnergy(powerOfBestPunch);
				}
			} else {  // remove energy from boxer who threw a missed punch
				float powerOfMissedPunch = (float) (punchPower/2);
				player.getDuksters().get(boxerPunching).setEnergy(powerOfMissedPunch);
			}
			
			// vary time between punches
			int timeBetweenPunches = randomizer.randomNumGen();
			Thread.sleep(timeBetweenPunches);
			
			commentator.duringRound(activeBoxersName, boxersBestPunch, thisPunch, strengthOfPunch);

			if(thisPunch.equals("low blow")) {
				referee.lowBlowWarning(activeBoxersName);
			}
			
			// if a boxer's energy is below knockoutLevel, end fight
			if(( player.getDuksters().get(0).getEnergy() < Values.knockoutLevel) || (player.getDuksters().get(1).getEnergy() < Values.knockoutLevel)) {
				knockoutStatus.setKnockout(true);
				break;
			}
			
			if (boxerTrashTalk) {
				trashTalk.banter(boxerPunching);
			}
		}
	}
}