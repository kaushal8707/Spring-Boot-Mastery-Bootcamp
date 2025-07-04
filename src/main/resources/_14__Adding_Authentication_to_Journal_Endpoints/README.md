
How to Test this App ?? Auth
----------------------------

First create a Uer using 
![img_31.png](img_31.png)

now user got registered, each entries associated with a user. 
so, User need to authenticated to perform operations on journal entries like add entry/delete entry by id/ update entry by id/
get all entries.
so, while performing operations you have to authenticated and add Basic Auth Credentials 
------------------------------------------------------------------------------------


we have a postman collection- journal-spring-boot-mastery.postman_collection with mentioned steps just import and test


Earlier we have enabled the Authorization in UserController so, now we will Authorize the JournalController.

so, here we are sending username in path variable and password we are not sending it. so AUth not yet enabled any user can come and
see any user journal entry.

Use-case
--------

User1 can see only their own entry ..same like user 2. so they can do after login.

![img.png](img.png)

unauthorized bcz we have added the authentication on journal endpoint.

![img_1.png](img_1.png)

![img_2.png](img_2.png)

Not found that is right bcz for user-akash1 there is no journal entry.

![img_3.png](img_3.png)

![img_4.png](img_4.png)
![img_5.png](img_5.png)

![img_6.png](img_6.png)
![img_7.png](img_7.png)

getJournalEntryById
==========================

earlier code
![img_9.png](img_9.png)

Imp - you have to make sure the id which you are passing should be from your journal entry id only not others please make sure
so let's do changes.

If myId(passed userid) is not in journal entries list which mean you are passing wrong value id.

![img_10.png](img_10.png)

How to Test
==========

first create user
![img_11.png](img_11.png)
get all entries- not found bcz no entries
![img_12.png](img_12.png)
create entries with authorization data
![img_13.png](img_13.png)
getJournalEntryById (id-> journal entry object id which is ref in user journal entry as well same)
![img_14.png](img_14.png)
![img_15.png](img_15.png)       bcz user should only see their own entries
![img_16.png](img_16.png)
![img_17.png](img_17.png)

so first add user-> play with journal entries controller after adding auth credentials


deleteJournalEntryById
========================

![img_18.png](img_18.png)

let's delete office title one

![img_19.png](img_19.png)
![img_20.png](img_20.png)

![img_21.png](img_21.png)
![img_22.png](img_22.png)
![img_23.png](img_23.png)



updateJournalEntryById
=======================

earlier data
![img_24.png](img_24.png)
![img_26.png](img_26.png)

![img_27.png](img_27.png)
![img_28.png](img_28.png)

![img_29.png](img_29.png)
![img_30.png](img_30.png)

We have added Auth to User and JournalEntry Controller


