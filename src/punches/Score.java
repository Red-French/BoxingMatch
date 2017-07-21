package punches;

import main.Player_setup;

// TODO: use a 'volatile' variable (if I decide to use multiple threads)
	
	// down with count
	// knockout
	// break
	// warns of low punch (triggered from Punches class)
	// minus point for least aggressive


//10-point scale. 
// Most rounds will end 10-9, with the more dominant boxer receiving 10 points, the other receiving 9.
//If a boxer is knocked down, he loses a point. If a boxer is knocked down twice, he loses two points. 
//When the referee sees fit, he can take away a point or two for an intentional foul; LOW-BLOW

//Unanimous Decision – All three judges had the same fighter scoring more points.
//Split Decision – Two of the three judges had the same fighter scoring more points (the winner), while the other judge had the other boxer scoring more points (the loser).
//Majority Decision – Two of the three judges had the same fighter scoring more points (the winner), while the other judge ruled the contest a draw.
//Draw – A draw can occur when either two of the judges rule the contest a draw, or it can happen when one judge scores the bout for one fighter, another judge scores it for the other fighter, and the third rules it a draw.

public class Score {
	
	private Player_setup player = new Player_setup();
	private static float thisRoundsScore;
	
	private enum Scores {  // punchTypes with scoring amounts (for punchTypes knockout power, see PunchTypes class)
		BODY_BLOW(-0.125f),
		JAB(-0.20f),
		HOOK(-0.20f),
		COMBINATION(-0.5f),
		LOW_BLOW(-0.20f),
		UPPERCUT(-0.20f),
		BEST_PUNCH(-0.20f);

		private float punchScore;

		Scores(float thePunch){
			this.punchScore = thePunch;
		}

		public float getPunchScore() {
			return punchScore;
		}
	}
	

	public void scoreRound(String thisPunch, int boxerPunched) {
		switch(thisPunch) {
	     case "body blow":
	    	 thisRoundsScore = Scores.BODY_BLOW.getPunchScore();
	         player.getDuksters().get(boxerPunched).setScore(thisRoundsScore);
	         break;
	     case "jab":
	    	 thisRoundsScore = Scores.JAB.getPunchScore();
	         player.getDuksters().get(boxerPunched).setScore(thisRoundsScore);		         
	         break;
	     case "hook":
	    	 thisRoundsScore = Scores.HOOK.getPunchScore();
	         player.getDuksters().get(boxerPunched).setScore(thisRoundsScore);
	         break;
	     case "combination":
	    	 thisRoundsScore = Scores.COMBINATION.getPunchScore();
	         player.getDuksters().get(boxerPunched).setScore(thisRoundsScore);
	         break;
	     case "low blow":
	    	 thisRoundsScore = Scores.LOW_BLOW.getPunchScore();
	         player.getDuksters().get(boxerPunched).setScore(thisRoundsScore);
	         break;
	     case "uppercut":
	    	 thisRoundsScore = Scores.UPPERCUT.getPunchScore();
	         player.getDuksters().get(boxerPunched).setScore(thisRoundsScore);
	         break;
	     case "best punch":
	    	 thisRoundsScore = Scores.BEST_PUNCH.getPunchScore();
	         player.getDuksters().get(boxerPunched).setScore(thisRoundsScore);
	         break;
		};
	}
	
	public void resetRoundsScore() {  // reset score for each round
		player.getDuksters().get(0).resetScore();
		player.getDuksters().get(1).resetScore();
	}
	
	public void roundWon() {		
		if (player.getDuksters().get(0).getScore() > player.getDuksters().get(1).getScore()) {
			player.getDuksters().get(0).setNumberOfRoundsWon(1);
		} else {
			player.getDuksters().get(1).setNumberOfRoundsWon(1);
		}
	}

}