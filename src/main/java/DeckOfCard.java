import java.util.Random;

public class DeckOfCard {
	
	private final int NUMBER_OF_CARDS = 52;
	private final Random randomNumbers = new Random();
	private Card[] deck;
	
	public DeckOfCard(){
		int[] faces = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
		char[] suits = { 'H', 'D', 'C', 'S' };
		deck = new Card[NUMBER_OF_CARDS];
		
		for(int count = 0; count < deck.length; count++){
			deck[count] = new Card(faces[count % 13], suits[count / 13]);
		}
	}
	
	public void shuffleCard(){
		for(int first = 0; first < deck.length; first++){
			int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
			Card temp = deck[first];
			deck[first] = deck[second];
			deck[second] = temp;
		}
	}
	
	public Card[][] dealCards(){
		int numberOfCards = 5;
		Card[][] hands = new Card[2][1];
		Card[] hand1 = new Card[numberOfCards];
		Card[] hand2 = new Card[numberOfCards];
		for(int count = 0; count < hand1.length; count++){
			hand1[count] = deck[count];
		}
		for(int count = 0; count < hand2.length; count++){
			
			hand2[count] = deck[count + 5];
		}
		hands[0] = hand1;
		hands[1] = hand2;
		return hands;
	}

	public Card[] getDeck() {
		return deck;
	}
}
