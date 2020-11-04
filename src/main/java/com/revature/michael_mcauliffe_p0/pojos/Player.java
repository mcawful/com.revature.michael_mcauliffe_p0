package com.revature.michael_mcauliffe_p0.pojos;

import com.revature.michael_mcauliffe_p0.service.PlayerControlsService;

public class Player implements PlayerControlsService<Track> {

	private Track currentTrack;
	private boolean isPlaying;
	
	public Player() {
		
		this.currentTrack = null;
		this.isPlaying = false;
	}

	@Override
	public void load(Track track) {
		
		this.currentTrack = track;
	}

	@Override
	public void unload() {
		
		this.currentTrack = null;
	}

	@Override
	public void play() {
		
		this.isPlaying = true;
	}

	@Override
	public void pause() {
		
		this.isPlaying = false;
	}
	
	public boolean isPlaying() {
		
		return this.isPlaying;
	}
	
	public Track getCurrentTrack() {
		
		return this.currentTrack;
	}	
}
