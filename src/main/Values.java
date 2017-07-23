// a class of constants

package main;

public final class Values {
// TODO: make variables private and use getters
	public static float numRoundsToFight = 0;
	public static  final int lengthOfRounds = 10000;
	public static float knockoutLevel;
	public static String energyLevelRepresentation = "+";
	public static int numHitsTilBoxerIsHurt;
	
	
	public static void calcKnockoutLevel() {
		knockoutLevel = 100-(80/(10/numRoundsToFight));  // *see notes below for example knockout levels for 'x' rounds
		numHitsTilBoxerIsHurt = (int)numRoundsToFight + 1;
	}
	
}

// DIFFICULTY OF KNOCKOUT CALC:
// sample calc --> 100-(40/(10/numRounds) <-- (to alter knockoutLevel value, change '40' in the sample calc)

// 	~ EASY KNOCKOUTS ~
// 40 provides knockoutLevels of:
// 10 rounds = 60 knockoutLevel
// 8 rounds = 68 knockoutLevel
// 7 rounds = 72 knockoutLevel
// 5 rounds = 80 knockoutLevel
// 3 rounds = 88 knockoutLevel

//	// ~ MED-EASE KNOCKOUTS ~
// 60 provides knockoutLevels of:
// 10 rounds = 40 knockoutLevel
// 8 rounds =  52 knockoutLevel
// 7 rounds = 58 knockoutLevel
// 5 rounds = 70 knockoutLevel
// 4 rounds = 76 knockoutLevel
// 3 rounds = 82 knockoutLevel

// 	~ DIFFICULT KNOCKOUTS ~
// 70 provides knockoutLevels of:
// 10 rounds = 30 knockoutLevel
// 8 rounds = 44 knockoutLevel
// 7 rounds = 51 knockoutLevel
// 5 rounds = 65 knockoutLevel
// 4 rounds = 72 knockoutLevel
// 3 rounds = 79 knockoutLevel

// 	~ MOST-DIFFICULT KNOCKOUTS ~
// 80 provides knockoutLevels of:
// 10 rounds = 20 knockoutLevel
// 8 rounds = 36 knockoutLevel
// 7 rounds = 44 knockoutLevel
// 5 rounds = 60 knockoutLevel
// 4 rounds = 68 knockoutLevel
// 3 rounds = 76 knockoutLevel
