package com.revature.michael_mcauliffe_p0.pojos;

import com.revature.michael_mcauliffe_p0.service.TrackHandlerService;

public class Track implements TrackHandlerService {

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public short getTrackNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getTrackTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAlbumTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getArtistName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getPlayCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void increasePlayCount() {
		// TODO Auto-generated method stub
		
	}
}
