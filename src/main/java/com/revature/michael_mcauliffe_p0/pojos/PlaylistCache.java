package com.revature.michael_mcauliffe_p0.pojos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.revature.michael_mcauliffe_p0.service.CacheService;

public class PlaylistCache<T> implements CacheService<Playlist> {

	private List<Playlist> cache = new ArrayList<Playlist>();
	
	public PlaylistCache() {
		
		super();
	}
	
	public PlaylistCache(List<Playlist> cache) {

		this.cache = cache;
	}
	
	@Override
	public void addToCache(Playlist playlist) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFromCache(Playlist playlist) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int positionInCache(Playlist playlist) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Playlist retreiveFromCache(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void emptyCache() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Playlist playlist) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Playlist> retrieveAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Playlist> retrieveMatching(Predicate<Playlist> p) {
		// TODO Auto-generated method stub
		return null;
	}
}
