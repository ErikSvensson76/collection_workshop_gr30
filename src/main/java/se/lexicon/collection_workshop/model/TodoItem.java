package se.lexicon.collection_workshop.model;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem implements Comparable<TodoItem> {
	
	private int itemId;
	private String title;
	private String description;
	private LocalDate deadline;
	private boolean isDone;
	
	public TodoItem(int itemId, String title, String description, LocalDate deadline) {
		this.itemId = itemId;
		this.title = title;
		this.description = description;
		this.deadline = deadline;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public int getItemId() {
		return itemId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(deadline, description, isDone, itemId, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TodoItem other = (TodoItem) obj;
		return Objects.equals(deadline, other.deadline) && Objects.equals(description, other.description)
				&& isDone == other.isDone && itemId == other.itemId && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TodoItem [itemId=");
		builder.append(itemId);
		builder.append(", title=");
		builder.append(title);
		builder.append(", description=");
		builder.append(description);
		builder.append(", deadline=");
		builder.append(deadline);
		builder.append(", isDone=");
		builder.append(isDone);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(TodoItem o) {
		return deadline.compareTo(o.getDeadline());
	}
}
