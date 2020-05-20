package se.lexicon.collection_workshop.model;

import java.util.Collection;
import java.util.Objects;
import java.util.TreeSet;

public class Person {
	
	private int personId;
	private String name;
	private String email;
	private Collection<TodoItem> todoitems;
	
	public Person(int personId, String name, String email) {
		this.personId = personId;
		this.name = name;
		this.email = email;
		this.todoitems = new TreeSet<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<TodoItem> getTodoitems() {
		if(this.todoitems == null) {
			this.todoitems = new TreeSet<>();
		}
		return todoitems;
	}

	public void setTodoitems(Collection<TodoItem> todoitems) {
		if(this.todoitems == null) {
			todoitems = new TreeSet<>();
		}
		this.todoitems = todoitems;
	}

	public int getPersonId() {
		return personId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, name, personId, todoitems);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(email, other.email) && Objects.equals(name, other.name) && personId == other.personId
				&& Objects.equals(todoitems, other.todoitems);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [personId=");
		builder.append(personId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", email=");
		builder.append(email);
		builder.append(", todoitems=");
		builder.append(todoitems);
		builder.append("]");
		return builder.toString();
	}
}
