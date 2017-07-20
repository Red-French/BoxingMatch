package referee;

import fighter.Fighter;
import main.Player_setup;
import main.Values;
import match.KnockoutStatus;

public class Announcer {
	
	private Player_setup player = new Player_setup();
	private KnockoutStatus knockoutStatus = new KnockoutStatus();

	
	public void fightIntro() throws InterruptedException {
		
		String callToAttention = "\nLLLLLET'S GET READY TO RUMMMMBUUUUULLE!!!";
		for (char c : callToAttention.toCharArray()) {
			System.out.print(c);
			Thread.sleep(50);
		}
		
		Thread.sleep(2000);
		System.out.println("\nGet ready for " + (int)Values.numRoundsToFight + " rounds of boxing bliss!");

		
		for(Fighter duksters : player.getDuksters()) {
			Thread.sleep(3000);
			String intro = "\n\nWeighing in at " + duksters.getWeight()  + " with his best punch being the " + duksters.getBestPunch() + "... " + duksters.getName() + "!\n";
			
			for (char c : intro.toCharArray()) {
			    System.out.print(c);
			    Thread.sleep(100);
			}
			// TODO: make boxer name blink (below should work in console (not Eclipse)
//			int nameLength = duksters.getName().length();
//			for (nameLength++; nameLength > 0; nameLength--) {
//				System.out.print("\b");
//				System.out.print("                          ");
//				Thread.sleep(1000);
//				System.out.print(duksters.getName() + "!");
//			}
		}
		
		Thread.sleep(1750);
		System.out.println("\n~ TONIGHT'S FIGHT TICKET ~\n");
		for(Fighter duksters : player.getDuksters()) {
			Thread.sleep(1500);
			System.out.println("FIGHTER: " + duksters.getName());
			Thread.sleep(1000);
			System.out.println("WEIGHT: " + duksters.getWeight());
			Thread.sleep(1000);
			System.out.println("BEST PUNCH: " + duksters.getBestPunch() + "\n\n");
		}
	}

	public void theDecision(String wonMostRounds) throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("\nWe're going to a decision");
		
		Thread.sleep(3000);
		System.out.print("\nThe judges score the fight as " + player.getDuksters().get(0).getNumberOfRoundsWon());
		if(player.getDuksters().get(0).getNumberOfRoundsWon() == 1) {
			System.out.print(" round to ");
		} else {
			System.out.print(" rounds to ");
		}
		System.out.println(player.getDuksters().get(1).getNumberOfRoundsWon());
		
		Thread.sleep(2000);
		System.out.print("The WINNER...");
		
		for(int i=0; i<4; i++) {
			Thread.sleep(1000);
			System.out.print(".");
		}

		if(wonMostRounds == "boxer1") {
			System.out.print(" " + player.getBoxerName(0) + "!!!");
		} else if(wonMostRounds == "boxer2") {
			System.out.print(" " + player.getBoxerName(1) + "!!!");
		} else {
			System.out.print(" It's a draw!!!");
		}
	}
	
	public void knockout() throws InterruptedException, InstantiationException, IllegalAccessException {
		Thread.sleep(2000);
		System.out.print("\n\nLadies and gentlemen, the WINNER, by way of knockout"); 
		
		for(int i=0; i<4; i++) {
			Thread.sleep(1000);
			System.out.print(".");
		}
		
		System.out.print(knockoutStatus.getWinningBoxer() + "!!!");
	}
	
}