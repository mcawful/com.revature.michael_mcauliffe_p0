package com.revature.michael_mcauliffe_p0.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.revature.michael_mcauliffe_p0.pojos.Track;

public class TrackCache<T> implements CacheService<Track> {
	
	private List<Track> cache = new ArrayList<Track>();
	
	public TrackCache() {
		
		super();
	}
	
	public TrackCache(List<Track> cache) {

		this.cache = cache;
	}

	@Override
	public void addToCache(Track track) {
		
		cache.add(track);
	}

	@Override
	public void removeFromCache(Track track) {
		
		cache.remove(track);
	}

	@Override
	public int positionInCache(Track track) {

		return cache.indexOf(track);
	}

	@Override
	public Track retreiveFromCache(int position) {
		
		return cache.get(position);
	}

	@Override
	public void emptyCache() {
		
		cache.clear();
	}

	@Override
	public boolean contains(Track track) {
		
		return cache.contains(track);
	}

	@Override
	public List<Track> retrieveAllItems() {
		
		return cache;
	}

	@Override
	public List<Track> retrieveMatching(Predicate<Track> p) {
		// TODO Add method to retrieve matching Tracks into a List
		return null;
	}
}
