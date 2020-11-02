package com.revature.michael_mcauliffe_p0.service;

public interface PlaylistHandlerService <T> {

	public T getPlaylist(T obj);
	
	public void setPlaylist();
	
	public String getPlaylistName(T obj);
	
}
