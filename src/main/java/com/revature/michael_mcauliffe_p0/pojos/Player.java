package com.revature.michael_mcauliffe_p0.pojos;

import com.revature.michael_mcauliffe_p0.service.PlayerControlsService;

public class Player implements PlayerControlsService<Track> {

	Track currentTrack;
	boolean isPlaying;
	
	public Player() {
		currentTrack = new Track();
		isPlaying = false;
	}
	
	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void play(Track track) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void next(Track track) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void previous(Track track) {
		// TODO Auto-generated method stub
		
	}

}
