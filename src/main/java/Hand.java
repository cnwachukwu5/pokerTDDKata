
public class Hand {
	
	Card[] cards;
	private int combination;
	private int highCard;
	
	public Hand(Card[] cards){
		this.cards = cards;
		sort();
		
	}

	public void printHand(){
		for(int i = 0; i < cards.length; i++){
			System.out.print(cards[i]);
			System.out.print(" ");
		}
		System.out.print("  ");
	}
	private void sort() {
		for(int i = 0; i < cards.length; i++){
			int indexOfMin = i, min = getFace(i);
			for(int x = i + 1; x < cards.length; x++){
				if(getFace(x) < min){
					min = getFace(x);
					indexOfMin = x;
				}
			}
			Card temp = getCard(i);
			cards[i] = getCard(indexOfMin);
			cards[indexOfMin] = temp;
		}
	}
	
	public int getFace(int i){
		return cards[i].getFace();
	}
	
	public char getSuit(int i){
		return cards[i].getSuit();
	}
	
	public int getCombination(){
		return combination;
	}
	
	public int getHighCard(){
		return highCard;
	}
	
	public Card getCard(int i){
		return cards[i];
	}
	
	public void setCombination(int combination){
		this.combination = combination;
	}
	
	public void setHighCard(int i){
		highCard = i;
	}

}//End of class
