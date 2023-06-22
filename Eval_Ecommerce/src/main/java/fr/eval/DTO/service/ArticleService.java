package fr.eval.DTO.service;

import java.util.List;
import java.util.Map;

import fr.eval.DAO.EntityDAO.ArticleDAO;
import fr.eval.entity.Article;
import fr.eval.entity.Commentaire;

public class ArticleService {

	private ArticleDAO articleDAO = new ArticleDAO();
	
	
	
	public ArticleService() {
		super();
	}



	public Map<Article, List<Commentaire>> getCommentairesMapParArticle() throws Exception {
		
		Map<Article, List<Commentaire>> map = articleDAO.getCommentairesMapParArticle();
		
		return map;
	}



	public List<Commentaire> getCommentairesListeParArticle(long id) throws Exception {
		List<Commentaire> commentaires = articleDAO.getCommentairesParArticleListe(id);
		return null;
	}



	public void addArticle(Article article) throws Exception {
		
		this.articleDAO.add(article);
		
	}



	public void updateArticle(Article article) throws Exception {
		
		this.articleDAO.update(article);
		
	}



	public Article getArticleById(long id) throws Exception {

		Article article = this.articleDAO.getById(id);
		
		return article;
	}



	public void removeArticleById(long id) throws Exception {
		
		this.articleDAO.deleteById(id);
		
	}
	
}
