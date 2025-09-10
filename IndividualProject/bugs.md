# Part 0 Maven Bugs

1. **Error:** `mvn compile` failed because there was a missing return statement in `RouteController.java`. Specifically in the `addCopy` method, the catch block missed a return statement.
   - **Solution:** Returned a new `ResponseEntity` saying something went wrong when adding a book copy.

2. **Error:** `mvn compile` also failed because there was an incompatible type conversion in `model.book`. In the inherited `equals()` method, when assigning `BOOK cmpBook = obj;` they forgot to cast `obj` to `BOOK` type first.
   - **Solution:** `BOOK cmpBook = (BOOK) obj;`

3. **Error:** `mvn compile` failed because in `Book.java`, `getLanguage()` was not implemented and had no return statement.
   - **Solution:** Add a `return language;` statement. It compiles now!

4. 

# Part 1 - [Next Section]

1. **Error:** 
   - **Solution:**

2. **Error:**
   - **Solution:**

# Part 2 - [Next Section]

1. **Error:**
   - **Solution:**