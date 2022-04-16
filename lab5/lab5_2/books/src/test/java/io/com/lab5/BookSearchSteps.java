package io.com.lab5;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

 
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
 
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BookSearchSteps {
	Library library = new Library();
	List<Book> result = new ArrayList<>();
    
    @DataTableType
    public Book newBook (Map<String, String> entry) throws ParseException {
        return new Book(entry.get("title"), entry.get("author"), new SimpleDateFormat("dd-MM-yyyy").parse(entry.get("published")), entry.get("category"));
    }

	@Given("these books exist")
	public void addNewBook(List<Book> books) {
		for (Book book : books) {
            library.addBook(book);
        }
	}
 
	@When("the customer searches for books published between {string} and {string}")
	public void setSearchParameters(String from, String to) throws ParseException {
		result = library.findBooksByDate(new SimpleDateFormat("yyyy").parse(from), new SimpleDateFormat("yyyy").parse(to));
	}

    @When("the customer searches for books written by {string}")
	public void search_for_author(String author) {
		result = library.findBooksByAuthor(author);
	}

    @When("the customer searches for books from the category {string}")
	public void search_for_category(String category) {
		result = library.findBooksByCategory(category);
	}
 
	@Then("{int} books should have been found")
	public void verifyAmountOfBooksFound(final int booksFound) {
		assertEquals(result.size(), booksFound);
	}
 
	@Then("Book {int} should have the title {string}")
	public void verifyBookAtPosition(final int position, final String title) {
		assertEquals(result.get(position - 1).getTitle(), title);
	}
}
