package dev.coms4156.project.individualproject;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dev.coms4156.project.individualproject.model.Book;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * This class contains the unit tests for the Book class.
 */
@SpringBootTest
public class BookUnitTests {

  public static Book book;

  /**
   * This method sets up a commonly used Book objects
   * across testing different methods.
   */
  @BeforeAll
  public static void setUpBookForTesting() {
    book = new Book("When Breath Becomes Air", 0);
  }

  @Test
  public void hasCopiesTestWhenCopiesAvailable() {
    Book fullBook = new Book(
        "Whatever",
        new ArrayList<>(),  // authors
        "",                 // language
        "",                 // shelving location  
        "",                 // publication date
        "",                 // publisher
        new ArrayList<>(),  // subjects
        99,                 // id
        3,                  // copiesAvailable
        5                   // totalCopies
    );
    boolean hasCopies = fullBook.hasCopies();
    assertEquals(true, hasCopies);
  }

  @Test
  public void hasCopiesTestWhenNoCopiesAvailable() {
    Book zeroCopiesBook = new Book(
        "No Copies Book",
        new ArrayList<>(),  // authors
        "",                 // language
        "",                 // shelving location  
        "",                 // publication date
        "",                 // publisher
        new ArrayList<>(),  // subjects
        99,                 // id
        0,                  // copiesAvailable
        0                   // totalCopies
    );
    boolean hasCopies = zeroCopiesBook.hasCopies();
    assertEquals(false, hasCopies);
  }

  @Test
  public void hasMultipleAuthorsWhenMultiple() {
    Book multipleAuthorsBook = new Book(
        "Multiple Authors",
        new ArrayList<>() { {
              add("Kaitlyn Wei");
              add("Gail Kaiser");
          }},                 // authors
        "",                 // language
        "",                 // shelving location  
        "",                 // publication date
        "",                 // publisher
        new ArrayList<>(),  // subjects
        99,                 // id
        0,                  // copiesAvailable
        0                   // totalCopies
    );
    boolean multipleAuthors = multipleAuthorsBook.hasMultipleAuthors();
    assertEquals(true, multipleAuthors);
  }

  @Test
  public void hasMultipleAuthorsWhenSingle() {
    Book singleAuthorsBook = new Book(
        "One Authors",
        new ArrayList<>() { {
              add("Kaitlyn Wei");
          }},                 // authors
        "",                 // language
        "",                 // shelving location  
        "",                 // publication date
        "",                 // publisher
        new ArrayList<>(),  // subjects
        99,                 // id
        0,                  // copiesAvailable
        0                   // totalCopies
    );
    boolean singleAuthors = singleAuthorsBook.hasMultipleAuthors();
    assertEquals(false, singleAuthors);
  }

  @Test
  public void setReturnDatesNull() {
    Book book = new Book("C++", 1);
    book.setReturnDates(null);

    assertNotNull(book.getReturnDates());
  }

  @Test
  public void setReturnDatesNotNull() {
    Book book = new Book("C++", 1);
    ArrayList<String> dates = new ArrayList<>();
    dates.add("2025-07-16");
    dates.add("2025-07-17");

    book.setReturnDates(dates);

    assertEquals(2, book.getReturnDates().size());
    assertEquals("2025-07-16", book.getReturnDates().get(0));
    assertEquals("2025-07-17", book.getReturnDates().get(1));
  }

  @Test
  public void checkoutCopyIfAvailable() {
    Book available = new Book(
        "Yay Copies",
        new ArrayList<>(),  // authors
        "",                 // language
        "",                 // shelving location  
        "",                 // publication date
        "",                 // publisher
        new ArrayList<>(),  // subjects
        99,                 // id
        1,                  // copiesAvailable
        1                   // totalCopies
    );
    LocalDate today = LocalDate.now();
    LocalDate dueDate = today.plusWeeks(2);
    String dueDateStr = dueDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    
    assertEquals(dueDateStr, available.checkoutCopy());
  }

  @Test
  public void checkoutCopyIfNotAvailable() {
    Book notAvailable = new Book(
        "Yay Copies",
        new ArrayList<>(),  // authors
        "",                 // language
        "",                 // shelving location  
        "",                 // publication date
        "",                 // publisher
        new ArrayList<>(),  // subjects
        99,                 // id
        0,                  // copiesAvailable
        1                   // totalCopies
    );
    
    assertNull(notAvailable.checkoutCopy());
  }

  @Test
  public void returnCopySuccess() {
    Book checkedout = new Book(
        "Return",
        new ArrayList<>(),  // authors
        "",                 // language
        "",                 // shelving location  
        "",                 // publication date
        "",                 // publisher
        new ArrayList<>(),  // subjects
        99,                 // id
        1,                  // copiesAvailable
        2                   // totalCopies
    );

    LocalDate today = LocalDate.now();
    LocalDate dueDate = today.plusWeeks(2);
    LocalDate dueDate2 = today.plusWeeks(3);
    
    String dueDateStr = dueDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    String dueDateStr2 = dueDate2.format(DateTimeFormatter.ISO_LOCAL_DATE);

    ArrayList<String> dates = new ArrayList<>();
    dates.add(dueDateStr);
    dates.add(dueDateStr2);
    checkedout.setReturnDates(dates);

    int beforeCopies = checkedout.getCopiesAvailable();
    boolean match = checkedout.returnCopy(dueDateStr);
    
    assertEquals(true, match);
    assertEquals(beforeCopies + 1, checkedout.getCopiesAvailable());
    assertFalse(checkedout.getReturnDates().contains(dueDateStr));
    assertTrue(checkedout.getReturnDates().contains(dueDateStr2));
  } 

  @Test
  public void returnCopyNoMatch() {
    Book notCheckedout = new Book(
        "Return",
        new ArrayList<>(),  // authors
        "",                 // language
        "",                 // shelving location  
        "",                 // publication date
        "",                 // publisher
        new ArrayList<>(),  // subjects
        99,                 // id
        1,                  // copiesAvailable
        2                   // totalCopies
    );

    LocalDate today = LocalDate.now();
    LocalDate dueDate = today.plusWeeks(2);
    LocalDate wrongDate = today.plusWeeks(3);
    
    String dueDateStr = dueDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    String wrongDateStr = wrongDate.format(DateTimeFormatter.ISO_LOCAL_DATE);

    ArrayList<String> dates = new ArrayList<>();
    dates.add(dueDateStr);
    notCheckedout.setReturnDates(dates);

    int beforeCopies = notCheckedout.getCopiesAvailable();
    boolean match = notCheckedout.returnCopy(wrongDateStr);
    
    assertEquals(false, match);
    assertEquals(beforeCopies, notCheckedout.getCopiesAvailable());
    assertTrue(notCheckedout.getReturnDates().contains(dueDateStr));
  } 

  @Test
  public void returnCopyEmptyDueDates() {
    Book book = new Book("C++", 1);
    book.setReturnDates(null);  // makes return date list empty

    LocalDate today = LocalDate.now();
    String dueDateStr = today.format(DateTimeFormatter.ISO_LOCAL_DATE);

    boolean match = book.returnCopy(dueDateStr);
    assertEquals(false, match);
  }

  @Test
  public void deleteCopyYesCopyYesAvailable() {
    Book book = new Book(
        "Tester",
        new ArrayList<>(),  // authors
        "",                 // language
        "",                 // shelving location  
        "",                 // publication date
        "",                 // publisher
        new ArrayList<>(),  // subjects
        35,                 // id
        3,                  // copiesAvailable
        3                   // totalCopies
    );

    int totalCopies = book.getTotalCopies();
    int copiesAvailable = book.getCopiesAvailable();
    boolean deleted = book.deleteCopy();

    assertEquals(true, deleted);
    assertEquals(totalCopies - 1, book.getTotalCopies());
    assertEquals(copiesAvailable - 1, book.getCopiesAvailable());
  }

  @Test
  public void deleteCopyYesCopyNoAvailable() {
    Book book = new Book(
        "Tester",
        new ArrayList<>(),  // authors
        "",                 // language
        "",                 // shelving location  
        "",                 // publication date
        "",                 // publisher
        new ArrayList<>(),  // subjects
        35,                 // id
        0,                  // copiesAvailable
        3                   // totalCopies
    );

    boolean deleted = book.deleteCopy();
    assertEquals(false, deleted);
  }

  @Test
  public void deleteCopyNoCopyNoAvailable() {
    Book notAvailable = new Book(
        "Whatever",
        new ArrayList<>(),  // authors
        "",                 // language
        "",                 // shelving location  
        "",                 // publication date
        "",                 // publisher
        new ArrayList<>(),  // subjects
        35,                 // id
        0,                  // copiesAvailable
        0                   // totalCopies
    );

    boolean deleted = notAvailable.deleteCopy();
    assertEquals(false, deleted);
  }
  

  @Test
  public void equalsBothAreTheSameTest() {
    Book book = new Book("When Breath Becomes Air", 0);
    Book cmpBook = book;
    assertEquals(cmpBook, book);
  }

  @Test
  public void equalsObjIsNull() {
    Book book = new Book("When Breath Becomes Air", 0);
    Book cmpBook = null;
    assertEquals(false, book.equals(cmpBook));
  }

  @Test
  public void equalClassesNotEqual() {
    Book book = new Book("When Breath Becomes Air", 0);
    String cmpStr = "Lol";
    assertEquals(false, book.equals(cmpStr));
  }

  @Test
  public void equalIdsEqual() {
    Book book = new Book("When Breath Becomes Air", 0);
    Object cmpBook = new Book("When Breath Becomes Air", 0);
    Boolean same = book.equals(cmpBook);
    assertEquals(true, same);
  }

  @Test
  public void equalIdsNotEqual() {
    Book book = new Book("When Breath Becomes Air", 0);
    Object cmpBook = new Book("When Breath Becomes Air", 3);
    Boolean same = book.equals(cmpBook);
    assertEquals(false, same);
  }

}
