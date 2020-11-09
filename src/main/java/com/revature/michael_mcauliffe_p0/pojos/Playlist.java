package com.revature.michael_mcauliffe_p0.pojos;

import java.util.LinkedList;

public class Playlist {
	
	private String name;
	private LinkedList<String> songList;
	
	public Playlist() {
		
		this.name = "";
		songList = new LinkedList<String>();
	}
	
	public Playlist(String name) {
		
		this.name = name;
		songList = new LinkedList<String>();
	}
	
	public Playlist getPlaylist() {
		
		return this;
	}

	public LinkedList<String> getSongList() {
		
		return songList;
	}

	public String getPlaylistName() {
		
		return this.name;
	}

	public void renamePlaylist(String name) {
		
		this.name = name;
	}

	public void addTrack(Track track) {
		
		this.songList.add(Integer.toString(track.hashCode()));
	}

	public void removeTrack(Track track) {

		this.songList.remove(Integer.toString(track.hashCode()));
	}

	public void clearPlaylist() {
		
		this.songList.clear();
	}

	public boolean hasTrack(Track track) {
		
		return this.songList.contains(Integer.toString(track.hashCode()));
	}

	public int findTrackPosition(Track track) {
		
		return this.songList.indexOf(Integer.toString(track.hashCode()));
	}

	public String getTrack(int trackPosition) {
		
		return this.songList.get(trackPosition);
	}

	@Override
    public boolean equals(Object ob) {
		
		if (ob == this)
            return true;
 
        if (ob == null || ob.getClass() != getClass()) {
            return false;
        }
		
        Playlist p = (Playlist) ob;
        
        return p.name.equals(this.name)
        		&& p.songList.equals(this.songList);
	}
}
