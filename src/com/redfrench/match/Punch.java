package com.redfrench.match;

public class Punch {

    private String punchType;
    private float punchPower;

    
    public String getPunchType() {
           return punchType;
    }

    public float getPunchPower() {
           return punchPower;
    }

    public Punch(String typeOfPunch, float powerOfPunch) {
           this.punchType = typeOfPunch;
           this.punchPower = powerOfPunch;
    }

}