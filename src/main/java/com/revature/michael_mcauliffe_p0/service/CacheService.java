package com.revature.michael_mcauliffe_p0.service;

import java.util.List;
import java.util.function.Predicate;

public interface CacheService <T> {
	
	public void addToCache(T obj);
	
	public void removeFromCache(T obj);
	
	public T retreiveFromCache(T obj);
	
	public void emptyCache();
	
	public boolean contains(T obj);
	
	public List<T> retrieveAllItems();
	
	public List<T> retrieveMatching(Predicate<T> p);

}
