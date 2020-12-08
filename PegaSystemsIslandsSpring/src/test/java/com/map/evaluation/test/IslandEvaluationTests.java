package com.map.evaluation.test;

import static org.junit.Assert.*;

import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import com.map.evaluation.IslandEvaluation;

/**
 * @author Patrick
 * Tests the 
 */
public class IslandEvaluationTests {
	
	private static final String ORTHO = "ortho";
	private static final String OMNI = "omni";
	
	private IslandEvaluation islandEvaluator;
	private int[][] grid1;
	private int[][] grid2;
	private int[][] grid3;
	private int[][] grid4;
	private int[][] grid5;
	private int[][] emptyGrid;
	private int[][] oneSpaceGridWater;
	private int[][] oneSpaceGridIsland;
	
	
	
	@Before
	public void setUpBefore() throws Exception {
		
		islandEvaluator = new IslandEvaluation();
		//Took the first 5 grids from the assessment prompt
		 // Omni=7, ortho=7
		grid1 = new int[][] {
	            { 0, 0, 0, 0, 0, 0, 0, 0 },
	            { 0, 1, 1, 1, 0, 0, 0, 0 },
	            { 0, 1, 1, 0, 0, 0, 1, 0 },
	            { 0, 0, 1, 0, 0, 0, 1, 0 },
	            { 1, 0, 0, 0, 0, 0, 0, 0 },
	            { 1, 0, 0, 0, 1, 0, 1, 0 },
	            { 0, 0, 0, 0, 0, 0, 1, 0 },
	            { 0, 0, 1, 0, 1, 0, 0, 0 } };

	    // Omni=3, ortho=14
	    grid2 = new int[][] {
	            { 0, 0, 1, 0, 0, 0, 1, 0 },
	            { 0, 1, 0, 1, 0, 0, 1, 0 },
	            { 1, 0, 1, 0, 0, 0, 0, 0 },
	            { 0, 0, 0, 1, 0, 0, 0, 0 },
	            { 0, 0, 0, 0, 1, 0, 1, 0 },
	            { 0, 1, 0, 0, 0, 1, 0, 0 },
	            { 1, 0, 0, 0, 0, 1, 0, 0 },
	            { 0, 1, 1, 1, 1, 0, 0, 1 } };

	    // Omni=1, ortho=1
	    grid3 = new int[][] {
	            { 0, 0, 0 },
	            { 0, 1, 0 },
	            { 0, 0, 0 } };

	    // Omni=1, ortho=4
	    grid4 = new int[][] {
	            { 0, 1, 0 },
	            { 1, 0, 1 },
	            { 0, 1, 0 } };

	    // Omni=1, ortho=2
	    grid5 = new int[][] {
	            { 0, 1, 1 },
	            { 1, 0, 1 },
	            { 1, 1, 0 } };
	    
	    //Some extra corner case tests to double check        
	    // Omni=0, ortho=0
	   	emptyGrid = new int[][] {	  
	   	    	 {}
	   	     };
	   	// Omni=0, ortho=0        
	   	oneSpaceGridWater = new int[][] {	  
   	    	 {0}
   	     	};
   	    // Omni=1, ortho=1 	 
	   	oneSpaceGridIsland=  new int[][] {	  
  	    	 {1}
  	     };
	   	 
	}
	
	@Test
	public void orthogonalTests() {
		
		assertEquals(7, islandEvaluator.evaluate(grid1, ORTHO));
		assertEquals(14, islandEvaluator.evaluate(grid2, ORTHO));
		assertEquals(1, islandEvaluator.evaluate(grid3, ORTHO));
		assertEquals(4, islandEvaluator.evaluate(grid4, ORTHO));
		assertEquals(2, islandEvaluator.evaluate(grid5, ORTHO));
		assertEquals(0, islandEvaluator.evaluate(emptyGrid, ORTHO));
		assertEquals(0, islandEvaluator.evaluate(oneSpaceGridWater, ORTHO));
		assertEquals(1, islandEvaluator.evaluate(oneSpaceGridIsland, ORTHO));
		
	}
	
	@Test
	public void omnidirecationalTest() {
		assertEquals(7, islandEvaluator.evaluate(grid1, OMNI));
		assertEquals(3, islandEvaluator.evaluate(grid2, OMNI));
		assertEquals(1, islandEvaluator.evaluate(grid3, OMNI));
		assertEquals(1, islandEvaluator.evaluate(grid4, OMNI));
		assertEquals(1, islandEvaluator.evaluate(grid5, OMNI));
		assertEquals(0, islandEvaluator.evaluate(emptyGrid, OMNI));
		assertEquals(0, islandEvaluator.evaluate(oneSpaceGridWater, OMNI));
		assertEquals(1, islandEvaluator.evaluate(oneSpaceGridIsland, OMNI));
	}
	
	@Test
	public void omnidirecationalUppercaseTest() {
		assertEquals(1, islandEvaluator.evaluate(grid5, "Omni")); //testing the uppercase check
	}

}
