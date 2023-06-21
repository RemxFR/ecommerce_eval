package fr.eval.DAO.EntityDAO;

import javax.persistence.RollbackException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.eval.DAO.Interface.ICrud;
import fr.eval.DAO.connexion.ConnexionBdd;
import fr.eval.entity.Utilisateur;

public class UtilisateurDAO implements ICrud<Utilisateur> {

	private Session session = null;

	@Override
	public void add(Utilisateur ut) throws Exception {
		System.out.println("-----Entrée dans add DAO -----");
		Transaction transaction = null;
		try {

			this.session = ConnexionBdd.getSession();

			transaction = this.session.beginTransaction();
			System.out.println("ut password & name: " + ut.getNom() + ", " + ut.getPassword());
			this.session.save(ut);
			transaction.commit();

		} catch (RollbackException e) {

			transaction.rollback();

		} finally {

			this.closeSession(this.session);
		}

	}

	@Override
	public Utilisateur getById(long id) throws Exception {
		try {

			this.session = ConnexionBdd.getSession();
			Query<Utilisateur> query = this.session.createNamedQuery("Utilisateur::FindUtilisateurById",
					Utilisateur.class);
			query.setParameter("id", id);
			return query.uniqueResult();

		} finally {

			this.closeSession(session);
		}
	}

	public Utilisateur getByMail(String mail) throws Exception {
		try {

			this.session = ConnexionBdd.getSession();
			Query<Utilisateur> query = this.session.createNamedQuery("Utilisateur::FindUtilisateursByMail",
					Utilisateur.class);
			query.setParameter("mail", mail);
			return query.uniqueResult();

		} finally {

			this.closeSession(session);
		}
	}

	@Override
	public void update(Utilisateur t) throws Exception {
		Transaction transaction = null;
		try {
			this.session = ConnexionBdd.getSession();
			transaction = this.session.beginTransaction();
			transaction.begin();
			this.session.update(t);
			transaction.commit();

		} catch (Exception e) {
			transaction.rollback();
		} finally {
			this.closeSession(this.session);
		}

	}

	@Override
	public void deleteById(long id) throws Exception {
		Transaction transaction = null;
		try {
			this.session = ConnexionBdd.getSession();
			transaction = this.session.beginTransaction();

			Utilisateur uToDelete = this.getById(id);

			if (uToDelete != null) {
				transaction.begin();
				this.session.delete(uToDelete);
				transaction.commit();
			} else {
				System.out.println("Pas d'utilisateur trouvé avec cet id.");
			}

		} catch (Exception e) {
			transaction.rollback();
		} finally {
			this.closeSession(this.session);
		}

	}

	@Override
	public void closeSession(Session session) throws Exception {
		if (session != null && session.isOpen()) {
			session.close();
		}

	}

}
