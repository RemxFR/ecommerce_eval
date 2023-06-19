package fr.eval.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.eval.DAO.Interface.ICrud;
import fr.eval.DAO.connexion.ConnexionBdd;
import fr.eval.entity.LigneDeCommande;

public class LigneDeCommandeDAO implements ICrud<LigneDeCommande> {

	private Session session = null;
	private Transaction transaction = null;

	@Override
	public void add(LigneDeCommande t) throws Exception {
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
	public LigneDeCommande getById(long id) throws Exception {
		try {

			this.session = ConnexionBdd.getSession();
			Query<LigneDeCommande> query = this.session.createNamedQuery("LigneDeCommande::FindAdressById",
					LigneDeCommande.class);
			query.setParameter("id", id);
			return query.uniqueResult();

		} finally {

			this.closeSession(session);
		}
	}

	@Override
	public void update(LigneDeCommande t) throws Exception {
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

			LigneDeCommande ldcToDelete = this.getById(id);

			this.transaction.begin();
			this.session.delete(ldcToDelete);
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
