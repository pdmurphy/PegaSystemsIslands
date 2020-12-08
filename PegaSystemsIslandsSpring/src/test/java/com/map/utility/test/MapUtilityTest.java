/**
 * 
 */
package com.map.utility.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.map.utility.MapUtility;

/**
 * @author Patrick
 * 
 */
public class MapUtilityTest {
	
	private MapUtility mapUtility;
	
	@Before
	public void setUpBefore() throws Exception {
		mapUtility = new MapUtility();
	}
	
	@Test
	public void mapConverterTest() {
		String map = "{{ 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }}";
		
		int[][] result = mapUtility.mapConverter(map);
		
		int[][] compare =  {
            { 0, 0, 0 },
            { 0, 1, 0 },
            { 0, 0, 0 } };
		assertEquals(compare.length, result.length);
		assertEquals("[0, 0, 0]", Arrays.toString(result[0]));
		assertEquals(Arrays.toString(compare[0]), Arrays.toString(result[0]));
		assertEquals(Arrays.toString(compare[1]), Arrays.toString(result[1]));
		assertEquals(Arrays.toString(compare[2]), Arrays.toString(result[2]));
		
		map = "{{ 0, 0, 0, 0, 0, 0, 0, 0 },{ 0, 1, 1, 1, 0, 0, 0, 0 },{ 0, 1, 1, 0, 0, 0, 1, 0 }, "
				+ "{ 0, 0, 1, 0, 0, 0, 1, 0 },{ 1, 0, 0, 0, 0, 0, 0, 0 },{ 1, 0, 0, 0, 1, 0, 1, 0 },"
				+ "{ 0, 0, 0, 0, 0, 0, 1, 0 },{ 0, 0, 1, 0, 1, 0, 0, 0 }}";
		
		int[][] result2 = mapUtility.mapConverter(map);
		
		int[][] compare2 =  {
	            { 0, 0, 0, 0, 0, 0, 0, 0 },
	            { 0, 1, 1, 1, 0, 0, 0, 0 },
	            { 0, 1, 1, 0, 0, 0, 1, 0 },
	            { 0, 0, 1, 0, 0, 0, 1, 0 },
	            { 1, 0, 0, 0, 0, 0, 0, 0 },
	            { 1, 0, 0, 0, 1, 0, 1, 0 },
	            { 0, 0, 0, 0, 0, 0, 1, 0 },
	            { 0, 0, 1, 0, 1, 0, 0, 0 } };
		
		assertEquals(compare2.length, result2.length);
		assertEquals(Arrays.toString(compare2[0]), Arrays.toString(result2[0]));
		assertEquals(Arrays.toString(compare2[1]), Arrays.toString(result2[1]));
		assertEquals(Arrays.toString(compare2[2]), Arrays.toString(result2[2]));
		
	}

}
