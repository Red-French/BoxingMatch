package fighter;

import java.util.ArrayList;

import main.Player_setup;
import match.Randomizer;
import referee.Commentator;

public class ActionsService {
	
	private static Player_setup player = new Player_setup();
	private static Randomizer randomizer = new Randomizer();
	private static ArrayList<String> banter = new ArrayList<String>();
	private static Commentator commentator = new Commentator();
	
	private int boxerPunched;
	private int randomAction;
	private ArrayList<String> attributes;
	private int randomIndexOfAttribute;
	private int BoxersAttributeArrayLength;
	
	static {	
		banter.add("was that a love tap?!");
		banter.add("quit. That tickles.");
		banter.add("are those pillows hitting me?");
		banter.add("your mama wears combat boots!");
	}

	
	public void performAction(int boxerPunched) {
		this.boxerPunched = boxerPunched;
		randomAction = randomizer.randomNum(3);
		switch(randomAction) {
	    case 1:
	        attributes = hurt();
	        commentator.shapeOfBoxer(attributes, randomIndexOfAttribute, boxerPunched);
	    	break;
	    case 2:
//	        dancing();
	    	attributes = hurt();
	        commentator.shapeOfBoxer(attributes, randomIndexOfAttribute, boxerPunched);
	        break;
	    case 3:
//	    	ropeToDope();
	    	attributes = hurt();
	        commentator.shapeOfBoxer(attributes, randomIndexOfAttribute, boxerPunched);
	        break;
		};	 
	}

	public ArrayList<String> hurt() {
		
		ArrayList<String> shapeOfBoxer = new ArrayList<String>();
		
		int hurtHow = randomizer.randomNum(5);

		// add adjective to shapeOfBoxer array
		switch(hurtHow) {
	      case 0:
	    	shapeOfBoxer.add("has a swollen");
	        break;
	      case 1:
	    	  shapeOfBoxer.add("has a cut");
	        break;
	      case 2:
	    	  shapeOfBoxer.add("has a bleeding");
	         break;
	      case 3:
	    	  shapeOfBoxer.add("has a mangled");
		     break;
	      case 4:
	    	  shapeOfBoxer.add("has a terrible-looking");
		     break;
		};
		
		// add noun to shapeOfBoxer array
		BoxersAttributeArrayLength = player.getDuksters().get(boxerPunched).fighterAttributes.size();
		if(BoxersAttributeArrayLength > 0) {
			randomIndexOfAttribute = randomizer.randomNum(BoxersAttributeArrayLength);
			shapeOfBoxer.add(player.getDuksters().get(this.boxerPunched).getFighterAttributes(randomIndexOfAttribute));
		} else {
			randomIndexOfAttribute = -1;
		}
		
		return shapeOfBoxer;
	}
	
	public void dancing() {
		// TODO: dancing code
		// bobbing and weaving
		// shuffling
	}
	
	public void ropeToDope() {
		// TODO: ropeToDope code
	}
	
	public void trashTalk(int boxer) throws InterruptedException {

		int banterLine = randomizer.randomNum(4);
		
		String boxerWhoPunched = player.getDuksters().get(boxer).getName();
		System.out.println("\n Trash talk: " + boxerWhoPunched + ", " + banter.get(banterLine) + "\n");
		Thread.sleep(1750);
	}

}