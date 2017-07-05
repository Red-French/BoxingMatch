package main;

import java.util.ArrayList;
import java.util.Scanner;


public class Player_setup {

	int i;
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
	    for(i = 0; i < 2; i++) {
	
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
	      
//	      duksters.add(competitor);
	      setDuksters(competitor);
	
	      if(i == 1) {
	    	  announcer();
	      }

	    }
	}
    
    
    public static void announcer() {
//    	String stngHolder = "weighing in at " + competitor.getWeight() + " with his best punch being the " + competitor.getBestPunch() + "... " + competitor.getName() + "!!!";
//        if(i == 0) {
//          System.out.print("\nIn this corner, " + stngHolder);
//        } else {
//          System.out.print("\nIn the opposite corner, " + stngHolder);
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
        
//        System.out.println("weighing in at " + competitor.getWeight() + " with his best punch being the " + competitor.getBestPunch() + "... " + competitor.getName() + "!!!");  

}
