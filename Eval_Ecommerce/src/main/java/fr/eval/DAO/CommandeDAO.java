package fr.eval.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.eval.DAO.Interface.ICrud;
import fr.eval.DAO.connexion.ConnexionBdd;
import fr.eval.entity.Commande;

public class CommandeDAO implements ICrud<Commande> {

	private Session session = null;
	private Transaction transaction = null;

	@Override
	public void add(Commande t) throws Exception {
		try {

			this.session = ConnexionBdd.getSession();
			this.transaction = this.session.beginTransaction();
			this.transaction.begin();
			this.session.save(t);
			this.transaction.commit();

		} catch (Exception e) {

			this.transaction.rollback();

		} finally {

			this.closeSession(this.session);
		}

	}

	@Override
	public Commande getById(long id) throws Exception {
		try {

			this.session = ConnexionBdd.getSession();
			Query<Commande> query = this.session.createNamedQuery("Commande::FindAdressById", Commande.class);
			query.setParameter("id", id);
			return query.uniqueResult();

		} finally {

			this.closeSession(session);
		}
	}

	@Override
	public void update(Commande t) throws Exception {
		try {
			this.session = ConnexionBdd.getSession();
			this.transaction = this.session.beginTransaction();
			this.transaction.begin();
			this.session.update(t);
			this.transaction.commit();

		} catch (Exception e) {
			this.transaction.rollback();
		} finally {
			this.closeSession(this.session);
		}

	}

	@Override
	public void deleteById(long id) throws Exception {
		try {
			this.session = ConnexionBdd.getSession();
			this.transaction = this.session.beginTransaction();

			Commande cToDelete = this.getById(id);
			
			if(cToDelete != null) {
			this.transaction.begin();
			this.session.delete(cToDelete);
			this.transaction.commit();
			} else {
				System.out.println("Pas de commande trouvée avec cet id.");
			}
		} catch (Exception e) {
			this.transaction.rollback();
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
