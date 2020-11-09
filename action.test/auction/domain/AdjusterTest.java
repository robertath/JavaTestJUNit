package auction.domain;

import java.util.List;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AdjusterTest {
	
	private Adjuster auctioneer;
	private User u1;
	private User u2;
	private User u3;
	private User u4;

	@BeforeEach
	public void setUp() {
		this.auctioneer = new Adjuster();
		
		this.u1 = new User("Mika");
		this.u2 = new User("Jonas");
		this.u3 = new User("Anne");
		this.u4 = new User("Gari");

	}
	
	@AfterEach
	public void finish() {
	  System.out.println("End");
	}
	
	@BeforeAll
	public static void testingBeforeClass() {
	  System.out.println("before class");
	}

	@AfterAll
	public static void testingAfterClass() {
	  System.out.println("after class");
	}

	@Test
	public void mustUnderstandBidsInAscendingOrder() {
		
		Auction auction = new CreateAuction().to("Playstation 7 - New")
				.bid(u1, 100.0)
				.bid(u2, 200.0)
				.bid(u3, 300.0)
				.bid(u4, 400.0)
				.build();
		
		auctioneer.rate(auction);
		
		double greatestExpected = 400;
		double lowestExpected = 100;
		
		assertEquals(greatestExpected, auctioneer.getGreatesBid(), 0.0001);
		assertEquals(lowestExpected, auctioneer.getLowestBid(), 0.0001);
	}
	
	@Test 
	public void mustCalculateAvarege () {
		
		Auction auction = new CreateAuction().to("Playstation 7 - New")
				.bid(u1, 100.0)
				.bid(u2, 200.0)
				.bid(u3, 300.0)
				.bid(u4, 400.0)
				.build();
		
		auctioneer.rate(auction);
		
		assertEquals(250.0, auctioneer.getAvarage(), 0.0001);
	}

	@Test 
	public void mustGetAvarageOfZeroBid () {
		
		
		Auction auction = new CreateAuction().to("Playstation 7 - New").build();
		
		Exception exception = assertThrows(RuntimeException.class, () -> auctioneer.rate(auction));
		
		assertEquals(0, auctioneer.getAvarage(), 0.0001);
		
	}
	
	@Test
	public void mustUnderstandActionWithOneBid() {
		
		Auction auction = new CreateAuction().to("Playstation 7 - New")
				.bid(u1, 700.0)
				.build();
		auctioneer.rate(auction);
		
		assertEquals(700.0, auctioneer.getGreatesBid(), 0.0001);
		assertEquals(700.0, auctioneer.getLowestBid(), 0.0001);
	}
	
	@Test
	public void mustShowThreeBiggestBids() {
		
		Auction auction = new CreateAuction().to("Playstation 7 - New")
				.bid(u1, 100.0)
				.bid(u2, 200.0)
				.bid(u3, 300.0)
				.bid(u4, 400.0)
				.build();
		
		auctioneer.rate(auction);
		
		List<Bid> biggest = auctioneer.getBiggest();
		
		assertEquals(3, biggest.size());
		assertThat(biggest, hasItems(
				new Bid(u4, 400),
				new Bid(u3, 300), 
				new Bid(u2, 200)
				));		
	}
	
	@Test
	public void dontEvaluateWithoutAnyBid() {
		
		Auction auction = new CreateAuction().to("Playstation 7 - New").build();
		Exception excpetion = assertThrows(RuntimeException.class, () -> auctioneer.rate(auction));
		
		assertEquals(0, auctioneer.getAvarage(), 0.0001);
		
	}
	
	@Test
	public void dontEvaluateWithoutAnyBid2() {
		
		Auction auction = new CreateAuction().to("Playstation 7 - New").build();
		Exception exception = assertThrows(RuntimeException.class, () -> auctioneer.rate(auction));
		
		assertTrue(auctioneer.getAvarage() == 0);
				
	}
}
