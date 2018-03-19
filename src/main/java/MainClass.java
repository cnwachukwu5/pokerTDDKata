
public class MainClass {

	public static void main(String[] args) {
		DeckOfCard deck = new DeckOfCard();
		
		deck.shuffleCard();
		
		Card[][] hands = new Card[2][1];
		hands = deck.dealCards();
		
		Hand black = new Hand(hands[0]);
		Hand white = new Hand(hands[1]);
		
		System.out.print("Black: ");
		black.printHand();
		
		System.out.print("White: ");
		white.printHand();
		
		PokerHands myPoker = new PokerHands(black, white);
		myPoker.judgeHands();
		String result = myPoker.getWinner();
		System.out.print(" " + result + " wins - ");
		System.out.println(displayResult(result, black, white));
	}
	
	public static String displayResult(String result, Hand black, Hand white){
		Hand resultHand = null;
		String displayVal = "";
		if(result.equals("Black"))
			resultHand = black;
		if(result.equals("White"))
			resultHand = white;
		
		switch(resultHand.getCombination()){
		
			case 8:
				displayVal = "Straight Flush";
				break;
			case 7:
				displayVal = "Four of a kind";
				break;
			case 6:
				displayVal = "Full House";
				break;
			case 5:
				displayVal = "Flush";
				break;
			case 4: 
				displayVal = "Straight";
				break;
			case 3:
				displayVal = "Three of a kind";
				break;
			case 2:
				displayVal = "Two Pairs";
				break;
			case 1:
				displayVal = "Pair";
				break;
			case 0:
				switch(resultHand.getHighCard()){
				case 10:
					displayVal = "High Card: Ten";
					break;
				case 11:
					displayVal = "High Card: Jack";
					break;
				case 12:
					displayVal = "High Card: Queen";
					break;
				case 13:
					displayVal = "High Card: King";
					break;
				case 14:
					displayVal = "High Card: Ace";
					break;
				default:
					break;	
				}//End of switch
				
				break;
		}
		return displayVal;
	}//End of method
}//End of class
