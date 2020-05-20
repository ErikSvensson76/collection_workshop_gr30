package se.lexicon.collection_workshop.data;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.lexicon.collection_workshop.model.Person;
import se.lexicon.collection_workshop.model.TodoItem;

import static org.junit.Assert.*;

public class PeopleInMemoryStorageTest {
	
	private PersonDAO testObject;
	
	public static List<Person> people(){
		return Arrays.asList(
				new Person(1, "Erik", "erik.svensson@lexicon.se"),
				new Person(2, "Ulf", "ulf.bengtsson@lexicon.se"),
				new Person(3, "Simon", "simon.elbrink@lexicon.se")
		);		
	}
	
	public static List<TodoItem> todoItems(){
		return Arrays.asList(
				new TodoItem(1, "Cleaning", "Clean the kitchen", LocalDate.parse("2020-05-20")),
				new TodoItem(2, "Shopping", "Buy cake", LocalDate.parse("2020-05-20")),
				new TodoItem(3, "Do workshop", "Collection workshop with javagroup 30", LocalDate.parse("2020-05-20"))
		);
	}
	
	private Person erik;
	private Person ulf;
	private Person simon;
	
	@Before
	public void beforeEachTest() {
		testObject = PeopleInMemoryStorage.getInstance();
		Person erik = people().get(0);
		Person ulf = people().get(1);
		Person simon = people().get(2);
		
		erik.setTodoitems(new TreeSet<>(Arrays.asList(todoItems().get(2))));   //Workshop
		ulf.setTodoitems(new TreeSet<>(Arrays.asList(todoItems().get(1))));   //Buy cake
		simon.setTodoitems(new TreeSet<>(Arrays.asList(todoItems().get(0)))); //Clean kitchen
		
		
		this.erik = testObject.save(erik);
		this.ulf = testObject.save(ulf);
		this.simon = testObject.save(simon);		
	}
	
	@Test
	public void assert_that_all_persons_are_successfully_added() {
		int expectedSize = 3;
		assertEquals(expectedSize, testObject.size());		
	}
	
	@Test
	public void given_email_findByEmail_should_return_erik() {
		String email = "erik.svensson@lexicon.se";
		
		Person result = testObject.findByEmail(email);
		
		assertEquals(erik, result);
	}
	
	@Test(expected = RuntimeException.class)
	public void given_email_duplicate_save_throws_RuntimeException() {
		testObject.save(ulf);
	}
	
	@Test
	public void given_todoId_findPersonAssignedTo_return_simon() {
		int todoId = 1;
		
		Person result = testObject.findPersonAssignedTo(todoId);
		
		assertEquals(simon, result);
	}	
	
	@After
	public void afterEachTest() {
		testObject.clear();		
	}

}
