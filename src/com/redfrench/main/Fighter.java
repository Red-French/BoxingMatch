package com.redfrench.main;

public class Fighter {

	private String name; 
	private int weight;
	private String bestPunch;
	private float energy;
	
	public Fighter(String name, int weight, String bestPunch) {
		this(100, name, weight, bestPunch);  // send default energy with parameters
	}
	
	public Fighter(float energy2, String name, int weight, String bestPunch) {
		super();
		this.name = name;
		this.weight = weight;
		this.bestPunch = bestPunch;
		this.energy = energy2;
	}
	
	
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

	public float setEnergy(float punchPower) {
		energy = energy - punchPower;
		return energy;
	}

}
