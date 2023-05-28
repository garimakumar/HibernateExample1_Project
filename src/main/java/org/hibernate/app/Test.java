package org.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.app.entities.Emp;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		try {
			Emp e=new Emp();
			e.setid(3);
			e.setName("Vansh");
			e.setAddress("New Delhi");
			session.save(e);
			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
		}
		session.close();
	}

}
