package com.redfrench.boxingmatch;

import java.util.Scanner;

 
public class Main {

  public static void main(String[] args) {

    System.out.println("\n LET'S GET READY TO RUMMMMBUUUUULLE!");

    int i;

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

      announcer(competitor, i);

    }

      if(i == 2) {
        System.out.println("\nDING DING DING DING DING!!!!!");
      }

  //  String[] fighters = {name, punch};

  //  Stream.of(competitors.getBoxers())
  //    .filter(e -> e.startsWith("D"))
  //    .forEach(System.out::println);
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
