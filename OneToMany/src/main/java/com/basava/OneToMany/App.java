package com.basava.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{

		Students s1 = new Students();
		s1.setRoleNumber(1);
		s1.setMarks(82);
		s1.setName("Arun");

		Students s2 = new Students();
		s2.setRoleNumber(2);
		s2.setMarks(82);
		s2.setName("Bhavana");

		Students s3 = new Students();
		s3.setRoleNumber(3);
		s3.setMarks(80);
		s3.setName("Chetan");

		Students s4 = new Students();
		s4.setRoleNumber(4);
		s4.setMarks(82);
		s4.setName("Kiran");



		Laptop l = new Laptop();
		l.setlId(1);
		l.setlName("Acer");

		Session s = null;
		Transaction t = null;

		try {
			Configuration cfg = new Configuration().configure().addAnnotatedClass(Students.class).addAnnotatedClass(Laptop.class);
			SessionFactory sf = cfg.buildSessionFactory();
			s = sf.openSession();
			t = s.beginTransaction();

			s.save(s1);
			s.save(l);
			//		s.save(s2);
			//		s.save(s3);
			//		s.save(s4);

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {


			t.commit();
			s.close();
		}
	}
}
