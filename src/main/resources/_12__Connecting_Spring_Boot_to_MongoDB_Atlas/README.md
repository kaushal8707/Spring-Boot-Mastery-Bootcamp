
Connecting Spring Boot to MongoDB Atlas
========================================

type mongodb atlas

it will give you a username and password
![img_1.png](img_1.png)

pwd-PhIJ2to8RHU8vXd0
uname-kaushalkumar

click on Drivers

connection string - mongodb+srv://kaushalkumar:PhIJ2to8RHU8vXd0@cluster0.w7qhtng.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0

![img_2.png](img_2.png)

![img_3.png](img_3.png)

remove host and port now

![img_4.png](img_4.png)

IP Access List

106.221.212.218/32

start your application and browse collection in Atlas...

![img_5.png](img_5.png)

we can see automatically journalDB database and inside that there is a user collection.

![img_6.png](img_6.png)

users collection made bcz we have written we want Indexing on username.

Testing
==========

Let's create an User from this API through Postman

now our server is in local but our database is in AWS

![img_7.png](img_7.png)

![img_8.png](img_8.png)

you can't find data in local db mongosh...bcz not our db is trigged to AWS
![img_9.png](img_9.png)
















