1. Overview
   Maven profiles can be used to create customized build configurations, like targeting a level of test granularity or a specific deployment environment.

In this tutorial, we’ll learn how to work with Maven profiles.

2. A Basic Example
   Normally when we run mvn package, the unit tests are executed as well. But what if we want to quickly package the artifact and run it to see if it works?

First, we’ll create a no-tests profile that sets the maven.test.skip property to true:

<profile>
    <id>no-tests</id>
    <properties>
        <maven.test.skip>true</maven.test.skip>
    </properties>
</profile>
Copy
Next, we’ll execute the profile by running the mvn package -Pno-tests command. Now the artifact is created and the tests are skipped. In this case the mvn package -Dmaven.test.skip command would have been easier.

However, this was just an introduction to Maven profiles. Let’s take a look at some more complex setups.

3. Declaring Profiles
   In the previous section, we saw how to create one profile. We can configure as many profiles as we want by giving them unique ids.

Let’s say we wanted to create a profile that only ran our integration tests and another for a set of mutation tests.

We would begin by specifying an id for each one in our pom.xml file:

<profiles>
    <profile>
        <id>integration-tests</id>
    </profile>
    <profile>
        <id>mutation-tests</id>
    </profile>
</profiles>
Copy
Within each profile element, we can configure many elements such as dependencies, plugins, resources, finalName.

So, for the example above, we could add plugins and their dependencies separately for integration-tests and mutation-tests.

Separating tests into profiles can make the default build faster by having it focus, say, on just the unit tests.

3.1. Profile Scope
Now, we just placed these profiles in our pom.xml file, which declares them only for our project.

But, in Maven 3, we can actually add profiles to any of three locations:

Project-specific profiles go into the project’s pom.xml file
User-specific profiles go into the user’s settings.xml file
Global profiles go into the global settings.xml file
Note that Maven 2 did support a fourth location, but this was removed in Maven 3.

We try to configure profiles in the pom.xml whenever possible. The reason is that we want to use the profiles both on our development machines and on the build machines. Using the settings.xml is more difficult and error-prone as we have to distribute it across build environments ourselves.

4. Activating Profiles
   After we create one or more profiles we can start using them, or in other words, activating them.

4.1. Seeing Which Profiles Are Active
Let’s use the help:active-profiles goal to see which profiles are active in our default build:

mvn help:active-profiles
Copy
Actually, since we haven’t activated anything yet, we get:

The following profiles are active:
Copy
Well, nothing.

We’ll activate them in just a moment. But quickly, another way to see what is activated is to include the maven-help-plugin in our pom.xml and tie the active-profiles goal to the compile phase:

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-help-plugin</artifactId>
            <version>3.2.0</version>
            <executions>
                <execution>
                    <id>show-profiles</id>
                    <phase>compile</phase>
                    <goals>
                        <goal>active-profiles</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
Copy
Now, let’s get to using them! We’ll look at a few different ways.

4.2. Using -P
Actually, we already saw one way at the beginning, which is that we can activate profiles with the -P argument.

So let’s begin by enabling the integration-tests profile:

mvn package -P integration-tests
Copy
If we verify the active profiles, with the maven-help-plugin or the mvn help:active-profiles -P integration-tests command we’ll get the following result:

The following profiles are active:

- integration-tests
  Copy
  In case we want to activate multiple profiles at the same time, we use a comma-separated list of profiles:

mvn package -P integration-tests,mutation-tests
Copy
4.3. Active by Default
If we always want to execute a profile, we can make one active by default:

<profile>
    <id>integration-tests</id>
    <activation>
        <activeByDefault>true</activeByDefault>
    </activation>
</profile>
Copy
Then, we can run mvn package without specifying the profiles, and we can verify that the integration-test profile is active.

However, if we run the Maven command and enable another profile then the activeByDefault profile is skipped. So when we run mvn package -P mutation-tests then only the mutation-tests profile is active.

When we activate in other ways, the activeByDefault profile is also skipped as we’ll see in the next sections.

4.4. Based on a Property
We can activate profiles on the command-line. However, sometimes it’s more convenient if they’re activated automatically. For instance, we can base it on a -D system property:

<profile>
    <id>active-on-property-environment</id>
    <activation>
        <property>
            <name>environment</name>
        </property>
    </activation>
</profile>
Copy
We now activate the profile with the mvn package -Denvironment command.

It’s also possible to activate a profile if a property is not present:

<property>
    <name>!environment</name>
</property>
Copy
Or we can activate the profile if the property has a specific value:

<property>
    <name>environment</name>
    <value>test</value>
</property>
Copy
We can now run the profile with mvn package -Denvironment=test.

Lastly, we can activate the profile if the property has a value other than the specified value:

<property>
    <name>environment</name>
    <value>!test</value>
</property>
Copy
4.5. Based on the JDK Version
Another option is to enable a profile based on the JDK running on the machine. In this case, we want to enable the profile if the JDK version starts with 11:

<profile>
    <id>active-on-jdk-11</id>
    <activation>
        <jdk>11</jdk>
    </activation>
</profile>
Copy
We can also use ranges for the JDK version as explained in Maven Version Range Syntax.

4.6. Based on the Operating System
Alternatively, we can activate the profile based on some operating system information.

And if we aren’t sure of that, we can first use the mvn enforcer:display-info command which gives the following output on my machine:

Maven Version: 3.5.4
JDK Version: 11.0.2 normalized as: 11.0.2
OS Info: Arch: amd64 Family: windows Name: windows 10 Version: 10.0
Copy
After that, we can configure a profile that is activated only on Windows 10:

<profile>
    <id>active-on-windows-10</id>
    <activation>
        <os>
            <name>windows 10</name>
            <family>Windows</family>
            <arch>amd64</arch>
            <version>10.0</version>
        </os>
    </activation>
</profile>
Copy
4.7. Based on a File
Another option is to run a profile if a file exists or is missing.

So, let’s create a test profile that only executes if the testreport.html is not yet present:

<activation>
    <file>
        <missing>target/testreport.html</missing>
    </file>
</activation>
Copy
5. Deactivating a Profile
We’ve seen many ways to activate profiles, but sometimes we need to disable one as well.

To disable a profile we can use the ‘!’ or ‘-‘.

So, to disable the active-on-jdk-11 profile we execute the mvn compile -P -active-on-jdk-11 command.

