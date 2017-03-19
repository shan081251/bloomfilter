package org.trimps.bloomfilter.util;

public interface SimpleFilter {
	
	public boolean contains(String value);
	
	
	public void add(String value) ;
	
	public long size() ;
	
}
