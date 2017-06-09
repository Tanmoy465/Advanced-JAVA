package fr.epita.core.tanmoy.test;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import fr.epita.core.datamodel.Identity;
import fr.epita.core.tanmoy.test.TestHibernate;

public class TestHibernate {
	
	
	@Inject
	SessionFactory sFactory;

	
	private static final Logger LOGGER = LogManager.getLogger(TestHibernate.class);
	

	
	
	
	
	@Test
	public void testHQL() {
		
		//Given
		String hqlQuery =  "from Identity as identity where identity.displayName = :displayName";
		Session session = sFactory.openSession();
		Transaction tx = session.beginTransaction();
		String displayName = "thomas broussard";
		session.save(new Identity("000", displayName, "zcobain.36@gmail.com"));
		tx.commit();
		
		//When
		Query query = session.createQuery(hqlQuery);
		query.setParameter("displayName", displayName);
		List<Identity> results = query.list();
		
		//Then
		Assert.assertTrue(!results.isEmpty());
		
		
	}


}
