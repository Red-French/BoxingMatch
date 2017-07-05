package match;

import main.Player_setup;

public class Punches {
	
	Randomizer randomizer = new Randomizer();
	Player_setup player = new Player_setup();
	
	int body = -1;
	int jab = -2;
	int hook = -3;
	float combination = -3.5f;
	int low_blow = -4;
	int uppercut = -5;
	int bestPunch = -7;  // TODO: determine if a fighter threw his best punch
	
	int punches[] = new int[7];
	
	public void throwPunches() throws InterruptedException {
		
		for(int i = 0; i < 5; i++) {
			int boxer = randomizer.boxer();
			String activeBoxer = player.getDuksters().get(boxer).getName();
			
			System.out.println(activeBoxer + " throws a punch!");
			Thread.sleep(1000);
		}
	}
	
}
