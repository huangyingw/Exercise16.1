package inheritance;

import javax.persistence.Entity;

@Entity
public class Book extends Product {
	private String title;

	public Book() {
		super();
	}

	public Book(String name, String description, String title) {
		super(name, description);
		this.title = title;
	}
}
