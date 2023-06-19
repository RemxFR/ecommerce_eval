package fr.eval.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.eval.DAO.Interface.ICrud;
import fr.eval.DAO.connexion.ConnexionBdd;
import fr.eval.entity.Categorie;

public class CategorieDAO implements ICrud<Categorie> {

	private Session session = null;
	private Transaction transaction = null;

	@Override
	public void add(Categorie t) throws Exception {
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
	public Categorie getById(long id) throws Exception {
		try {

			this.session = ConnexionBdd.getSession();
			Query<Categorie> query = this.session.createNamedQuery("Categorie::FindAdressById", Categorie.class);
			query.setParameter("id", id);
			return query.uniqueResult();

		} finally {

			this.closeSession(session);
		}
	}

	@Override
	public void update(Categorie t) throws Exception {
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

			Categorie cToDelete = this.getById(id);

			if(cToDelete != null) {
			this.transaction.begin();
			this.session.delete(cToDelete);
			this.transaction.commit();
			} else {
				System.out.println("Pas de catégorie trouvé avec cet id.");
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
