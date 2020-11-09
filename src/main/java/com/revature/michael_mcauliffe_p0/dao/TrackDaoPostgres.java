package com.revature.michael_mcauliffe_p0.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.michael_mcauliffe_p0.pojos.Log;
import com.revature.michael_mcauliffe_p0.pojos.Track;
import com.revature.michael_mcauliffe_p0.util.ConnectionUtil;

public class TrackDaoPostgres implements TrackDao {

	private Log log = new Log();
	
	private PreparedStatement ps;
	
	private ConnectionUtil connUtil = new ConnectionUtil();
	
	public void setConnUtil(ConnectionUtil connUtil) {
		
		this.connUtil = connUtil;
	}
	
	@Override
	public Track addTrack(Track track) throws SQLException {

		String sql = "insert into tracks (track_title, album_title, artist_name, play_count)"
		+ " values (?, ?, ?, ?) returning *;";
		
		try(Connection conn = connUtil.createConnection()){
			
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
	public Track updateTrack(int trackID, Track track) {
		
		String sql = "update tracks set track_title = ?, album_title = ?, artist_name = ? "
				+ "where track_id = ? returning *;";

		try(Connection conn = connUtil.createConnection()){
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, track.getTrackTitle());
			ps.setString(2, track.getAlbumTitle());
			ps.setString(3, track.getArtistName());
			ps.setInt(4, trackID);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			track.setPlayCount(rs.getInt("play_count"));
			
			return track;
			
		} catch (SQLException e) {
			
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean incrementPlayCount(int trackID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Track removeTrack(int trackID) throws SQLException {

		String sql = "delete from tracks where track_id = ? returning *;";
		
		try(Connection conn = connUtil.createConnection()){
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, trackID);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				Track track = new Track(rs.getString("track_title"), rs.getString("album_title"),
						rs.getString("artist_name"));

				track.setTrackID(rs.getInt("track_id"));
				track.setPlayCount(rs.getInt("play_count"));
				
				return track;
			}
			
		
		} catch(SQLException e) {
			
			log.info(e.getMessage());
			return null;
		}
		return null;
	}

	@Override
	public int getPlayCount(int trackID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Track getTrack(int trackID) {

		String sql = "select * from tracks where track_id = ?;";
		
		try(Connection conn = connUtil.createConnection()){
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, trackID);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				Track track = new Track(rs.getString("track_title"), rs.getString("album_title"),
						rs.getString("artist_name"));

				track.setTrackID(rs.getInt("track_id"));
				track.setPlayCount(rs.getInt("play_count"));
				
				return track;
			}
			
		
		} catch(SQLException e) {
			
			log.info(e.getMessage());
			return null;
		}
		return null;
	}

	@Override
	public List<Track> getAllTracks() {
		// TODO Auto-generated method stub
		return null;
	}

}
