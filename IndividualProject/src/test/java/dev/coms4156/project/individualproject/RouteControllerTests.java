package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dev.coms4156.project.individualproject.controller.RouteController;
import dev.coms4156.project.individualproject.model.Book;
import dev.coms4156.project.individualproject.service.MockApiService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * This class contains the unit tests for the RouteController class.
 */
@SpringBootTest
public class RouteControllerTests {

  private RouteController routeController;

  /**
    * A mockup of a mock API that will always use the same list of books we give it
    * for consistency in testing's sake.
  */
  public static class FakeMockApiService extends MockApiService {
    private final List<Book> books;

    public FakeMockApiService(List<Book> books) {
      this.books = books;
    }

    @Override
    public ArrayList<Book> getBooks() {
      return new ArrayList<>(books);
    }
  }

  @Test
  public void testRecommendationReturnsTenBooks() {
    List<Book> books = new ArrayList<>();

    for (int i = 1; i <= 15; i++) {
      Book book = new Book("Book " + i, i);
      book.setAmountOfTimesCheckedOut(i);
      books.add(book);
    }

    routeController = new RouteController(new FakeMockApiService(books));

    ResponseEntity<?> response = routeController.getRecommendations();

    assertEquals(HttpStatus.OK, response.getStatusCode());

    Object body = response.getBody();
    List<Book> recommendations = (List<Book>) body;

    assertEquals(10, recommendations.size(), "Should return 10 books");

    long uniqueCount = recommendations.stream().distinct().count();
    assertEquals(10, uniqueCount, "All recommended books should be unique");
  }
}
