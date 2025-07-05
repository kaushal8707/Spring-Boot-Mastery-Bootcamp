

![img.png](img.png)

![img_1.png](img_1.png)

so we can see application port started on 8081 what we mentioned in application.yml

If .properties and .yml both available which one will get preference first
---------------------------------------------------------------------------

![img_2.png](img_2.png)

![img_3.png](img_3.png)

*** application.properties get preference first

If .properties and .yml and command-line argument all 3 available which one will get preference first
----------------------------------------------------------------------------------------------------

![img_4.png](img_4.png)

![img_5.png](img_5.png)

PS C:\Users\e162554\OneDrive - Mastercard\Interview\Spring-Boot-Mastery-Bootcamp\target> 
                    
    java -jar .\journalApplication-1.0-SNAPSHOT.jar --server.port=9999

![img_6.png](img_6.png)

*** First Preference command-line-argument
*** Second Preference application.properties
*** Third Preference application.yml

Even we can pass argument through Spring Boot Run Configuration as well
=======================================================================

![img_7.png](img_7.png)

![img_8.png](img_8.png)

so, this is the another way we can pass config parameters what is in .properties or .yml



