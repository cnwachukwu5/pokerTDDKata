import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value = Suite.class)
@SuiteClasses(value = { CardTest.class, DeckOfCardTest.class, HandTest.class, PokerHandsTest.class})
public class PokerTestSuite {

}
