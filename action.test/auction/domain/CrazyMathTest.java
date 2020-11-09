package auction.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;


public class CrazyMathTest {

	@Test
	public void MustMultiplyByBiggestThan30() {
	
		CrazyMath math = new CrazyMath();
		assertEquals(50*4, math.crazyAccount(50));
	}
	
	@Test
	public void MustMultiplyByBiggestThan10LessThan30() {
	
		CrazyMath math = new CrazyMath();
		assertEquals(20*3, math.crazyAccount(20));
	}
	
	@Test
	public void MustMultiplyByLessThan10() {
	
		CrazyMath math = new CrazyMath();
		assertEquals(5*2, math.crazyAccount(5));
	}
}
