I would recommend building the project, but you can try to exectue the jar itself by doing:
java -jar target/PegaSystemsIslandsFramework-0.0.1-SNAPSHOT.jar
This jar is located in the directory named 'target'
I've found this is more prone to issues with java  depending on what version is running on your machine.

As mentioned, I would recommend building and running the application in the following manner:

NOTE: Depending on your setup for using maven
you may need to use either 'mvn' or 'mvnw' for the commands.

To run this project. 
run 'mvn clean install' in the top directory of the project

This should build the project and run the unit tests.

Once this passes, 
run 'mvn spring-boot:run' to run the application.
You should see some nice ASCII from spring like the following along with some other logger info

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.3.3.RELEASE)
 
 etc
 INFO 14764 --- [main] com.map.application.Application: Started Application 
 
 The service is now running!
 
 To get started, you can put this url in the browser of your choosing
 http://localhost:8080/
 This should give you a Hello World message
 
 For calling the island evaluation api
 the api expects the following:
 POST request to URL http://localhost:8080/api/map/islands
 passing in JSON as the body (Content-Type: application/json)
 The JSON expected format is as follows
 { "map" : "String representation of the map", "strategy" : "strategyName"}
 Here is an example:
 { "map": "{{ 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }}", "strategy":"omni"}
 
 The response should be just a singular number. In this case the return value would be 1
 
 The parsing is not fullproof by any means, as I didn't feel this to be the focus of the exercise.
 For example if the end of the map looks like  } }" the parsing will fail.
 
 

 