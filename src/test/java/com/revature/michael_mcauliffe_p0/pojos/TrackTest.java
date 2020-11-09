package com.revature.michael_mcauliffe_p0.pojos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TrackTest {
	
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
	public void getTrack() throws Exception {
		
		Track testTrack = track;
		assertEquals("Should return Track object.", testTrack, track.getTrack());
	}
	
	@Test
	public void getTrackTitleTest() throws Exception {
		
		String expectedTrackTitle = "Test Track";
		assertEquals("Should return track title", expectedTrackTitle, track.getTrackTitle());
	}
	
	@Test
	public void getAlbumTitleTest() throws Exception {
		
		String expectedAlbumTitle = "Test Album";
		assertEquals("Should return album title.", expectedAlbumTitle, track.getAlbumTitle());
	}
	
	@Test
	public void getArtistNameTest() throws Exception {
		
		String expectedArtistName = "Test Artist";
		assertEquals("Should return artist name.", expectedArtistName, track.getArtistName());
	}
	
	@Test
	public void getPlayCountTest() throws Exception {
		
		long expectedPlayCount = 5;
		assertEquals("Should return play count.", expectedPlayCount, track.getPlayCount());
	}
	
	@Test
	public void increasePlayCountTest() throws Exception {
		
		long expectedPlayCount = 6;
		track.increasePlayCount();
		assertEquals("Should return incremeneted play count.", expectedPlayCount, track.getPlayCount());
	}
	
	@Test
	public void equalsTest() throws Exception {
		
		Track testTrack = new Track("Test Track", "Test Album", "Test Artist");
		
		assertTrue("Should retuen true if tracks match.", track.equals(testTrack));
	}
}
