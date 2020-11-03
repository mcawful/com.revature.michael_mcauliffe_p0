package com.revature.michael_mcauliffe_p0.service;

import java.util.LinkedList;

import com.revature.michael_mcauliffe_p0.pojos.Track;

public interface PlaylistHandlerService <T> {

	public T getPlaylist();
	
	public LinkedList<Track> getSongList();
		
	public String getPlaylistName();
	
	public void renamePlaylist(String newName);
	
	public void addTrack(Track track);
	
	public void removeTrack(Track track);
	
	public void clearPlaylist();
	
	public boolean hasTrack(Track track);
	
	public int findTrackPosition(Track track);
	
	public Track getTrack(int trackPosition);
	
}
