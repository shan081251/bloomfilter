package org.trimps.bloomfilter.util.impl;

import java.util.HashSet;
import java.util.Set;

import org.trimps.bloomfilter.util.SimpleFilter;

public class SimpleHashSetFilter implements SimpleFilter {

	private static final Set<String> dataSet = new HashSet<String>(100000000);
	 
	
	public SimpleHashSetFilter() {
		
	}

	public boolean contains(String value) {
		// TODO Auto-generated method stub
		return dataSet.contains(value);
	}

	public void add(String value) {
		dataSet.add(value);
	}

	public long size() { 
		return dataSet.size();
	}

}
