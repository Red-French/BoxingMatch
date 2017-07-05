package match;

public class Punches {
	
	int body = -1;
	int jab = -2;
	int hook = -3;
	int low_blow = -4;
	int uppercut = -5;
	int bestPunch = -7;  // TODO: determine if a fighter threw his best punch
	
	public void throwPunches() throws InterruptedException {
		for(int i = 0; i < 5; i++) {
			Thread.sleep(1000);
			System.out.println(i + " punch, punch, jab, jab");
		}
	}
	
}
