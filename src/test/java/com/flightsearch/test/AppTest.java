package com.flightsearch.test;

import com.flightsearch.src.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

	@Test
	public void testAirportName() {
		assertEquals("Madrid",Airport.Madrid.getName());
	}

}
