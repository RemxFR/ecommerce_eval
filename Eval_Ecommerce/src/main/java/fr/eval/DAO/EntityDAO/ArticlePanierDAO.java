package fr.eval.DAO.EntityDAO;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.eval.DAO.Interface.ICrud;
import fr.eval.DAO.connexion.ConnexionBdd;
import fr.eval.entity.Adress;
import fr.eval.entity.ArticlePanier;

public class ArticlePanierDAO implements ICrud<ArticlePanier> {

	private Session session = null;
	private Transaction transaction = null;
	
	@Override
	public void add(ArticlePanier t) throws Exception {
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
	public ArticlePanier getById(long id) throws Exception {
		try {

			this.session = ConnexionBdd.getSession();
			Query<ArticlePanier> query = this.session.createNamedQuery("ArticlePanier::FindArticleById", ArticlePanier.class);
			query.setParameter("id", id);
			return query.uniqueResult();

		} finally {

			this.closeSession(session);
		}
	}

	@Override
	public void update(ArticlePanier t) throws Exception {
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

			ArticlePanier apToDelete = this.getById(id);

			if(apToDelete != null) {
			this.session.delete(apToDelete);
			this.transaction.commit();
			} else {
				System.out.println("Pas de panier trouvé avec cet id.");
			}
			
		} catch (Exception e) {
			this.transaction.rollback();
		} finally {
			this.closeSession(this.session);
		}
		
	}
	
	public List<ArticlePanier> getPanierByIdClient(long id) throws Exception {
		
		try {
			
			this.session = ConnexionBdd.getSession();
			
			Query<ArticlePanier> query = this.session.createNamedQuery("ArticlePanier::FindPanierByClientId", ArticlePanier.class);
			query.setParameter("id", id);
			
			return query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeSession(this.session);
		}
		
		return null;
	}

	@Override
	public void closeSession(Session session) throws Exception {
		if(session != null && session.isOpen()) {
			session.close();
		}
		
	}



	
	
}
