package inheritance;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

public class Order {
	private int orderid;
	private Date date;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Customer customer;

	public Order(int orderid, Date date) {
		super();
		this.orderid = orderid;
		this.date = date;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
