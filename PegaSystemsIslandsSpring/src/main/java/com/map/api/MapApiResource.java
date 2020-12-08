/**
 * 
 */
package com.map.api;

/**
 * @author Patrick
 * Resource configuration for mapping the JSON posted to the api call
 */
public class MapApiResource {

	private String map;
	private String strategy;
	
	//default constructor, required
	public MapApiResource() {
		super();
	}
	
	public MapApiResource(String map, String strategy) {
		this.map = map;
		this.strategy = strategy;
	}

	public String getMap() {
		return map;
	}

	public String getStrategy() {
		return strategy;
	}
	
	
}
