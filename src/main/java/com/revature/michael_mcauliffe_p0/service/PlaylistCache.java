package com.revature.michael_mcauliffe_p0.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.revature.michael_mcauliffe_p0.pojos.Playlist;

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
		
		cache.add(playlist);
	}

	@Override
	public void removeFromCache(Playlist playlist) {
		
		cache.remove(playlist);
	}

	@Override
	public int positionInCache(Playlist playlist) {
		
		return cache.indexOf(playlist);
	}

	@Override
	public Playlist retreiveFromCache(int position) {
		
		return cache.get(position);
	}

	@Override
	public void emptyCache() {
		
		cache.clear();
	}

	@Override
	public boolean contains(Playlist playlist) {
		
		return cache.contains(playlist);
	}

	@Override
	public List<Playlist> retrieveAllItems() {
		
		return cache;
	}

	@Override
	public List<Playlist> retrieveMatching(Predicate<Playlist> p) {
		// TODO Add method to retrieve matching Playlists into a List
		return null;
	}
}
