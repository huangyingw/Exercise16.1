package inheritance;

import javax.persistence.Entity;

@Entity
public class DVD extends Product {
	private String genre;

	public DVD(String name, String description, String genre) {
		super(name, description);
		this.genre = genre;
	}

	public DVD() {
		super();
	}

	public DVD(String genre) {
		super();
		this.genre = genre;
	}
}
