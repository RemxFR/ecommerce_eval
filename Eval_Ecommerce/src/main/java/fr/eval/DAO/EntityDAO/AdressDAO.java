package fr.eval.DAO.EntityDAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.eval.DAO.Interface.ICrud;
import fr.eval.DAO.connexion.ConnexionBdd;
import fr.eval.entity.Adress;

public class AdressDAO implements ICrud<Adress> {

	private Session session = null;
	private Transaction transaction = null;

	@Override
	public void add(Adress t) throws Exception {

		try {

			this.session = ConnexionBdd.getSession();
			this.transaction = this.session.beginTransaction();
			this.session.save(t);
			this.transaction.commit();

		} catch (Exception e) {
			this.transaction.rollback();
		} finally {
			this.closeSession(this.session);
		}
	}

	@Override
	public Adress getById(long id) throws Exception {

		try {

			this.session = ConnexionBdd.getSession();
			Query<Adress> query = this.session.createNamedQuery("Adress::FindAdressById", Adress.class);
			query.setParameter("id", id);
			return query.uniqueResult();

		} finally {

			this.closeSession(session);
		}

	}

	@Override
	public void deleteById(long id) throws Exception {

		try {
			this.session = ConnexionBdd.getSession();
			this.transaction = this.session.beginTransaction();

			Adress adressToDelete = this.getById(id);

			if (adressToDelete != null) {
				this.transaction.begin();
				this.session.delete(adressToDelete);
				this.transaction.commit();
			} else {
				System.out.println("Pas d'adresse trouvée avec cette id.");
			}

		} catch (Exception e) {
			this.transaction.rollback();
		} finally {
			this.closeSession(this.session);
		}

	}

	@Override
	public void update(Adress t) throws Exception {

		try {
			this.session = ConnexionBdd.getSession();
			this.transaction = this.session.beginTransaction();
			this.session.update(t);
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
