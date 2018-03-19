
public class Card {
	
	private final Integer face;
	private final char suit;
	
	public Card(int cardFace, char cardSuit){
		this.face = cardFace;
		this.suit = cardSuit;
	}
	
	public int getFace() {
		return face;
	}

	public char getSuit() {
		return suit;
	}

	public String singleCard(int result){
		String value = "";
		
		switch(result){
		case 10:
			value = "T";
			break;
		case 11:
			value = "J";
			break;
		case 12:
			value = "Q";
			break;
		case 13:
			value = "K";
			break;
		case 14:
			value = "A";
			break;
		default:
			break;	
		}//End of switch
		
		return value;
	}


	@Override
	public String toString(){
		int val = getFace();
		String faceVal = "";
		String returnVal = "";
		if(val == 10 || val == 11 || val == 12 || val == 13 || val == 14){
			faceVal = singleCard(val);
			returnVal = faceVal + "" + getSuit();
		}else{
			returnVal = getFace() + "" + getSuit();
		}
		return returnVal;
	}
}
