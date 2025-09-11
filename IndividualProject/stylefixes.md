# Part 1 - Code Clean Up (not bugs, just style fix changes I made)

1. **Error:** `mvn checkstyle:check` warning: in `RouteController.java` there were 2 import package statements that used * statements. 
   - **Solution:** I deleted the * part of the import statements and looked at the @classname parts in the rest of the code (and other compilation error messages) to figure out what classes we needed.

2. **Error:** missing a Javadoc comment for `RouteController.java class`
   - **Solution:** Add a multi-line comment explaining the class is the API controller.

3. **Error:** incorrect indentation of the return statement in the catch block of `getAvailableBooks() and addCopy() in RouteController.java`
   - **Solution:** Delete extra indentation.

4. **Error:** in `Book.java`, abbreviations shouldn't have more than 1 consecutive uppercase letter.
   - **Solution:** Rename all instances of BOOK to Book, rename files to Book.java and BookUnitTests.java

5. **Error:** similarly, lowercase `MockApiService.java`
   - **Solution:** same as (4)

6. **Error:** in `MockApiService.java, MockApiService()` the catch block has a commented out return statement
   - **Solution:** Uncomment return statement + ensure proper indentation

7. **Error:** in `MockApiService.java, updateBook()` javadoc comment missing period
   - **Solution:** add .

8. **Error:** in `MockApiService.java, updateBook()` there should be a empty line preceding @param tag
   - **Solution:** add new line

9. **Error:** in `MockApiService.java, updateBook()` there should be a empty line preceding import statements tag
   - **Solution:** add new line

10. **Error:** import statements have wrong lexicographical order in `MockApiService.java`
   - **Solution:** reordered in alphabetical order
