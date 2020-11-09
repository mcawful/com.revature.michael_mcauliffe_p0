package com.revature.michael_mcauliffe_p0.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import com.revature.michael_mcauliffe_p0.pojos.Track;

public class TrackCacheTest  {
	
	private TrackCache<Track> cacheService;	
	
	static private List<Track> testCache;
	
	@Mock
	private Track track1, track2, track3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		testCache = new ArrayList<>();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		track1 = new Track("Test Track", "Test Album", "Test Artist");
		track2 = new Track("Hip to be Square", "Fore!", "Heuy Lewis and the News");
		track3 = new Track("This", "Is", "Sparta");
		
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
		
		Track track4 = new Track("Eight", "Nine", "Oh my");
		cacheService.addToCache(track4);
		assertTrue("Track " + track4 + " should be in cache.", testCache.contains(track4));
	}
	
	@Test
	public void removeFromCacheTest() throws Exception {
		
		cacheService.removeFromCache(track3);
		assertFalse("Track " + track3 + " should NOT be in cache.", testCache.contains(track3));
	}
	
	@Test
	public void positionInCacheTest() throws Exception {
		
		int position = cacheService.positionInCache(track3);
		assertTrue("Position '" + position + "' should be '2'.", position == 2);
	}
	
	@Test
	public void retreiveFromCacheTest() throws Exception {
		
		int position = 1;
		Track testTrack = cacheService.retreiveFromCache(position);
		assertTrue("Track " + track2 + " should be retreived.", testTrack == track2);
	}
	
	@Test
	public void emptyCacheTest() throws Exception {
		
		cacheService.emptyCache();
		assertTrue("Cache should be empty.", testCache.isEmpty());
	}
	
	@Test
	public void containsTest() throws Exception {
		
		assertTrue("Cache should return true.", cacheService.contains(track1));
	}
	
	@Test
	public void retrieveAllItemsTest() throws Exception {

		assertTrue("Cache should return true.", cacheService.retrieveAllItems() == testCache);
	}
	
	@Test
	public void retrieveMatchingTest() throws Exception {
		//TODO: Create tests for future implementation
		//fail("Not yet implemented");
	}
	
	@Test
	public void equalsListTest() throws Exception {
		
		assertTrue("Caches should be equal.", cacheService.equals(testCache));
	}
	
	@Test
	public void equalsTrackCacheTest() throws Exception {
		
		TrackCache<Track> testCacheService = new TrackCache<Track>(testCache);
		
		assertTrue("Caches should be equal.", cacheService.equals(testCacheService));
	}
}
