package se.lexicon.collection_workshop.data;

import java.util.HashSet;
import java.util.Set;

import se.lexicon.collection_workshop.model.Person;
import se.lexicon.collection_workshop.model.TodoItem;

public class PeopleInMemoryStorage implements PersonDAO {
	
	private static final PersonDAO INSTANCE;
	
	static {
		INSTANCE = new PeopleInMemoryStorage();
	}

	private PeopleInMemoryStorage() {
		this.peopleSet = new HashSet<>();
	}
	
	public static PersonDAO getInstance() {
		return INSTANCE;
	}
	
	private Set<Person> peopleSet;
	
	@Override
	public Set<Person> findAll(){
		return peopleSet;
	}
	
	@Override
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
	
	@Override
	public Person findByEmail(String email) {
		if(email == null) throw new RuntimeException();
		
		for(Person p : peopleSet) {
			if(p.getEmail().equalsIgnoreCase(email)) {
				return p;
			}
		}
		return null;
	}
	
	@Override
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
	
	@Override
	public Person findById(int personId) {
		for(Person p : peopleSet) {
			if(p.getPersonId() == personId) {
				return p;
			}
		}
		return null;
	}
	
	@Override
	public Person update(Person updated) {
		Person toUpdate = findById(updated.getPersonId());
		
		if(toUpdate == null) throw new RuntimeException();
		
		toUpdate.setEmail(updated.getEmail());
		toUpdate.setName(updated.getName());
		toUpdate.setTodoitems(updated.getTodoitems());
		
		return toUpdate;
	}
	
	@Override
	public boolean delete(Person person) {
		return peopleSet.remove(person);
	}
	
	@Override
	public void clear() {
		this.peopleSet = new HashSet<>();
	}

	@Override
	public int size() {
		return peopleSet.size();
	}
	
	
	
	

}
