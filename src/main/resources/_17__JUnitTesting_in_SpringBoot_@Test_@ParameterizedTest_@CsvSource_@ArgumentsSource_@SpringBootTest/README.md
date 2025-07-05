

![img.png](img.png)

TDD - Test Driven Development
-----------------------------

Writing a test cases along with developed code.

dependencies-
![img_1.png](img_1.png)
<scope>test</scope>

as it is needed during testing not to creating a jar..
If we go inside spring-boot-starter-test i can have jupiter dependencies.

![img_2.png](img_2.png)

It's already Included so no need to do anything.

SCENARIOS - 1
=============

suppose we need to write a test - case for a UserService
--------------------------------------------------------

![img_3.png](img_3.png)

In Database

![img_4.png](img_4.png)

![img_5.png](img_5.png)
![img_6.png](img_6.png)

here we got null pointer exception bcz UserRepository is Null here.

imp->
  This is null because Spring Application context not yet started. so when our application running
then only bean will create and, we are Injecting so null pointer exception. so, To start
Spring Application Context we need to annotate our test class with annotation @SpringBootTest

![img_7.png](img_7.png)

![img_8.png](img_8.png)

![img_9.png](img_9.png)



Parameterized Test
------------------

SCENARIOS - 2 @CsvSource - (Passing Multiple values as a Parameters not a static value)
=======================================================================================

just like a loop with multiple values

![img_10.png](img_10.png)

![img_11.png](img_11.png)



SCENARIOS - 3 @ValueSource - (Passing Multiple values as a Parameters not a static value)
=========================================================================================

![img_12.png](img_12.png)

![img_13.png](img_13.png)


SCENARIOS - 4 @ArgumentSource / Custom Source - (Passing Multiple values as a Parameters not a static value)
============================================================================================================

ArgumentSource Test - String Data
----------------------------------
![img_14.png](img_14.png)

![img_15.png](img_15.png)

![img_16.png](img_16.png)

![img_17.png](img_17.png)


ArgumentSource Test - User Object Data
--------------------------------------
![img_18.png](img_18.png)

![img_19.png](img_19.png)

![img_20.png](img_20.png)

![img_21.png](img_21.png)

![img_22.png](img_22.png)