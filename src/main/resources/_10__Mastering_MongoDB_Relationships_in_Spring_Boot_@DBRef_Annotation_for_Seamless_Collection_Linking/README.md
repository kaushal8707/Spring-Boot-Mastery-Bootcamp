

USECASE
========

We are going to Implement the Login Functionality. Every User can have many Journal Entries. let's assume 10 users then all 
user's corresponding journal entries will be there. All general entries will be associated with a user, obviously. 
suppose I am a user, I am entering my username and password then i could see only my journal entries not others.

This Authentication Process we are going to start from here...

so, our User will be look like this...

![img.png](img.png)

There will be a username, a password, and there will be a List of Journal Entries and here there will be Id for a User's Journal.

![img_3.png](img_3.png)

=> using Indexing on username field searching will get faster. so, all username will be unique here and it should be also.

=> Neither username and password should be null.

=> we want every user should have a particular journal entries. so, we want to map all journal entries to a particular users.

=> In DB In a user collection there will be multiple users there is a field called journalEntries. so journalEntries will contains
   a list of journalEntry. 

=> when one User get Initialized then there will be an empty JournalEntries list not null.

Is user collection and journalEntries collection get mapped by using this much configuration???
-----------------------------------------------------------------------------------------------

Is user collection and journalEntries collection get linked by this much configuration. 
so, we need to use one annotation @DBRef. which mean you are creating a Reference of JournalEntry inside a User.
which mean JournalEntries will keep a reference of a JournalEntry data. so it will looks like this below.

![img_4.png](img_4.png)

suppose username is ram, and a password and see in journalEntries has 2 reference, not kept a complete document like title..
but it kept a reference, a objectId of journalEntries of a particular document. so, we linked both. so for a User Ram there
are 2 journalEntries. so, the main use will be suppose In future we are deleting a User so from here we can fetch journalEntry
of a particular user then we can delete that entry as well. this work like a foreign keys. so here journalEntries field here
work like a reference and helping to make a link between these 2 collections.

![img_5.png](img_5.png)

so, parent child relationship got established here.

![img_7.png](img_7.png)
here we have written @Indexed(unique=true) but automatically won't create to create automatically we need to set properties.
by default spring won't do Indexing we have to configure in properties file.

![img_6.png](img_6.png)

UserController created let's do testing through postman.

![img_8.png](img_8.png)

![img_9.png](img_9.png)

![img_10.png](img_10.png)

we can see we have created a user with userName kaushal8707.as we have mentioned userName Indexed unique
   @Indexed(unique = true)
   @NonNull
   private String userName;

so while trying to create one more user getting exception
![img_11.png](img_11.png)

![img_12.png](img_12.png)

we are getting a duplicate key exception.

now we can't change the username. for this functionality we can't change the username. so now if i send
a request with name manu it won't create bcz there are no user with that name. 
now we have created a UserController which will create a user, get a user list and update a user.
![img_13.png](img_13.png)


let's try for update PUT Method
-------------------------------

![img_14.png](img_14.png)

![img_15.png](img_15.png)

so now all 3 end points tested for a user endpoint
![img_16.png](img_16.png)
![img_17.png](img_17.png)
![img_18.png](img_18.png)




Important->
->
->->
->->->

Usecase of @DBRef & @Indexed
============================

Till now there is no link between Journal Entry and User.

so, when we do a get call for a journal entry then what all entries are there i db it will fetch. But now what we will do for
a particular user's entry we will fetch. similarly while we do entry in db then we mentioned for which user we are doing
journal entries. so we will perform all operations for a particular user.

![img_19.png](img_19.png)

so now here by userName we are able to find the User like below. here always journalEntries will be an empty list bcz we have initialized
using new ArrayList<>();

![img_20.png](img_20.png)

![img_21.png](img_21.png)

![img_22.png](img_22.png)

![img_23.png](img_23.png)

Testing----->
---------------

** In Entity class we need @NoArgConstructor which is needed during de-serialization means converting from JSON to POJO.
In User we have one user- kaushal
![img_24.png](img_24.png)

step 1-
go to postman and do 1 entry in journal for a user-kaushal

![img_25.png](img_25.png)

![img_26.png](img_26.png)

![img_27.png](img_27.png)

Now we have tested below 2 API's and one more also get By ObjectId bcz no change req now done
---------------------------------------------------------------------------------------------

![img_29.png](img_29.png)


let's try for DELETE Journal Entry
===================================

let's see DB first

![img_30.png](img_30.png)

now for a user kaushal there is one journal entry whose id is : 6864e97899b6b736141c0262 let's try to delete

![img_31.png](img_31.png)

![img_32.png](img_32.png)

conclusion: deleted entries from journal entry table but still there is a reference of a journal entries in a user table.
            which means automatically not got deleted. this is called cascade deleted which doesn't happened here in mongodb.
            let's do it now.


![img_33.png](img_33.png)

![img_34.png](img_34.png)

now here updated user got saved not new user bcz in that id will also be there. then on same id if we run save()  then will
get updated. so here user saved and journal entry got deleted. let's try run and test.

=> let's create some entry then try deleting

![img_35.png](img_35.png)
![img_36.png](img_36.png)

![img_37.png](img_37.png)

DELETE : localhost:8080/journal/id/Kaushal/6864f25005c39508cc8e66fa

![img_38.png](img_38.png)

![img_39.png](img_39.png)

=> that entry got deleted whose title was 2.



            
Now let's see UPDATE By ID
============================

old api enpoint
![img_40.png](img_40.png)

after code change:-

![img_41.png](img_41.png)

PUT : localhost:8080/journal/id/Kaushal/6864f27b05c39508cc8e66fb

![img_42.png](img_42.png)

![img_43.png](img_43.png)




Now here we made a relation between user and journal entries...like while adding in journal entries it adding in user also...while deleting
from journal entries its deleting from user as well.





















