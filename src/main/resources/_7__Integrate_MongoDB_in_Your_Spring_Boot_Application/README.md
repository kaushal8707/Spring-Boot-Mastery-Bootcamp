
![img.png](img.png)

![img_1.png](img_1.png)

![img_2.png](img_2.png)

![img_3.png](img_3.png)

![img_4.png](img_4.png)

Postman Testing
==================

1. POST : Create Entry
----------------------

![img_5.png](img_5.png)

![img_7.png](img_7.png)

we can see Id automatically created as we not pass in our postman request. 


===>>  now let me pass Id from postman as 2

![img_8.png](img_8.png)

![img_9.png](img_9.png)

we can see flexibility. we are able to change the Id datatype every time. It converted 2 into String because
In our JournalEntry Entity we have given @Id as a String type. so default mongodb generated Id got mapped with 
@Id String Id value. because we have given @Id annotation. 
    So, In postman If you give Id then It will get saved as It is, But If you will not give then mongodb will
use their own data type ObjectId for Id.


===>> let me add same entry with Id : 2, let's see what will happen.

![img_10.png](img_10.png)

we can see It's not get added.

![img_11.png](img_11.png)

===>> let me update/do some changes other than Id, let's see what will happen.

![img_12.png](img_12.png)

we can see id:2 record got updated. so when Id same then new document won't add it will update that specific document.

![img_13.png](img_13.png)

![img_14.png](img_14.png)
----------------------------------------------------------------------------------------
*** let's delete all entries from database and change Id as a String given to ObjectId.

![img_15.png](img_15.png)

![img_16.png](img_16.png)

![img_17.png](img_17.png)

we should not add date manually while sending request from postman it should automatically come bcz we are
going to set LocalDateTime.now()

![img_18.png](img_18.png)

![img_22.png](img_22.png)

![img_20.png](img_20.png)

![img_21.png](img_21.png)
----------------------------------------------------------------------------------------


2. GET : Fetch Journal Entries
------------------------------

3. GET : Fetch Journal Entry By Id
-----------------------------------

4. PUT : Update By Id
---------------------

5. DELETE : Delete By Id
-------------------------


Testing
=========

In DB 2 documents

![img_23.png](img_23.png)


![img_24.png](img_24.png)

![img_25.png](img_25.png)

![img_26.png](img_26.png)

![img_27.png](img_27.png)

![img_28.png](img_28.png)

