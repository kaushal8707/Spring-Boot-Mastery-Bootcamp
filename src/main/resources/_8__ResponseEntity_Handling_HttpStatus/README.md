![img_13.png](img_13.png)

![img_14.png](img_14.png)

![img_15.png](img_15.png)

![img_16.png](img_16.png)

![img_17.png](img_17.png)

![img_18.png](img_18.png)

![img_19.png](img_19.png)

![img_20.png](img_20.png)

![img_21.png](img_21.png)

![img_22.png](img_22.png)

![img_23.png](img_23.png)

![img_24.png](img_24.png)

![img_25.png](img_25.png)

![img_26.png](img_26.png)

![img_27.png](img_27.png)

![img_28.png](img_28.png)

![img_29.png](img_29.png)

![img_30.png](img_30.png)

![img_31.png](img_31.png)

![img_32.png](img_32.png)

![img_33.png](img_33.png)


WE CAN ACHIEVE SENDING a STATUS CODE WITH HELP oF RESPONSE ENTITY
![img_34.png](img_34.png)
![img_35.png](img_35.png)

![img_36.png](img_36.png)

![img_37.png](img_37.png)



Code Change Explanation
========================


------------------------
1 - getJournalEntryById
------------------------
Earlier
-------
![img.png](img.png)
After ResponseEntity Addition
------------------------------
![img_1.png](img_1.png)
![img_2.png](img_2.png)
earlier it was showing 200:OK If data found and not found.. but now if found 200 if not found 404
![img_3.png](img_3.png)
![img_4.png](img_4.png)



------------------------
2 - create Journal Entry
------------------------
Earlier
-------
![img_5.png](img_5.png)
![img_7.png](img_7.png)
earlier it was showing 200:OK If entry created successfully But Now If created 201 If not Bad Request
After ResponseEntity Addition
------------------------------
![img_6.png](img_6.png)
![img_8.png](img_8.png)
![img_9.png](img_9.png)


------------------------
3 - Delete
------------------------
Earlier
-------
![img_10.png](img_10.png)
After ResponseEntity Addition
------------------------------
![img_12.png](img_12.png)
![img_11.png](img_11.png)





