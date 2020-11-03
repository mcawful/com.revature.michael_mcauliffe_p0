package com.revature.michael_mcauliffe_p0.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.michael_mcauliffe_p0.pojos.Track;
import com.revature.michael_mcauliffe_p0.pojos.TrackCache;

public class TrackCacheTest  {
	
	private TrackCache<Track> cacheService;	
	static private List<Track> testCache;
	Track track1, track2, track3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		testCache = new ArrayList<>();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		track1 = new Track((short) 6, "Test Track", "Test Album", "Test Artist");
		track2 = new Track((short) 9, "Hip to be Square", "Fore!", "Heuy Lewis and the News");
		track3 = new Track((short) 12, "This", "Is", "Sparta");
		
		testCache.add(track1);
		testCache.add(track2);
		testCache.add(track3);
		
		cacheService = new TrackCache<Track>(testCache);
	}

	@After
	public void tearDown() throws Exception {
		
		testCache.clear();
	}

	@Test
	public void addToCacheTest() throws Exception {
		
		Track track4 = new Track((short) 7, "Eight", "Nine", "Oh my");
		cacheService.addToCache(track4);
		assertEquals("Track " + track4 + " should be in cache.", true, testCache.contains(track4));
	}
	
	@Test
	public void removeFromCacheTest() throws Exception {
		
		cacheService.removeFromCache(track3);
		assertEquals("Track " + track3 + " should NOT be in cache.", false, testCache.contains(track3));
	}
	
	@Test
	public void positionInCacheTest() throws Exception {
		
		int position = cacheService.positionInCache(track3);
		assertEquals("Position '" + position + "' should be '2'.", true, position == 2);
	}
	
	@Test
	public void retreiveFromCacheTest() throws Exception {
		
		int position = 1;
		Track testTrack = cacheService.retreiveFromCache(position);
		assertEquals("Track " + track2 + " should be retreived.", true, testTrack == track2);
	}
	
	@Test
	public void emptyCacheTest() throws Exception {
		
		cacheService.emptyCache();
		assertEquals("Cache should be empty.", true, testCache.isEmpty());
	}
	
	@Test
	public void containsTest() throws Exception {
		
		assertEquals("Cache should return true.", true, cacheService.contains(track1));
	}
	
	@Test
	public void retrieveAllItemsTest() throws Exception {
		//TODO: Create tests for future implementation
		//fail("Not yet implemented");
	}
	
	@Test
	public void retrieveMatchingTest() throws Exception {
		//TODO: Create tests for future implementation
		//fail("Not yet implemented");
	}
}
