package com.revature.michael_mcauliffe_p0.pojos;

import java.util.LinkedList;

import com.revature.michael_mcauliffe_p0.service.PlaylistHandlerService;

public class Playlist implements PlaylistHandlerService<Playlist>  {
	
	String name;
	LinkedList<Track> songList;
	
	public Playlist() {
		
		this.name = "";
		songList = new LinkedList<Track>();
	}
	
	public Playlist(String name) {
		
		this.name = name;
		songList = new LinkedList<Track>();
	}
	
	@Override
	public Playlist getPlaylist() {
		
		return this;
	}

	@Override
	public LinkedList<Track> getSongList() {
		// TODO Auto-generated method stub
		return songList;
	}

	@Override
	public String getPlaylistName() {
		
		return this.name;
	}

	@Override
	public void renamePlaylist(String name) {
		
		this.name = name;
	}

	@Override
	public void addTrack(Track track) {
		
		this.songList.add(track);
	}

	@Override
	public void removeTrack(Track track) {
		
		this.songList.remove(track);
	}

	@Override
	public void clearPlaylist() {
		
		this.songList.clear();
	}

	@Override
	public boolean hasTrack(Track track) {
		
		return this.songList.contains(track);
	}

	@Override
	public int findTrackPosition(Track track) {
		
		return this.songList.indexOf(track);
	}

	@Override
	public Track getTrack(int trackPosition) {
		
		return this.songList.get(trackPosition);
	}

}
