package match;


public class KnockoutStatus {
	
	private static boolean aKnockout;
	private static String winningBoxer;
	
	
	// GETTERS
	public boolean isKnockout() {
		return aKnockout;
	}
	public String getWinningBoxer() {
		return winningBoxer;
	}
	
	
	// SETTERS
	public void setKnockout(boolean knockout) {
		aKnockout = knockout;
	}
	public void setWinningBoxer(String boxerWithWinningPunch) {
		winningBoxer = boxerWithWinningPunch;
	}
	
}