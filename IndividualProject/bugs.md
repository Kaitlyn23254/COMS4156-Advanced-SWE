# Part 0 Maven Bugs

1. **Error:** `mvn compile` failed because there was a missing return statement in `RouteController.java`. Specifically in the `addCopy` method, the catch block missed a return statement.
   - **Solution:** Returned a new `ResponseEntity` saying something went wrong when adding a book copy.

2. **Error:** `mvn compile` also failed because there was an incompatible type conversion in `model.book`. In the inherited `equals()` method, when assigning `Book cmpBook = obj;` they forgot to cast `obj` to `Book` type first.
   - **Solution:** `Book cmpBook = (Book) obj;`

3. **Error:** `mvn compile` failed because in `Book.java`, `getLanguage()` was not implemented and had no return statement.
   - **Solution:** Add a `return language;` statement. It compiles now!

# Part 1 - Code Clean Up

1. **Error:** `mvn checkstyle:check` warning: in `RouteController.java` there were 2 import package statements that used * statements. 
   - **Solution:** I deleted the * part of the import statements and let the error messages tell me exactly which classes we needed. **err come back to this**

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

9. **Error:**
   - **Solution:**

10. **Error:**
   - **Solution:**

# Part 2 - [Next Section]

1. **Error:** 
   - **Solution:**

2. **Error:**
   - **Solution:**

3. **Error:**
   - **Solution:**

4. **Error:**
   - **Solution:**

5. **Error:**
   - **Solution:**

6. **Error:** 
   - **Solution:**

7. **Error:**
   - **Solution:**

8. **Error:**
   - **Solution:**

9. **Error:**
   - **Solution:**

10. **Error:**
   - **Solution:**