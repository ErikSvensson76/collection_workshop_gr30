package se.lexicon.collection_workshop.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

import org.junit.Test;
import static org.junit.Assert.*;
public class PersonTest {
	
	@Test
	public void test_set() {
		Person p = new Person(1, "Test", "test@test.com");
		Collection<TodoItem> items = new TreeSet<>(Arrays.asList(
				new TodoItem(1,"Test", "test", LocalDate.parse("2020-05-20"))				
		));
		
		p.setTodoitems(items);
		
		assertEquals(1, p.getTodoitems().size());
		for(TodoItem item : items) {
			System.out.println(item.getAssignee());
		}
	}

}
