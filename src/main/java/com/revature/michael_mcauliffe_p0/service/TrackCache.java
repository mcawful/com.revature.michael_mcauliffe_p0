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
	
	public boolean removeFromCache(int trackID) {
		
		for(Track tempTrack : cache) {
			
			if(tempTrack.equals(trackID)) {
				
				return cache.remove(tempTrack);
			}
		}
		return false;
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
	
	public boolean equals(List<Track> testingCache) {
		
		return cache.equals(testingCache);
	}
	
	public boolean equals(TrackCache<Track> testingCache) {
		
		return cache.equals(testingCache.retrieveAllItems());
	}
}
