package com.revature.michael_mcauliffe_p0.service;

public interface PlayerControlsService<T> {

	public void play();
	
	public void play(T obj);
	
	public void pause();
	
	public void stop();
	
	public void next(T obj);
	
	public void previous(T obj);
}
