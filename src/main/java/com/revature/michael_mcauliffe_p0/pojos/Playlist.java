package com.revature.michael_mcauliffe_p0.pojos;

import java.util.LinkedList;

import com.revature.michael_mcauliffe_p0.service.PlaylistHandlerService;

public class Playlist implements PlaylistHandlerService<Playlist>  {
	
	String name;
	int currentTrack = -1;
	LinkedList<Track> songList = new LinkedList<Track>();
	
	public Playlist(String name) {
		
		this.name = name;
	}
	
	@Override
	public Playlist getPlaylist() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<Track> getSongList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPlaylistName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void renamePlaylist(String newName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTrack(Track track) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTrack(Track track) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearPlaylist() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasTrack(Track track) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int findTrackPosition(Track track) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Track getTrack(int trackPosition) {
		// TODO Auto-generated method stub
		return null;
	}

}
