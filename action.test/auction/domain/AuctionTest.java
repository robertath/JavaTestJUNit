package auction.domain;

import static auction.domain.AuctionMatcher.hasOneBid;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;

public class AuctionTest {
	


	@Test
    public void mustReceiveOneBid() {
        Auction auction = new Auction("Macbook Pro 15");
        assertEquals(0, auction.getBids().size());

        Bid bid = new Bid(new User("Steve Jobs"), 2000);
        auction.offer(bid);
        
        assertThat(auction.getBids().size(), equalTo(1));
        assertThat(auction, hasOneBid(bid));
    }

    @Test
    public void mustReceiveSeveralBids() {
        Auction auction = new Auction("Macbook Pro 15");
        auction.offer(new Bid(new User("Steve Jobs"), 2000));
        auction.offer(new Bid(new User("Steve Wozniak"), 3000));

        assertEquals(2, auction.getBids().size());
        assertEquals(2000.0, auction.getBids().get(0).getValue(), 0.00001);
        assertEquals(3000.0, auction.getBids().get(1).getValue(), 0.00001);
    }
    
    @Test
    public void cantAcceptTwoBidsInSequenceFromUser() {
        Auction auction = new Auction("Macbook Pro 15");
        User u1 = new User("Steve");
        auction.offer(new Bid(u1, 2000));
        auction.offer(new Bid(u1, 3000));

        assertEquals(1, auction.getBids().size());
        assertEquals(2000.0, auction.getBids().get(0).getValue(), 0.00001);
    }
    
    @Test
    public void cantAcceptFiveBidsByUserOnForAction() {
        Auction auction = new Auction("Macbook Pro 15");
        User u1 = new User("Steve");
        User u2 = new User("Bill");
        auction.offer(new Bid(u1, 5000));
        auction.offer(new Bid(u2, 4000));
        auction.offer(new Bid(u1, 4000));
        auction.offer(new Bid(u2, 5200));
        auction.offer(new Bid(u1, 6500));
        auction.offer(new Bid(u2, 8100));
        auction.offer(new Bid(u1, 8000));
        auction.offer(new Bid(u2, 7500));
        auction.offer(new Bid(u1, 10000));
        auction.offer(new Bid(u2, 11000));

        assertEquals(10, auction.getBids().size());
        assertEquals(11000.0, auction.getBids().get(auction.getBids().size()-1).getValue(), 0.00001);
    }
    
    @Test
    public void mustDoubleBid() {
        Auction auction = new Auction("Macbook Pro 15");
        User u1 = new User("Steve");
        User u2 = new User("Bill");
        auction.offer(new Bid(u1, 2000));
        auction.offer(new Bid(u2, 3000));
        auction.doubleBid(u1);

        assertEquals(4000, auction.getBids().get(2).getValue(), 0.00001);
    }
    
    @Test
    public void cantDoubleBidIfDontHavePreviosBid() {
        Auction auction = new Auction("Macbook Pro 15");
        User u1 = new User("Steve");
        auction.doubleBid(u1);

        assertEquals(0, auction.getBids().size());
    }
}
