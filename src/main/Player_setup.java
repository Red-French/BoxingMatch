package main;

import java.util.ArrayList;
import java.util.Scanner;


public class Player_setup {

	public ArrayList<Fighter> getDuksters() {
		return duksters;
	}

	private ArrayList<Fighter> setDuksters(Fighter competitor) {
		duksters.add(competitor);
		return null;
	}

	private static ArrayList<Fighter> duksters = new ArrayList<Fighter>();

	public void questions() {
		
	    // question the player
	    for(int i = 0; i < 2; i++) {
	
	      @SuppressWarnings("resource")
	      Scanner scanner = new Scanner(System.in);
	
	      System.out.print("\nEnter your name: ");
	      String name = scanner.nextLine();                  
	
	      System.out.println("Enter your best punch: ");
	      String punch = scanner.nextLine();
	         
	      System.out.print("Enter your weight: ");
	      int weight = scanner.nextInt();                          
	
	      // create new fighter
	      Fighter competitor = new Fighter(name, weight, punch);
	      
	      setDuksters(competitor);

	    }
	}
    
    
    public void announcer() {// TODO: create Announcer class for this method
    						 // TODO: write method for end of fight announcement

    	for(Fighter duksters : duksters) {
        	  System.out.print("\nWeighing in at " + duksters.getWeight()  + " with his best punch being the " + duksters.getBestPunch() + "... " + duksters.getName() + "!!!\n\n");
          }
          
          System.out.println("\n~ TONIGHT'S FIGHT TICKET ~\n");
          for(Fighter duksters : duksters) {
	    	  System.out.println("FIGHTER: " + duksters.getName());
	    	  System.out.println("WEIGHT: " + duksters.getWeight());
	    	  System.out.println("BEST PUNCH: " + duksters.getBestPunch() + "\n\n");
	     }
        }

}
