package main;

import java.util.ArrayList;
import java.util.Scanner;

import fighter.Fighter;


public class Player_setup {

	private static ArrayList<Fighter> duksters = new ArrayList<Fighter>();
	private String name;
	private int weight;
	private String punch;

	public void questions() {
		
	    // question the player
	    for(int i = 0; i < 2; i++) {
	      int punchVal = 0;
	      boolean allLetters = false;
	      
	      @SuppressWarnings("resource")
	      Scanner scanner = new Scanner(System.in);
	      
	      // GET BOXER'S NAME
	      System.out.print("\nEnter your name: ");
	      while(!allLetters) {
	    	  name = scanner.nextLine();
	    	  allLetters = name.matches("[a-zA-Z]+");
	    	  if(!allLetters) {
	    		  System.out.println("Letters only.");
	    	  }
	      }
	      
	      // GET BOXER'S BEST PUNCH
	      while(punchVal < 1 || punchVal > 6) {
	    	  System.out.println("Enter number of your best punch (1-6): \n"
	      		+ "1 - body blow \n"
	      		+ "2 - jab \n"
	      		+ "3 - hook\n"
	      		+ "4 - combination \n"
	      		+ "5 - low blow \n"
	      		+ "6 - uppercut");
	    	  
		      while(!scanner.hasNextInt()) {
		    	  System.out.println("Numbers 1-6 only.");
		          scanner.next();  // non-integer; consume it and continue
		      }
	    	  punchVal = scanner.nextInt();
	      }
	    	  
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

	  
	      // GET BOXER'S WEIGHT
	      System.out.print("Enter your weight: ");
	      while(!scanner.hasNextInt()) {
	    	  System.out.println("Numbers only.");
	          scanner.next();  // non-integer; consume it and continue
	      }
	      weight = scanner.nextInt();

	      
	      // create new fighter
	      Fighter competitor = new Fighter(name, weight, punch);
	      setDuksters(competitor);

	    }
	    
	    // GET # OF ROUNDS
	    @SuppressWarnings("resource")
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("\nHow many rounds? (1-10): ");
	    while(!scanner.hasNextInt()) {
	    	  System.out.println("Numbers only.");
	          scanner.next();  // non-integer; consume it and continue
	      }
	    while(Values.numRoundsToFight < 1 || Values.numRoundsToFight > 10) {
	    	Values.numRoundsToFight = scanner.nextInt();
	    }
	    
	    
	    Values.calcKnockoutLevel();
	    System.out.println("\nThe knockout level is >>>>>>> " + Values.knockoutLevel + " <<<<<<<");
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