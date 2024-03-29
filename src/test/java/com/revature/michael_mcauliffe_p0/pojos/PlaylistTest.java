package com.revature.michael_mcauliffe_p0.pojos;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlaylistTest {

	private Track track1, track2;
	private Playlist playlist;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		track1 = new Track("Test Track", "Test Album", "Test Artist");
		track2 = new Track("Hip to be Square", "Fore!", "Heuy Lewis and the News");
		playlist = new Playlist("Test Playlist");
		playlist.addTrack(track1);
		playlist.addTrack(track2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getPlaylistTest() throws Exception {

		Playlist testPlaylist = this.playlist;
		
		assertEquals("Should return Playlist object.", testPlaylist, this.playlist.getPlaylist());
	}

	@Test
	public void getSonglistTest() throws Exception {
		
		LinkedList<String> testSongList = new LinkedList<String>();
		testSongList.add(Integer.toString(track1.hashCode()));
		testSongList.add(Integer.toString(track2.hashCode()));
		
		try {
			assertEquals("Should return true if contents match.", testSongList.toString(),
						this.playlist.getSongList().toString());
			
		} catch(NullPointerException e) {
			fail(e.toString());
		}
	}
	
	@Test
	public void getPlaylistNameTest() throws Exception {
		
		String testPlaylistName = "Test Playlist";
		
		assertEquals("Should return playlist name.", testPlaylistName, this.playlist.getPlaylistName());
	}
	
	@Test
	public void renamePlaylistTest() throws Exception {

		String testRename = "Hello World!";
		this.playlist.renamePlaylist(testRename);
		
		assertEquals("Should return the new playlist name.", testRename, this.playlist.getPlaylistName());
	}
	
	@Test
	public void addTrackTest() throws Exception {
		
		Track track3 = new Track("This", "Is", "Sparta");
		this.playlist.addTrack(track3);
		
		try{
			assertTrue("Should return the new track.", this.playlist.hasTrack(track3));
			
		} catch(NullPointerException e) {
			fail(e.toString());
		}
	}
	
	@Test
	public void removeTrackTest() throws Exception {
		
		try {
			this.playlist.removeTrack(this.track1);
			
		} catch(NullPointerException e){
			fail(e.toString());
		} catch(IndexOutOfBoundsException e) {
			fail(e.toString());
		}
		
		assertFalse("Should return false if track was removed", this.playlist.hasTrack(track1));
	}
	
	@Test
	public void clearPlaylistTest() throws Exception {
		
		this.playlist.clearPlaylist();
		
		try {
			assertTrue("Should return an empty songlist.", this.playlist.getSongList().isEmpty());
			
		} catch(NullPointerException e){
			fail(e.toString());
		}
	}
	
	@Test
	public void hasTrackTest() throws Exception {
		
		assertTrue("Should return true if track exists in the playlist.",
					this.playlist.hasTrack(this.track1));
	}
	
	@Test
	public void findTrackPositionTest() throws Exception {
		
		int trackPosition = 1;
		
		assertEquals("Should return track position.", trackPosition,
					this.playlist.findTrackPosition(this.track2));
	}
	
	@Test
	public void getTrackTest() throws Exception 
	{
		
		int trackPosition = 1;
		
		assertEquals("Should return expected track", Integer.toString(this.track2.hashCode())
				, this.playlist.getTrack(trackPosition));
	}
	
	@Test
	public void equalsTest() throws Exception {
		
		Playlist testPlaylist= new Playlist("Test Playlist");
		
		testPlaylist.addTrack(track1);
		testPlaylist.addTrack(track2);
		
		assertTrue("Should return true if tracks are the same", playlist.equals(testPlaylist));
	}
}
