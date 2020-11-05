/**
 * Track class creates Track objects that give information regarding audio and music
 * tracks which can be set once upon initialization and retrieved through methods
 * implemented through the TrackServiceHandler interface. The fields contained in the
 * Track object are values for the track number, track title, album title and artist
 * name along with a play count field that can be incremented through the
 * increasePlayCount method.
 */

package com.revature.michael_mcauliffe_p0.pojos;

public class Track {

	private short trackNumber;
	private int hashID;
	private String trackTitle;
	private String albumTitle;
	private String artistName;
	private long playCount = 0;
	
	public Track() {
		
		this.trackNumber = -1;
		this.trackTitle = "";
		this.albumTitle = "";
		this.artistName = "";
		this.hashID = hash();
	}
	
	public Track(short trackNumber, String trackTitle, String albumTitle, String artistName) {
		
		this.trackNumber = trackNumber;
		this.trackTitle = trackTitle;
		this.albumTitle = albumTitle;
		this.artistName = artistName;
		this.hashID = hash();
	}
	
	public Track(short trackNumber, String trackTitle, String albumTitle, String artistName, long playCount) {
		
		this.trackNumber = trackNumber;
		this.trackTitle = trackTitle;
		this.albumTitle = albumTitle;
		this.artistName = artistName;
		this.playCount = playCount;
	}

	public Track getTrack() {
		
		return this;
	}

	public short getTrackNumber() {
		
		return this.trackNumber;
	}

	public String getTrackTitle() {
		
		return this.trackTitle;
	}

	public String getAlbumTitle() {
		
		return this.albumTitle;
	}

	public String getArtistName() {
		
		return this.artistName;
	}
	
	public int getHashID() {
		
		return this.hashID;
	}

	public long getPlayCount() {
		
		return this.playCount;
	}

	public void increasePlayCount() {
		
		playCount++;
	}
	
	private int hash() {
		
		return (this.trackNumber + this.trackTitle + this.albumTitle + this.artistName).hashCode();
	}
}
