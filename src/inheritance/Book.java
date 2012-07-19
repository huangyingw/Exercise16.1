package inheritance;

import javax.persistence.Entity;

@Entity
public class Book extends Product {
	private String title;
}
