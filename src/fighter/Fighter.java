package fighter;


public class Fighter {

	private String name; 
	private int weight;
	private String bestPunch;
	private float energy;
	private float score;  // score of each round (reset to 10 after each round)
	private int numberOfRoundsWon;  // total # of rounds won
	
	public Fighter(String name, int weight, String bestPunch) {
		this(100, 10, 0, name, weight, bestPunch);  // send default energy, score, and numberOfRoundsWon with parameters
	}
	
	public Fighter(float energy, float score, int roundsWon, String name, int weight, String bestPunch) {
		super();
		this.name = name;
		this.weight = weight;
		this.bestPunch = bestPunch;
		this.energy = energy;
		this.score = score;
		this.numberOfRoundsWon = roundsWon;
	}
	
	
	// GETTERS
	public String getName() {
		return name;
	}
	public int getWeight() {
		return weight;
	}
	public String getBestPunch() {
		return bestPunch;
	}
	public float getEnergy() {
		return energy;
	}
	public float getScore() {
		return score;
	}
	public int getNumberOfRoundsWon() {
		return numberOfRoundsWon;
	}
	
	
	// SETTERS
	public float setEnergy(float punchPower) {
		energy = energy - punchPower;
		return energy;
	}
	public float setScore(float roundsScore) {
		score += roundsScore;
		return score;
	}
	public float resetScore() {
		return score = 10;
	}
	public int setNumberOfRoundsWon(int roundWon) {
		numberOfRoundsWon += roundWon;
		return numberOfRoundsWon;
	}
	
}