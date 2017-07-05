package match;

import java.util.Timer;
import java.util.TimerTask;

import referee.Round;


public class Punches {
	
	Round round = new Round();
	
	Timer timer;
	int body = -1;
	int jab = -2;
	int hook = -3;
	int low_blow = -4;
	int uppercut = -5;
	int bestPunch = -7;  // TODO: determine if a fighter threw his best punch
	
	public void throwPunches() throws InterruptedException {
		timer = new Timer();
		timer.schedule(new EndOfRound(), 5000);
		for(int i = 0; i < 50000; i++) {
			Thread.sleep(1000);
			System.out.println(i + " punch, punch, jab, jab");
		}
	}
	
	class EndOfRound extends TimerTask {
        public void run() {
        timer.cancel();
        round.endOfRound();
        }    
    }
	
}
