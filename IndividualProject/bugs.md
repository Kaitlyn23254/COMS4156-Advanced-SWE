# Part 0 Maven Bugs

1. **Error:** `mvn compile` failed because there was a missing return statement in `RouteController.java`. Specifically in the `addCopy` method, the catch block missed a return statement.
   - **Solution:** Returned a new `ResponseEntity` saying something went wrong when adding a book copy.

2. **Error:** `mvn compile` also failed because there was an incompatible type conversion in `model.book`. In the inherited `equals()` method, when assigning `Book cmpBook = obj;` they forgot to cast `obj` to `Book` type first.
   - **Solution:** `Book cmpBook = (Book) obj;`

3. **Error:** `mvn compile` failed because in `Book.java`, `getLanguage()` was not implemented and had no return statement.
   - **Solution:** Add a `return language;` statement. It compiles now

# Part 2 - Testing

1. **Bug:** `Book.java hasCopies()` method has a logic error where it returns true if copiesAvailable >= 0
   - **Solution:** return copiesAvailable > 0

2. **Bug:**  `Book.java returnCopy()` method has a logic error where it only looped through return dates if returnDates was empty
   - **Solution:** We only loop if returnDates is **not** empty

3. **Bug:** `Book.java deleteCopy()` method has a logic error where the return false/true statements were switched, resulting in a method that returned false if there was a successful deletion.
   - **Solution:** Switch return statements

# Part 3 - PMD Analysis

1. **Bug:** in `Book.java` there was an unused private variable called `bookmarks` that was never used in the rest of the class.
   - **Solution:** Delete unused variables.

2. **Bug:** in `RouteController.java`, the `addCopy()` method, there was an unused StringBuilder variable `currBookId` which was part of a larger logic problem where the method was using equals() to compare book IDs (which are ints) instead of ==
   - **Solution:** deleted Stringbuilder line, changed equals() comparison to ==