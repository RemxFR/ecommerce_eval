package fr.eval.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.eval.DAO.Interface.ICrud;
import fr.eval.DAO.connexion.ConnexionBdd;
import fr.eval.entity.CartePaiement;

public class CartePaiementDAO implements ICrud<CartePaiement> {

	private Session session = null;
	private Transaction transaction = null;

	@Override
	public void add(CartePaiement t) throws Exception {
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
	public CartePaiement getById(long id) throws Exception {
		try {

			this.session = ConnexionBdd.getSession();
			Query<CartePaiement> query = this.session.createNamedQuery("CartePaiement::FindAdressById",
					CartePaiement.class);
			query.setParameter("id", id);
			return query.uniqueResult();

		} finally {

			this.closeSession(session);
		}
	}

	@Override
	public void update(CartePaiement t) throws Exception {
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

			CartePaiement cpToDelete = this.getById(id);

			this.transaction.begin();
			this.session.delete(cpToDelete);
			this.transaction.commit();

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
