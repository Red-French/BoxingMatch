package match;

public class Punch {
	
	public String getPunchType() {
		return punchType;
	}

	public float getPunchPower() {
		return punchPower;
	}
	
	
	private String punchType;
	private float punchPower;
	
	
	public Punch(String typeOfPunch, float powerOfPunch) {
		this.punchType = typeOfPunch;
		this.punchPower = powerOfPunch;
	}
	
}