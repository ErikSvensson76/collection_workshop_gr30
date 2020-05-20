package se.lexicon.collection_workshop.data;

import java.util.Set;

import se.lexicon.collection_workshop.model.Person;

public interface PersonDAO {
	
	int size();

	Person save(Person person);

	Person findByEmail(String email);

	Person findPersonAssignedTo(int itemId);

	Person findById(int personId);

	Person update(Person updated);

	boolean delete(Person person);

	void clear();

	Set<Person> findAll();

}