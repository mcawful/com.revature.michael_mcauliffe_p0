package com.revature.michael_mcauliffe_p0.controllers;

import java.util.List;

import com.revature.michael_mcauliffe_p0.dao.TrackDao;
import com.revature.michael_mcauliffe_p0.dao.TrackDaoPostgres;
import com.revature.michael_mcauliffe_p0.pojos.Log;
import com.revature.michael_mcauliffe_p0.pojos.Track;
import com.revature.michael_mcauliffe_p0.service.TrackCache;

import io.javalin.http.Context;

public class TrackController {

	private Log log = new Log();
	
	private TrackCache<Track> trackCache = new TrackCache<Track>();
	
	public void addTrack(Context ctx) throws Exception {
		
		new Thread(() -> {log.info("Responding to add Track post request.");}).start();
		
		Track track = new Track();
		TrackDao trackDao = new TrackDaoPostgres();
		
		try{
			
			String trackTitle = ctx.formParam("track_title");
			String albumTitle = ctx.formParam("album_title");
			String artistName = ctx.formParam("artist_name");
			
			track = new Track(trackTitle, albumTitle, artistName);
			
			track = trackDao.addTrack(track);
			
			if(track != null) {
				
				this.trackCache.addToCache(track);
				
				ctx.html("The following track was added:\n\n"
						+ "Track ID: " + track.getTrackID()
						+ "\nTitle: " + track.getTrackTitle()
						+ "\nAlbum: " + track.getAlbumTitle()
						+ "\nArtist: " + track.getArtistName());
				
				ctx.status(201);
				
				new Thread(() -> {this.log.info("Track added successfully.\n");}).start();
			}
			
		} catch(Exception e) {
			
			ctx.status(400);
			ctx.html("Error processing request.");
			
			new Thread(() -> {log.info("Exception caught: " + e + "\n");}).start();
			
		}
	}

	public void updateTrack(Context ctx) throws Exception {
		
		new Thread(() -> {log.info("Responding to update Track post request.");}).start();
		
		Track track = new Track();
		TrackDao trackDao = new TrackDaoPostgres();
		
		try{
			
			int trackID = Integer.parseInt(ctx.formParam("track_id"));
			String trackTitle = ctx.formParam("track_title");
			String albumTitle = ctx.formParam("album_title");
			String artistName = ctx.formParam("artist_name");
			
			track = new Track(trackTitle, albumTitle, artistName);
			
			if(trackDao.updateTrack(trackID, track) != null) {

				this.trackCache.removeFromCache(trackID);
				
				track.setTrackID(trackID);
				this.trackCache.addToCache(track);
				
				
				
				ctx.html("The following track was updated:\n"
						+ "\nTrack ID: " + track.getTrackID()
						+ "\nTitle: " + track.getTrackTitle()
						+ "\nAlbum: " + track.getAlbumTitle()
						+ "\nArtist: " + track.getArtistName());
				
				new Thread(() -> {this.log.info("Track updated successfully.\n");}).start();
			}
			else {
				
				ctx.status(400);
				ctx.html("No track found with matching track ID. No update was performed.");
				
				new Thread(() -> {this.log.info("Attempted update with invalid track ID.\n");}).start();
				
			}
		} catch (NumberFormatException nfe) {
			
			ctx.html("Numeric input expected for track ID.");
			new Thread(() -> {log.info("Exception caught: " + nfe + "\n");}).start();
		}
		
		catch(Exception e) {

			ctx.html("Error processing request.");
			
			new Thread(() -> {log.info("Exception caught: " + e + "\n");}).start();
			
		} finally {
			
			ctx.status(400);
		}
	}
	
	public void removeTrack(Context ctx) throws Exception {
		
		new Thread(() -> {log.info("Responding to removing Track post request.");}).start();
		
		TrackDao trackDao = new TrackDaoPostgres();
		
		try {
			
			int trackID = Integer.parseInt(ctx.formParam("track_id"));
			
			Track track = trackDao.removeTrack(trackID);
			
			if(track != null) {
				
				this.trackCache.removeFromCache(trackID);
				
				ctx.html("The following track was removed:\n"
						+ "\nTrack ID: " + track.getTrackID()
						+ "\nTitle: " + track.getTrackTitle()
						+ "\nAlbum: " + track.getAlbumTitle()
						+ "\nArtist: " + track.getArtistName());
				
				new Thread(() -> {this.log.info("Track removed successfully.\n");}).start();
				
			}
			else {
				
				ctx.status(204);
				ctx.html("No track found with matching track ID.");
				new Thread(() -> {this.log.info("Attempted removal of non existent track.\n");}).start();				
			}
			
		} catch (NumberFormatException nfe) {
			
			ctx.html("Numeric input expected for track ID.");
			new Thread(() -> {log.info("Exception caught: " + nfe + "\n");}).start();
		
		} catch (Exception e) {

			ctx.html("Error processing request.");
			new Thread(() -> {log.info("Exception caught: " + e + "\n");}).start();
			
		} finally {
			
			ctx.status(400);
		}
	}

	public void getTrack(Context ctx) throws Exception {
		
		new Thread(() -> {log.info("Responding to get Track post request.");}).start();
		
		TrackDao trackDao = new TrackDaoPostgres();
		
		try {
			
			int trackID = Integer.parseInt(ctx.formParam("track_id"));
			
			Track track = trackDao.getTrack(trackID);
			
			if(track != null) {
				
				ctx.html("The following track was retrieved:\n"
						+ "\nTrack ID: " + track.getTrackID()
						+ "\nTitle: " + track.getTrackTitle()
						+ "\nAlbum: " + track.getAlbumTitle()
						+ "\nArtist: " + track.getArtistName());
				
				new Thread(() -> {this.log.info("Track was retrieved successfully.\n");}).start();
			}
			else {
				
				ctx.status(204);
				ctx.html("No track found with matching track ID.");
				
				new Thread(() -> {this.log.info("Attempted retrieval of non existent track.\n");}).start();				
			}
			
		} catch (NumberFormatException nfe) {
			
			ctx.html("Numeric input expected for track ID.");
			new Thread(() -> {log.info("Exception caught: " + nfe + "\n");}).start();
		
		} catch (Exception e) {

			ctx.html("Error processing request.");
			new Thread(() -> {log.info("Exception caught: " + e + "\n");}).start();
			
		} finally {
			
			ctx.status(400);
		}
	}

	public void getTrackList(Context ctx) throws Exception {
	
		new Thread(() -> {log.info("Responding to get all tracks get request.");}).start();
		
		TrackDao trackDao = new TrackDaoPostgres();
		
		try {
			
			List<Track> trackList = trackDao.getAllTracks();
			
			if(!trackList.isEmpty()) {
				
				String htmlResponse = "Current track list:\n\n";
				
				for(Track tempTrack : trackList) {
					
					htmlResponse += "[" + tempTrack.getTrackID() + "] "
									+ tempTrack.getTrackTitle() + " by "
									+ tempTrack.getArtistName() + "\n";
				}
				ctx.html(htmlResponse);
				
				new Thread(() -> {this.log.info("Full track list was retrieved successfully.\n");}).start();
			}
			else {
				
				ctx.html("No tracks have been uploaded");
			}
			ctx.status(200);
			
		} catch(Exception e) {
			
			ctx.status(400);
			ctx.html("Error processing request.");
			new Thread(() -> {log.info("Exception caught: " + e + "\n");}).start();
		}
	}
	
	public void syncWithDatabase() throws Exception {
		
		TrackDao trackDao = new TrackDaoPostgres();
		
		try {
			
			List<Track> trackList = trackDao.getAllTracks();
			
			for(Track tempTrack : trackList) {
				
				if(!trackCache.contains(tempTrack)) trackCache.addToCache(tempTrack);
			}
			new Thread(() -> {log.info("Track list synchronization successful.\n");}).start();
			//ctx.status(200);
			
		} catch(Exception e) {
			
			//ctx.status(500);
			//ctx.html("Local cache could not be synchronized with database.");
			new Thread(() -> {log.info("Exception caught: " + e + "\n");}).start();
		}
	}
}
