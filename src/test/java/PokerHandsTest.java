import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;


public class PokerHandsTest {

	PokerHands myPokerHand; 
	@Before
	public void init(){
		String black = "2H 3D 9S 9C KD";
		String white = "2C 3H 4S 8C AH";	
		
		Hand blackHand = new Hand(pokerhand(black));
		Hand whiteHand = new Hand(pokerhand(white));
		
	   myPokerHand = new PokerHands(blackHand, whiteHand);
	}
	
	public Card[] pokerhand(String str){
		String[] card5 = str.split(" ");
		String[] someJorr = new String[2];
		Card[] hand = new Card[5];
		for(int i = 0; i < card5.length; i++){
			someJorr = card5[i].split("(?!^)");
			hand[i] = new Card(cardFace(someJorr[0]), someJorr[1].charAt(0));	
		}
		
		return hand;
	}
	
	public int cardFace(String str){
		int value = 0;
		if(Character.isDigit(str.charAt(0))){
            value = Integer.parseInt(str);
        }else{
            switch(str.charAt(0)){
                case 'T':
                    value= 10;
                case 'J':
                    value = 11;
                    break;
                case 'Q':
                    value = 12;
                    break;
                case 'K':
                    value = 13;
                    break;
                case 'A':
                    value = 14;
                    break;
                default:
                    value = 0;
            }
        }
		return value;
	}
	
	@Test
	public void givenPokerHands_WhenInstantiatingObject_ThenObjectCreated(){
		assertNotNull(myPokerHand);
	}
	
	 @Test
	 public void isPair() throws Exception{
		 String black = "2H 3D 9S 9C KD";
		 String white = "2C 3H 4S 8C AH";	
			
		Hand blackHand = new Hand(pokerhand(black));
		Hand whiteHand = new Hand(pokerhand(white));
		PokerHands myPokerHand1 = new PokerHands(blackHand, whiteHand);
		myPokerHand1.judgeHands();
	    assertEquals(1, myPokerHand1.player1.getCombination());
	    assertEquals(9, myPokerHand1.player1.getHighCard());
	}
	 
	 @Test
    public void isTwoPair() throws Exception {
		 String black = "2H 2D 9S 9C KD";
		 String white = "2C 3H 4S 8C AH";	
			
		Hand blackHand = new Hand(pokerhand(black));
		Hand whiteHand = new Hand(pokerhand(white));
		PokerHands myPokerHand1 = new PokerHands(blackHand, whiteHand);
		myPokerHand1.judgeHands();
        
        assertEquals(2, myPokerHand1.player1.getCombination());
        assertEquals(9, myPokerHand1.player1.getHighCard());

    }
	 
	 @Test
    public void isThreeOfAKind() throws Exception {
		 String black = "2H 9D KS KC KD";
		 String white = "2C 3H 4S 8C AH";	
			
		Hand blackHand = new Hand(pokerhand(black));
		Hand whiteHand = new Hand(pokerhand(white));
		PokerHands myPokerHand1 = new PokerHands(blackHand, whiteHand);
		myPokerHand1.judgeHands();
		
        assertEquals(3, myPokerHand1.player1.getCombination());
        assertEquals(13, myPokerHand1.player1.getHighCard());
    }
	 
	 @Test
    public void isStraight() throws Exception {
		String black = "2H 3D 4S 5C AD";
		String white = "2C 3H 4S 8C AH";	
			
		Hand blackHand = new Hand(pokerhand(black));
		Hand whiteHand = new Hand(pokerhand(white));
		PokerHands myPokerHand1 = new PokerHands(blackHand, whiteHand);
		myPokerHand1.judgeHands();
		
        assertEquals(4, myPokerHand1.player1.getCombination());
        assertEquals(5, myPokerHand1.player1.getHighCard());
    }
	
	 @Test
    public void isFlush() throws Exception{
		 String black = "2S 4S 7S 8S JS";
		 String white = "2C 3H 4S 8C AH";	
				
		Hand blackHand = new Hand(pokerhand(black));
		Hand whiteHand = new Hand(pokerhand(white));
		PokerHands myPokerHand1 = new PokerHands(blackHand, whiteHand);
		myPokerHand1.judgeHands();
		
	    assertEquals(5, myPokerHand1.player1.getCombination());
	    assertEquals(11, myPokerHand1.player1.getHighCard());
    }
	
	 @Test
    public void isFullHouse() throws Exception{
		 String black = "2S 2D 2H 8S 8D";
		 String white = "2C 3H 4S 8C AH";	
				
		Hand blackHand = new Hand(pokerhand(black));
		Hand whiteHand = new Hand(pokerhand(white));
		PokerHands myPokerHand1 = new PokerHands(blackHand, whiteHand);
		myPokerHand1.judgeHands();
		
        assertEquals(6, myPokerHand1.player1.getCombination());
        assertEquals(2, myPokerHand1.player1.getHighCard());
    }
	
	 @Test
    public void isFourOfAKind() throws Exception {
		 String black = "2S 2D 2H 2C 8D";
		 String white = "2C 3H 4S 8C AH";	
				
		Hand blackHand = new Hand(pokerhand(black));
		Hand whiteHand = new Hand(pokerhand(white));
		PokerHands myPokerHand1 = new PokerHands(blackHand, whiteHand);
		myPokerHand1.judgeHands();
		
        assertEquals(7, myPokerHand1.player1.getCombination());
        assertEquals(2, myPokerHand1.player1.getHighCard());
	}
	 
	 @Test
    public void isStraightFlush() throws Exception {
		 String black = "2S 3S 4S 5S 6S";
		 String white = "2C 3H 4S 8C AH";	
				
		Hand blackHand = new Hand(pokerhand(black));
		Hand whiteHand = new Hand(pokerhand(white));
		PokerHands myPokerHand1 = new PokerHands(blackHand, whiteHand);
		myPokerHand1.judgeHands();
		
        assertEquals(8, myPokerHand1.player1.getCombination());
        assertEquals(6, myPokerHand1.player1.getHighCard());
    }
	
	 @Test
    public void getWinner() throws Exception{
		 String black = "2H 3D 5S 9C KD";
		 String white = "2C 3H 4S 8C AH";	
				
		Hand blackHand = new Hand(pokerhand(black));
		Hand whiteHand = new Hand(pokerhand(white));
		PokerHands myPokerHand1 = new PokerHands(blackHand, whiteHand);
		myPokerHand1.judgeHands();
        assertEquals("White", myPokerHand1.getWinner());
    }
	
	 @Test
    public void getTie() throws Exception {
		 String black = "2H 3D 5S 9C KD";
		 String white = "2D 3H 5C 9S KH";	
				
		Hand blackHand = new Hand(pokerhand(black));
		Hand whiteHand = new Hand(pokerhand(white));
		PokerHands myPokerHand1 = new PokerHands(blackHand, whiteHand);
		myPokerHand1.judgeHands();
		
        assertEquals("Tie", myPokerHand1.getWinner());

    } 
}
