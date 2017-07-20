package main;

import match.Round;
import referee.Announcer;

public class Main {

  public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException {
	  
	Player_setup setup = new Player_setup();
    Announcer announcer = new Announcer();
    Round round = new Round();
    
    
    setup.questions();
    announcer.fightIntro();
    round.beginFight();

  //  String[] fighters = {name, punch};

  //  Stream.of(competitors.getBoxers())
  //    .filter(e -> e.startsWith("D"))
  //    .forEach(System.out::println);
  }

}

// TODO: separate thread for crowd