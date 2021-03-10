package com.revature.michael_mcauliffe_p0.main;
import com.revature.michael_mcauliffe_p0.controllers.TrackController;
import com.revature.michael_mcauliffe_p0.pojos.Log;

import io.javalin.Javalin;

public class ServerDriver {

	
	private static Log log = new Log();
	private static TrackController trackController = new TrackController();
	
	public static void main(String[] args) {
		
		new Thread(() -> {log.sessionStarted();}).start();
		Javalin app = Javalin.create().start(9090);
		
		try {
			trackController.syncWithDatabase();
			app.post("/track", ctx -> trackController.addTrack(ctx));
			app.delete("/track", ctx -> trackController.removeTrack(ctx));
			app.put("/track", ctx -> trackController.updateTrack(ctx));
			app.get("/track",  ctx -> trackController.getTrack(ctx));
			app.get("/getTrackList", ctx -> trackController.getTrackList(ctx));
		} catch (Exception e) {
			
			app.stop();
			e.printStackTrace();
		}
		
	}
}
