package com.revature.michael_mcauliffe_p0.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.michael_mcauliffe_p0.pojos.Playlist;
import com.revature.michael_mcauliffe_p0.pojos.Track;

@RunWith(MockitoJUnitRunner.class)
public class PlaylistCacheTest  {
	
	private PlaylistCache<Playlist> cacheService;	
	
	static private List<Playlist> testCache;
	
	@Mock
	private Playlist playlist1, playlist2;
	
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
		
		playlist1 = new Playlist("Playlist Number One");
		playlist2 = new Playlist("My second playlist EVA!!");		
		
		track1 = new Track("Test Track", "Test Album", "Test Artist");
		track2 = new Track("Hip to be Square", "Fore!", "Heuy Lewis and the News");
		track3 = new Track("This", "Is", "Sparta");
		
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
		assertTrue("Playlist " + playlist3 + " should be in cache.", testCache.contains(playlist3));
	}
	
	@Test
	public void removeFromCacheTest() throws Exception {
		
		cacheService.removeFromCache(playlist1);
		assertFalse("Playlist " + playlist1 + " should NOT be in cache.", testCache.contains(playlist1));
	}
	
	@Test
	public void positionInCacheTest() throws Exception {
		
		int position = cacheService.positionInCache(playlist2);
		assertTrue("Position '" + position + "' should be '1'.", position == 1);
	}
	
	@Test
	public void retreiveFromCacheTest() throws Exception {
		
		int position = 1;
		Playlist testPlaylist = cacheService.retreiveFromCache(position);
		assertTrue("Playlist " + playlist2 + " should be retreived.", testPlaylist == playlist2);
	}
	
	@Test
	public void emptyCacheTest() throws Exception {
		
		cacheService.emptyCache();
		assertTrue("Cache should be empty.", testCache.isEmpty());
	}
	
	@Test
	public void containsTest() throws Exception {
		
		assertTrue("Cache should return true.", cacheService.contains(playlist1));
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
}
