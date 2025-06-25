@SpringBootApplication Internal Working | IOC Container & Dependency Injection in Spring Boot
=============================================================================================

![img.png](img.png)

![img_1.png](img_1.png)

![img_2.png](img_2.png)


Spring Boot Core Concept
-------------------------

![img_3.png](img_3.png)

earlier If we have a class and we want to create an instance. we were creating an object using new keyword . 
But Spring provides a functionality so now we are going and ask to Spring to create an Object and give it to us.

Now we are externalizing the object creation. earlier we were creating now spring is do it behalf of us.
Now we move the control from developer to Spring that's called Inversion of Control.

Now we will go to Spring IOC container i.e spring and IOC will give an object to us. 
![img_4.png](img_4.png)

IOC Container is a part of SPRING. 


Difference Between IOC Container and Application Context
========================================================

Application Context is a way to Implement IOC Container. We achieve IOC Container with the help of Application Context.

![img_5.png](img_5.png)

ApplicationContext is a way to achieve IOC Container.


How IOC Container keeps the Beans inside ??
============================================

Actually IOC container scans the package which we defined. If we have 100 classes Is IOC container keep all 100 classes
with them Answer is - No.  

IOC container will see Is class is annotated with @Component annotation. If yes then he will kept that class as a Bean.

![img_7.png](img_7.png)

Class is Automatically registered as a Spring Bean If It annotated with @Component.

![img_8.png](img_8.png)

Bean -> In Spring Language Object is called Bean. write @Component with class it is called Bean.




@SpringBootApplication Internal Working
=======================================

![img_9.png](img_9.png)

![img_10.png](img_10.png)


In our Spring Boot Application this is the main Entry Point. this annotation we put in a main method.

this annotation will perform 3 tasks:

![img_11.png](img_11.png)


this @SpringBootApplication annotation perform work for 3 annotations. 

a. ComponentScan: Either you can say IOC container or ApplicationContext. it will look for a classes which is annotated 
                  with @Component. It will scan the Beans so later while user need IOC container can provide. it will look into
                  the base package we defined and where main method defined. 

   ![img_12.png](img_12.png)
   
   ![img_13.png](img_13.png)
   
   ![img_14.png](img_14.png)
   
   ** let's put both class into a same package.

   http://localhost:8080/ok

   ![img_15.png](img_15.png)

   @RestController  is a specialized version of a Component. @RestController also creates a Bean. because @RestController consist of @Controller + @ResponseBody. @Controller consist of
   @Component. @Controller is a stereotype annotation. Car class we annotated with @RestController so this will also register as bean.

   @Autowired 
   private Dog dog;  -> this is called Dependency Injection. 
   Now our Car is depending on a Dog class. now we are asking spring to give a dog object.
   Now our Car is depending on a Dog class and we have injected dog into a Car class using @Autowired called Filled Injection.

   
b. @EnableAutoConfiguration: It will do Configuration automatically. now you want to run mongodb. you are just adding the
                             mongodb dependency in pom.xml and in .properties file added server, port and username/password.
                             springboot will do everything by itself. so no need to do anything like creating a connection and all.
                             It will do Configuration automatically.


c. @Configuration:  @Configuration annotation if you are writing on a class then that class will provide some configuration. generally
                    @Configuration annotation get using with an annotation that annotation is called @Bean. we can create a Bean
                    using bean annotation @Bean as well. @Bean annotation we never apply on a class we applied only on a function/method.
                    while we define @Configuration on any class then we can create a Bean Inside that class with the help of Function. 
                    
   
   
  