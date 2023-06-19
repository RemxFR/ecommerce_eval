package fr.eval.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.eval.DAO.Interface.ICrud;
import fr.eval.DAO.connexion.ConnexionBdd;
import fr.eval.entity.Params;

public class ParamsDAO implements ICrud<Params> {

	private Session session = null;
	private Transaction transaction = null;

	@Override
	public void add(Params t) throws Exception {
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
	public Params getById(long id) throws Exception {
		try {

			this.session = ConnexionBdd.getSession();
			Query<Params> query = this.session.createNamedQuery("Params::FindAdressById", Params.class);
			query.setParameter("id", id);
			return query.uniqueResult();

		} finally {

			this.closeSession(session);
		}
	}

	@Override
	public void update(Params t) throws Exception {
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

			Params paramsToDelete = this.getById(id);
			if (paramsToDelete != null) {
				this.transaction.begin();
				this.session.delete(paramsToDelete);
				this.transaction.commit();
			} else {
				System.out.println("Pas de clé de chiffrage trouvée avec cet id.");
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
