/**
 * 
 */
package com.map.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Patrick
 * Basic springboot application class
 */

@SpringBootApplication @ComponentScan(basePackages = { "com.map.api"} )
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
