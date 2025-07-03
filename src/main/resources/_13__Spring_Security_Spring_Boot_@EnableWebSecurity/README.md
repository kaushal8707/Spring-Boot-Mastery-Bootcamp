
Spring Basic Security
========================
===========================

![img.png](img.png)

![img_1.png](img_1.png)

Authentication means to whom we allow to access application and to whom we should not. so, we have an API
are you able to access that API?? that is authentication. ex username, email password or 2 MFA.

Authorization means If you do have an Access then what all resources can you access. for example
do you have a admin role or read role.

=> To Handle Authentication & Authorization SPRING Security comes into picture.

![img_2.png](img_2.png)

![img_3.png](img_3.png)

![img_4.png](img_4.png)

![img_5.png](img_5.png)

![img_6.png](img_6.png)

![img_7.png](img_7.png)

What is mean of Basic Authentication ??
========================================

![img_8.png](img_8.png)

<encoded-string>
------------------

![img_9.png](img_9.png)

![img_10.png](img_10.png)

![img_11.png](img_11.png)

![img_12.png](img_12.png)

![img_13.png](img_13.png)

let's do Testing for our Controller
====================================

after adding dependencies now all endpoints get secured.

![img_14.png](img_14.png)

![img_15.png](img_15.png)

![img_16.png](img_16.png)

![img_17.png](img_17.png)

![img_18.png](img_18.png)

we have added username and pwd in Auth but If we open Header Postman automatically added in Header Authorization
as key and value as a Basic <encoded-string>

Key- Authorization
Value- Basic <encoded username:password>

![img_19.png](img_19.png)

Basic dXNlcjo0OGQwNTNiZi1iNmJiLTQxNjgtOTZmYi1hNzVlZjA4MTI1ZWM=
Basic <encoded-string>    i.e username:password  encoded using Base64

https://www.base64decode.org/
![img_20.png](img_20.png)

![img_21.png](img_21.png)

so, when we added in Authorization It automatically went to Header.

summary
========
now all the end-points got secured but using only one password we do have. so we need customization.

![img_22.png](img_22.png)


let's create a Configuration class
==================================

![img_23.png](img_23.png)

we are creating a class called SecurityConfig. why we are creating is now all our endpoints got secured
but, we want to secure only few endpoints and which all endpoints we want to secure matter. now we have only
one default user that also need changes.
SecurityConfig extending WebSecurityConfigurerAdapter. 

we have one annotation @EnableWebSecurity what is meaning of It??
-------------------------------------------------------------------
![img_24.png](img_24.png)

SecurityConfig extending WebSecurityConfigurerAdapter what is meaning of It??
------------------------------------------------------------------------------
![img_25.png](img_25.png)

![img_26.png](img_26.png)
![img_27.png](img_27.png)

HttpSecurity http
------------------
using instance of HttpSecurity we can apply all filters like which all requests we want to authenticate
which all requests we do not want to authenticate. 

![img_28.png](img_28.png)

![img_29.png](img_29.png)

![img_30.png](img_30.png)

![img_31.png](img_31.png)

![img_32.png](img_32.png)

![img_33.png](img_33.png)

![img_34.png](img_34.png)

![img_35.png](img_35.png)


Basic Authentication is Stateless What is Meaning for It??
==========================================================

I am sending a encoded username and password in Header, It went to server, and we got the response now
If I am sending second time requests then again same things i need to do. so, If I am sending 100 times
requests then 100 times i need to send username and password. stateless means second request do not know 
what was the first request. so all treat differently.


If Basic Authentication is stateless here then what the use of Logout here
==========================================================================

+ Some Applications do mix Basic Authentication with session management for various reasons.
+ This isn't standard behavior and requires additional setup and logic.
+ In such scenarios, once the user's credentials are verified via Basic Authentication, a session might
  be established, and the client is provided a session cookies. 
+ This way, the client won't need to send the Authorization header with every request, and the server
  can rely on the session cookie to identify the authenticated user.

When you login with Spring Security, It manages your authentication across multiple requests, despite HTTP being stateless
--------------------------------------------------------------------------------------------------------------------------
![img_36.png](img_36.png)

![img_37.png](img_37.png)


![img_38.png](img_38.png)






Authenticate Users Based on their Credentials stored in a Mongo Database
========================================================================

now any user can see any other user's journal entry. we want user can see only their own journal entries after authenticated successfully

![img_39.png](img_39.png)

![img_40.png](img_40.png)

![img_41.png](img_41.png)

Now let's delete old entries from AWS. let's create 2 users and for each users let's create 2 entries.
![img_42.png](img_42.png)

Now username and password we are not going to pass through URI we will give it inside a Header.

USE-CASE
========

![img_44.png](img_44.png)

![img_45.png](img_45.png)

A User can have roles like user, admin....

![img_46.png](img_46.png)

UserDetailsService Implementation to fetch user details

Inside Spring Security there is an Interface called UserDetailsService.

![img_47.png](img_47.png)

we have to create an Implementation class of a UserDetailsService.

![img_48.png](img_48.png)

![img_49.png](img_49.png)

![img_51.png](img_51.png)

![img_50.png](img_50.png)

we saw when we started our server then in Mongodb created a user collection in AWS bcz it has to do Indexing.

![img_52.png](img_52.png)


Some Modifications in User Controller
=====================================

![img_53.png](img_53.png)

as of now we are saving username and password as it is which is wrong.

BCryptEncoder we can use to hash the password

https://bcrypt-generator.com/

![img_55.png](img_55.png)

for user we have not added security if u can see...
![img_56.png](img_56.png)

![img_57.png](img_57.png)

![img_58.png](img_58.png)

*** Spring Security Manages a Session so we are going to disable it.
![img_59.png](img_59.png)

![img_60.png](img_60.png)

*** Now User is created and that endpoint is Public so anyone can access it.


Now Put Mapping to Update the User (Imp)
========================================

Obviously this should be Authenticated. now there is one problem create user we have to make it public so anyone can access it.
but there would be 2 more endpoint one for update and another for delete.

=> And that should only be accessible once user get loggedIn or user get authenticated.

create one Public controller and move create endpoint there. bcz our public control will be un-authenticated.
![img_61.png](img_61.png)

** => for /user we have to authenticate
![img_62.png](img_62.png)

Important
-----------

![img_63.png](img_63.png)

If username not pass here then from where it will take to update user. 

POST: localhost:8080/public/create-user

Now we Authenticate this PUT / update method

![img_64.png](img_64.png)

![img_65.png](img_65.png)

Now with which username and password we hit this endpoint automatically it will come here after authenticate no need to pass username
and password.so, How it will come, It will come using SecurityContextHolder.

*** When Any User get Authenticated then there details will get stored in SecurityContextHolder.
![img_66.png](img_66.png)
so, no need to give pwd bcz till here it will reach only If he gets authenticated.

=> so user send username and pwd converted into hash. 
![img_67.png](img_67.png)
after that it will get checked also the hash pwd we have and the hash pwd value from db matched or not. if matched then authenticated
otw forbidden. so spring security will handle all matching code here.

Testing
==========
In db we have a registered user akash & aks
let's pass that in our Basic Auth... let's give in body akash1 & aks1 and try to update

![img_68.png](img_68.png)
![img_70.png](img_70.png)

![img_69.png](img_69.png)

If I try again with old uname & pwd

![img_71.png](img_71.png)


DELETE User
============

![img_72.png](img_72.png)

![img_73.png](img_73.png)

![img_74.png](img_74.png)

![img_75.png](img_75.png)

![img_76.png](img_76.png)








