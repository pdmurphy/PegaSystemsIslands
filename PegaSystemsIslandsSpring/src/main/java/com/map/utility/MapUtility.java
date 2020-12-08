/**
 * 
 */
package com.map.utility;

/**
 * @author Patrick
 *
 */
public class MapUtility {

	/**
	 * Just a bit of a dirty way to convert the string into the int[][] array
	 * It could have more sanitizing and things of that nature, but isn't the focus of the exercise
	 * @param map
	 * @return
	 */
	public int[][] mapConverter(String map) {
		
		///get rid of first and last curly brace
		map = map.substring(1, map.length()-2);
		//get rid of all front curly braces
		map = map.replace("{",  "");
		//get rid of spaces
		map = map.replace(" ",  "");
		//split into groups
		String[] rows = map.split("},");
		
		int width = rows.length;
		//look to see how big each row group is
		String[] column1 = rows[0].split(",");
		int height = column1.length;
		//created our int array
		int[][] convertedMap = new int[width][height];
		
		for(int i = 0; i < width; i++) {
			String[] values = rows[i].split(",");
			for(int j= 0; j < height; j++) {
		        convertedMap[i][j] = Integer.parseInt(values[j]);
		    }
		}
		
		return convertedMap;
	}
}
