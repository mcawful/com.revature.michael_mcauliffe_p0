package com.revature.michael_mcauliffe_p0.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.michael_mcauliffe_p0.pojos.Track;

public interface TrackDao {

	public Track addTrack(Track track) throws SQLException;
	
	public Track updateTrack(int trackID, Track track);
	
	public boolean incrementPlayCount(int trackID);
	
	public Track removeTrack(int trackID) throws SQLException;
	
	public int getPlayCount(int trackID);
	
	public Track getTrack(int trackID);
	
	public List<Track> getAllTracks();
}
