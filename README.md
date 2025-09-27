# 4156-Miniproject-2025-Students
This is the public repo for posting the miniproject assignments to the class COMS 4156 Advanced Software Engineering at Columbia University. It was originally forked from: https://github.com/Programming-Systems-Lab/4156-Miniproject-2025-Students

This is a RESTful API service for managing a book lending system.

## Building and Running a Local Instance
In order to build and use this service you must install the following:

1. **Maven 3.9.11+**: https://maven.apache.org/download.cgi
  - Download and follow the installation instructions
  - Make sure to add Maven's bin directory to your PATH environment variable

2. **JDK 21**: This project uses JDK 21 for development
  - Download from: https://www.oracle.com/java/technologies/downloads/#java21

3. **IntelliJ IDE**: We recommend IntelliJ but you can use any IDE
  - Download from: https://www.jetbrains.com/idea/download/

4. **Cloning repo**: Open terminal and copy these commands. At the top of this GitHub page, click the green code button and copy the http line into the <repository-url> placeholder:
```
git clone <repository-url>
cd 4156-Miniproject-2025-Students/IndividualProject
```

5. **Building the application**: Run these commands in your terminal
```
mvn clean compile
mvn spring-boot:run
```

## Running Tests
Unit tests are located under the `/IndividualProject/src/test` directory.

To run all tests and generate coverage report:
```
mvn clean test
mvn test jacoco:report
```

Coverage reports will be generated in `target/site/jacoco/index.html`

## Checkstyle
To run the style checker, use `mvn checkstyle:check` or `mvn checkstyle:checkstyle` if you want to generate a report as well.

## Static Analysis
I used PMD, a built-in Maven, plugin, to perform static analysis (bugs and code styling). If you fork the repo, this code is already included in pom.xml but to use PMD in general make sure to include this code. 

It implements the JXR plugin in pom.xml, a stylistic tool that lets you visualize your code in HTML better, which is helpful for reading the reports.
```	<reporting>
<plugins>
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-jxr-plugin</artifactId>
        <version>3.3.0</version>
    </plugin>
</plugins>
```
To generate a pmd report, run in terminal:
```mvn pmd:pmd```

Reports are generated in `target/site/pmd.html`


## Continuous Integration
This project uses GitHub Actions for CI/CD. The pipeline automatically:
- Builds the project
- Runs all unit tests
- Performs code style checking with Checkstyle
- Runs static analysis with PMD

View the latest CI results: [GitHub Actions](UPDATE THIS URL LATER../../actions) 


## API Endpoints
All endpoints that return a Book object also return the associated information: title, authors
  language, shelving location, publication date, publishers, subjects, ID,
  amount of times checked out, copies available, return dates, and total copies.

#### GET / or /index
* Expected Input Parameters: N/A
* Expected Output: Welcome message (String)
* Displays a welcome message with basic API usage information.
* Upon Success: HTTP 200 Status Code is returned along with the welcome message
* Upon Failure: N/A - This endpoint should not fail in normal circumstances

#### GET /book/{id}
* Expected Input Parameters: id (int)
* Expected Output: Book object corresponding to that ID
* Retrieves the details of a specific book by its unique identifier.
* Upon Success: HTTP 200 Status Code is returned along with the book object in the response body
* Upon Failure: HTTP 404 Status Code is returned along with "Book not found." in the response body

#### PUT /books/available
* Expected Input Parameters: N/A
* Expected Output: List of available Book object
* Retrieves all books that have available copies for checkout.
* Upon Success: HTTP 200 Status Code is returned along with the list of available books in the response body
* Upon Failure: HTTP 500 Status Code is returned along with "Error occurred when getting all available books" in the response body

#### GET /book/recommendation
* Expected Input Parameters: N/A
* Expected Output: List of 10 recommended Book objects
* Returns 10 book recommendations consisting of the 5 most popular books plus 5 additional random selections.
* Upon Success: HTTP 200 Status Code is returned along with the list of recommended books in the response body
* Upon Failure: HTTP 200 Status Code is returned along with "Error occurred when getting recommended books" in the response body

#### PATCH /book/{bookId}/add
* Expected Input Parameters: bookId (int)
* Expected Output: Updated Book object
* Adds one copy to the specified book's inventory.
* Upon Success: HTTP 200 Status Code is returned along with the updated book object in the response body
* Upon Failure:
  * HTTP 404 Status Code with "Book not found." in the body if the specified book does not exist
  * HTTP 500 Status Code with "Error occurred when adding a copy to the Book" in the response body if an unexpected error occurs

#### PATCH /book/{bookId}/checkout
* Expected Input Parameters: bookId (int)
* Expected Output: Updated Book object
* Checks out one copy of the specified book if available.
* Upon Success: HTTP 200 Status Code is returned along with the updated book object in the response body
* Upon Failure:
  * HTTP 409 Status Code with "Book not available." in the body if the book has no available copies
  * HTTP 404 Status Code with "Book not found." in the body if the specified book does not exist
  * HTTP 500 Status Code with "Error occurred when checking out." in the response body if an unexpected error occurs

## Technologies Used 🧰
- **Java 17** - Programming language
- **Spring Boot** - Application framework
- **Maven** - Build and dependency management
- **JUnit** - Unit testing framework
- **Mockito** - Mocking framework for tests
- **GitHub Actions** - Continuous Integration
- **Checkstyle** - Code style checking
- **PMD** - Static code analysis
- **JaCoCo** - Code coverage reporting


