package main;

import referee.Round;

public class Main {

  public static void main(String[] args) throws InterruptedException {
	  
	Player_setup setup = new Player_setup();
    Round round = new Round();

    System.out.println("\nLET'S GET READY TO RUMMMMBUUUUULLE!");

    setup.questions();
    round.newRound();


  //  String[] fighters = {name, punch};

  //  Stream.of(competitors.getBoxers())
  //    .filter(e -> e.startsWith("D"))
  //    .forEach(System.out::println);
  }

}
