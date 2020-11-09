package auction.domain;

import java.util.ArrayList;
import java.util.List;

public class BidFilter {

	
	public List<Bid> filter(List<Bid> bids){
	
		ArrayList<Bid> result =  new ArrayList<Bid>();
		
		for(Bid bid : bids) {
			if(bid.getValue() > 1000 && bid.getValue() < 3000)
				result.add(bid);
			if(bid.getValue() > 500 && bid.getValue() < 700)
				result.add(bid);
			if(bid.getValue() > 5000)
				result.add(bid);
		}
		return result;
	}
}
