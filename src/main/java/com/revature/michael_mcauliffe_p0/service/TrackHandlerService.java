/**
 * Interface to be used with audio and music objects.
 */

package com.revature.michael_mcauliffe_p0.service;

public interface TrackHandlerService<T> {

	public T getTrack();
	
	public short getTrackNumber();
	
	public String getTrackTitle();
	
	public String getAlbumTitle();
	
	public String getArtistName();
	
	public long getPlayCount();
	
	public void increasePlayCount();
	
}
