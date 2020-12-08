/**
 * 
 */
package com.map.api;

import org.springframework.web.bind.annotation.RestController;

import com.map.evaluation.IslandEvaluation;
import com.map.utility.MapUtility;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Patrick
 * Rest controller 
 * I did not bother to make unit tests for the rest controller and api calls to save time
 * as I did manual testing anyway.
 */
@RestController
public class MapRestController {

	/**
	 * URL to call this is http://localhost:8080/api/map/islands passing in json in the body
	 * ex { "map": "{ { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }}", "strategy":"omni"}
	 * @param resource
	 * @return islandCount as response
	 */
	@RequestMapping(value = "/api/map/islands", consumes = "application/json", 
			produces = "application/json", method = RequestMethod.POST)
	public int mapIslandsEvaluation(@RequestBody MapApiResource resource) {
		
		//Return 0 for empty maps "{{}}" or empty string ""
		if(resource.getMap().isEmpty() || (!resource.getMap().contains("0") && !resource.getMap().contains("1"))) {
			return 0;
		}
		MapUtility mapUtility = new MapUtility();
		IslandEvaluation evaluator = new IslandEvaluation();
		
		int[][] map = mapUtility.mapConverter(resource.getMap());
		int islandCount = evaluator.evaluate(map, resource.getStrategy());
		
		return islandCount;
	}
	
	/**
	 * Was used for initial testing to make sure things works. 
	 * Kept for manual testing checks if there are troubles with the json post call
	 * To access this go to http://localhost:8080/ once running
	 *  @return
	 */
	@RequestMapping("/")
	public String index() {
		return "Hello World";
	}
}