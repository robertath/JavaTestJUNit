package auction.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Auction {

	private String description;
	private List<Bid> bids;

	public Auction(String description) {
		this.description = description;
		this.bids = new ArrayList<Bid>();
	}

	public void offer(Bid bid) {
		if (bids.isEmpty() || canBid(bid.getUser())) {
			bids.add(bid);
		}
	}

	public Bid getLastBid() {
		return bids.get(bids.size() - 1);
	}

	public String getDescription() {
		return description;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public int amountBidsForUser(User user) {
		int sum = 0;
		for (Bid b : bids) {
			if (b.getUser().equals(user))
				sum++;
		}
		return sum;
	}

	public boolean canBid(User user) {
		return !getLastBid().getUser().equals(user) && amountBidsForUser(user) < 5;
	}

	public void doubleBid(User user) {
		Bid last = lastBid(user);
		if (last != null) {
			offer(new Bid(user, last.getValue() * 2));
		}
	}

	public Bid lastBid(User user) {
		Bid last = null;
		for (Bid bid : bids) {
			if (bid.getUser().equals(user))
				last = bid;
		}
		return last;
	}
}
