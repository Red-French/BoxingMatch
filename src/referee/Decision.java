package referee;

import main.Player_setup;

public class Decision {

	Player_setup player = new Player_setup();
	Announcer announcer = new Announcer();
	
	
	public void theDecision() throws InterruptedException {
		int boxer1RoundsWon = player.getDuksters().get(0).getNumberOfRoundsWon();
		int boxer2RoundsWon = player.getDuksters().get(1).getNumberOfRoundsWon();
		
		if(boxer1RoundsWon > boxer2RoundsWon) {
			announcer.theDecision("boxer1");
		} else if(boxer1RoundsWon < boxer2RoundsWon){
			announcer.theDecision("boxer2");
		} else {
			announcer.theDecision("draw");
		}
	}
	
}