package auction.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;
import java.util.List;
import java.util.Arrays;


public class BidFilterTest {

	
	@Test
	public void mustSelectBidsBtw1000And3000() {
		User joao = new User("Joao");

        BidFilter filtro = new BidFilter();
        List<Bid> resultado = filtro.filter(Arrays.asList(
                new Bid(joao,2000), 
                new Bid(joao,1000), 
                new Bid(joao,3000), 
                new Bid(joao, 800)));

        assertEquals(1, resultado.size());
        assertEquals(2000, resultado.get(0).getValue(), 0.00001);
	}
	
	@Test
	public void mustSelectBidsBtw500And700() {
		User joao = new User("Joao");

        BidFilter filtro = new BidFilter();
        List<Bid> resultado = filtro.filter(Arrays.asList(
                new Bid(joao,600), 
                new Bid(joao,500), 
                new Bid(joao,700), 
                new Bid(joao, 800)));

        assertEquals(1, resultado.size());
        assertEquals(600, resultado.get(0).getValue(), 0.00001);
	}
	
	@Test
	public void mustSelectBidsBiggestThan5000() {
		User joao = new User("Joao");

        BidFilter filtro = new BidFilter();
        List<Bid> resultado = filtro.filter(Arrays.asList(
                new Bid(joao,10000), 
                new Bid(joao, 800)));

        assertEquals(1, resultado.size());
        assertEquals(10000, resultado.get(0).getValue(), 0.00001);
	}
	
	@Test
	public void mustSelectBidsLessThan500() {
		User joao = new User("Joao");

        BidFilter filtro = new BidFilter();
        List<Bid> resultado = filtro.filter(Arrays.asList(
                new Bid(joao,400), 
                new Bid(joao, 300)));

        assertEquals(0, resultado.size());
	}
}
