package auction.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Adjuster {

	private double greatestOfAll = Double.NEGATIVE_INFINITY;
	private double lowestOfAll = Double.POSITIVE_INFINITY;
	private double average = 0;
	private List<Bid> biggest;

	public void rate(Auction auction) {

		// lançando a exceção
        if(auction.getBids().size() == 0) {
            throw new RuntimeException("Cant validate any auction!");
        }
		
		double sum = 0;

		for (Bid bid : auction.getBids()) {
			if (bid.getValue() > greatestOfAll)
				greatestOfAll = bid.getValue();

			if (bid.getValue() < lowestOfAll)
				lowestOfAll = bid.getValue();

			sum += bid.getValue();
		}

		if (sum == 0) {
			average = 0;
			return;
		}
		
		average = sum / auction.getBids().size();
		
		biggest = new ArrayList<Bid>(auction.getBids());
		Collections.sort(biggest, new Comparator<Bid>() {

			public int compare(Bid b1, Bid b2) {
				if (b1.getValue() < b2.getValue())
					return 1;
				if (b1.getValue() > b2.getValue())
					return -1;
				return 0;
			}
		});

		biggest = biggest.subList(0, biggest.size() > 3 ? 3 : biggest.size());
	}

	public double getGreatesBid() {
		return greatestOfAll;
	}

	public double getLowestBid() {
		return lowestOfAll;
	}

	public double getAvarage() {
		return average;
	}

	public List<Bid> getBiggest() {
		return this.biggest;
	}
}
