/**
 * Track class creates Track objects that give information regarding audio and music
 * tracks which can be set once upon initialization and retrieved through methods
 * implemented through the TrackServiceHandler interface. The fields contained in the
 * Track object are values for the track number, track title, album title and artist
 * name along with a play count field that can be incremented through the
 * increasePlayCount method.
 */

package com.revature.michael_mcauliffe_p0.pojos;

import com.revature.michael_mcauliffe_p0.service.TrackHandlerService;

public class Track implements TrackHandlerService<Track> {

	private short trackNumber;
	private String trackTitle;
	private String albumTitle;
	private String artistName;
	private long playCount = 0;
	
	public Track(short trackNumber, String trackTitle, String albumTitle, String artistName) {
		this.trackNumber = trackNumber;
		this.trackTitle = trackTitle;
		this.albumTitle = albumTitle;
		this.artistName = artistName;
	}
	
	public Track(short trackNumber, String trackTitle, String albumTitle, String artistName, long playCount) {
		this.trackNumber = trackNumber;
		this.trackTitle = trackTitle;
		this.albumTitle = albumTitle;
		this.artistName = artistName;
		this.playCount = playCount;
	}

	@Override
	public Track getTrack() {
		
		return this;
	}

	@Override
	public short getTrackNumber() {
		
		return this.trackNumber;
	}

	@Override
	public String getTrackTitle() {
		
		return this.trackTitle;
	}

	@Override
	public String getAlbumTitle() {
		
		return this.albumTitle;
	}

	@Override
	public String getArtistName() {
		
		return this.artistName;
	}

	@Override
	public long getPlayCount() {
		
		return this.playCount;
	}

	@Override
	public void increasePlayCount() {
		
		playCount++;
	}
}
