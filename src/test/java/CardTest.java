import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class CardTest {
	
	Card pokerCard;
	
	@Before
	public void init(){
		pokerCard = new Card(2, 'D');
	}
	
	@Test
	public void givenCard_WhenInstantiatingObject_ThenObjectCreated(){
		assertNotNull(pokerCard);
	}
	
	@Test
	public void singleCardTest(){
		assertEquals("T", pokerCard.singleCard(10));
	}
	
	@After
	public void destroy(){
		pokerCard = null;
	}

}
