package auction.domain;

public class CreateAuction {
	
	private Auction auction;

	public CreateAuction() {}

	public CreateAuction to(String description) {
		this.auction = new Auction(description);
		return this;
	}
	
	public CreateAuction bid(User user, double value) {
		auction.offer(new Bid(user, value));
		return this;
	}
	
	public Auction build() {
		return auction;
	}
}
