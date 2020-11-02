package com.revature.michael_mcauliffe_p0.service;

public interface TrackHandlerService<T> {

	public T getTrack(T obj);
	
	public void setTrack(short trackNumber, String albumTitle, String artistName, String trackName);
	
	public short getTrackNumber(T obj);
	
	public String getAlbumTitle(T obj);
	
	public String getArtistName(T obj);
	
	public String getTrackName(T obj);
	
	public long getPlayCount(T obj);
	
	public void setTrackNumber(short trackNumber);
		
	public void setAlbumTitle(String albumTitle);
		
	public void setArtistName(String artistName);
		
	public void setTrackName(String trackName);
	
}
