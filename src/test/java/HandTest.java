import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;




public class HandTest {
	
	Hand pokerHand;
	
	@Before
	public void init(){
		/* 
		 * Create an array of 5cards used to instantiate a poker hand
		 */
		int[] faces = {2, 5, 8, 9, 3};
		char[] suit = {'H', 'D', 'C', 'S'};
		Card[] cards = cardArray(faces, suit);
		
		pokerHand = new Hand(cards);
	}
	
	public Card[] cardArray(int[] faces, char[] suit){
		Card[] cards = new Card[5];
		for(int i = 0; i < cards.length; i++){
			if(i == 4){
				cards[i] = new Card(faces[i], suit[i - 1]);
			}else{
				cards[i] = new Card (faces[i], suit[i]);
			}
		}
		return cards;
	}
	
	@Test
	public void givenHand_WhenInstantiatingObject_ThenObjectCreated(){
		assertNotNull(pokerHand);
	}
	
	@Test
	public void sortTest(){
		Card pokerCard = new Card(pokerHand.getFace(1), pokerHand.getSuit(1)); //Sorted in Hand
		Card anotherCard = new Card(5, 'D');//Unsorted from card array
		assertNotEquals(pokerCard, anotherCard);
	}
	
	@Test
	public void getCombination(){
		pokerHand.setCombination(2);
		assertEquals(2, pokerHand.getCombination(), 0);
	}
	
	@After
	public void destroy(){
		pokerHand = null;
	}

}
