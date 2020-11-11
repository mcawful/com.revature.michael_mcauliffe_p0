package com.revature.michael_mcauliffe_p0.main;
import com.revature.michael_mcauliffe_p0.controllers.TrackController;
import com.revature.michael_mcauliffe_p0.pojos.Log;

import io.javalin.Javalin;

public class ServerDriver {

	
	private static Log log = new Log();
	private static TrackController trackController = new TrackController();
	
	private static final String TRACK_PATH = "/track";
	
	public static void main(String[] args) {
		
		new Thread(() -> {log.sessionStarted();}).start();
		Javalin app = Javalin.create().start(9090);
		
		try {
			trackController.syncWithDatabase();
			app.post(TRACK_PATH, ctx -> trackController.addTrack(ctx));
			app.put(TRACK_PATH, ctx -> trackController.updateTrack(ctx));
			app.delete(TRACK_PATH, ctx -> trackController.removeTrack(ctx));
			app.get(TRACK_PATH,  ctx -> trackController.getTrack(ctx));
			app.get("/getTrackList", ctx -> trackController.getTrackList(ctx));
		} catch (Exception e) {
			
			app.stop();
			e.printStackTrace();
		}
		
	}
}
