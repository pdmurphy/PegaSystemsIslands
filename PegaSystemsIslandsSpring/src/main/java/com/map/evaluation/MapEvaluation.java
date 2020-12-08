package com.map.evaluation;
/**
 * 
 */

/**
 * @author Patrick
 * Perhaps we have different ways to evaluate maps in the future.
 * Whether it is with a strategy pattern and have different classes in addition to IslandEvaluation
 * or additionally other types of calls we could want in the future.
 * For example: having 2's in the 'map' being a shipwreck 
 * Lots of potential changes could be done for the future.
 */

public interface MapEvaluation {

		
	/**
	 * @param map
	 * @param strategy
	 * @return Return the number of islands as an int
	 * Could rename this to "evaluate" but perhaps we would want a "evaluateShipwrecks" or "evaluateVolcanoes" in the future
	 */
	public int evaluate(int[][] map, String strategy);
	
}
