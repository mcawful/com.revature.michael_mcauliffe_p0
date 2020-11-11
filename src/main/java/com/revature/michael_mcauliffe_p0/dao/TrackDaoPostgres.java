package com.revature.michael_mcauliffe_p0.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.michael_mcauliffe_p0.pojos.Log;
import com.revature.michael_mcauliffe_p0.pojos.Track;
import com.revature.michael_mcauliffe_p0.util.ConnectionUtil;

public class TrackDaoPostgres implements TrackDao {

	private Log log = new Log();
	
	private PreparedStatement ps;
	
	Connection conn = ConnectionUtil.getInstance().getConnection();
	
	@Override
	public Track addTrack(Track track) throws SQLException {

		String sql = "insert into tracks (track_title, album_title, artist_name, play_count)"
		+ " values (?, ?, ?, ?) returning *;";
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, track.getTrackTitle());
			ps.setString(2, track.getAlbumTitle());
			ps.setString(3, track.getArtistName());
			ps.setInt(4, 0);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			track.setTrackID(rs.getInt("track_id"));
			
			return track;
			
		} catch (SQLException e) {
			
			log.info(e.getMessage());
			return null;
		}		
	}

	@Override
	public Track updateTrack(int trackID, Track track) throws SQLException {
		
		String sql = "update tracks set track_title = ?, album_title = ?, artist_name = ? "
				+ "where track_id = ? returning *;";

		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, track.getTrackTitle());
			ps.setString(2, track.getAlbumTitle());
			ps.setString(3, track.getArtistName());
			ps.setInt(4, trackID);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			track.setPlayCount(rs.getLong("play_count"));
			
			return track;
			
		} catch (SQLException e) {
			
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public long incrementPlayCount(int trackID) throws SQLException {

		String sql = "select play_count from tracks where track_id = ? returning play_count;";
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, trackID);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				long playCount = rs.getLong("play_count");
				
				playCount++;
				
				sql = "update tracks set play_count = ? where track_id = ? returning play_count;";

				ps = conn.prepareStatement(sql);
				ps.setLong(1, playCount);
				ps.setInt(2, trackID);
				rs = ps.executeQuery();
				
				rs.next();
				
				if(rs.getLong("play_count") == playCount){
					
					return playCount;
				}

			}
		} catch(SQLException e) {
			
			log.info(e.getMessage());
			return -1L;
		}
		return -1L;
	}

	@Override
	public Track removeTrack(int trackID) throws SQLException {

		String sql = "delete from tracks where track_id = ? returning *;";
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, trackID);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				Track track = new Track(rs.getString("track_title"), rs.getString("album_title"),
						rs.getString("artist_name"));

				track.setTrackID(rs.getInt("track_id"));
				track.setPlayCount(rs.getLong("play_count"));
				
				return track;
			}
			
		
		} catch(SQLException e) {
			
			log.info(e.getMessage());
			return null;
		}
		return null;
	}

	@Override
	public long getPlayCount(int trackID) throws SQLException {

		String sql = "select play_count from tracks where track_id = ?;";
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, trackID);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				return rs.getLong("play_count");
			}
			
		
		} catch(SQLException e) {
			
			log.info(e.getMessage());
			return -1L;
		}
		return -1L;
	}

	@Override
	public List<Track> getTrack(int trackID, String trackTitle, String albumTitle, String artistName)
			throws SQLException {
		
		String sqlByID = "select * from tracks where track_id = ?;";
		
		String sqlBySearch = "select * from tracks where"
				+ " lower(track_title) like lower('%' + ? + '%')"
				+ "	and lower(album_title) like lower('%' + ? + '%')"
				+ "	and lower(artist_name) like lower('%' + ? + '%');";
		
		if(trackID > 0) {
			
						
		}
		
		return null;
	}

	/*@Override
	public Track getTrack(int trackID) throws SQLException {

		String sql = "select * from tracks where track_id = ?;";
		
		try(Connection conn = connUtil.createConnection()){
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, trackID);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				Track track = new Track(rs.getString("track_title"), rs.getString("album_title"),
						rs.getString("artist_name"));

				track.setTrackID(rs.getInt("track_id"));
				track.setPlayCount(rs.getLong("play_count"));
				
				return track;
			}
			
		
		} catch(SQLException e) {
			
			log.info(e.getMessage());
			return null;
		}
		return null;
	}

	@Override
	public List<Track> getAllTracks() throws SQLException {

		String sql = "select * from tracks order by track_id;";
		
		List<Track> trackList = new ArrayList<Track>();
		
		try(Connection conn = connUtil.createConnection()){
			
			ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Track track = new Track(rs.getString("track_title"), rs.getString("album_title"),
						rs.getString("artist_name"));

				track.setTrackID(rs.getInt("track_id"));
				track.setPlayCount(rs.getLong("play_count"));
				
				trackList.add(track);
			}
		
			return trackList;
			
		} catch(SQLException e) {
			
			log.info(e.getMessage());
			return null;
		}
	}*/
}
