package main;

import java.util.ArrayList;
import java.util.Scanner;

import fighter.Fighter;


public class Player_setup {

	private static ArrayList<Fighter> duksters = new ArrayList<Fighter>();
	private String name;
	private boolean allLetters;
	private int punchVal;
	private int weight;
	private String punch;
	

	public void questions() {
		
	    // question the player
	    for(int i = 0; i < 2; i++) {
	      punchVal = 0;
	      allLetters = false;
	      
	      @SuppressWarnings("resource")
	      Scanner scanner = new Scanner(System.in);
	      
	      while(!allLetters) {
	    	  System.out.print("\nEnter your name: ");
	    	  name = scanner.nextLine();
	    	  for (char c : name.toCharArray()) {
	    		  if(!Character.isLetter(c)) {
			    	System.out.println("Please enter letters only.");
			    	continue;
	    		  } else {
	    			  allLetters = true;
	    		  }
	    	  }
	      }
	      
	      while(punchVal < 1 || punchVal > 6) {
	    	  System.out.println("Enter number of your best punch (1-6): \n"
	      		+ "1 - body blow \n"
	      		+ "2 - jab \n"
	      		+ "3 - hook\n"
	      		+ "4 - combination \n"
	      		+ "5 - low blow \n"
	      		+ "6 - uppercut");
	    	  punchVal = scanner.nextInt();
	      }
	      
	      System.out.print("Enter your weight: ");
	      weight = scanner.nextInt();
	      
	      switch(punchVal) {
	      	case 1:
	          punch = "body blow";
	          break;
	      	case 2:
	          punch = "jab";
	          break;
	      	case 3:
	          punch = "hook";
	          break;
	      	case 4:
	          punch = "combination";
	          break;
	      	case 5:
	          punch = "low blow";
	          break;
	      	case 6:
	          punch = "uppercut";
	          break;
	      };
	  
	 
	      // create new fighter
	      Fighter competitor = new Fighter(name, weight, punch);
	      setDuksters(competitor);

	    }
	    
	    @SuppressWarnings("resource")
	    Scanner scanner = new Scanner(System.in);
	    while(Values.numRoundsToFight < 1 || Values.numRoundsToFight > 10) {
	    	System.out.print("\nHow many rounds? (1-10): ");
	    	Values.numRoundsToFight = scanner.nextInt();
	    }
	    Values.calcKnockoutLevel();
	    System.out.println("The knockout level is " + Values.knockoutLevel);
	}
	
	
	public ArrayList<Fighter> getDuksters() {
		return duksters;
	}
	
	public String getBoxerName(int boxer) {
		return duksters.get(boxer).getName();
	}

	
	private ArrayList<Fighter> setDuksters(Fighter competitor) {
		duksters.add(competitor);
		return null;
	}

}