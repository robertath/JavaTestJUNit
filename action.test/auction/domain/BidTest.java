package auction.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

public class BidTest {

	@Test
	public void needRefuseBidsOfZeroValue() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Bid(new User("John"), 0));
		
//		assertTrue(auctioneer.getAvarage() == 0);

	}
	
	@Test
	public void needRefuseBidsOfNegativeValue() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Bid(new User("John"), -10));
	}

}
