Maven Phases
=============

Although hardly a comprehensive list, these are the most common default lifecycle phases executed.

validate: validate the project is correct and all necessary information is available
compile: compile the source code of the project
test: test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
package: take the compiled code and package it in its distributable format, such as a JAR.
integration-test: process and deploy the package if necessary into an environment where integration tests can be run
verify: run any checks to verify the package is valid and meets quality criteria
install: install the package into the local repository, for use as a dependency in other projects locally
deploy: done in an integration or release environment, copies the final package to the remote repository for sharing with other developers and projects.
There are two other Maven lifecycles of note beyond the default list above. They are

clean: cleans up artifacts created by prior builds
site: generates site documentation for this project
Phases are actually mapped to underlying goals. The specific goals executed per phase is dependant upon the packaging type of the project. For example, package executes jar:jar if the project type is a JAR, and war:war if the project type is - you guessed it - a WAR.

An interesting thing to note is that phases and goals may be executed in sequence.

mvn clean dependency:copy-dependencies package
This command will clean the project, copy dependencies, and package the project (executing all phases up to package, of course).

Generating the Site
mvn site
This phase generates a site based upon information on the project's pom. You can look at the documentation generated under target/site.

Conclusion
We hope this quick overview has piqued your interest in the versatility of Maven. Note that this is a very truncated quick-start guide. Now you are ready for more comprehensive details concerning the actions you have just performed. Check out the Maven Getting Started Guide.





Lab 1: - Command Prompt based interactice simple maven project
==============================================================





create maven_workspace folder...
go inside folder and open cmd prompt

<<< - >>>
mvn archetype:generate  --create maven project where archetype is a plugin and generate is a maven goal.
*** archetype is a skeleton/blueprint/template or a project structure.
*** In maven groupId, artifactId and versionId ..all are the cordinates of our maven project.
*** groupId - reverse of a domain name like com.mycompany
*** artifactId - name of a project.
*** project co-ordinates are groupId, artifactId and versionId.
pom.xml - project object model.

part of pom.xml
---------------
======================================================================================================================

<build>
    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
      <plugins>
        <!-- clean lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#clean_Lifecycle -->
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.1.0</version>
        </plugin>
        <!-- default lifecycle, jar packaging: see https://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_jar_packaging -->
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.22.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-jar-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>
        <!-- site lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#site_Lifecycle -->
        <plugin>
          <artifactId>maven-site-plugin</artifactId>
          <version>3.7.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-project-info-reports-plugin</artifactId>
          <version>3.0.0</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
							
======================================================================================================================

Note :- this section is required for how we want to build this entire project. So if there are any Java compiler of Java file you want to compile them. Any HTML and JSP of the bundle in war file, JAR file, an ear file whatever all that information is spread over. Here you can see there's a lot of plugins described over here. In Plug in there is artifact ID and a version to the plug in its Maven compiler plugin, right?
So all these guys, these are plugged in.
--------------------------------------------------
Maven is as its heart of pluggin execution framework.
----------------------------------------------------

*** The real task is actually done by the plugins. Like compilation or like jar creation or like deploying right. All these are done by the plugins in. In order to create any sensible output of this project you will need all these plugins together.

*** That's why the build section has been included in your pom.xml.


*** To Compile maven project -  mvn complile                --go inside project folder and execute this command // C:\maven_workspace\TestProj1
Note- download will happen only one time.
If u want to see the downloaded plugin u can see in directory -> C:\Users\kaushal_kumar1\.m2\repository\org\apache\maven\plugins\maven-compiler-plugin\3.8.0
-- once we do the mvn compile, inside our project target folder will create and compiled class will place inside a target/classes folder.

*** To clean project/remove target folder - mvn clean
Note- deleting the target folder.
It delete the products of the previous builds.

***  - mvn package
Note - along with the target folder it will create a executable jar file also.

***  - mvn test
Note - you can see this time a target folder is created but jar is not created.
-- test cases are executed, surefire-report is creted for how many test-cases pass or failed but jar is not created and all the other things are created.

***  - mvn compile
Note- compile will just compile your java to class file inside target folder.

Observation - when we did the mvn test we only expected test to be run. but you can see it is compiling also then executing all test cases and showing test case details in surefire-report inside target folder.

mvn compile -    only compile happened
mvn test -       both compile and test happened.
mvn package -    first compile, execute test-cases then create a jar.
mvn clean compile test package  - it will execute all one-by-one.
mvn clean package - it will clean, compile, test and then package.   (package = compile+test+jar creation).

*** To execute a Jar file (go to a target folder)

	java -cp TestProj1-1.0-SNAPSHOT.jar com.mycompany.App
	
	Note- This is how we can run the normal java file within the jar.
	** if i do some code change and run the jar again it won't reflect the changes bcz what we need to do is we need to go back to our project folder and we need to run command - mvn clean package. so it will create a new jar and then we need to go to target folder and run a command - java -cp TestProj1-1.0-SNAPSHOT.jar com.mycompany.App 




											Lab 2: - Command Prompt based non-interactice simple maven project
											==================================================================



mvn archetype:generate -DgroupId={project-packaging}
-DartifactId={project-name}
-DarchetypeArtifactId=maven-archetype-quickstart
-DinteractiveMode=false
-DarchetypeVersion=1.4


mvn archetype:generate -DgroupId=com.company -DartifactId=TestProj2 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false -DarchetypeVersion=1.4

>> go inside maven_workspace and execute this command.





**************************************************
Maven Plugins, Goals and LifeCycle
**************************************************

A Lifecycle might have multiple Phases.
A Phase is a group of Goals. A Collection of goals is called as a phase.
A Goal is a task level details given by the plugin. A Goals is nothing but a plugin tasks given by the plugin.
Note- Maven does all of his work through the plugins. Goal is like a task level details like compilation, cleaning... A Goals is nothing but a plugin tasks given by the plugin.

Summary-
Lifecycle - broadest unit.
Phase - A Stage in the lifecycle.
Goal - A plugin goal represents a specific tasks.


default Lifecycles in Maven
--------------------------
• default - handles your project deployment
• clean - handles project cleaning
• site - handles the creation of your project's site documentation

Lifecycle phases (these are some phases but the lifecycle contains many more phases)
---------------------------------------------------------------------------------------------
• validate - validate the project is correct and all necessary information is available
• compile - compile the source code of the project
• test - test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed.
• package - take the compiled code and package it in its distributable format, such as a JAR.
• verify - run any checks on results of integration tests to ensure quality criteria are met
• install - install the package into the local repository, for use as a dependency in other projects locally
*** Inside (.m2/repository) local repository our application jar file will be created so any other project can use.
• deploy - done in the build environment, copies the final package to the remote repository for sharing with other developers and projects.

Clean Lifecycle Phases
-----------------------
pre-clean - execute processes needed prior to the actual project cleaning
clean - remove all files generated by the previous build
post-clean - execute processes needed to finalize the project cleaning

Note*** since clean is not in our default life cycle. Actually clean is in other life cycle thats why we are using explicitely maven clean package or maven clean install....


Site Lifecycle
----------------
pre-site - execute processes needed prior to  the actual project site generation
site - generate the project's site documentation
post-site - execute processes needed to  finalize the site generation, and to  prepare for site deployment
site-deploy deploy the generated site documentation to the specified web server.

Maven Coordinates
------------------
• The Archetype plugin created a project with a file named pom.xml.
• This is the Project Object Model (POM), a declarative description of a project
• Maven coordinates define a set of identifiers which can be used to uniquely identify a project
- groupId
- artifactId
- Version (Snapshot/1.x/2.x)
- Packaging (jar/war/ear/pom)

***Note- If u see in our pom.xml we are not defining <package> tag because by default maven will use jar as a packaging...

Maven Co-ordinates
-------------------
• groupId
- The group, company, team, organization, project, or other group
- The convention for group identifiers is that they begin with the reverse domain name of the organization that creates the project
- Project groupid created by apache would be org.apache.maven
• artifactId
- A unique identifier under groupId that represents a single project
• version
- A specific release of a project.
- Projects that have been released have a fixed version identifier that refers to a specific version of the project.
- Projects undergoing active development can use a special identifier that marks a version as a SNAPSHOT
• Packaging
- Jar/war/ear/pom




											Lab 3: - Command Prompt based non-interactice web project
											==================================================================


mvn archetype:generate -DgroupId={project-packaging}
-DartifactId={project-name}
-DarchetypeArtifactId=maven-archetype-webapp
-DinteractiveMode=false
-DarchetypeVersion=1.4


mvn archetype:generate -DgroupId=com.company -DartifactId=TestProj3 -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false -DarchetypeVersion=1.4

*** Note- If you observed here this time a packaging element is given here in pom.xml
<groupId>com.company</groupId>
<artifactId>TestProj3</artifactId>
<version>1.0-SNAPSHOT</version>
<packaging>war</packaging>

	*** By default packaging will be a jar.
  

	*** If you want to add any dependency like log4j and all...then you need to specify that maven dependency in pom.xml and that dependency should be 	available in local repository like (.m2/repository... folder).
	
    if u will add any dependency in pom.xml then maven first of all will look that dependency in local repository(.m2/repository...) then it will go and download from a maven central repository.
	*** after adding dependencies in pom.xml go and run a maven command(mvn clean package) then it will download the jar from central repository to your local repository like .m2 folder...so later u can run ur application offline as well.


Maven Dependency Management
----------------------------
• Ability to locate an artifact in a repository based on Maven coordinates
<dependencies>
<dependency>
<groupId>junit</groupId>
<artifactId>junit</artifactId>
<version>3.8.1</version>
<scope>test</scope>
</dependency>
</dependencies>



Dependency Scopes
==================
	compile - This is default scope. This scope indicates that dependency is available in classpath of project. It is default scope.
	provided - This scope indicates that dependency is to be provided by JDK or webServer/Container at runtime
	runtime - This scope indicates that dependency is not required for compilation, but is required during execution.
	test - This scope indicates that the dependency is only available for the test compilation and execution phases.
	system - This scope indicates that the dependency is not required for normal use of the application, and is only available for the test compilation and execution phases. 
	import - This scope is only used when dependency is of type pom. This scopes indicates that the specified POM should be replaced with the dependencies in that POM's <dependencyManagement> section.
	
	*** provided scope means - we have like jdk, tomcat these all like external conatiner they also have their own jar providing. maven is not going to download the dependency from central repository at compile time/runtime/st test execution...instead jdk and tomcat container already provided artifact
	
	*** system scope - is very similar to provided. if u have ur own jar whatever jar u have downloaded or u have it itself u will provide it as a system scope. that way also maven is not going to downlaod the jar from maven central repository.so this artifact will be always available and not going to looked up in a repository.this time the provider is you not the container(jdk,tomcat).


Dependency Scopes - In details
-------------------------------


Dependency scopes can help to limit the transitivity of the dependencies. They also modify the classpath for different build tasks. Maven has six default dependency scopes.

And it’s important to understand that each scope — except for import — has an impact on transitive dependencies.

Compile
----------

This is the default scope when no other scope is provided.

Dependencies with this scope are available on the classpath of the project in all build tasks. They are also propagated to the dependent projects.

More importantly, these dependencies are also transitive:

<dependency> 
    <groupId>org.apache.commons</groupId> 
    <artifactId>commons-lang3</artifactId> 
    <version>3.14.0</version> 
</dependency>


Provided
-----------

We use this scope to mark dependencies that should be provided at runtime by JDK or a container.

A good use case for this scope would be a web application deployed in some container, where the container already provides some libraries itself. For example, this could be a web server that already provides the Servlet API at runtime.

In our project, we can define those dependencies with the provided scope:

<dependency>
    <groupId>jakarta.servlet</groupId>
    <artifactId>jakarta.servlet-api</artifactId>
    <version>6.0.0</version>
    <scope>provided</scope>
</dependency>

The provided dependencies are available only at compile time and in the test classpath of the project. These dependencies are also not transitive.


Runtime
-------


The dependencies with this scope are required at runtime. But we don’t need them for the compilation of the project code. Because of that, dependencies marked with the runtime scope will be present in the runtime and test classpath, but they will be missing from the compile classpath.

A JDBC driver is a good example of dependencies that should use the runtime scope:

<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.28</version>
    <scope>runtime</scope>
</dependency>


Test
-----


We use this scope to indicate that dependency isn’t required at standard runtime of the application but is used only for test purposes.

Test dependencies aren’t transitive and are only present for test and execution classpaths.

The standard use case for this scope is adding a test library such as JUnit to our application:

<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
</dependency>


System
-------

System scope is very similar to the provided scope. The main difference is that system requires us to directly point to a specific jar on the system.

It’s worthwhile to mention that system scope is deprecated.

The important thing to remember is that building the project with system scope dependencies may fail on different machines if dependencies aren’t present or are located in a different place than the one systemPath points to:

<dependency>
    <groupId>com.baeldung</groupId>
    <artifactId>custom-dependency</artifactId>
    <version>1.3.2</version>
    <scope>system</scope>
    <systemPath>${project.basedir}/libs/custom-dependency-1.3.2.jar</systemPath>
</dependency>


import
------------

It’s only available for the dependency type pom.

import indicates that this dependency should be replaced with all effective dependencies declared in its POM.

Here, below custom-project dependency will be replaced with all dependencies declared in custom-project’s pom.xml <dependencyManagement> section.

<dependency>
    <groupId>com.baeldung</groupId>
    <artifactId>custom-project</artifactId>
    <version>1.3.2</version>
    <type>pom</type>
    <scope>import</scope>
</dependency>


	
========================================================================================================================================================================================================

																		***************************
																			Project & Dependencies
																		***************************


Aggregator project /Multi-modules project / parent pom
-------------------------------------------------------

*** What is POM , Super POM and Minimal POM
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

A Project Object Model or POM is the fundamental unit of work in Maven. It is an XML file that contains information about the project and configuration details used by Maven to build the project. It contains default values for most projects. Examples for this is the build directory, which is target; the source directory, which is src/main/java; the test source directory, which is src/test/java; and so on. When executing a task or goal, Maven looks for the POM in the current directory. It reads the POM, gets the needed configuration information, then executes the goal.

Some of the configuration that can be specified in the POM are the project dependencies, the plugins or goals that can be executed, the build profiles, and so on. Other information such as the project version, description, developers, mailing lists and such can also be specified.

**********
Super POM
**********
The Super POM is Maven's default POM. All POMs extend the Super POM unless explicitly set, meaning the configuration specified in the Super POM is inherited by the POMs you created for your projects.

You can see the Super POM definition below----->>>
Note ::-- All models implicitly inherit from a super-POM:

[[ SUPER POM ]]

<project>
  <modelVersion>4.0.0</modelVersion>

  <repositories>
    <repository>
      <id>central</id>
      <name>Central Repository</name>
      <url>https://repo.maven.apache.org/maven2</url>
      <layout>default</layout>
      <snapshots>
        <enabled>false</enabled>
      </snapshots>
    </repository>
  </repositories>

  <pluginRepositories>
    <pluginRepository>
      <id>central</id>
      <name>Central Repository</name>
      <url>https://repo.maven.apache.org/maven2</url>
      <layout>default</layout>
      <snapshots>
        <enabled>false</enabled>
      </snapshots>
      <releases>
        <updatePolicy>never</updatePolicy>
      </releases>
    </pluginRepository>
  </pluginRepositories>

  <build>
    <directory>${project.basedir}/target</directory>
    <outputDirectory>${project.build.directory}/classes</outputDirectory>
    <finalName>${project.artifactId}-${project.version}</finalName>
    <testOutputDirectory>${project.build.directory}/test-classes</testOutputDirectory>
    <sourceDirectory>${project.basedir}/src/main/java</sourceDirectory>
    <scriptSourceDirectory>${project.basedir}/src/main/scripts</scriptSourceDirectory>
    <testSourceDirectory>${project.basedir}/src/test/java</testSourceDirectory>
    <resources>
      <resource>
        <directory>${project.basedir}/src/main/resources</directory>
      </resource>
    </resources>
    <testResources>
      <testResource>
        <directory>${project.basedir}/src/test/resources</directory>
      </testResource>
    </testResources>
    <pluginManagement>
      <!-- NOTE: These plugins will be removed from future versions of the super POM -->
      <!-- They are kept for the moment as they are very unlikely to conflict with lifecycle mappings (MNG-4453) -->
      <plugins>
        <plugin>
          <artifactId>maven-antrun-plugin</artifactId>
          <version>1.3</version>
        </plugin>
        <plugin>
          <artifactId>maven-assembly-plugin</artifactId>
          <version>2.2-beta-5</version>
        </plugin>
        <plugin>
          <artifactId>maven-dependency-plugin</artifactId>
          <version>2.8</version>
        </plugin>
        <plugin>
          <artifactId>maven-release-plugin</artifactId>
          <version>2.5.3</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>

  <reporting>
    <outputDirectory>${project.build.directory}/site</outputDirectory>
  </reporting>

  <profiles>
    <!-- NOTE: The release profile will be removed from future versions of the super POM -->
    <profile>
      <id>release-profile</id>

      <activation>
        <property>
          <name>performRelease</name>
          <value>true</value>
        </property>
      </activation>
 
      <build>
        <plugins>
          <plugin>
            <inherited>true</inherited>
            <artifactId>maven-source-plugin</artifactId>
            <executions>
              <execution>
                <id>attach-sources</id>
                <goals>
                  <goal>jar-no-fork</goal>
                </goals>
              </execution>
            </executions>
          </plugin>
          <plugin>
            <inherited>true</inherited>
            <artifactId>maven-javadoc-plugin</artifactId>
            <executions>
              <execution>
                <id>attach-javadocs</id>
                <goals>
                  <goal>jar</goal>
                </goals>
              </execution>
            </executions>
          </plugin>
          <plugin>
            <inherited>true</inherited>
            <artifactId>maven-deploy-plugin</artifactId>
            <configuration>
              <updateReleaseInfo>true</updateReleaseInfo>
            </configuration>
          </plugin>
        </plugins>
      </build>
    </profile>
  </profiles>

</project>


***********
Minimal POM
***********

The minimum requirement for a POM are the following:

project root
modelVersion - should be set to 4.0.0
groupId - the id of the project's group.
artifactId - the id of the artifact (project)
version - the version of the artifact under the specified group
Here's an example:

<project>
  <modelVersion>4.0.0</modelVersion>

<groupId>com.mycompany.app</groupId>
<artifactId>my-app</artifactId>
<version>1</version>
</project>

A POM requires that its groupId, artifactId, and version be configured. These three values form the project's fully qualified artifact name. This is in the form of <groupId>:<artifactId>:<version>. As for the example above, its fully qualified artifact name is "com.mycompany.app:my-app:1".

Also, as mentioned in the first section, if the configuration details are not specified, Maven will use their defaults. One of these default values is the packaging type. Every Maven project has a packaging type. If it is not specified in the POM, then the default value "jar" would be used.

Furthermore, you can see that in the minimal POM the repositories were not specified. If you build your project using the minimal POM, it would inherit the repositories configuration in the Super POM. Therefore when Maven sees the dependencies in the minimal POM, it would know that these dependencies will be downloaded from https://repo.maven.apache.org/maven2 which was specified in the Super POM.



********************************************
Project Inheritance vs Project Aggregation
********************************************

Project Inheritance
===================
Elements in the POM that are merged are the following:

dependencies
developers and contributors
plugin lists (including reports)
plugin executions with matching ids
plugin configuration
resources
The Super POM is one example of project inheritance, however you can also introduce your own parent POMs by specifying the parent element in the POM, as demonstrated in the following examples.

Example 1
---------


The Scenario
-----------
As an example, let us reuse our previous artifact, com.mycompany.app:my-app:1. And let us introduce another artifact, com.mycompany.app:my-module:1.

<project>
  <modelVersion>4.0.0</modelVersion>

<groupId>com.mycompany.app</groupId>
<artifactId>my-module</artifactId>
<version>1</version>
</project>

And let us specify their directory structure as the following:

.
|-- my-module
|   `-- pom.xml
`-- pom.xml
Note: my-module/pom.xml is the POM of com.mycompany.app:my-module:1 while pom.xml is the POM of com.mycompany.app:my-app:1



The Solution
-------------
Now, if we were to turn com.mycompany.app:my-app:1 into a parent artifact of com.mycompany.app:my-module:1,we will have to modify com.mycompany.app:my-module:1's POM to the following configuration:

com.mycompany.app:my-module:1's POM

<project>
  <modelVersion>4.0.0</modelVersion>

  <parent>
    <groupId>com.mycompany.app</groupId>
    <artifactId>my-app</artifactId>
    <version>1</version>
  </parent>

<groupId>com.mycompany.app</groupId>
<artifactId>my-module</artifactId>
<version>1</version>
</project>

Notice that we now have an added section, the parent section. This section allows us to specify which artifact is the parent of our POM. And we do so by specifying the fully qualified artifact name of the parent POM. With this setup, our module can now inherit some of the properties of our parent POM.

Alternatively, if you want the groupId or the version of your modules to be the same as their parents, you can remove the groupId or the version identity of your module in its POM.

<project>
  <modelVersion>4.0.0</modelVersion>

  <parent>
    <groupId>com.mycompany.app</groupId>
    <artifactId>my-app</artifactId>
    <version>1</version>
  </parent>

<artifactId>my-module</artifactId>
</project>
This allows the module to inherit the groupId or the version of its parent POM.



Example 2
------------

The Scenario
------------
However, that would work if the parent project was already installed in our local repository or was in that specific directory structure (parent pom.xml is one directory higher than that of the module's pom.xml).

But what if the parent is not yet installed and if the directory structure is as in the following example?

.
|-- my-module
|   `-- pom.xml
`-- parent
`-- pom.xml


The Solution
------------
To address this directory structure (or any other directory structure), we would have to add the <relativePath> element to our parent section.

<project>
  <modelVersion>4.0.0</modelVersion>

  <parent>
    <groupId>com.mycompany.app</groupId>
    <artifactId>my-app</artifactId>
    <version>1</version>
    <relativePath>../parent/pom.xml</relativePath>
  </parent>

<artifactId>my-module</artifactId>
</project>
As the name suggests, it's the relative path from the module's pom.xml to the parent's pom.xml.




Project Aggregation
===================


Project Aggregation is similar to Project Inheritance. But instead of specifying the parent POM from the module, it specifies the modules from the parent POM. By doing so, the parent project now knows its modules, and if a Maven command is invoked against the parent project, that Maven command will then be executed to the parent's modules as well. To do Project Aggregation, you must do the following:

Change the parent POMs packaging to the value "pom".
Specify in the parent POM the directories of its modules (children POMs).


Example 3
----------

The Scenario
--------------
Given the previous original artifact POMs and directory structure:

com.mycompany.app:my-app:1's POM

<project>
  <modelVersion>4.0.0</modelVersion>

<groupId>com.mycompany.app</groupId>
<artifactId>my-app</artifactId>
<version>1</version>
</project>

com.mycompany.app:my-module:1's POM

<project>
  <modelVersion>4.0.0</modelVersion>

<groupId>com.mycompany.app</groupId>
<artifactId>my-module</artifactId>
<version>1</version>
</project>
directory structure

.
|-- my-module
|   `-- pom.xml
`-- pom.xml


The Solution
-------------

If we are to aggregate my-module into my-app, we would only have to modify my-app.

<project>
  <modelVersion>4.0.0</modelVersion>

<groupId>com.mycompany.app</groupId>
<artifactId>my-app</artifactId>
<version>1</version>
<packaging>pom</packaging>

  <modules>
    <module>my-module</module>
  </modules>
</project>


In the revised com.mycompany.app:my-app:1, the packaging section and the modules sections were added. For the packaging, its value was set to "pom", and for the modules section, we have the element <module>my-module</module>. The value of <module> is the relative path from the com.mycompany.app:my-app:1 to com.mycompany.app:my-module:1's POM (by practice, we use the module's artifactId as the module directory's name).

Now, whenever a Maven command processes com.mycompany.app:my-app:1, that same Maven command would be ran against com.mycompany.app:my-module:1 as well. Furthermore, some commands (goals specifically) handle project aggregation differently.



Example 4
----------

The Scenario
But what if we change the directory structure to the following:

.
|-- my-module
|   `-- pom.xml
`-- parent
`-- pom.xml
How would the parent POM specify its modules?


The Solution
-------------

The answer? - the same way as Example 3, by specifying the path to the module.

<project>
  <modelVersion>4.0.0</modelVersion>

<groupId>com.mycompany.app</groupId>
<artifactId>my-app</artifactId>
<version>1</version>
<packaging>pom</packaging>

  <modules>
    <module>../my-module</module>
  </modules>
</project>




Note ******** In multimodule project instead of doing maven build for all the modules so just need to build for a main project.

-- Right click on Main project pom.xml-> Run AS -> Maven build -> Goal as a clean package or in Intellij Right Side click on clean and then package.

Reactor Build Order:
[INFO]
[INFO] MainProject                                                        [pom]
[INFO] DataAccessModule                                                   [jar]
[INFO] ServiceModule                                                      [jar]
[INFO]
[INFO] -------------------< org.example.parent:MainProject >-------------------
[INFO] Building MainProject 1.0-SNAPSHOT                                  [1/3]
[INFO]   from pom.xml
[INFO] --------------------------------[ pom ]---------------------------------
[INFO]
[INFO] ----------------< org.example.module:DataAccessModule >-----------------
[INFO] Building DataAccessModule 1.0-SNAPSHOT                             [2/3]
[INFO]   from DataAccessModule\pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] ------------------< org.example.module:ServiceModule >------------------
[INFO] Building ServiceModule 1.0-SNAPSHOT                                [3/3]
[INFO]   from ServiceModule\pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] Reactor Summary for MainProject 1.0-SNAPSHOT:
[INFO]
[INFO] MainProject ........................................ SUCCESS [  0.007 s]
[INFO] DataAccessModule ................................... SUCCESS [  2.238 s]
[INFO] ServiceModule ...................................... SUCCESS [  0.308 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------

*** this is the power of aggregator or multi-module project. no need to build individually it will done by maven and aggregator itself. bcz here service is dependent on data access so first data access module build first and then use that jar in service module.


pom.xml for Main Project
************************
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>

    <groupId>org.example.parent</groupId>
    <artifactId>MainProject</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>pom</packaging>
    <modules>
        <module>ServiceModule</module>
        <module>DataAccessModule</module>
    </modules>

</project>


pom.xml for Data Access Module
******************************
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>
<parent>
<groupId>org.example.parent</groupId>
<artifactId>MainProject</artifactId>
<version>1.0-SNAPSHOT</version>
</parent>

    <groupId>org.example.module</groupId>
    <artifactId>DataAccessModule</artifactId>

</project>


pom.xml for Service Module
**************************
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>
<parent>
<groupId>org.example.parent</groupId>
<artifactId>MainProject</artifactId>
<version>1.0-SNAPSHOT</version>
</parent>

    <dependencies>
        <dependency>
            <groupId>org.example.module</groupId>
            <artifactId>DataAccessModule</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>
	
    <groupId>org.example.module</groupId>
    <artifactId>ServiceModule</artifactId>
</project>


Summary-
similar to project inheritance, OK? The only difference that you will understand is In inheritance, no. What happens is typically. The children know of their parent because children have A tag for parent in their pom.xml However, parent is not aware that, OK, these this particular pom is extending the parent. There is no way The parent understands that because parent only has a pom packaging. Beyond that, nothing is there in the parent. Extending that concept here in aggregation or multi module. You'll see that you know As against to the, you know, uh? Multi in multi module will clearly realize that the parent, the main project. Not only is the parent, but it also knows which sub modules are OR which children are there. You know, for this particular parent,



********************************************
Project Inheritance vs Project Aggregation
*********************************************

If you have several Maven projects, and they all have similar configurations, you can refactor your projects by pulling out those similar configurations and making a parent project. Thus, all you have to do is to let your Maven projects inherit that parent project, and those configurations would then be applied to all of them.

And if you have a group of projects that are built or processed together, you can create a parent project and have that parent project declare those projects as its modules. By doing so, you'd only have to build the parent and the rest will follow.

But of course, you can have both Project Inheritance and Project Aggregation. Meaning, you can have your modules specify a parent project, and at the same time, have that parent project specify those Maven projects as its modules. You'd just have to apply all three rules:

*** Specify in every child POM who their parent POM is.
*** Change the parent POMs packaging to the value "pom" .
*** Specify in the parent POM the directories of its modules (children POMs)


Example 5
==========
The Scenario
-------------

Given the previous original artifact POMs again,

com.mycompany.app:my-app:1's POM

<project>
  <modelVersion>4.0.0</modelVersion>

<groupId>com.mycompany.app</groupId>
<artifactId>my-app</artifactId>
<version>1</version>
</project>

com.mycompany.app:my-module:1's POM

<project>
  <modelVersion>4.0.0</modelVersion>

<groupId>com.mycompany.app</groupId>
<artifactId>my-module</artifactId>
<version>1</version>
</project>
and this directory structure

.
|-- my-module
|   `-- pom.xml
`-- parent
`-- pom.xml

The Solution
---------------
To do both project inheritance and aggregation, you only have to apply all three rules.

com.mycompany.app:my-app:1's POM

<project>
  <modelVersion>4.0.0</modelVersion>

<groupId>com.mycompany.app</groupId>
<artifactId>my-app</artifactId>
<version>1</version>
<packaging>pom</packaging>

  <modules>
    <module>../my-module</module>
  </modules>
</project>
com.mycompany.app:my-module:1's POM

<project>
  <modelVersion>4.0.0</modelVersion>

  <parent>
    <groupId>com.mycompany.app</groupId>
    <artifactId>my-app</artifactId>
    <version>1</version>
    <relativePath>../parent/pom.xml</relativePath>
  </parent>

<artifactId>my-module</artifactId>
</project>
NOTE: Profile inheritance the same inheritance strategy as used for the POM itself.




*********************************
		Maven Plugins

*********************************

Maven is - at its heart - a plugin execution framework; all work is done by plugins. Looking for a specific goal to execute? This page lists the core plugins and others. There are the build and the reporting plugins:

1. Build plugins - will be executed during the build and they should be configured in the <build/> element from the POM.
2. Reporting plugins - will be executed during the site generation and they should be configured in the <reporting/> element from the POM. Because the result of a Reporting plugin is part of the generated site, Reporting plugins should be both internationalized and localized.



Plugin	      				Type*						Description

Core plugins				               Plugins corresponding to default core phases (ie. clean, compile). They may have multiple goals as well.
------------							   ---------------------------------------------
clean						B							Clean up after the build.
compiler					B							Compiles Java sources.
deploy						B							Deploy the built artifact to the remote repository.
failsafe					B							Run the JUnit integration tests in an isolated classloader.
install						B							Install the built artifact into the local repository.		
resources					B							Copy the resources to the output directory for including in the JAR.		
site						B							Generate a site for the current project.
surefire					B							Run the JUnit unit tests in an isolated classloader.
verifier					B							Useful for integration tests - verifies the existence of certain conditions.

Packaging types/tools					   These plugins relate to packaging respective artifact types.
---------------------					   ------------------------------------------------------------
ear							B					Generate an EAR from the current project.
ejb							B					Build an EJB (and optional client) from the current project.
jar							B					Build a JAR from the current project.
rar							B					Build a RAR from the current project.
war							B					Build a WAR from the current project.
app-client/acr				B					Build a JavaEE application client from the current project.
source						B					Build a source-JAR from the current project.


Reporting plugins				     Plugins which generate reports, are configured as reports in the POM and run under the site generation lifecycle.
------------------					 ----------------------------------------------------------------------------------------------------------------

changelog					R				Generate a list of recent changes from your SCM.
changes						B+R				Generate a report from an issue tracker or a change document.
checkstyle					B+R				Generate a Checkstyle report.
javadoc						B+R				Generate Javadoc for the project.
jxr							R				Generate a source cross reference.
linkcheck					R				Generate a Linkcheck report of your project's documentation.
project-info-reports		R				Generate standard project reports.
surefire-report				R				Generate a report based on the results of unit tests.

Tools								 These are miscellaneous tools available through Maven by default.
-----------							 -----------------------------------------------------------------

antrun						B				Run a set of ant tasks from a phase of the build.
artifact					B				Manage artifacts tasks like buildinfo.
archetype					B				Generate a skeleton project structure from an archetype.
assembly					B				Build an assembly (distribution) of sources and/or binaries.
dependency					B+R				Dependency manipulation (copy, unpack) and analysis.
gpg							B				Create signatures for the artifacts and poms.
help						B				Get information about the working environment for the project.
invoker						B+R				Run a set of Maven projects and verify the output.
jarsigner					B				Signs or verifies project artifacts.
pdf							B				Generate a PDF version of your project's documentation.
plugin						B				Create a Maven plugin descriptor for any mojos found in the source tree, to include in the JAR.
plugin-report				R				Create a plugin documentation for any mojos found in the source tree.
release						B				Release the current project - updating the POM and tagging in the SCM.
remote-resources			B				Copy remote resources to the output directory for inclusion in the artifact.
scripting					B	            The Maven Scripting Plugin wraps the Scripting API according to JSR223.
stage						B				Assists with release staging and promotion.
wrapper						B				Download and unpack the maven wrapper distribution	Git / GitHub	Jira MWRAPPER


Note - let's go in depth of Maven Lifecycle/ Phases/ Goal and It's Usages for few of the plugins....



										<<<<<<<<<<<<<<< [ Build Plugins ] >>>>>>>>>>>>>





***** 1. Maven Clean Plugin *********

The Clean Plugin is used when you want to remove files generated at build-time in a project's directory.

Goals Overview
The Clean Plugin only has one goal.

clean:clean attempts to clean a project's working directory of the files that were generated at build-time. By default, it discovers and deletes the directories configured in project.build.directory, project.build.outputDirectory, project.build.testOutputDirectory, and project.reporting.outputDirectory.

Usage
-------
The Maven Clean Plugin, as the name implies, attempts to clean the files and directories generated by Maven during its build. While there are plugins that generate additional files, the Clean Plugin assumes that these files are generated inside the target directory.

Cleaning a Maven project using the command-line
The Clean Plugin can be called to execute in the command-line without any additional configurations. Like the other plugins, to run the Clean Plugin, you use:

-mvn clean:clean
where the first clean refers to the plugin's alias, and the second clean refers to the plugin goal.

However, the Clean Plugin is a special plugin and is bound to its own special lifecycyle phase called clean. Thus, for simplicity, it can also be executed by using:

-mvn clean
or with other phases/goals like:

-mvn clean package site

Running the Clean Plugin automatically during a build   (Imp -> instead of mvn clean if u do mvn build then also clean goal will perform...bcz it is in <build> tag.
======================================================

If for some reason, adding clean to the command-line is not option, the Clean Plugin can be put into a project's pom.xml so that it gets executed everytime the project is built. Below is a sample pom.xml for running the Clean Plugin in the initialize phase everytime the project is built:

<project>
  [...]
  <build>
    <plugins>
      <plugin>
        <artifactId>maven-clean-plugin</artifactId>
        <version>3.3.2</version>
        <executions>
          <execution>
            <id>auto-clean</id>
            <phase>initialize</phase>
            <goals>
              <goal>clean</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>
  [...]
</project>




***** 2. Maven Compiler Plugin *********

The Compiler Plugin is used to compile the sources of your project. Since 3.0, the default compiler is javax.tools.JavaCompiler (if you are using java 1.6) and is used to compile Java sources. If you want to force the plugin using javac, you must configure the plugin option forceJavacCompilerUse.

Also note that at present the default source setting is 1.8 and the default target setting is 1.8, independently of the JDK you run Maven with. You are highly encouraged to change these defaults by setting source and target as described in Setting the -source and -target of the Java Compiler.

Setting the -source and -target of the Java Compiler
-------------------------------------------------------

Sometimes when you may need to compile a certain project to a different version than what you are currently using. The javac can accept such command using -source and -target. The Compiler Plugin can also be configured to provide these options during compilation.

For example, if you want to use the Java 8 language features (-source 1.8) and also want the compiled classes to be compatible with JVM 1.8 (-target 1.8), you can either add the two following properties, which are the default property names for the plugin parameters:

<project>
  [...]
  <properties>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
  </properties>
  [...]
</project>
or configure the plugin directly:

<project>
  [...]
  <build>
    [...]
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.12.1</version>
        <configuration>
          <source>1.8</source>
          <target>1.8</target>
        </configuration>
      </plugin>
    </plugins>
    [...]
  </build>
  [...]
</project>

Goals Overview
---------------

The Compiler Plugin has two goals. Both are already bound to their proper phases within the Maven Lifecycle and are therefore, automatically executed during their respective phases.

compiler:compile is bound to the compile phase and is used to compile the main source files.
compiler:testCompile is bound to the test-compile phase and is used to compile the test source files.


Usage
-------
Compiling Your Java Sources
The goals for the Compiler Plugin are bound to their respective phases in the build lifecycle. So to compile your sources, you need only to tell maven until which lifecycle to execute. The following will compile your sources:

mvn compile
To compile your test sources, you'll do:

mvn test-compile
The above command will execute both compiler:compile and compiler:testCompile since the compile phase happens a few phases before the test-compile phase.

Configuring Your Compiler Plugin
Since the Compiler Plugin executes automatically during their phases, you don't have to put executions unlike many other plugins. However, you should specify the version of the Compiler Plugin.

<project>
  ...
  <build>
    <pluginManagement>
      <plugins>
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.12.1</version>
          <configuration>
            <!-- put your configurations here -->
          </configuration>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
  ...
</project>


***** 3. Maven Install Plugin *********

The Install Plugin is used during the install phase to add artifact(s) to the local repository. The Install Plugin uses the information in the POM (groupId, artifactId, version) to determine the proper location for the artifact within the local repository.

The local repository is the local cache where all artifacts needed for the build are stored. By default, it is located within the user's home directory (~/.m2/repository) but the location can be configured in ~/.m2/settings.xml using the <localRepository> element.

Goals Overview
-----------------
The Install Plugin has 3 goals:

install:install is used to automatically install the project's main artifact (the JAR, WAR or EAR), its POM and any attached artifacts (sources, javadoc, etc) produced by a particular project.
install:install-file is mostly used to install an externally created artifact into the local repository, along with its POM. In that case the project information can be taken from an optionally specified pomFile, but can also be given using command line parameters.
install:help displays help information on maven-install-plugin.

Usages
---------
Apache Maven has a two level strategy to resolve and distribute files, which we call artifacts. The first level is called the local repository, which is the artifact cache on your system, by default located at ${user.home}/.m2/repository. When executing Maven, it first looks in this local cache for artifacts. If the artifact cannot be found here, Maven will access the remote repositories to find the artifact. Once found it will be stored into the local repository, so it's available for current and future usage.

With the maven-install-plugin you can put your artifacts in the local repository. To upload artifacts to a remote repository, you need to use the maven-deploy-plugin.

The install:install goal
In most cases, install:install goal doesn't need any configuration, it needs the project's POM and the artifact file to be installed during the install phase of the default build lifecycle.

mvn install
The install:install-file goal
The install:install-file goal is used primarily for installing artifacts to the local repository which were not built by Maven. The project's development team may or may not provide a POM for the artifact. Here's a list of some of the available parameters for the install-file goal:

mvn install:install-file -Dfile=your-artifact-1.0.jar \
[-DpomFile=your-pom.xml] \
[-Dsources=src.jar] \
[-Djavadoc=apidocs.jar] \
[-DgroupId=org.some.group] \
[-DartifactId=your-artifact] \
[-Dversion=1.0] \
[-Dpackaging=jar] \
[-Dclassifier=sources] \
[-DgeneratePom=true] \
[-DcreateChecksum=true]
the groupId, artifactId, version and packaging of the file to install. These can be taken from the specified pomFile, extracted from the pom.xml inside the artifact, and overridden or specified using the command line. When the pomFile contains a parent section, the parent's groupId can be considered if the groupId is not specified further for the current project or on the command line.
the optional classifier parameter can be used to install secondary artifacts for a project, like a javadoc or sources JAR. If a classifier is not given, Maven assumes the file is the main artifact for the project.




***** 4. Maven Deploy Plugin *********

The deploy plugin is primarily used during the deploy phase, to add your artifact(s) to a remote repository for sharing with other developers and projects. This is usually done in an integration or release environment. It can also be used to deploy a particular artifact (e.g. a third party jar like Sun's non redistributable reference implementations).

As a repository contains more than the artifacts (POMs, the metadata, MD5 and SHA1 hash files...), deploying means not only copying the artifacts, but making sure all this information is correctly updated. It's the reponsibility of the deploy plugin.

To work, the deployment will require:

information about the repository: its location, the transport method used to access it (FTP, SCP, SFTP...) and the optional user specific required account information
information about the artifact(s): the group, artifact, version, packaging, classifier...
a deployer: a method to actually perform the deployment. This can be implemented as a wagon transport (making it cross-platform), or use a system specific method.
The information will be taken from the implied (or specified) pom and from the command line. The settings.xml file may also be parsed to retrieve user credentials.

Goals Overview
-----------------
The deploy plugin has 2 goals:

deploy:deploy - is used to automatically install the artifact, its pom and the attached artifacts produced by a particular project. Most if not all of the information related to the deployment is stored in the project's pom.
deploy:deploy-file - is used to install a single artifact along with its pom. In that case the artifact information can be taken from an optionally specified pomFile, but can be completed/overriden using the command line.

Usage
-------
The Deploy Plugin has two basic functions. In most project builds, the deploy phase of the build lifecycle is implemented using the deploy:deploy mojo. Also, artifacts which are not built using Maven can be added to any remote repository using the deploy:deploy-file mojo.

The deploy:deploy Mojo
In most cases, this mojo is invoked when you call the deploy phase of the default build lifecycle.

To enable this mojo to function, you must include a valid <distributionManagement/> section POM, which at the minimum provides a <repository/> defining the remote repository location for your artifact. To separate snapshot artifacts from release artifacts, you can also specify a <snapshotRepository/> location. Finally, to deploy a project website, you must specify a <site/> section here as well. It's also important to note that this section can be inherited, allowing you to specify the deployment location one time for a set of related projects.

If your repository is secured, you may also want to configure your settings.xml file to define corresponding <server/> entries which provides authentication information. Server entries are matched to the different parts of the distributionManagement using their <id/> elements. For example, your project may have a distributionManagement section similar to the following:

[...]
<distributionManagement>
<repository>
<id>internal.repo</id>
<name>MyCo Internal Repository</name>
<url>Host to Company Repository</url>
</repository>
</distributionManagement>
[...]
In this case, you can specify a server definition in your settings.xml to provide authentication information for both of these repositories at once. Your server section might look like this:

[...]
<server>
<id>internal.repo</id>
<username>maven</username>
<password>foobar</password>
</server>
[...]
Please see the article about Password Encryption for instructions on how to avoid clear text passwords in the settings.xml.

Once you've configured your repository deployment information correctly deploying your project's artifact will only require invocation of the deploy phase of the build:

mvn deploy
The deploy:deploy-file Mojo
The deploy:deploy-file mojo is used primarily for deploying artifacts, which were not built by Maven. The project's development team may or may not provide a POM for the artifact, and in some cases you may want to deploy the artifact to an internal remote repository. The deploy-file mojo provides functionality covering all of these use cases, and offers a wide range of configurability for generating a POM on-the-fly. Additionally, you can specify what layout your repository uses. The full usage statement of the deploy-file mojo can be described as:

mvn deploy:deploy-file -Durl=file://C:\m2-repo \
-DrepositoryId=some.id \
-Dfile=your-artifact-1.0.jar \
[-DpomFile=your-pom.xml] \
[-DgroupId=org.some.group] \
[-DartifactId=your-artifact] \
[-Dversion=1.0] \
[-Dpackaging=jar] \
[-Dclassifier=test] \
[-DgeneratePom=true] \
[-DgeneratePom.description="My Project Description"] \
[-DrepositoryLayout=legacy]
If the following required information is not specified in some way, the goal will fail:

the artifact file to deploy
the group, artifact, version and packaging of the file to deploy. These can be taken from the specified pomFile, and overriden or specified using the command line. When the pomFile contains a parent section, the parent's groupId can be considered if the groupId is not specified further for the current project or on the command line.
the repository information: the url to deploy to and the repositoryId mapping to a server section in the settings.xml file. If you don't specify a repositoryId, Maven will try to extract authentication information using the id 'remote-repository'.


Password Encryption
-------------------

Maven supports server password encryption. The main use case, addressed by this solution is:

multiple users share the same build machine (server, CI box)
some users have the privilege to deploy Maven artifacts to repositories, some don't.
this applies to any server operations, requiring authorization, not only deployment
settings.xml is shared between users
The implemented solution adds the following capabilities:

authorized users have an additional settings-security.xml file in their ${user.home}/.m2 directory
this file either contains encrypted master password, used to encrypt other passwords
or it can contain a relocation - reference to another file, possibly on removable storage
this password is created first via CLI for now
server entries in the settings.xml have passwords and/or keystore passphrases encrypted
for now - this is done via CLI after master password has been created and stored in appropriate location
How to create a master password
Use the following command line:

mvn --encrypt-master-password <password>
Note: Since Maven 3.2.1 the password argument should no longer be used (see Tips below for more information). Maven will prompt for the password. Earlier versions of Maven will not prompt for a password, so it must be typed on the command-line in plaintext.

This command will produce an encrypted version of the password, something like

{jSMOWnoPFgsHVpMvz5VrIt5kRbzGpI8u+9EF1iFQyJQ=}
Store this password in the ${user.home}/.m2/settings-security.xml; it should look like

<settingsSecurity>
  <master>{jSMOWnoPFgsHVpMvz5VrIt5kRbzGpI8u+9EF1iFQyJQ=}</master>
</settingsSecurity>
When this is done, you can start encrypting existing server passwords.

How to encrypt server passwords
You have to use the following command line:

mvn --encrypt-password <password>
Note:Just like --encrypt-master-password the password argument should no longer be used since Maven 3.2.1 (see Tips below for more information.).

This command produces an encrypted version of it, something like

{COQLCE6DU6GtcS5P=}
Copy and paste it into the servers section of your settings.xml file. This will look like:

<settings>
...
  <servers>
...
    <server>
      <id>my.server</id>
      <username>foo</username>
      <password>{COQLCE6DU6GtcS5P=}</password>
    </server>
...
  </servers>
...
</settings>
Please note that password can contain any information outside of the curly brackets, so that the following will still work:

<settings>
...
  <servers>
...
    <server>
      <id>my.server</id>
      <username>foo</username>
      <password>Oleg reset this password on 2009-03-11, expires on 2009-04-11 {COQLCE6DU6GtcS5P=}</password>
    </server>
...
  </servers>
...
</settings>
Then you can use, say, deploy plugin, to write to this server:

mvn deploy:deploy-file -Durl=https://maven.corp.com/repo \
-DrepositoryId=my.server \
-Dfile=your-artifact-1.0.jar \
How to keep the master password on removable drive
Create the master password exactly as described above, and store it on a removable drive, for instance on OSX, my USB drive mounts as /Volumes/mySecureUsb, so I store

<settingsSecurity>
  <master>{jSMOWnoPFgsHVpMvz5VrIt5kRbzGpI8u+9EF1iFQyJQ=}</master>
</settingsSecurity>
in the file /Volumes/mySecureUsb/secure/settings-security.xml

And then I create ${user.home}/.m2/settings-security.xml with the following content:

<settingsSecurity>
  <relocation>/Volumes/mySecureUsb/secure/settings-security.xml</relocation>
</settingsSecurity>
This assures that encryption only works when the USB drive is mounted by the OS. This addresses a use case where only certain people are authorized to deploy and are issued these devices.

Tips
Escaping curly-brace literals in your password (Since: Maven 2.2.0)
At times, you might find that your password (or the encrypted form of it) contains '{' or '}' as a literal value. If you added such a password as-is to your settings.xml file, you would find that Maven does strange things with it. Specifically, Maven treats all the characters preceding the '{' literal, and all the characters after the '}' literal, as comments. Obviously, this is not the behavior you want. What you really need is a way of escaping the curly-brace literals in your password.

You can do this with the widely used '\' escape character. If your password looks like this:

jSMOWnoPFgsHVpMvz5VrIt5kRbzGpI8u+{EF1iFQyJQ=
Then, the value you would add to your settings.xml looks like this:

{jSMOWnoPFgsHVpMvz5VrIt5kRbzGpI8u+\{EF1iFQyJQ=}
Password Security
Editing settings.xml and running the above commands can still leave your password stored locally in plaintext. You may want to check the following locations:

Shell history (e.g. by running history). You may want to clear your history after encrypting the above passwords
Editor caches (e.g. ~/.viminfo)
Also note that the encrypted passwords can be decrypted by someone that has the master password and settings security file. Keep this file secure (or stored separately) if you expect the possibility that the settings.xml file may be retrieved.



***** 5. Maven Site Plugin *********


The Site Plugin is used to generate a site for the project. The generated site also includes the project's reports that were configured in the POM.

Please read the migration guide if you want to upgrade from a previous version.

Goals Overview
---------------
The Site Plugin has seven goals:

site:site is used generate a site for a single project. Note that links between module sites in a multi module build will not work, since local build directory structure doesn't match deployed site.
site:deploy is used to deploy the generated site using Wagon supported protocol to the site URL specified in the <distributionManagement> section of the POM.
site:run starts the site up, rendering documents as requested for faster editing. It uses Jetty as the web server.
site:stage generates a site in a local staging or mock directory based on the site URL specified in the <distributionManagement> section of the POM. It can be used to test that links between module sites in a multi module build work. This goal requires the site to already have been generated using the site goal, such as by calling mvn site.
site:stage-deploy deploys the generated site to a staging or mock directory to the site URL specified in the <distributionManagement> section of the POM.
site:attach-descriptor adds the site descriptor (site.xml) to the list of files to be installed/deployed. For more references of the site descriptor, here's a link.
site:jar bundles the site output into a JAR so that it can be deployed to a repository.
site:effective-site calculates the effective site descriptor, after inheritance and interpolation.

Usage
-----

Generating a Site
Deploying a Site
Staging a Site
Running a Site
Rebuilding a Published (Released) Site

Generating a Site
-----------------
To generate the project's site and reports, execute:

	-mvn site
By default, the resulting site will be in the target/site/ directory.

Note: If you have a multi module project, then the links between the parent and child modules will not work when you use mvn site or mvn site:site. If you want to use those links, you should use mvn site:stage instead. You can read more about that goal further down on this page in the section called 'Staging a Site'.

Note: For performance reasons, Maven compares the timestamps of generated files and corresponding source documents, and only regenerates documents that have changed since the last build. However, this only applies to documentation source documents (apt, xdoc,...). If you change anything in your site.xml, any relevant sections in your pom, or any relevant properties or resource files, you should generate the site from scratch to make sure all references and links are correct.

Deploying a Site
----------------
To be able to deploy the site, you must first specify where the site will be deployed. This is set in the <distributionManagement> element of the POM as shown below.

<project>
  ...
  <distributionManagement>
    <site>
      <id>www.yourcompany.com</id>
      <url>scp://www.yourcompany.com/www/docs/project/</url>
    </site>
  </distributionManagement>
  ...
</project>
The <id> element identifies the repository, so that you can attach credentials to it in your settings.xml file using the <servers> element as you would for any other repository.

The <url> gives the location to deploy to. In the example above we copy to the host www.mycompany.com using the path /www/docs/project/ over the scp protocol. You can read more about which protocols are supported on this page. If subprojects inherit the site URL from a parent POM, they will automatically append their <artifactId> to form their effective deployment location.

Now you can execute the site:deploy goal from your project directory.

Note: A site must be generated first before executing site:deploy.

	-mvn site:deploy
If you want to generate the site and deploy it in one go, you can utilize the site-deploy phase of the site lifecycle. To do this, just execute:

	-mvn site-deploy
Staging a Site
To review/test the generated web site before an official deploy, you can stage the site in a specific directory. It will use the <distributionManagement> element or the project hierarchy to link the project and its modules.

Just execute the site:stage goal from your project

	-mvn site:stage
Note: A site must be generated first before executing site:stage.

By default, the site will be staged in a directory target/staging/. A different staging location can be chosen with the stagingDirectory parameter as shown below:

	-mvn site:stage -DstagingDirectory=C:\fullsite
Note: stagingDirectory cannot be dynamic, i.e. stagingDirectory=${basedir}\fullsite

To stage a site and deploy it, execute the site:stage-deploy goal from your project with the required parameters. The site:stage-deploy goal will use the value of distributionManagement.site.id as default id to lookup the server section in your settings.xml; unless this is not defined, then the String stagingSite will be used as id. So if you need to add your username or password separately for stage-deploy in settings.xml, you should use <id>stagingSite</id> for that <server> section. See the Guide to Deployment and Security Settings for more information on this.

By default, the site will be stage-deployed to $distributionManagement.site.url/staging/. A different location can be chosen with the stagingSiteURL parameter as shown below:

	-mvn site:stage-deploy -DstagingSiteURL=scp://www.mycompany.com/www/project/
Note:A site must be generated first before executing site:stage-deploy.

Running a Site
-----------------
The Site Plugin can also be used to start up the site in Jetty. To do this, execute:

	-mvn site:run
The server will, by default, be started on http://localhost:8080/. See https://www.eclipse.org/jetty/ for more information about the Jetty server.

Note: Running a site only works for single-module sites. To preview a multi-module site one should use site:stage.




****** 6. Maven Surefire Plugin ********


Requirements: Maven 3.2.5 and JDK 1.8 or higher.

The Surefire Plugin is used during the test phase of the build lifecycle to execute the unit tests of an application. It generates reports in two different file formats:

Plain text files (*.txt)
XML files (*.xml)
By default, these files are generated in ${basedir}/target/surefire-reports/TEST-*.xml.

The schema for the Surefire XML reports is available at Surefire XML Report Schema.

For an HTML format of the report, please see the Maven Surefire Report Plugin.

Goals Overview
----------------
The Surefire Plugin has only one goal:

	-surefire:test runs the unit tests of an application.

Usage
======
Best practice is to define the version of the Surefire Plugin that you want to use in either your pom.xml or a parent pom.xml:

<project>
  [...]
  <build>
    <pluginManagement>
      <plugins>
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>3.2.5</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
  [...]
</project>
The Surefire Plugin can be invoked by calling the test phase of the build lifecycle.

	-mvn test




****** 7. Maven JAR Plugin ********

This plugin provides the capability to build jars. To sign jars, use the Maven Jarsigner Plugin.

Goals Overview
--------------
	-jar:jar create a jar file for your project classes inclusive resources.
	-jar:test-jar create a jar file for your project test classes .

Usage
------
How to build a JAR file
When you want to create a JAR-file with Maven, you first have to create a pom.xml-file with at least the following content:

<project>
  <modelVersion>4.0.0</modelVersion>

<groupId>com.mycompany.project</groupId>
<artifactId>core</artifactId>
<version>1.0-SNAPSHOT</version>
  <!-- <packaging>jar</packaging>  -->
</project>
Since 'jar' is the default packaging type it is not required to set it in this case. Apart from the above you will normally want some real java source files which should be located within src/main/java. If you need extra resources on your classpath (for example property files) they should be located in src/main/resources. Now we can create a JAR-file by using the command below:

	-mvn package
The 'package' phase is always responsible for bundling all the files in the artifact, in this case a JAR-file.

In your project's target directory you'll see the generated jar file which is named like: 'core-1.0-SNAPSHOT.jar'. The resulting 'jar' file contains the compiled java class files as well as the files from src/main/resources.

Usually there is no need to mentioned the 'maven-jar-plugin' explicit cause it's bound to the Maven Build Life Cycle.
You should specify the version in your project's plugin configuration:

<project>
  ...
  <build>
    <!-- To define the plugin version in your parent POM -->
    <pluginManagement>
      <plugins>
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-jar-plugin</artifactId>
          <version>3.3.0</version>
        </plugin>
        ...
      </plugins>
    </pluginManagement>
    <!-- To use the plugin goals in your POM or parent POM -->
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-jar-plugin</artifactId>
        <version>3.3.0</version>
      </plugin>
      ...
    </plugins>
  </build>
  ...
</project>




****** 8. Maven WAR  Plugin ********

The WAR Plugin is responsible for collecting all artifact dependencies, classes and resources of the web application and packaging them into a web application archive.

Goals Overview
---------------
war:war is the default goal invoked during the package phase for projects with a packaging type of war. It builds a WAR file.

Usages-
-------
There are 4 ways to use the WAR Plugin:

using the package phase with the project package type as war
invocation of the war:war goal

Note: When using the war: goals it is assumed that the compile phase is already done. The WAR Plugin is not responsible for compiling the java sources or copying the resources.

Using the package phase with the project package type as war / invocation of the war:war goal
This is the normal way of using the WAR Plugin. To illustrate, here's the pom.xml for our project:

<project>
  ...
  <groupId>com.example.projects</groupId>
  <artifactId>documentedproject</artifactId>
  <packaging>war</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>Documented Project</name>
  <url>http://example.com</url>
  ...
</project>
The project's structure looks like this:

|-- pom.xml
`-- src
`-- main
|-- java
|   `-- com
|       `-- example
|           `-- projects
|               `-- SampleAction.java
|-- resources
|   `-- images
|       `-- sampleimage.jpg
`-- webapp
|-- WEB-INF
|   `-- web.xml
|-- index.jsp
`-- jsp
`-- websource.jsp
Invoking

	-mvn package
or

	-mvn compile war:war
will generate the WAR file target/documentedproject-1.0-SNAPSHOT.war. Here are the contents of that WAR file:

documentedproject-1.0-SNAPSHOT.war
|-- META-INF
|   |-- MANIFEST.MF
|   `-- maven
|       `-- com.example.projects
|           `-- documentedproject
|               |-- pom.properties
|               `-- pom.xml
|-- WEB-INF
|   |-- classes
|   |   |-- com
|   |   |   `-- example
|   |   |       `-- projects
|   |   |           `-- SampleAction.class
|   |   `-- images
|   |       `-- sampleimage.jpg
|   `-- web.xml
|-- index.jsp
`-- jsp
`-- websource.jsp



										<<<<<<<<<<<<<<< [ Reporting Plugins ] >>>>>>>>>>>>>



***** 9. Maven Javadoc Plugin *********

The Javadoc Plugin gets the parameter values that will be used from the plugin configuration specified in the pom. To hold all javadoc arguments, packages or files, the Javadoc Plugin generates argument files and calls the Javadoc tool as follow:

javadoc.exe(or .sh) @options @packages | @argfile
When no configuration values are set, the plugin sets default values instead and then executes the Javadoc tool.

You can also use the plugin to package the generated javadocs into a jar file for distribution.

Goals Overview
---------------
The Javadoc Plugin has 16 goals:

-javadoc:javadoc generates the Javadoc files for the project. It executes the standard Javadoc tool and supports the parameters used by the tool.
-javadoc:test-javadoc generates the test Javadoc files for the project. It executes the standard Javadoc tool and supports the parameters used by the tool.
-javadoc:javadoc-no-fork generates the Javadoc files for the project. It executes the standard Javadoc tool and supports the parameters used by the tool without forking the generate-sources phase again. Note that this goal does require generation of test sources before site generation, e.g. by invoking mvn clean deploy site.
-javadoc:test-javadoc-no-fork generates the test Javadoc files for the project. It executes the standard Javadoc tool and supports the parameters used by the tool without forking the generate-test-sources phase again. Note that this goal does require generation of test sources before site generation, e.g. by invoking mvn clean deploy site.
-javadoc:aggregate generates the Javadoc files for an aggregator project. It executes the standard Javadoc tool and supports the parameters used by the tool.
-javadoc:test-aggregate generates the test Javadoc files for an aggregator project. It executes the standard Javadoc tool and supports the parameters used by the tool.
-javadoc:aggregate-no-fork generates the Javadoc files for an aggregator project. It executes the standard Javadoc tool and supports the parameters used by the tool without forking the compile> phase again. Note that this goal does require generation of class files before site generation, e.g. by invoking mvn compile or mvn install.
-javadoc:test-aggregate generates the test Javadoc files for an aggregator project. It executes the standard Javadoc tool and supports the parameters used by the tool without forking the compile phase again. Note that this goal does require generation of test class files before site generation, e.g. by invoking mvn test-compile or mvn install.
-javadoc:jar creates an archive file of the generated Javadocs. It is used during the release process to create the Javadoc artifact for the project's release. This artifact is uploaded to the remote repository along with the project's compiled binary and source archive.
-javadoc:test-jar creates an archive file of the generated Test Javadocs.
-javadoc:aggregate-jar creates an archive file of the generated Javadocs for an aggregator project.
-javadoc:test-aggregate-jar creates an archive file of the generated Test Javadocs for an aggregator project.
-javadoc:fix is an interactive goal which fixes the Javadoc documentation and tags for the Java files.
-javadoc:test-fix is an interactive goal which fixes the Javadoc documentation and tags for the test Java files.
-javadoc:resource-bundle bundles the javadocDirectory along with Javadoc configuration options such as taglet, doclet, and link information into a deployable artifact.
-javadoc:test-resource-bundle bundles the testJavadocDirectory along with Javadoc configuration options such as taglet, doclet, and link information into a deployable artifact.

The Javadoc Plugin generates javadocs using the Javadoc tool. The following examples describe the basic usage of the Plugin.

Generate Javadocs As Part Of Project Reports
---------------------------------------------
To generate javadocs as part of the site generation, you should add the Javadoc Plugin in the <reporting> section of your pom:

<project>
  ...
  <reporting>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-javadoc-plugin</artifactId>
        <version>3.6.3</version>
        <configuration>
          ...
        </configuration>
      </plugin>
    </plugins>
    ...
  </reporting>
  ...
</project>
When you execute mvn site, the javadocs will be generated and included in the generated site. A link to the javadocs will be added in the Project Reports menu.

Generate Standalone Javadocs
-----------------------------
To generate standalone javadocs for the project, you could add the Javadoc Plugin in the <build> section of your pom (if no configuration defined, the plugin uses default values):

<project>
  ...
  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-javadoc-plugin</artifactId>
        <version>3.6.3</version>
        <configuration>
          ...
        </configuration>
      </plugin>
    </plugins>
    ...
  </build>
  ...
</project>
And execute any of the following commands:

-mvn javadoc:javadoc
-mvn javadoc:jar
-mvn javadoc:aggregate
-mvn javadoc:aggregate-jar
-mvn javadoc:test-javadoc
-mvn javadoc:test-jar
-mvn javadoc:test-aggregate
-mvn javadoc:test-aggregate-jar
For all jar goals, the javadocs are first generated and then packaged into a jar file.

Javadoc Configuration
----------------------
The Javadoc Plugin supports a large number of configuration parameters. Each configuration parameter turns into a tag name.

Please refer to the Javadoc Plugin Documentation for a listing of these parameters. Most of these parameters are passed directly to the Javadoc tool itself.

IMPORTANT NOTE: configuring the Javadoc plugin in the <reporting/> or <build/> elements in the pom have NOT the same behavior as described in the Guide to Configuring Plug-ins.

For instance, if you have the following snippet:

<project>
  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-javadoc-plugin</artifactId>
        <version>3.6.3</version>
        <configuration>
          <show>private</show>
          <nohelp>true</nohelp>
        </configuration>
      </plugin>
    </plugins>
  </build>

  <reporting>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-javadoc-plugin</artifactId>
        <version>3.6.3</version>
        <configuration>
          <stylesheetfile>${basedir}/src/main/javadoc/stylesheet.css</stylesheetfile>
          <show>public</show>
        </configuration>
      </plugin>
    </plugins>
  </reporting>
</project>
mvn site
It will generate the Javadoc for public members (defined in <reporting/>) using the given stylesheet (defined in <reporting/>), and with a help page (default value for nohelp is true).
mvn javadoc:javadoc
It will generate the Javadoc for private members (defined in <build/>) using the stylesheet (defined in <reporting/>), and with no help page (defined in <build/>).




***** 10. Maven Surefire Report Plugin *********

The Surefire Report Plugin parses the generated TEST-*.xml files under ${basedir}/target/surefire-reports and renders them using DOXIA, which creates the web interface version of the test results.

Goals Overview
--------------
The Surefire Report Plugin has three goals:

surefire-report:report Generates the test results report into HTML format.
surefire-report:report-only This goal does not run the tests, it only builds the report. It is provided as a work around for SUREFIRE-257
surefire-report:failsafe-report-only This goal does not run the tests, it only builds the IT reports. See SUREFIRE-257

Generate the Report as Part of Project Reports
-----------------------------------------------
To generate the Surefire report as part of the site generation, add the following in the <reporting> section of your POM:

<project>
  ...
  <reporting>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-report-plugin</artifactId>
        <version>3.2.5</version>
      </plugin>
    </plugins>
  </reporting>
  ...
</project>
When mvn site is invoked, the report will automatically be included in the Project Reports menu as shown in the figure below.


Generate the Report in a Standalone Fashion
------------------------------------------------
The plugin can also generate the report using its standalone goal:

	- mvn surefire-report:report  
A HTML report should be generated in ${basedir}/target/site/surefire-report.html.



------------------------------------------------------------------------
*************************Lab Exercises**********************************
------------------------------------------------------------------------


***************
Site LifeCycle
***************

we have seen the default lifecycle and we have also seen the clean life cycle.
*** Life cycles has number of phases and each phases has a number of goals.

go to TestProj1 directory and type command its not a command it's a Phase only - mvn clean site

- mvn clean site / mvn site

INFO] Building TestProj1 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- clean:3.1.0:clean (default-clean) @ TestProj1 ---
[INFO] Deleting C:\maven_workspace\TestProj1\target
[INFO]
[INFO] --- site:3.7.1:site (default-site) @ TestProj1 ---
[INFO] configuring report plugin org.apache.maven.plugins:maven-project-info-reports-plugin:3.0.0
[INFO] 15 reports detected for maven-project-info-reports-plugin:3.0.0: ci-management, dependencies, dependency-info, dependency-management, distribution-management, index, issue-management, licenses, mailing-lists, modules, plugin-management, plugins, scm, summary, team
[INFO] Rendering site with default locale English (en)
[INFO] Relativizing decoration links with respect to localized project URL: http://www.example.com
[INFO] Rendering content with org.apache.maven.skins:maven-default-skin:jar:1.2 skin.
[INFO] Generating "Dependencies" report  --- maven-project-info-reports-plugin:3.0.0:dependencies
[INFO] Generating "Dependency Information" report --- maven-project-info-reports-plugin:3.0.0:dependency-info
[INFO] Generating "About" report         --- maven-project-info-reports-plugin:3.0.0:index
[INFO] Generating "Plugin Management" report --- maven-project-info-reports-plugin:3.0.0:plugin-management
[INFO] Generating "Plugins" report       --- maven-project-info-reports-plugin:3.0.0:plugins
[INFO] Generating "Summary" report       --- maven-project-info-reports-plugin:3.0.0:summary
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.650 s

*** Todays Lab we will do in a reporting plugin.
reporting is when you report on a site. surefire is a build plugin and surefire-report is a pure reporting plugin.

surefire					B				Run the JUnit unit tests in an isolated classloader.        B-> Build Plugin
surefire-report				R				Generate a report based on the results of unit tests.		R-> Reporting Plugin

***** Let's do a lab on surefire-report
The Surefire Report Plugin has a goals:

	-surefire-report:report 		->Generates the test results report into HTML format.

Imp->>

Generate the Report as Part of Project Reports
-------------------------------------------------
To generate the Surefire report as part of the site generation, add the following in the <reporting> section of your POM:

<project>
  ...
  <reporting>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-report-plugin</artifactId>
        <version>3.2.5</version>
      </plugin>
    </plugins>
  </reporting>
  ...
</project>

*** When -mvn site is invoked, the report will automatically be included in the Project Reports menu as shown in the figure below.

Generate the Report in a Standalone Fashion
----------------------------------------------
The plugin can also generate the report using its standalone goal:

	-mvn surefire-report:report  
A HTML report should be generated in ${basedir}/target/site/surefire-report.html.

so, In either way u can use it.... so add <reporting> tag plugin in pom.xml and run command -mvn site
go to TestProject1 and do...
so after <build> tab u need to add the <reporting> tab...bith are diff.
go to /target you will see /site folder got created.
you can see index.html and surefire-report.html file got created.

The build lifecycle is simple enough to use, but when you are constructing a Maven build for a project, how do you go about assigning tasks to each of those build phases?

Phase	plugin:goal for the jar packaging
process-resources	resources:resources
compile	compiler:compile
process-test-resources	resources:testResources
test-compile	compiler:testCompile
test	surefire:test
package	jar:jar
install	install:install
deploy	deploy:deploy








Project Interpolation and Variables
One of the practices that Maven encourages is don't repeat yourself. However, there are circumstances where you will need to use the same value in several different locations. To assist in ensuring the value is only specified once, Maven allows you to use both your own and pre-defined variables in the POM.

For example, to access the project.version variable, you would reference it like so:

<version>${project.version}</version>
One factor to note is that these variables are processed after inheritance as outlined above. This means that if a parent project uses a variable, then its definition in the child, not the parent, will be the one eventually used.

Available Variables
Project Model Variables
Any field of the model that is a single value element can be referenced as a variable. For example, ${project.groupId}, ${project.version}, ${project.build.sourceDirectory} and so on. Refer to the POM reference to see a full list of properties.

These variables are all referenced by the prefix "project.". You may also see references with pom. as the prefix, or the prefix omitted entirely - these forms are now deprecated and should not be used.

Special Variables
project.basedir	The directory that the current project resides in.
project.baseUri	The directory that the current project resides in, represented as an URI. Since Maven 2.1.0
maven.build.timestamp	The timestamp that denotes the start of the build (UTC). Since Maven 2.1.0-M1
The format of the build timestamp can be customized by declaring the property maven.build.timestamp.format as shown in the example below:

<project>
  ...
  <properties>
    <maven.build.timestamp.format>yyyy-MM-dd'T'HH:mm:ss'Z'</maven.build.timestamp.format>
  </properties>
  ...
</project>
The format pattern has to comply with the rules given in the API documentation for SimpleDateFormat. If the property is not present, the format defaults to the value already given in the example.

Properties
You are also able to reference any properties defined in the project as a variable. Consider the following example:

<project>
  ...
  <properties>
    <mavenVersion>3.0</mavenVersion>
  </properties>

  <dependencies>
    <dependency>
      <groupId>org.apache.maven</groupId>
      <artifactId>maven-artifact</artifactId>
      <version>${mavenVersion}</version>
    </dependency>
    <dependency>
      <groupId>org.apache.maven</groupId>
      <artifactId>maven-core</artifactId>
      <version>${mavenVersion}</version>
    </dependency>
  </dependencies>
  ...
</project>






