package referee;

import main.Player_setup;
import match.KnockoutStatus;

public class Referee {
	
	Player_setup player = new Player_setup();
	Announcer announcer = new Announcer();
	KnockoutStatus knockoutStatus = new KnockoutStatus();
	Commentator commentator = new Commentator();
	

	public void knockout() throws InstantiationException, IllegalAccessException, InterruptedException {
		float boxer1Energy = player.getDuksters().get(0).getEnergy();
		float boxer2Energy = player.getDuksters().get(1).getEnergy();
		
		String boxer1Name = player.getDuksters().get(0).getName();
		String boxer2Name = player.getDuksters().get(1).getName();
		String knockedOutBoxersName;
			
		if(boxer1Energy > boxer2Energy) {
			knockoutStatus.setWinningBoxer(player.getDuksters().get(0).getName());
			knockedOutBoxersName = boxer2Name;
		} else {
			knockoutStatus.setWinningBoxer(player.getDuksters().get(1).getName());
			knockedOutBoxersName = boxer1Name;
		}
			
		Thread.sleep(1000);
		commentator.knockDown(knockedOutBoxersName);

		Thread.sleep(750);
		System.out.println("\nREFEREE: ");
		for(int i=10; i>0; i--) {
			Thread.sleep(1000);
			System.out.print(i + " ");
		}
		
		announcer.knockout();
	}
	
	public void lowBlowWarning(String activeBoxersName) {
		System.out.println("REFEREE:  Get those punches up " + activeBoxersName + "!\n");
	}
	
	public void comeOutFighting() {
		System.out.println("\nWhen the bell rings, come out fighting! \n");
	}
	
}