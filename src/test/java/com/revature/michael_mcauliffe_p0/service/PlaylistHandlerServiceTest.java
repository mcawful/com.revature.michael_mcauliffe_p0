package com.revature.michael_mcauliffe_p0.service;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.michael_mcauliffe_p0.pojos.Playlist;
import com.revature.michael_mcauliffe_p0.pojos.Track;

public class PlaylistHandlerServiceTest {

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
		
		track1 = new Track((short) 6, "Test Track", "Test Album", "Test Artist");
		track2 = new Track((short) 9, "Hip to be Square", "Fore!", "Heuy Lewis and the News");
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
		
		LinkedList<Track> testSongList = new LinkedList<Track>();
		testSongList.add(track1);
		testSongList.add(track2);
		
		try {
			assertEquals("Should return true if contents match.", true,
						testSongList.containsAll(this.playlist.getSongList())
						&& (testSongList.size() == this.playlist.getSongList().size()));
			
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
		
		Track track3 = new Track((short) 12, "This", "Is", "Sparta");
		this.playlist.addTrack(track3);
		
		try{
			assertEquals("Should return the new track.", track3, this.playlist.getSongList().getLast());
			
		} catch(NullPointerException e) {
			fail(e.toString());
		}
	}
	
	@Test
	public void removeTrackTest() throws Exception {
		
		this.playlist.removeTrack(this.track1);
		
		try {
			assertEquals("Should return false if the first track in the linked list was removed", false,
						this.playlist.getSongList().getFirst() == this.track1);
			
		} catch(NullPointerException e){
			fail(e.toString());
		}
	}
	
	@Test
	public void clearPlaylistTest() throws Exception {
		
		this.playlist.clearPlaylist();
		
		try {
			assertEquals("Should return an empty songlist.", true, this.playlist.getSongList().isEmpty());
			
		} catch(NullPointerException e){
			fail(e.toString());
		}
	}
	
	@Test
	public void hasTrackTest() throws Exception {
		
		assertEquals("Should return true if track exists in the playlist.", true,
					this.playlist.hasTrack(this.track1));
	}
	
	@Test
	public void findTrackPositionTest() throws Exception {
		
		int trackPosition = 1;
		
		assertEquals("Should return track position.", trackPosition,
					this.playlist.findTrackPosition(this.track2));
	}
	
	@Test
	public void getTrackTest() throws Exception {
		
		int trackPosition = 1;
		
		assertEquals("Should return expected track", this.track2, this.playlist.getTrack(trackPosition));
	}
}
