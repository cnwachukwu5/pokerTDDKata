import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertArrayEquals;


public class DeckOfCardTest {
	
	DeckOfCard myDec;
	
	@Before
	public void init(){
		myDec = new DeckOfCard();
	}
	
	@Test
	public void givenDeckOfCard_WhenInstantiatingObject_ThenObjectCreated(){
		assertNotNull(myDec);
	}
	
	@Test
	public void checkSizeOfDec(){
		assertEquals(52, myDec.getDeck().length, 0);
	}
	
	@Test
	public void shuffleCardTest(){
		Card topCardBeforeShuffle = myDec.getDeck()[0];//Returns the first card in the deck of cards
		myDec.shuffleCard();//Shuffle the card
		Card topCardafterShuffle = myDec.getDeck()[0];
		assertFalse((topCardBeforeShuffle.getFace() == topCardafterShuffle.getFace()) && (topCardBeforeShuffle.getSuit() == topCardafterShuffle.getSuit()));
	}
	
	@Test
	public void dealCardTest(){
		Card[][] pokerHands = myDec.dealCards();
		assertArrayEquals(pokerHands, myDec.dealCards());
	}
	
	@After
	public void destroy(){
		myDec = null;
	}
	
}
