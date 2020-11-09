package auction.domain;

public class CrazyMath {
	
	public int crazyAccount(int number) {
        if (number > 30)
            return number * 4;
        else if (number > 10)
            return number * 3;
        else
            return number * 2;
    }

}
