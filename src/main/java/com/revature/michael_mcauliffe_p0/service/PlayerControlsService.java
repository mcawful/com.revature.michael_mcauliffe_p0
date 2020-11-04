package com.revature.michael_mcauliffe_p0.service;

public interface PlayerControlsService<T> {

	public void load(T obj);
	
	public void unload();
	
	public void play();
	
	public void pause();
}
