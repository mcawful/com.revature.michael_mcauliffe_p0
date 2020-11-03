package com.revature.michael_mcauliffe_p0.pojos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import com.revature.michael_mcauliffe_p0.service.CacheService;

public class TrackCache<T> implements CacheService<Track> {
	
	private Set<T> cache = new HashSet<T>();
	
	public TrackCache() {
		
		super();
	}
	
	public TrackCache(Set<T> cache) {

		this.cache = cache;
	}

	@Override
	public void addToCache(Track obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFromCache(Track obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int positionInCache(Track obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Track retreiveFromCache(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void emptyCache() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Track obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Track> retrieveAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Track> retrieveMatching(Predicate<Track> p) {
		// TODO Auto-generated method stub
		return null;
	}
}
