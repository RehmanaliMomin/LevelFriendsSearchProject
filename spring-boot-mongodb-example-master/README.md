# Circle - Assignment


1. There are Users and Blogs, and any user can comment on any blog.
2. Create a database with sample data, use database of your choice.
3. Consider all users who have commented on the same blog as friends ( 1st level
friend) .
4. A friend is 2nd level friend if he has commented on a blog where a 1st level friend has
also commented but has not commented on any common blog.
5. Example - Blog1 has comment of {User1, User2}, Blog2 has comment of {User1,
User3} here User2 and User3 are 2nd level friend if there exists no blog which has
comment of User2 and User3.
6. Similar to above there can be third level friend and k-th level friend ( LinkedIn shows
this kind of friend level)
7. Create a REST api GET /users/<userId>/level/<levelNo> which should give list of all
friends of that level for given userId (ex- /users/1234/level/1 for first level friend )
8. Use high standard design principles while implementing solution
9. Write modular and clean code with comments keeping in mind scalability and
manageability of code.


# Funda used :
- The User Table will keep track of the list of first level friends.
- The blog table will keep track of the userIds who have commented on that blog.
- Whenever a user comments on a blog, that user's first level friends will be populated with the help of the above 2nd point.
- And all that user of that blog obtained through 2nd point will have their list of first level friends updated.
- This is how the post APIs will work.
- Now for the get API, I have written the logic inside the UserService class using ArrayList and HashMap (https://github.com/RehmanaliMomin/LevelFriendsSearchProject/blob/master/spring-boot-mongodb-example-master/src/main/java/com/techprimers/mongodb/springbootmongodbexample/repository/UserService.java)


  
# Tech Stack Used : 
1. Database : MongoDB
2. Programming Language : Java

