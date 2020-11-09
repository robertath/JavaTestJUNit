package auction.domain;

public class Bid {

	private User user;
	private double price;
	
	public Bid(User user, double price) {
		if(price <= 0)
			throw new IllegalArgumentException();
		this.user = user;
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public double getValue() {
		return price;
	}
	
	@Override
	public String toString() {
		return "User: " + user.getName() + " - Bid: " + this.price;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (getClass() != obj.getClass())
	        return false;
	    Bid other = (Bid) obj;
	    if (user == null) {
	        if (other.user != null)
	            return false;
	    } else if (!user.equals(other.user))
	        return false;
	    if (Double.doubleToLongBits(price) != Double
	            .doubleToLongBits(other.price))
	        return false;
	    return true;
	}

}
