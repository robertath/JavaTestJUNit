package auction.domain;

import java.util.List;

public class Main {

	
	public static void main(String[] args) {
		User u1 = new User("July");
		User u2 = new User("Mike");
		Auction auction = new Auction("TV 55 inches");
		auction.offer(new Bid(u1, 700));
		auction.offer(new Bid(u2, 800));
		auction.offer(new Bid(u1, 750));
		auction.offer(new Bid(u2, 750));
		auction.offer(new Bid(u1, 900));
		
		Adjuster actioneer = new Adjuster();
		actioneer.rate(auction);
		
		List<Bid> biggest = actioneer.getBiggest();
		
		if(biggest.size() >= 3) {
			biggest.forEach(System.out::println);
		}
	}
}
