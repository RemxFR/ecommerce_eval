package fr.eval.DAO.EntityDAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.eval.DAO.Interface.ICrud;
import fr.eval.DAO.connexion.ConnexionBdd;
import fr.eval.entity.Adress;
import fr.eval.entity.Article;

public class ArticleDAO  implements ICrud<Article>{

	private Session session = null;
	private Transaction transaction = null;

	
	@Override
	public void add(Article t) throws Exception {
		
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
	public Article getById(long id) throws Exception {
		try {

			this.session = ConnexionBdd.getSession();
			Query<Article> query = this.session.createNamedQuery("Article::FindAdressById", Article.class);
			query.setParameter("id", id);
			return query.uniqueResult();

		} finally {

			this.closeSession(session);
		}
	}

	@Override
	public void update(Article t) throws Exception {

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

			Article articleToDelete = this.getById(id);

			if(articleToDelete != null) {
			this.transaction.begin();
			this.session.delete(articleToDelete);
			this.transaction.commit();
			} else {
				System.out.println("Aucun Article trouvé avec cet id.");
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
