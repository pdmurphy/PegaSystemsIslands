/**
 * 
 */
package com.map.evaluation;

/**
 * @author Patrick
 * Island evaluation class
 */
public class IslandEvaluation implements MapEvaluation {

	/**
	 * evaluates for islands represented as 1 in int[][] where 0 is water.
	 * If we wanted to be strict I could have added a check for if no strategy is passed in. 
	 * Always defaults to doing ortho, does omni as well if it is the strategy
	 */
	@Override
	public int evaluate(int[][] map, String strategy) {
		//Start our count with 0
		int islandCount = 0; 
		
		if(map == null || map.length == 0) {
			//quickly returns for empty maps
			return islandCount; 
		}

		//loop through each element of the map matrix
		for(int i = 0; i < map.length; i++) {
			
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 1 ) {
					islandCount += mapDepthSearch(map, i, j, strategy);
				}
			}
		}
		//return the final islandCount 
		return islandCount;
	}
	
	/**
	 * Recursive depth first search algorithm to search for islands
	 * @param map
	 * @param row
	 * @param column
	 * @param strategy
	 * @return 
	 */
	public int mapDepthSearch(int[][] map, int row, int column, String strategy) {
		if( row < 0 || row >= map.length || //check top and bottom bounds
				column < 0 || column >= map[row].length || //check left and right bounds
				map[row][column] == 0) /*check if value is 0/water */ { 
			return 0; //we don't care about water, return 0
		}
		
		map[row][column] = 0; //set this to 0 so that if we visit this space later, we don't double count it.
		
		//check orthogonal directions
		checkOrthogonalDirections(map, row, column, strategy);
		//all orthogonal directions checked, now if we are the other omnidirectional strategy we want to check diagonals
		if (strategy.toLowerCase().equals("omni")) { 
			//Just in case we get sent "omni" or "Omni" i sent to lowercase. 
			//the initial assignment prompt had "Omni" and "ortho" as examples
			//this could be changed to  whatever we want of course OMNIDIRECTIONAL, etc.
			checkDiagonalDirections(map, row, column, strategy);
		}
		//return since we found an island on map[row][column] 
		return 1;
	}
	
	/**
	 * Not completely necessary to make this helper but helps readability
	 * 
	 * @param map
	 * @param row
	 * @param column
	 * @param strategy
	 */
	public void checkOrthogonalDirections(int[][] map, int row, int column, String strategy ) {
		mapDepthSearch(map, row + 1, column, strategy);
		mapDepthSearch(map, row - 1, column, strategy );
		mapDepthSearch(map, row, column + 1, strategy);
		mapDepthSearch(map, row, column - 1, strategy);
	}
	
	/**
	 * Not completely necessary to make this helper but helps readability
	 * @param map
	 * @param row
	 * @param column
	 * @param strategy
	 */
	public void checkDiagonalDirections(int[][] map, int row, int column, String strategy ) {
		mapDepthSearch(map, row + 1, column - 1, strategy);
		mapDepthSearch(map, row + 1, column + 1, strategy);
		mapDepthSearch(map, row - 1, column - 1, strategy);
		mapDepthSearch(map, row - 1, column + 1, strategy);
	}
}
