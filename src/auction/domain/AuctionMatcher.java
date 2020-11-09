package auction.domain;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class AuctionMatcher extends TypeSafeMatcher<Auction> {

	private final Bid bid;
	
	public AuctionMatcher(Bid bid) {
		this.bid = bid;
	}

	@Override
	public void describeTo(Description desc) {
        desc.appendText("Auction with Bid: " + bid.getValue());
	}

	@Override
	protected boolean matchesSafely(Auction auction) {
        return auction.getBids().contains(bid);
	}

	public static Matcher<Auction> hasOneBid(Bid bid) {
        return new AuctionMatcher(bid);
    }
	
}
