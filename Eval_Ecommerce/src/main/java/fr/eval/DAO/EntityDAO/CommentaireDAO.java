package fr.eval.DAO.EntityDAO;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.eval.DAO.Interface.ICrud;
import fr.eval.DAO.connexion.ConnexionBdd;
import fr.eval.entity.Article;
import fr.eval.entity.Commentaire;

public class CommentaireDAO implements ICrud<Commentaire> {

	private Session session = null;
	private Transaction transaction = null;

	@Override
	public void add(Commentaire t) throws Exception {
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
	public Commentaire getById(long id) throws Exception {
		try {

			this.session = ConnexionBdd.getSession();
//			Query<Commentaire> query = this.session.createNamedQuery("Commentaire::FindAdressById", Commentaire.class);
//			query.setParameter("id", id);
//			return query.uniqueResult();
			return null;
		} finally {

			this.closeSession(session);
		}
	}

	@Override
	public void update(Commentaire t) throws Exception {
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
	public void deleteById(long id) throws Exception {
		try {
			this.session = ConnexionBdd.getSession();
			this.transaction = this.session.beginTransaction();

			Commentaire cToDelete = this.getById(id);

			if (cToDelete != null) {
				this.session.delete(cToDelete);
				this.transaction.commit();
			} else {
				System.out.println("Pas de commentaire trouvé avec cet id.");
			}
		} catch (Exception e) {
			this.transaction.rollback();
		} finally {
			this.closeSession(this.session);
		}

	}

	public List<Commentaire> getCommentairesList() throws Exception {
		Transaction transaction = null;
		try {
			this.session = ConnexionBdd.getSession();

			Query<Commentaire> query = this.session.createNamedQuery("Commentaire::FindAll", Commentaire.class);
			return query.getResultList();

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
