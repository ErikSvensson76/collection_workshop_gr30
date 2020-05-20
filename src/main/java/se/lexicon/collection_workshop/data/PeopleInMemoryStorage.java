package se.lexicon.collection_workshop.data;

import java.util.HashSet;
import java.util.Set;

import se.lexicon.collection_workshop.model.Person;
import se.lexicon.collection_workshop.model.TodoItem;

public class PeopleInMemoryStorage {
	
	private Set<Person> peopleSet;

	public PeopleInMemoryStorage() {
		this.peopleSet = new HashSet<>();
	}
	
	public Person save(Person person) {
		if(person == null) {
			return null;
		}
		
		if(findByEmail(person.getEmail()) != null) {
			throw new RuntimeException("A person with email " + person.getEmail() + " already exists");
		}
		
		peopleSet.add(person);
		return person;		
	}
	
	public Person findByEmail(String email) {
		if(email == null) throw new RuntimeException();
		
		for(Person p : peopleSet) {
			if(p.getEmail().equalsIgnoreCase(email)) {
				return p;
			}
		}
		return null;
	}
	
	public Person findPersonAssignedTo(int itemId) {
		for(Person p : peopleSet) {
			for(TodoItem item : p.getTodoitems()) {
				if(item.getItemId() == itemId) {
					return p;
				}
			}
		}
		return null;
	}
	
	public Person findById(int personId) {
		for(Person p : peopleSet) {
			if(p.getPersonId() == personId) {
				return p;
			}
		}
		return null;
	}
	
	public Person update(Person updated) {
		Person toUpdate = findById(updated.getPersonId());
		
		if(toUpdate == null) throw new RuntimeException();
		
		toUpdate.setEmail(updated.getEmail());
		toUpdate.setName(updated.getName());
		toUpdate.setTodoitems(updated.getTodoitems());
		
		return toUpdate;
	}
	
	public boolean delete(Person person) {
		return peopleSet.remove(person);
	}
	
	
	
	

}
