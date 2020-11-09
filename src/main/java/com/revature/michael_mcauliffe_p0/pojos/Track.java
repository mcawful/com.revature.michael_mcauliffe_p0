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

	private int trackID = 0;
	private String trackTitle;
	private String albumTitle;
	private String artistName;
	private long playCount = 0;
	
	public Track() {
		
		this.trackTitle = "";
		this.albumTitle = "";
		this.artistName = "";
	}
	
	public Track(String trackTitle, String albumTitle, String artistName)  {
		
		this.trackTitle = trackTitle;
		this.albumTitle = albumTitle;
		this.artistName = artistName;
	}

	
	public Track getTrack() {
		
		return this;
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
	
	public void setTrackID(int trackID) {
		
		this.trackID = trackID;
	}
	
	public int getTrackID() {
		
		return this.trackID;
	}

	public long getPlayCount() {
		
		return this.playCount;
	}

	public void setPlayCount(long playCount) {
		
		this.playCount = playCount;
	}
	
	public void increasePlayCount() {
		
		playCount++;
	}
	
	@Override
    public boolean equals(Object ob) {
		
		if (ob == this)
            return true;
 
        if (ob == null || ob.getClass() != getClass()) {
            return false;
        }
		
        Track t = (Track) ob;
        
        return t.trackTitle.equals(this.trackTitle)
        		&& t.albumTitle.equals(this.albumTitle)
        		&& t.artistName.equals(this.artistName);
	}
	
	public boolean equals(int trackID) {
		
		return this.trackID == trackID;
	}
}
