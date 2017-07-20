package punches;

public class Punch {

	private String punchType;
	private float punchPower;
	
	
	public Punch(String typeOfPunch, float powerOfPunch) {
		this.punchType = typeOfPunch;
		this.punchPower = powerOfPunch;
	}

	public String getPunchType() {
		return punchType;
	}

	public float getPunchPower() {
		return punchPower;
	}
	
}