package com.revature.michael_mcauliffe_p0.pojos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

public class PlayerTest {

	@Mock
	private Track track;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		track = new Track("Test Track", "Test Album", "Test Artist");
		track.setPlayCount(5);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void playTest() {
		fail("Not yet implemented");
	}

}
