package match;


import referee.Decision;
import referee.Referee;
import match.KnockoutStatus;

public class EndFight {
	
	private Decision decision = new Decision();
    private Referee referee = new Referee();
    private KnockoutStatus knockoutStatus = new KnockoutStatus();
    
	
	public void endFight() throws InstantiationException, IllegalAccessException, InterruptedException {
    	if(knockoutStatus.isKnockout() == true) {
    		referee.knockout();
    	} else {
    		decision.theDecision();
    	}
    }
	
}