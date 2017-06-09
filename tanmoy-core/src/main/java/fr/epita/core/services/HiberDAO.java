package fr.epita.core.services;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.epita.core.datamodel.Identity;
import fr.epita.core.services.Dao;

public class HiberDAO implements Dao<Identity>{
	
	@Inject
	SessionFactory sf;
	
	
	
	public void write(Identity identity){
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(identity);
		transaction.commit();
		session.close();
	}
	
	public void update(Identity identity){
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(identity);
		transaction.commit();
		session.close();
	}
	 
	public void delete(Identity identity){
		
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(identity);
		transaction.commit();
		session.close();
	}
	
	public List<Identity> search(Identity identity){
		Session session = sf.openSession();
//		String queryString = "from Identity as identity";
		String queryString = "from Identity as identity where identity.displayName like :displayName";
		Query query = session.createQuery(queryString);
		query.setParameter("displayName", "%" + identity.getDisplayName()+"%");
		List<Identity> identityList = query.list();
		session.close();
		return identityList;
	}


}
