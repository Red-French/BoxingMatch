package com.redfrench.boxingmatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player_setup {

	int i;
	List<Fighter> duksters = new ArrayList<Fighter>();

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
	      
	      duksters.add(competitor);
	      System.out.println(competitor.getName());
	      System.out.println(competitor.getEnergy());
	
	      announcer(competitor, i);
//	      System.out.println(duksters.iterator().hasNext());
	      for(Fighter duksters : duksters)
	    	  System.out.println("FIGHTER: " + duksters.getName());
	
	    }
	}
    
    
    public static void announcer(Fighter competitor, int i) {
    	   
        if(i == 0) {
          System.out.println("\nIn this corner, ");
        } else {
          System.out.println("\nIn the opposite corner, ");
        }
        
        System.out.println("weighing in at " + competitor.getWeight() + " with his best punch being the " + competitor.getBestPunch() + "... " + competitor.getName() + "!!!");

      }
    
}
