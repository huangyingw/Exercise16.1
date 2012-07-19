package inheritance;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Application {
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public static void main(String[] args) {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// Create new instance of Car and set values in it

			Product pro = new CD("Ying", "Ying", "A good stuff");
			OrderLine oLine = new OrderLine(8);
			pro.setOrderLine(oLine);
			session.persist(pro);

			pro = new DVD("Huang", "Ying", "A good stuff");
			pro.setOrderLine(oLine);
			session.persist(pro);

			pro = new Book("huangyingw", "Ying", "A good stuff");
			session.persist(pro);

			tx.commit();

		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			List<Product> proList = session.createQuery("from Product").list();
			for (Product pro : proList) {
				System.out.println(pro.getName());
			}
			tx.commit();

		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		// Close the SessionFactory (not mandatory)
		sessionFactory.close();
	}
}
