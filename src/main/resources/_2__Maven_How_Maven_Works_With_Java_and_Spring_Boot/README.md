jar we can run through cmd but war we need to deploy on an external server.
jar - java Archive
war - Web Application Archive

Maven is a Build Automation Tool and Is used to make a build and manages a dependencies.

How Maven Manages dependencies (pom.xml - project object model)
---------------------------------------------------------------

suppose you want to use some external libraries. If not maven then u have to go to website download jar and need to 
import that jar in your project class path. a simplified way is you can use maven. 
so there is a maven repository where all jars you can find that.

=> just add dependency as a group-id, artifact-id and version then that jar will be available in your build path,
that is the managing dependencies.

=> Maven is a build automation tool. 

Maven has defined a build life cycle. 

Maven Build Life cycle
================
1. clean 
2. validate - validate the project is correct and all necessary information is available. 
              It will validate your pom.xml is looks good or not
3. compile -  compile the source code of project
4. test -    test the compiled source code using suitable unit testing framework.
5. package - Take the compiled code and package it in its distributable format such as JAR.
             It will convert either in jar or war.
6. verify -  Run any checks on results of integration tests to ensure quality criteria are met.             
             It will do Integration testing. 
7. install - Install the package into the local repository. for use as a dependency in other project locally.
8. deploy -  If you want to deploy in a remote repository you can do. done in the build environment,            
             copies the final package to the remote repository for developers and projects.


If you have not Installed Maven in your system then you can use maven wrapper as well.
--------------------------------------------------------------------------------------

go to terminal >>  [C O M M A N D S]

mvn validate
------------    
will validate our pom is written correctly or not. 

./mvnw validate
---------------    
If maven is not installed then use mvnw. i.e maven wrapper to use. maven wrapper is a part of spring boot.

mvn compile
-----------    
source code will get compiled into the target folder.

mvn test
--------
If you have written any tests then it will run/execute.

mvn package
-----------    
your compiled code build a jar and then you can run ur application  
- If you want to run your jar  
- - ls  
- - cd target  
- - ls  
- - java -jar journalApp-1.0-SNAPSHOT.jar

mvn verify
----------    
for integration testing

mvn install
-----------    
it will push our created jar into .m2 /repository folder.    
- so maven will put jar in local repository so next time no need to downlaod the jar for other projects.

mvn deploy
----------    
it will deploy

summary: simply write mvn package then it will validate, will compile, will run tests and create a jar.    
 
 