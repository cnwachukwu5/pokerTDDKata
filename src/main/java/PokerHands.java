
public class PokerHands {
	
	public Hand player1, player2;
	private int numberOfCards = 5;
	
	public PokerHands(Hand player1, Hand player2){
		this.player1 = player1; 
		this.player2 = player2;
	}
	
	public void judgeHands(){
		getCombination(player1);
		getCombination(player2);
	}
	
	private void getCombination(Hand player) {
        if(hasStraightFlush(player)){
            player.setCombination(8);
            int temp = player.getFace(4) == 14 && player.getFace(3) == 5 ? 5 : player.getFace(4);
            player.setHighCard(temp);
        }
        else if(hasFourOfAKind(player)){
            player.setCombination(7);
            player.setHighCard(player.getFace(1));
        }
        else if(hasFullHouse(player)){
            player.setCombination(6);
            player.setHighCard(player.getFace(2));
        }
        else if(hasFlush(player)){
            player.setCombination(5);
            player.setHighCard(player.getFace(4));
        }
        else if(hasStraight(player)){
            player.setCombination(4);
            int temp = player.getFace(4) == 14 && player.getFace(3) == 5 ? 5 : player.getFace(4);
            player.setHighCard(temp);
        } else if(hasThreeOfAKind(player)){
            player.setCombination(3);
            player.setHighCard(player.getFace(2));
        } else if(hasTwoPair(player)){
            player.setCombination(2);
            player.setHighCard(player.getFace(3));
        } else if(hasPair(player)){
            player.setCombination(1);
            if(isPair(player.getCard(0), player.getCard(1)) || isPair(player.getCard(2), player.getCard(1)))
                player.setHighCard(player.getFace(1));
            else
                player.setHighCard(player.getFace(3));
        }else
            player.setHighCard(player.getFace(4));
    }
	
	private boolean hasStraightFlush(Hand player) {
        return hasFlush(player) && hasStraight(player);
    }
	
	private boolean hasFourOfAKind(Hand player) {
        for(int i = 0; i < numberOfCards - 3; i++){
            if(isThreeOfAKind(player.getCard(i), player.getCard(i + 1), player.getCard(i + 2))
                    && isPair(player.getCard(i + 2), player.getCard(i + 3))){
                return true;
            }
        }
        return false;
    }
	
	private boolean hasFullHouse(Hand player) {
	       return (isPair(player.getCard(0), player.getCard(1)) &&
	                    isThreeOfAKind(player.getCard(2), player.getCard(3), player.getCard(4)) ||
	                    (isPair(player.getCard(3), player.getCard(4)) &&
	                            isThreeOfAKind(player.getCard(0), player.getCard(1), player.getCard(2))));
	    }
	
	private boolean hasFlush(Hand player) {
        for(int i = 0; i < numberOfCards - 1; i++){
            if(player.getSuit(i) != player.getSuit(i + 1))
                return false;
        }
        return true;
    }
	
	private boolean hasStraight(Hand player) {
        for(int i = numberOfCards - 1; i > 0; i--){
            int one = player.getFace(i);
            int two = player.getFace(i - 1);
            if(one == 14 && two == 5){
                continue;
            }
            if(one - two != 1){
                return false;
            }
        }
        return true;
    }
	
	private boolean hasThreeOfAKind(Hand player) {
        for(int i = 0; i < numberOfCards - 2; i++){
            if(isThreeOfAKind(player.getCard(i), player.getCard(i + 1), player.getCard(i + 2))){
                return true;
            }
        }
        return false;
    }
	
	private boolean isThreeOfAKind(Card card1, Card card2, Card card3) {
        return card1.getFace() == card2.getFace() && card2.getFace() == card3.getFace();
    }
	
	private boolean hasTwoPair(Hand player){
		for(int i = 0; i < numberOfCards - 3; i++){
            if(isPair(player.getCard(i), player.getCard(i + 1))){
                for(int j = i + 2; j < numberOfCards - 1; j++){
                    if(isPair(player.getCard(j), player.getCard(j + 1))){
                        return true;
                    }
                }
            }
        }
        return false;
	}
	
	private boolean hasPair(Hand player){
		for(int i = 0; i < numberOfCards - 1; i++){
			if(isPair(player.getCard(i), player.getCard(i + 1))){
				return true;
			}
		}
		return false;
	}
	
	private boolean isPair(Card card1, Card card2){
		return card1.getFace() == card2.getFace();
	}
	
	public String getWinner() {
        if(player1.getCombination() == player2.getCombination()){
            if(player1.getHighCard() == player2.getHighCard())
                return resolveTie();
            else
                return player1.getHighCard() > player2.getHighCard() ? "Black" : "White";
        }else
            return player1.getCombination() > player2.getCombination() ? "Black" : "White";
    }
	
	private String resolveTie() {
        for(int i = numberOfCards - 1; i >= 0; i--){
            if(player1.getFace(i) == player2.getFace(i))
                continue;
            return player1.getFace(i) > player2.getFace(i) ? "Black" : "White";
        }
        return "Tie";
    }

}//End of class
