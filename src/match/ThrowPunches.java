package match;

import fighter.ActionsService;
import main.Player_setup;
import main.Values;
import punches.PunchTypes;
import punches.Score;
import referee.Commentator;
import referee.Referee;
import match.KnockoutStatus;


public class ThrowPunches extends ActionsService {
	
	private static Player_setup player = new Player_setup();
	private Randomizer randomizer = new Randomizer();
	private PunchTypes punchTypes = new PunchTypes();
	private Commentator commentator = new Commentator();
	private Referee referee = new Referee();
	private Score score = new Score();
	private KnockoutStatus knockoutStatus = new KnockoutStatus();
	
	private int theBoxerPunching;
	private int theBoxerPunched;
	private int punch;
	private int strengthOfPunch;
	private int boxerBanter;
	private boolean boxerTrashTalk;
	private String activeBoxersName;
	private String boxersBestPunch;
	private String thisPunch;
	private float punchPower;
	private int numTimesHit;
	
	public void throwPunches() throws InterruptedException {

		long time = System.currentTimeMillis();
		long end = time + Values.lengthOfRounds;
		
		
		while(System.currentTimeMillis() < end) {
			
			theBoxerPunching = randomizer.randomNum(2);
			punch = randomizer.randomNum(6);
			strengthOfPunch = randomizer.randomNum(4);
			boxerBanter = randomizer.randomNum(80);
			boxerTrashTalk = (boxerBanter % 20 == 0) ? true : false;
	
			activeBoxersName = player.getDuksters().get(theBoxerPunching).getName();
			boxersBestPunch = (String) player.getDuksters().get(theBoxerPunching).getBestPunch();
			thisPunch = punchTypes.getThepunch().get(punch).getPunchType();
			punchPower = punchTypes.getThepunch().get(punch).getPunchPower();

			
			if (theBoxerPunching == 0) {
				theBoxerPunched = 1;
			} else {
				theBoxerPunched = 0;
			}
			
			
			// set vars in Commentator class
			commentator.setBoxerPunching(theBoxerPunching);
			commentator.setBoxerPunched(theBoxerPunched);
			
			score.scoreRound(thisPunch, theBoxerPunched);
			
			
			// if boxer landed punch, remove energy from boxer who got punched
			if (strengthOfPunch != 3) {
				player.getDuksters().get(theBoxerPunched).setTimesHit();
				
				if (!thisPunch.equals(boxersBestPunch)) {
					player.getDuksters().get(theBoxerPunched).setEnergy(punchPower);
				} else {  // boxer threw his best punch
					int powerOfBestPunch = (int) punchTypes.getThepunch().get(6).getPunchPower();
					player.getDuksters().get(theBoxerPunched).setEnergy(powerOfBestPunch);
				}
			} else {  // remove energy from boxer who threw a missed punch
				float powerOfMissedPunch = (float) (punchPower/2);
				player.getDuksters().get(theBoxerPunching).setEnergy(powerOfMissedPunch);
			}
			
			// vary time between punches
			int timeBetweenPunches = randomizer.randomTimeBetweenPunches();
			Thread.sleep(timeBetweenPunches);
			
			commentator.duringRound(activeBoxersName, boxersBestPunch, thisPunch, strengthOfPunch);
			
			// if boxerPunched has taken many punches
			numTimesHit = player.getDuksters().get(theBoxerPunched).getTimesHit();
			if(numTimesHit >= Values.numHitsTilBoxerIsHurt) {
				if(randomizer.randomNum(50)%2 == 0) {
					performAction(theBoxerPunched);
				}
			}

			if(thisPunch.equals("low blow")) {
				referee.lowBlowWarning(activeBoxersName);
			}
			
			// if a boxer's energy is below knockoutLevel, end fight
			if(( player.getDuksters().get(0).getEnergy() < Values.knockoutLevel) || (player.getDuksters().get(1).getEnergy() < Values.knockoutLevel)) {
				knockoutStatus.setKnockout(true);
				break;
			}
			
			if (boxerTrashTalk) {
				trashTalk(theBoxerPunching);
			}
		}
	}
}