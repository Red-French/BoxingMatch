package fighter;

import java.util.ArrayList;

public class Fighter {

	private String name;
	private int weight;
	private String bestPunch;
	private float energy;
	private int timesHit;
	private float score;  // score of each round (reset to 10 after each round)
	private int numberOfRoundsWon;  // total # of rounds won
	ArrayList<String> fighterAttributes = new ArrayList<String>();
	
	
	public Fighter(String name, int weight, String bestPunch) {
		this(100, 0, 10, 0, name, weight, bestPunch);  // send default energy, #times hit, score, and numberOfRoundsWon with parameters
	}
	
	public Fighter(float energy, int timesHit, float score, int roundsWon, String name, int weight, String bestPunch) {
		super();
		ArrayList<String> attributes = new ArrayList<String>();
		this.name = name;
		this.weight = weight;
		this.bestPunch = bestPunch;
		this.energy = energy;
		this.timesHit = timesHit;
		this.score = score;
		this.numberOfRoundsWon = roundsWon;
		attributes.add("right eye");
		attributes.add("left eye");
		attributes.add("right ear");
		attributes.add("left ear");
		attributes.add("nose");
		attributes.add("lip");
		attributes.add("tooth");
		this.fighterAttributes = attributes;
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
	public int getTimesHit() {
		return timesHit;
	}
	public float getScore() {
		return score;
	}
	public int getNumberOfRoundsWon() {
		return numberOfRoundsWon;
	}
	public String getFighterAttributes(int index) {
		return fighterAttributes.get(index);
	}
	
	// TEMP
	public ArrayList<String> getAllFighterAttributes() {
		return fighterAttributes;
	}
	
	
	// SETTERS
	public float setEnergy(float punchPower) {
		energy = energy - punchPower;
		return energy;
	}
	public void setTimesHit() {
		this.timesHit += 1;
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
	public void setFighterAttributes(int attributeToRemove) {
		this.fighterAttributes.remove(attributeToRemove);
	}
}
