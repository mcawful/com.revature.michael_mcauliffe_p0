package com.revature.michael_mcauliffe_p0.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.michael_mcauliffe_p0.pojos.Playlist;
import com.revature.michael_mcauliffe_p0.pojos.PlaylistCache;
import com.revature.michael_mcauliffe_p0.pojos.Track;

public class PlaylistCacheTest  {
	
	private PlaylistCache<Playlist> cacheService;	
	static private List<Playlist> testCache;
	Playlist playlist1, playlist2;
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
		
		playlist1 = new Playlist("Playlist Number One");
		playlist2 = new Playlist("My second playlist EVA!!");		
		
		track1 = new Track((short) 6, "Test Track", "Test Album", "Test Artist");
		track2 = new Track((short) 9, "Hip to be Square", "Fore!", "Heuy Lewis and the News");
		track3 = new Track((short) 12, "This", "Is", "Sparta");
		
		playlist1.addTrack(track1);
		playlist1.addTrack(track2);
		playlist1.addTrack(track3);
		playlist2.addTrack(track3);
		playlist2.addTrack(track2);
		
		testCache.add(playlist1);
		testCache.add(playlist2);
		
		cacheService = new PlaylistCache<Playlist>(testCache);
	}

	@After
	public void tearDown() throws Exception {
		
		testCache.clear();
	}

	@Test
	public void addToCacheTest() throws Exception {
		
		Playlist playlist3 = new Playlist("My New Mixtape");
		cacheService.addToCache(playlist3);
		assertEquals("Playlist " + playlist3 + " should be in cache.", true, testCache.contains(playlist3));
	}
	
	@Test
	public void removeFromCacheTest() throws Exception {
		
		cacheService.removeFromCache(playlist1);
		assertEquals("Playlist " + playlist1 + " should NOT be in cache.", false, testCache.contains(playlist1));
	}
	
	@Test
	public void positionInCacheTest() throws Exception {
		
		int position = cacheService.positionInCache(playlist2);
		assertEquals("Position '" + position + "' should be '1'.", true, position == 1);
	}
	
	@Test
	public void retreiveFromCacheTest() throws Exception {
		
		int position = 1;
		Playlist testPlaylist = cacheService.retreiveFromCache(position);
		assertEquals("Playlist " + playlist2 + " should be retreived.", true, testPlaylist == playlist2);
	}
	
	@Test
	public void emptyCacheTest() throws Exception {
		
		cacheService.emptyCache();
		assertEquals("Cache should be empty.", true, testCache.isEmpty());
	}
	
	@Test
	public void containsTest() throws Exception {
		
		assertEquals("Cache should return true.", true, cacheService.contains(playlist1));
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
