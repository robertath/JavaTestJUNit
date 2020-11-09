package auction.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;


public class LeapYearTest {

	
	@Test
	public void mustReturnLeapYear() {        
	    LeapYear leapYear = new LeapYear();

	    assertEquals(true, leapYear.isLeapYear(2016));
	    assertEquals(true, leapYear.isLeapYear(2012));
	}

	@Test
	public void dontReturnLeapYear() {        
	    LeapYear leapYear = new LeapYear();        

	    assertEquals(false, leapYear.isLeapYear(2015));
	    assertEquals(false, leapYear.isLeapYear(2011));
	}
}
