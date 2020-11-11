package com.revature.michael_mcauliffe_p0.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.michael_mcauliffe_p0.pojos.Track;

public interface TrackDao {

	public Track addTrack(Track track) throws SQLException;
	
	public Track updateTrack(int trackID, Track track) throws SQLException;
	
	public long incrementPlayCount(int trackID) throws SQLException;
	
	public Track removeTrack(int trackID) throws SQLException;
	
	public long getPlayCount(int trackID) throws SQLException;
	
	public List<Track> getTrack(int trackID, String trackTitle,
			String albumTitle,  String artistName) throws SQLException;
}
