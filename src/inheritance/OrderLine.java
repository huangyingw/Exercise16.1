package inheritance;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderLine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int quantity;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Order order;

	public OrderLine(int orderid, Date date) {
		super();
		this.id = orderid;
	}

	public OrderLine(int quantity) {
		super();
		this.quantity = quantity;
	}

}
