package fr.eval.DAO.connexion;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class ConnexionBdd {

	private static ConnexionBdd instance;
	private static SessionFactory sessionFactory;
	private static Session session;
	
	private ConnexionBdd() {
		if(sessionFactory == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
	}
	
	public static Session getSession() {
		if(instance == null) {
			instance = new ConnexionBdd();
		}
		
		if(session == null || !session.isOpen()) {
			session = sessionFactory.openSession();
		}
		
		return session;
	}
	
}
